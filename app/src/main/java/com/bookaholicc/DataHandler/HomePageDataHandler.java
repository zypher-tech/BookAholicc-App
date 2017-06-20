package com.bookaholicc.DataHandler;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Model.Combo;
import com.bookaholicc.Model.Product;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.utils.APIUtils;
import com.google.android.gms.common.api.Api;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 16/6/17.
 * The Class Which Handlers Caching , Sending Request etc
 *
 */

public class HomePageDataHandler implements Response.ErrorListener, Response.Listener<JSONObject> {


    private static final String TAG = "BK HOMEDATA";
    private Context mContext;
    private static boolean isRequestMade = false;
    private homeDataCallbacks mCallback ;
    public HomePageDataHandler(Context mContext,homeDataCallbacks mCallback){

        this.mCallback = mCallback;
        this.mContext = mContext;

    }

    public void makeRequests(){
        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST, APIUtils.HOME_API,null,this,this);
        AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(mContext);
        if (mRequestQueue != null){
            mRequestQueue.addToRequestQue(mRequest);

        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }


    /** got the response
     *
     *
     * */
    @Override
    public void onResponse(JSONObject response) {

        try {
            JSONArray mProductsArray = response.getJSONArray("products");
            JSONArray mComboArray  = response.getJSONArray("products");
            List<Product> mProductsList = getProductListFromJson(mProductsArray);
            List<Combo> mCombosList = getComboListFromJson(mComboArray);


            //Tell Data is loaded
            if (mCallback != null){
                mCallback.dataLoaded(mProductsList,mCombosList);
            }
        }
        catch (Exception e){
            Log.d(TAG, "onResponse: Exception in Parsing home");
        }

    }

    private List<Combo> getComboListFromJson(JSONArray mComboArray) {

        //Make Sure not more than 7
        int productCount = mComboArray.length();
        List<Combo> mList = new ArrayList<>(productCount);
        try {
            for (int i = 0; i < productCount; i++) {
                JSONObject pObj = null;
                // Get the Oject Turn It to String
                pObj = mComboArray.getJSONObject(i);

                //Got the Object , get String Push it to List
                mList.add(new Combo(pObj.getString(APIUtils.COMBO_ID),
                            pObj.getString(APIUtils.COMBO_NAME),
                        pObj.getString(APIUtils.COMBO_DESC),
                        pObj.getString(APIUtils.C_IMAGE_URL),
                        pObj.getString(APIUtils.OUR_PRICE),
                        pObj.getString((APIUtils.DURATION))));

            }
            return mList;
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getProductListFromJson: "+e.getLocalizedMessage());
        }
        return null;

    }

    private List<Product> getProductListFromJson(JSONArray mProductsArray) {
        int productCount = mProductsArray.length();
        List<Product> mList = new ArrayList<>(productCount);
        try {
            for (int i = 0; i < productCount; i++) {
                JSONObject pObj = null;
               // Get the Oject Turn It to String
                pObj = mProductsArray.getJSONObject(i);

                //Got the Object , get String Push it to List
                mList.add(new Product(pObj.getString(APIUtils.PID),
                        pObj.getString(APIUtils.PRODUCT_NAME),
                        pObj.getString(APIUtils.PRODUCT_DESC),
                        pObj.getString(APIUtils.AUTHOR_NAME),
                        pObj.getString(APIUtils.PUBLISHER_NAME),
                        pObj.getString(APIUtils.MRP),
                        pObj.getString(APIUtils.IS_TOP_RATED),
                        pObj.getString(APIUtils.IS_BEST_SELLER),
                        pObj.getString(APIUtils.BOOK_SUMMARY),
                        pObj.getString(APIUtils.BASE_CATEGORY),
                        pObj.getString(APIUtils.SUB_CATEGORY),
                        pObj.getString(APIUtils.OUR_PRICE),
                        pObj.getString(APIUtils.DURATION),
                        pObj.getString(APIUtils.IMAGE_URL))   // Construct of Product
                );

                // Combo List


            }
            return mList;
        }
         catch (Exception e) {
            e.printStackTrace();
             Log.d(TAG, "getProductListFromJson: "+e.getLocalizedMessage());
        }
        return null;
    }




    private  void unregisterCallback(){
        this.mCallback = null;
        this.mContext = null;

    }

    public static boolean isRequestMade() {
        return isRequestMade;
    }

    public static void setIsRequestMade(boolean isRequestMade) {
        HomePageDataHandler.isRequestMade = isRequestMade;
    }

    public interface homeDataCallbacks{
        void dataLoaded(List<Product> mProductsList, List<Combo> mComboList);
        void noDataLoaded();
    }
}
