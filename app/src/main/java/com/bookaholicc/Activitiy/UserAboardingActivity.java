package com.bookaholicc.Activitiy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.bookaholicc.Fragments.UserAboarding.PhoneActivity;
import com.bookaholicc.Fragments.UserAboarding.UARootFragment;
import com.bookaholicc.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 2/6/17.
 * The Activity Which comes First Time , or During Profile Page
 */

public  class UserAboardingActivity extends AppCompatActivity  implements  GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {


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

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            handleFirebaseUser(user);
        }
        else{
            startLoginProcess();
        }











//
//        mRootFragment = new UARootFragment();
//        mRootFragment.setRootCallback((UARootFragment.RootCallback)this);
//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.ua_frag_holder,mRootFragment,"root")
//                .setTransition(R.animator.active_raise)
//                .commit();
//


    }

    private void handleFirebaseUser(FirebaseUser user) {

    }

    private void startLoginProcess() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this , this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        findViewById(R.id.sign_in_button).setOnClickListener(this);

        loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                // App code

            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });


        // Pass the activity result back to the Facebook SDK


    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           //Start new Activity
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//                            Toast.makeText(GoogleSignInActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            // SHow Toast
                        }

                        // ...
                    }
                });
    }

    /** Handling Facebook Sing In Flow*/
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            saveFirebaseUserDetails(user);
                            // Start Main Activity
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            /*Toast.makeText(FacebookLoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);*/
                        }

                        // ...
                    }


                });
    }

    private void saveFirebaseUserDetails(FirebaseUser user) {
      String firstName  = user.getDisplayName();
      String email = user.getEmail();
      startActivity(new Intent(this, PhoneActivity.class));




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

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleGoogleSignIn(result);
        }

        callbackManager.onActivityResult(requestCode, resultCode, data);




    }

    private void handleGoogleSignIn(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            handleGoogleSignIn(result);
        } else {
            // Signed out, show unauthenticated UI.

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
//        b.putString(BundleKey.ARG_FIRST_NAME,firstName);
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


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;

        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
}
