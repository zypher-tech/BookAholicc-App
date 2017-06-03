package com.bookaholicc.Activitiy;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bookaholicc.Fragments.SignUpNameFragment;
import com.bookaholicc.Fragments.UserAboarding.EmailFragment;
import com.bookaholicc.Fragments.UserAboarding.LoginFragment;
import com.bookaholicc.Fragments.UserAboarding.UARootFragment;
import com.bookaholicc.Fragments.UserAboarding.UserPrefFragment;
import com.bookaholicc.Model.Tags;
import com.bookaholicc.Model.User;
import com.bookaholicc.R;
import com.bookaholicc.utils.BundleKey;
import com.bookaholicc.utils.ScreenUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bookaholicc.Fragments.UserAboarding.LoginFragment.*;

/**
 * Created by nandhu on 2/6/17.
 * The Activity Which comes First Time , or During Profile Page
 */

public  class UserAboardingActivity extends AppCompatActivity  implements UARootFragment.RootCallback, LoginCallback, SignUpNameFragment.SignUpCallback, EmailFragment.RegistrationCallback, UserPrefFragment.UserPrefsCallback {


    private static final String TAG = "BK UA : ";
    UARootFragment mRootFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_aboarding_activity);
        ButterKnife.bind(this);


        mRootFragment = new UARootFragment();
        mRootFragment.setRootCallback((UARootFragment.RootCallback)this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ua_frag_holder,mRootFragment,"root")
                .setTransition(R.animator.active_raise)
                .commit();




    }



    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void showLoginFragment() {

        /** Callback is Already Obtained in Fragment in OnAttach()*/
        LoginFragment mFragment = new LoginFragment();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ua_frag_holder,mFragment,"loginfrag")
                .commit();
    }

    @Override
    public void showSigUpFragment() {




        SignUpNameFragment mFragment = new SignUpNameFragment();
        mFragment.setmCallback(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ua_frag_holder,mFragment,"loginfrag")
                .commit();

    }

    @Override
    public void loggedIn(User u) {

    }

    @Override
    public void notLoggedIn() {

    }

    @Override
    public void inCorrectLoginDetails() {

    }

    @Override
    public void showEmailFragment(String firstName, String lastName) {

        Bundle b = new Bundle();
        b.putString(BundleKey.ARG_FIRST_NAME,firstName);
        b.putString(BundleKey.ARG_LAST_NAME,lastName);
        EmailFragment mFragment = new EmailFragment();
        mFragment.setmCallback(this);
        mFragment.setArguments(b);

        //Start the Transaction
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ua_frag_holder,mFragment,"emailfrag")
                .commit();

    }

    @Override
    public void noSignUp() {

    }

    @Override
    public void registered(User u) {
        showPrefernceFragment();
    }

    private void showPrefernceFragment() {
        UserPrefFragment mFragment = new UserPrefFragment();
        mFragment.setmCallback(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ua_frag_holder,mFragment,"preffrag")
                .commit();
    }

    @Override
    public void emailAlreadyExists() {

    }

    @Override
    public void phoneAlreadyExists() {

    }

    @Override
    public void notRegistered() {

    }

    @Override
    public void prefsRegsitered(Tags tag) {

    }

    @Override
    public void noPrefsRegistered() {

    }
}
