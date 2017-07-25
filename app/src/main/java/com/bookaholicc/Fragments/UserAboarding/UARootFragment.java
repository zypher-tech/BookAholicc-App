package com.bookaholicc.Fragments.UserAboarding;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bookaholicc.Adapters.ViewpagerAdapters.IntroAdapter;
import com.bookaholicc.R;
import com.bookaholicc.utils.ScreenUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 3/6/17.

 */

public class UARootFragment extends Fragment implements View.OnClickListener {


    private View mView;
    private Context mContext;

    @BindView(R.id.ua_login_button)
    Button mLoginButton;
    @BindView(R.id.ua_signup_button) Button mSignUpButtton;


    @BindView(R.id.ua_pager)
    ViewPager mPager;

    @BindView(R.id.ua_root)
    FrameLayout mRoot;
    private RootCallback mCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.ua_frag_root,container,false);
        ButterKnife.bind(this,mView);

        // Set Adapter to Views
        // Listen for Button CLick Events
        // Fire Up the nExt Fragemnt with callbacks

        IntroAdapter mAdapter = new IntroAdapter(getContext());
        mPager.setAdapter(mAdapter);
        mLoginButton.setOnClickListener(this);
        mSignUpButtton.setOnClickListener(this);





//        startAnimation();
        return mView;
    }


    private void startAnimation() {
        mRoot.setTranslationY(ScreenUtil.getScreenHeight(mContext));
        mLoginButton.setAlpha(0f);
        mSignUpButtton.setAlpha(0f);
        mRoot.animate().translationY(0)
                .setDuration(600)
                .setInterpolator(new AccelerateInterpolator(1.5f))
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        mLoginButton.animate().alpha(1).setInterpolator(new DecelerateInterpolator()).start();
                        mSignUpButtton.animate().alpha(1).setInterpolator(new DecelerateInterpolator()).start();
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
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null){
            mContext = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mLoginButton != null ){
            mLoginButton.setOnClickListener(this);
        }
        if (mSignUpButtton != null){
            mSignUpButtton.setOnClickListener(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

            mContext = context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


    private void showSignUpPage() {

        mCallback.showSigUpFragment();


    }

    private void showLoginPage() {
        mCallback.showLoginFragment();

    }

    @Override
    public void onClick(View view) {
        if (view.getId()  == R.id.ua_login_button){
            //Login Button Has been Clicked
            showLoginPage();
        }
        if (view.getId() == R.id.ua_signup_button){
            //Sign Up Button Clicked
            showSignUpPage();
        }
        else{
            //

        }
    }

    public void setRootCallback(RootCallback rootCallback) {
        this.mCallback = rootCallback;
    }

    public interface RootCallback{
        void showLoginFragment();
        void showSigUpFragment();
    }
}
