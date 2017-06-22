package com.bookaholicc.services;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

/**
 * Created by nandhu on 21/6/17.
 * A Token iS Generated and send to Server use DataStore to track the Sent Status
 * Please see { https://firebase.google.com/docs/cloud-messaging/android/client}
 * and {  https://github.com/firebase/quickstart-android/blob/master/messaging/app/src/main/java/com/google/firebase/quickstart/fcm/MyFirebaseInstanceIDService.java#L35-L45}
 */

public class FirebaseTokenService extends FirebaseInstanceIdService implements Response.ErrorListener, Response.Listener<JSONObject> {


    private String TAG = "BK Token ";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        String userId = null;

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        DataStore mStore = DataStore.getStorageInstance(getApplicationContext());
        if (mStore != null){
            userId = mStore.getUserId();
        }

        if (userId != null && refreshedToken != null){
            sendTokenToServer(userId,refreshedToken);
        }
    }


    /**  APIUtils.SAVE_TOKEN_API accepts 3 Arguments
     *
     *          "profileId"(userId)
     *          "tokenId"
     *          "fromWhere" --> Indicating where to save this token
     *
     * */
    private void sendTokenToServer(String userId, String refreshedToken) {

        JSONObject mObject = new JSONObject();
        try {
            mObject.put(APIUtils.PROFILE_ID,userId);
            mObject.put(APIUtils.TOKEN_ID,refreshedToken);
            mObject.put(APIUtils.FROM_WHERE,"0");
        } catch (JSONException e) {
            Log.d(TAG, "sendTokenToServer: Exception : "+e.getLocalizedMessage());
        }

        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST,APIUtils.SAVE_TOKEN_API,mObject,this,this);

        AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(getApplicationContext());
        mRequestQueue.addToRequestQue(mRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        DataStore mStore  = DataStore.getStorageInstance(getApplicationContext());
        mStore.setTokenSaved(false);
    }

    @Override
    public void onResponse(JSONObject response) {
        DataStore mStore  = DataStore.getStorageInstance(getApplicationContext());
        try {
            if (Objects.equals(response.getString("isAccepted"),"1")){
                //Token Save Successfully
                mStore.setTokenSaved(true);
                mStore.saveToken(response.getString("tokenId"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
