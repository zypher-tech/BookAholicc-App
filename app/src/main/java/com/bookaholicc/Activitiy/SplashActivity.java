package com.bookaholicc.Activitiy;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.bookaholicc.CustomUI.HelviticaTv;
import com.bookaholicc.MainActivity;
import com.bookaholicc.R;
import com.bookaholicc.utils.ScreenUtil;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 29/5/17.
 * The Splash Acitivy Which is Show First
 * After it , show the {@link com.bookaholicc.MainActivity}
 *
 *
 */

public class SplashActivity extends AppCompatActivity {


    private static final long SPLASH_TIME_OUT = 2500;
    @BindView(R.id.splash_logo)
    ImageView mSplashImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        ButterKnife.bind(this);


        Picasso.with(this).load(R.mipmap.splash_bg)
                .resize(ScreenUtil.getScreenWidth(this),ScreenUtil.getScreenHeight(this))
                .centerCrop()
                .into(mSplashImage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
            }
        }, SPLASH_TIME_OUT);



    }

    private void runIntroAnim() {




    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}


