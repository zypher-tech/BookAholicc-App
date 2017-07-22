package com.bookaholicc.Activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.CustomUI.CircleImageView;
import com.bookaholicc.CustomUI.OpenSansBold;
import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.Model.Order;
import com.bookaholicc.Model.Product;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;
import com.bookaholicc.utils.BundleKey;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 18/7/17.
 * The Final Check out Activity Class
 */

public class CheckOutActivity extends AppCompatActivity implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

    private static final String TAG = "CHECK_OUT";
    @BindView(R.id.co_pro_image)
    CircleImageView mpImage;
    @BindView(R.id.co_user_name)
    OpenSansBold mName;
    @BindView(R.id.co_phone_number)
    OpenSansBold mPhone;
    @BindView(R.id.textView2)
    OpenSansBold textView2;
    @BindView(R.id.textView3)
    WhitenyBooksFont textView3;
    @BindView(R.id.co_profile_div)
    View coProfileDiv;
    @BindView(R.id.deliver_text)
    WhitenyBooksFont deliverText;
    @BindView(R.id.street_address)
    OpenSansBold mAddr1;
    @BindView(R.id.region_addr)
    OpenSansBold mAddr2;
    @BindView(R.id.ship_text)
    WhitenyBooksFont shipText;
    @BindView(R.id.co_pay_container)
    LinearLayout coPayContainer;
    @BindView(R.id.place_order_button)
    Button mOrder;

    @BindView(R.id.co_change_addr) WhitenyBooksFont mChangeAddress;



    @BindView(R.id.co_change_phone) WhitenyBooksFont mChangeNumber;
    DataStore mStore;

    private boolean mLocationExists;
    List<Product> cartList;


    private boolean isPaymentSelected = false;
    private int paymentMode = 0;
//    @BindView(R.id.) // TODO: 23/7/17 Add View HEre

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
        ButterKnife.bind(this);


        // ORder Button
        mOrder.setOnClickListener(this);
        mChangeNumber.setOnClickListener(this);
        mChangeAddress.setOnClickListener(this);


        // The peviouse List
        if (getIntent() != null){
            Type type = new TypeToken<List<Product>>(){}.getType();
            Gson gson = new Gson();
            cartList = gson.fromJson(getIntent().getStringExtra(BundleKey.ARG_CHECKOUT_STRING),type);
            int amount = getIntent().getIntExtra(BundleKey.ARG_PRICE,0);
            if (amount ==0){
                throw new NullPointerException("Some Problem Please Contact Support");
            }

        }

        if (mStore == null){
            mStore = DataStore.getStorageInstance(this);
            mName.setText(mStore.getUserName());
            mPhone.setText(mStore.getPhoneNumber());
            if (mStore.isLocationSaved()){
                String  addres =  mStore.getAddress();
                double lat = mStore.getUserLat();
                double lon  = mStore.getUserLon();

            }
        }


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
         mStore  =  DataStore.getStorageInstance(this);
         // set Views Here
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.place_order_button:
                prepareOrder();
                break;
            case R.id.co_change_addr:
                selectLocation();
                break;
            case R.id.co_change_phone:
                changePhoneNumber();
        }
    }

    private void selectLocation() {
        Log.d(TAG, "selecting New Loction");
    }

    private void changePhoneNumber() {
        Log.d(TAG, "changePhoneNumber: ");
        // Show an ALert Dialog and show past the Same to the view
    }

    private void prepareOrder() {
        if (mLocationExists && isPaymentSelected){
              if (paymentMode == 1){
                  placeOrder();
              }
              else{
                  // Other Payemnt Options

                  startActivity(new Intent(this,OtherPaymentActiviy.class));
              }
        }
        else{
            // show Location Dialog
        }
    }

    private void placeOrder() {

        // Firs Check whether Address, Products, user Details are there and Also Contruct Return Object Separately
        Log.d(TAG, "placeOrder: ");
        JSONObject mJsonObject  = new JSONObject();
        if (mStore != null){

            try{

                mJsonObject.put(APIUtils.USER_ID,mStore.getUserId());
                mJsonObject.put(APIUtils.PHONE_NUMBER,mStore.getPhoneNumber());
                mJsonObject.put(APIUtils.ORDER_LAT,mStore.getUserLat());
                mJsonObject.put(APIUtils.ORDER_LON,mStore.getUserLon());
//                boolean mProducts;
                JSONArray mProductObj = getProductsAsJson(cartList);
                mJsonObject.put(APIUtils.PRODUCTS_KEYWORD,mProductObj);
                JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST,APIUtils.HOME_ENDPOINT_PLACE_ORDER,mJsonObject,this,this);
                AppRequestQueue appRequestQueue  = AppRequestQueue.getInstance(this);
                Log.d(TAG, "placeOrder: Final Placing");
                appRequestQueue.addToRequestQue(mRequest);
            }
            catch (Exception e){
                Log.d(TAG, "placeOrder: ");
            }
        }
    }

    private JSONArray getProductsAsJson(List<Product> cartList) {
        if (cartList.size() ==0 ){
            return null;
        }
        try {
                  JSONArray mJsonArray = null;

                   for (int i =0 ;i < cartList.size(); i++){
                         JSONObject mObject = new JSONObject();
                         Product p = cartList.get(i);

                         mObject.put(APIUtils.PID,p.getPid());

                         mObject.put(APIUtils.PRODUCT_NAME,p.getProductName());
//                         mObject.put(APIUtils.DURATION,p.get) // Get the Duration
                            // Get the Price
                        mJsonArray.put(i,mObject);

                     }
            Log.d(TAG, "getProductsAsJson: Successfyllu COnvereted Prodcts , return");
         return mJsonArray;
        } catch (JSONException e) {
            Log.d(TAG, "getProductsAsJson:Exception");
            return null;
        }
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.d(TAG, "onResponse: Order Response "+response.toString());
        try {
            if (response.getBoolean(APIUtils.IS_ACCEPTED)){
                // if One Order Passed Through
                int orderId = response.getInt(APIUtils.ORDER_ID);
                Intent i = new Intent(this,OrderPlacedActivity.class);
                i.putExtra(BundleKey.ARG_CATEGORY_ID,orderId);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "onResponse: Exception in Parsing");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse: inc CHeckout ");
    }
}
