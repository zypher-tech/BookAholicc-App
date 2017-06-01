package com.bookaholicc.Network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by nandhu on 17/10/16.
 *
 */

public class AppRequestQueue {
    private Context mContext;
    protected RequestQueue mRequestQueue;


    private static AppRequestQueue mRequestQ;

    public AppRequestQueue(Context mContext) {
        this.mContext = mContext;
    }

//    get the single object here..with that singleton get getRequest queue

    public static synchronized AppRequestQueue getInstance(Context context) {
        if (mRequestQ == null) {
            mRequestQ = new AppRequestQueue(context);
        }
        return mRequestQ;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQue(Request<T> req) {
        getRequestQueue().add(req);
    }


    public void cancelRequest(String netTag) {
        if (mRequestQueue!=null){
            getRequestQueue().cancelAll(netTag);
        }
    }
}

