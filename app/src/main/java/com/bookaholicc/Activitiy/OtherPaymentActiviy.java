package com.bookaholicc.Activitiy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bookaholicc.R;

/**
 * Created by nandhu on 23/7/17.
 *  Other payment Activities
 *  this should Always Start with method StartActivity for Result Callback , We must provide return Stats
 */

class OtherPaymentActiviy extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_payment);
    }
}
