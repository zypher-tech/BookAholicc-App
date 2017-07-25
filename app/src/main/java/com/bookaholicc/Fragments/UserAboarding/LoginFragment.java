package com.bookaholicc.Fragments.UserAboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholicc.Model.User;
import com.bookaholicc.R;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 3/6/17.
 * THe Fragment Must SHow in SHared Manned
 * Uses Email & pass,
 * Branches out to Forgot Password, OTP SMS, Question page
 */

public class LoginFragment extends Fragment{


    private View mView ;
    private Context mContext;



    public LoginCallback mCallback;

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
        mView = LayoutInflater.from(mContext).inflate(R.layout.login_fragment,container,false);
        ButterKnife.bind(this,mView);


        return mView;
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
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        mCallback = (LoginCallback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mCallback != null) {

            mCallback = null;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void setLoginCallback(LoginCallback loginCallback) {
        this.mCallback = loginCallback;
    }

    public interface LoginCallback{
        void loggedIn(User u);
        void notLoggedIn();
        void inCorrectLoginDetails();

    }
}
