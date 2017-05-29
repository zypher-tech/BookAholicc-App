package com.bookaholicc.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

//import com.strictlyindian.rentsmart.Activity.HomeActivity;

/**
 * Created by nandhu on 2/4/17.
 *
 * A Class Whihc handles Network Related Codes
 */
public class NetworkUtils {



    /*Returns a Boolean Representing the Connection Type */
    public static boolean isConnectectionPresent(Context mContext) {
        ConnectivityManager connMgr =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            return true;
        }
        return false;
    }


}
