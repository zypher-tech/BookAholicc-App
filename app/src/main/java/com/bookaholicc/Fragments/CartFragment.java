package com.bookaholicc.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.CartAdapter;
import com.bookaholicc.Model.CartProduct;
import com.bookaholicc.Model.Product;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.CartHandler;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 29/5/17.
 *
 * Shows Cart Products -- Uses {@link CartHandler} to provide with List of Products that the User has Added
 */

public class CartFragment extends Fragment implements CartAdapter.CartCallbacks, CompoundButton.OnCheckedChangeListener, Response.ErrorListener, Response.Listener<JSONObject> {



    /*The Rooot of this page*/
    @BindView(R.id.cart_root)
    FrameLayout mCartRoot;
    @BindView(R.id.no_order_image)
    ImageView mCartImage;
    @BindView(R.id.no_order_text)
    TextView mOrderText;
    @BindView(R.id.no_orders_loading_indicator)
    ProgressBar mProgess;
    @BindView(R.id.no_orderindicator_text)
    TextView mIndicatorText;
    @BindView(R.id.no_order_loading_frame)
    RelativeLayout mLoadingFrame;
    @BindView(R.id.no_orders_root_frame)
    FrameLayout mRootFragme;

    private Context mContext;
    private View v;


    public List<Product> mCartList;
    private String TAG = "CARTFRAGMENT";
    private boolean isDefaultChecked = false;

    private int userId;
    private String userName;
    private String phoneNumber;
    private double orderLat;
    private double orderLon;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = LayoutInflater.from(mContext).inflate(R.layout.cart_fragment, container, false);
        ButterKnife.bind(this, v);


        //get Prdoucts from Storage
        mCartList = CartHandler.getInstance(mContext).getProducts();


        if (mCartList == null){
            //No Cart Products Exists
            NoCartProducts();
        }
        else{
            // Products DO Exist
            showCartProducts(mCartList);
        }
        return v;
    }

    private void NoCartProducts() {

    }

    private void showCartProducts(List<Product> mCartList) {

        //There is Products Remove the Views and Show the it in Recycelr view
        View cartListView = null;

        if (mCartRoot != null){
            try {


                // Inflate The views by Showing Products
                mCartRoot.removeAllViews();
                cartListView = LayoutInflater.from(mContext).inflate(R.layout.cart_view,mCartRoot,false);
                RecyclerView mList = (RecyclerView) cartListView.findViewById(R.id.list);

                // Initilized Top Cards values
                TextView mProductsCount = (TextView) cartListView.findViewById(R.id.cart_view_product_count);
                TextView mAmount = (TextView) cartListView.findViewById(R.id.cart_view_amount_value);


                mProductsCount.setText(mCartList.size());

                CheckBox mDefaultChekcbox = (CheckBox) cartListView.findViewById(R.id.cart_view_check_box);

                // Check whether Locatin exisits or not
                DataStore mStore = DataStore.getStorageInstance(mContext);
                if (mStore.isFirstTime()){

                    // change the Text to Select delivery Location
                    mDefaultChekcbox.setText("Select Default Delivery Location");

                }
                else{
                    //Leave i
                }




                String totalAmount = getAmount(mCartList);
                mAmount.setText(totalAmount);
                CartAdapter mAdapter = new CartAdapter(mCartList,mContext,this);

                mList.setLayoutManager(new LinearLayoutManager(mContext));
                mList.setAdapter(mAdapter);

                // Place Order Button
                Button mPlaceOrder = (Button) cartListView.findViewById(R.id.place_order_button);
                mPlaceOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        placeOrder();
                    }
                });
            }
            catch (Exception e){
                Log.d(TAG, "showCartProducts: Exception: "+e.getLocalizedMessage());
            }
        }

    }

    private void placeOrder() {
        //Here are The List of products
        //Check whether Check box Check or Not
        //Check whether Location has been saved on not

        if (isDefaultChecked){
            // take to Place Order, Ask for Confirmation
            DataStore mStore = DataStore.getStorageInstance(mContext);
            if (mStore != null){

                // Get Variables , Fill it in Object
                // Get List of Products
                userId = mStore.getUserId();
                userName = mStore.getUserName();
                orderLat = mStore.getUserLat();
                orderLon = mStore.getUserLon();
                List<CartProduct> mListToSend= getOrderFormat(mCartList);

                //Create Request Body
                JSONObject mOrderObject = new JSONObject();
                try {


                    mOrderObject.put(APIUtils.USER_ID,userId);
                    mOrderObject.put(APIUtils.FIRST_NAME,userName);
                    mOrderObject.put(APIUtils.ORDER_LAT,orderLat);
                    mOrderObject.put(APIUtils.ORDER_LON,orderLon);
                    mOrderObject.put(APIUtils.PRODUCTS_KEYWORD,mListToSend);

                }
                catch (Exception e){
                    Log.d(TAG, "placeOrder: Exception");

                }

                JsonObjectRequest mRequest  = new JsonObjectRequest(Request.Method.POST,APIUtils.HOME_ENDPOINT_PLACE_ORDER,mOrderObject,this,this);
                AppRequestQueue mRequestQueue  = AppRequestQueue.getInstance(mContext);
                mRequestQueue.addToRequestQue(mRequest);



            }
        }
        else{
            // Ask for new Location

        }



    }

    public List<CartProduct> getOrderFormat(List<Product> mCartList) {
         List<CartProduct> mList = new ArrayList<>();
            for (int i=0;i<mCartList.size();i++){
                mList.add(new CartProduct(mCartList.get(i).getPid(),mCartList.get(i).getProductName()));
            }
            return mList;
    }

    private String getAmount(List<Product> mCartList) {
        String totalSum ="";
        for (int i=0;i<mCartList.size();i++){
            totalSum = totalSum + mCartList.get(i).getOru_price();
        }

        return totalSum;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void removeProduct(int pos, Product p) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        // IF First Time Checked then it is
        // Then show Map Picker Activity
        if (compoundButton.getId() == R.id.cart_view_check_box && b){
            //Check Box Clicked
            isDefaultChecked = b;

        }
        else{

            isDefaultChecked = false;


        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse: "+error.getLocalizedMessage());
    }

    @Override
    public void onResponse(JSONObject response) {
        Log.d(TAG, "onResponse: From Placing Order: "+response.toString());
    }
}
