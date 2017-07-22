package com.bookaholicc.Activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.CustomUI.CircleImageView;
import com.bookaholicc.CustomUI.OpenSansBold;
import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.Model.Order;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;
import com.bookaholicc.utils.BundleKey;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 18/7/17.
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
    DataStore mStore;
    private boolean mLocationExists;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_out);
        ButterKnife.bind(this);
        mOrder.setOnClickListener(this);


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
        }
    }

    private void prepareOrder() {
        if (mLocationExists){
                placeOrder();
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
//                mJsonObject.put(APIUtils.PRODUCTS_KEYWORD,mProducts);
                JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST,APIUtils.HOME_ENDPOINT_PLACE_ORDER,mJsonObject,this,this);
            }
            catch (Exception e){
                Log.d(TAG, "placeOrder: ");
            }
        }
    }

    @Override
    public void onResponse(JSONObject response) {
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
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
