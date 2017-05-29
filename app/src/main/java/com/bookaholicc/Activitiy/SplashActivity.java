package com.bookaholicc.Activitiy;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.bookaholicc.CustomUI.HelviticaTv;
import com.bookaholicc.MainActivity;
import com.bookaholicc.R;

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



    @BindView(R.id.splash_logo)
    ImageView mSplashImage;
    @BindView(R.id.splash_text)
    HelviticaTv mSplashText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        ButterKnife.bind(this);


        runIntroAnim();


    }

    private void runIntroAnim() {
        mSplashImage.setAlpha(0f);


        mSplashText.setAlpha(0f);
        mSplashImage.animate()
                .alpha(1f)
                .scaleX(1)
                .scaleY(1)
                .setDuration(1200)
                .setInterpolator(new DecelerateInterpolator())
                .start();
        mSplashText.animate()
                .alpha(1)
                .setDuration(400)
                .setStartDelay(1500)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        startMainActivity();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .start();

    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}


