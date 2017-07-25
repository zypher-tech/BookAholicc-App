package com.bookaholicc.Activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bookaholicc.Fragments.SignUpNameFragment;
import com.bookaholicc.Fragments.UserAboarding.LoginFragment;
import com.bookaholicc.Fragments.UserAboarding.PhoneActivity;
import com.bookaholicc.Fragments.UserAboarding.UARootFragment;
import com.bookaholicc.R;
import com.bookaholicc.utils.BundleKey;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 2/6/17.
 * The Activity Which comes First Time , or During Profile Page
 */

public  class UserWelcomeActivity extends AppCompatActivity implements UARootFragment.RootCallback, SignUpNameFragment.SignUpCallback {


    private static final String TAG = "BK UA : ";
    UARootFragment mRootFragment;

    // The Face Book Login Button
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    FirebaseAuth mAuth;
    private GoogleApiClient mGoogleApiClient;
    private int RC_SIGN_IN = 101;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_aboarding_activity);
        ButterKnife.bind(this);


        mRootFragment = new UARootFragment();
        mRootFragment.setRootCallback(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ua_frag_holder, mRootFragment, "root")
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ua_frag_holder,new LoginFragment())
                .commit();
    }

    @Override
    public void showSigUpFragment() {
        SignUpNameFragment mFragment = new SignUpNameFragment();

        mFragment.setmCallback(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ua_frag_holder,mFragment)
                .commit();
    }

    @Override
    public void showEmailFragment(String fullName, String email, String pass) {
       Intent i = new Intent(this,PhoneActivity.class);
        i.putExtra(BundleKey.ARG_FULL_NAME,fullName);
        i.putExtra(BundleKey.ARG_EMAIL_ID,email);
        i.putExtra(BundleKey.ARG_PASSWORD,pass);
        startActivity(i);

    }

    @Override
    public void noSignUp() {

    }

//
//    @Override
//    public void showLoginFragment() {
//
//        /** Callback is Already Obtained in Fragment in OnAttach()*/
//        LoginFragment mFragment = new LoginFragment();
//
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"loginfrag")
//                .commit();
//    }
//
//    @Override
//    public void showSigUpFragment() {
//
//
//
//
//        SignUpNameFragment mFragment = new SignUpNameFragment();
//        mFragment.setmCallback(this);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"loginfrag")
//                .commit();
//
//    }
//
//    @Override
//    public void loggedIn(User u) {
//
//    }
//
//    @Override
//    public void notLoggedIn() {
//
//    }
//
//    @Override
//    public void inCorrectLoginDetails() {
//
//    }
//
//    @Override
//    public void showEmailFragment(String firstName, String lastName) {
//
//        Bundle b = new Bundle();
//        b.putString(BundleKey.ARG_FULL_NAME,firstName);
//        b.putString(BundleKey.ARG_LAST_NAME,lastName);
//        PhoneActivity mFragment = new PhoneActivity();
//        mFragment.setmCallback(this);
//        mFragment.setArguments(b);
//
//        //Start the Transaction
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"emailfrag")
//                .commit();
//
//    }
//
//
//    @Override
//    public void registered(User u) {
//        showPrefernceFragment();
//    }

//    private void showPrefernceFragment() {
//        UserPrefFragment mFragment = new UserPrefFragment();
//        mFragment.setmCallback(this);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mFragment,"preffrag")
//                .commit();
//    }

}
