package com.bookaholicc.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by nandhu on 18/10/16.
 */

public class NetworkUitls {
    private Context mContext;
    public NetworkUitls(Context c) {
        mContext=c;
    }

    public  boolean isOnline(){

        ConnectivityManager co=(ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nw=co.getActiveNetworkInfo();
        return (nw!=null && nw.isConnected());



    }
}
