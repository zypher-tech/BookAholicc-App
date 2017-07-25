package com.bookaholicc.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bookaholicc.CustomUI.HelviticaTv;
import com.bookaholicc.R;
import com.bookaholicc.utils.StringValidator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by nandhu on 2/6/17.
 * The Login Framgent
 * showed in Cart & profile
 */

public class SignUpNameFragment extends Fragment implements View.OnClickListener {


    View mView;
    @BindView(R.id.s_title)
    HelviticaTv mTitle;
    @BindView(R.id.s_name_e)
    TextInputEditText mName;
    @BindView(R.id.s_email_e)
    TextInputEditText mEmail;
    @BindView(R.id.s_pass_e)
    TextInputEditText mPas;
    @BindView(R.id.s_signup_button)
    Button mBut;
    Unbinder unbinder;
    private Context mContext;


    /*A Callback Which Delivers The result to Activity*/
    private SignUpCallback mCallback;
    private String TAG  = "SIGN Up";


    public SignUpCallback getmCallback() {
        return mCallback;
    }

    public void setmCallback(SignUpCallback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.registartion_name_fragment, container, false);
        unbinder = ButterKnife.bind(this, mView);

        mBut.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
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
        if (mCallback != null) {
            mCallback.noSignUp();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
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
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.s_signup_button){
            //Button Clicked
            showEmailPassPage();
        }
    }




    /**
     * Submit Button Has been Clicked ,  Validate the Fields
     * save it to file, show in the Next Fragment
     */

    private void showEmailPassPage() {
        String mNameFul = mName.getText().toString();
        String  mEmaill = mEmail.getText().toString();
        String pass  = mPas.getText().toString();
        if (StringValidator.CheckUserName(mNameFul)){
                //Correct UserName
                if (StringValidator.checkeEMail(mEmaill)){
                    //Email name is Also Correct
                        if (StringValidator.checkPassword(pass)){


                        showEndingAnimation(mNameFul,mEmaill,pass);
                    }

                }
                else{
                    Snackbar.make(mView,"Enter Last Name",Snackbar.LENGTH_SHORT).show();
                }
        }
        else{
            Snackbar.make(mView,"Enter First Name",Snackbar.LENGTH_SHORT).show();
        }

    }

    private void showEndingAnimation(String mNameFul, String mEmaill, String pass) {

//        mBut.setAlpha();
        Log.d(TAG, "showEndingAnimation: Perfrom SOme Animation");
        mCallback.showEmailFragment(mNameFul,mEmaill,pass);
    }

    public interface SignUpCallback {
        void showEmailFragment(String firstName, String email,String pass);
        void noSignUp();
    }


}
