package com.bookaholicc.DataHandler;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Model.Product;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.utils.APIUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by nandhu on 20/6/17.
 *
 */

public class OrdePlacer implements Response.ErrorListener, Response.Listener<JSONObject> {



    private orderCallback mCallback;
    private Context mContext;
    private String TAG = "ORDER_PLACER";


    public OrdePlacer(orderCallback mCallback, Context mContext) {
        this.mCallback = mCallback;
        this.mContext = mContext;
    }


    private void  placeOrder(List<Product> mProducts, String  firstName, String phoneNumber,double orderLat,double orderLon){
        JSONObject mObject  = new JSONObject();
        JSONArray mProductArray = new JSONArray();
         int totalSum = 0;

        try {
            //Get Individual Products
            for (int i = 0;i<mProducts.size();i++){


                    String  pid = mProducts.get(i).getPid();

                //Adding to the total Products
                    totalSum = Integer.parseInt(mProducts.get(i).getPrice());

                    String pName = mProducts.get(i).getProductName();
                    JSONObject mObject1 = new JSONObject();
                        mObject.put(APIUtils.PID,pid);
                        mObject.put(APIUtils.PRODUCT_NAME,pName);
                mProductArray.put(i,mObject1);
                }

                //Object Have Been Contructed and put in Array
            mObject.put(APIUtils.FIRST_NAME,firstName);
            mObject.put(APIUtils.PHONE_NUMBER,phoneNumber);
            mObject.put(APIUtils.PRODUCTS_KEYWORD,mProductArray);
            mObject.put(APIUtils.ORDER_LAT,orderLat);
            mObject.put(APIUtils.ORDER_LON,orderLon);
            mObject.put(APIUtils.AMOUNT,totalSum);
        }
            catch (Exception e){
                Log.d(TAG, "placeOrder: "+e.getLocalizedMessage());
        }
        JsonObjectRequest mObjectRequest = new JsonObjectRequest(Request.Method.POST, APIUtils.HOME_ENDPOINT_PLACE_ORDER,mObject,this,this);

         AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(mContext);
        if (mRequestQueue == null) {
            mRequestQueue.addToRequestQue(mObjectRequest);
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        boolean isAccepted  = false;
        try {
            isAccepted = response.getBoolean(APIUtils.IS_ACCEPTED);
        } catch (JSONException e) {
            Log.d(TAG, String.format("onResponse: %s", e.getLocalizedMessage()));
        }
        if (isAccepted){
                 Order mOrder = ParseOrder(response);
                 if (mCallback!= null){
                     mCallback.orderPlaced(mOrder);
                 }
             }
             else{
                 mCallback.noOrderPlaced();


             }
    }
    private Order ParseOrder(JSONObject response) {

        try {
            String orderId = response.getString(APIUtils.ORDER_ID);
            String firstName = response.getString(APIUtils.FIRST_NAME);
            String orderAccepted = response.getString(APIUtils.ORDER_ACCEPTED);
            double orderLat = response.getDouble(APIUtils.ORDER_LON);
            double orderLon = response.getDouble(APIUtils.ORDER_LON);
            int amount = response.getInt(APIUtils.AMOUNT);
            String phoneNumber = response.getString(APIUtils.PHONE_NUMBER);
            JSONArray mArray = response.getJSONArray("products");
            List<MiniProduct> mProductsList = new ArrayList<>();
            for (int i = 0; i < mArray.length(); i++) {
                JSONObject mObject = mArray.getJSONObject(i);
                String pid = mObject.getString(APIUtils.PID);
                String pName = mObject.getString(APIUtils.PRODUCT_NAME);
                String imageUrl = mObject.getString(APIUtils.IMAGE_URL);
                mProductsList.add(new MiniProduct(pName, pid, imageUrl));


            }


            Order mOrder = new Order(mProductsList, orderId, phoneNumber, orderLat, orderLon);
            return mOrder;
        }
        catch (Exception e){
            Log.d(TAG, "ParseOrder: "+e.getLocalizedMessage());
        }
    }


    interface orderCallback{
        void orderPlaced(Order order);
        void noOrderPlaced();
    }

}
