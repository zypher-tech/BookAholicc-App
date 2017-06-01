package com.bookaholicc.Network;

import com.android.volley.NetworkError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;


/**
 * Created by nandhu on 18/10/16.
 *
 */

public class ErrorHandler implements Response.ErrorListener {



    private ErrorHandlerCallbacks mCallback;


    public ErrorHandler(ErrorHandlerCallbacks mCallback) {
        this.mCallback = mCallback;

    }

    private static final String TAG = "Volley Error";

    @Override
    public void onErrorResponse(VolleyError error) {





        if (error instanceof NetworkError){

           mCallback.NetworkError();

        }else if (error instanceof TimeoutError){
          mCallback.TimeoutError();
        }
        else if (error instanceof ServerError){
           mCallback.ServerError();
        }
        else{
            mCallback.NetworkError();
        }
        mCallback.NetworkError();
    }

    public interface ErrorHandlerCallbacks{
        void TimeoutError();
        void NetworkError();
        void ServerError();
    }
}
