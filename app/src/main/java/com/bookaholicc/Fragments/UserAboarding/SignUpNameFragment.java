package com.bookaholicc.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bookaholicc.R;
import com.bookaholicc.utils.StringValidator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 2/6/17.
 * The Login Framgent
 * showed in Cart & profile
 */

public class SignUpNameFragment extends Fragment implements View.OnClickListener {


    View mView;
    @BindView(R.id.reg_fi_tip)
    TextInputLayout mFirstName;
    @BindView(R.id.reg_lastname_tip)
    TextInputLayout mLastName;
    @BindView(R.id.name_submit_button)
    Button mSubmitButton;
    private Context mContext;


    /*A Callback Which Delivers The result to Activity*/
    private SignUpCallback mCallback;


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


        ButterKnife.bind(this, mView);


        mSubmitButton.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
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
        if (mCallback != null){
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
        if (view.getId() == R.id.name_submit_button){
            //Button Clicked
            showEmailPassPage();
        }
    }


    /** Submit Button Has been Clicked ,  Validate the Fields
     *  save it to file, show in the Next Fragment
     * */

    private void showEmailPassPage() {
        String vFirstName = mFirstName.getEditText().getText().toString();
        String  vLastName = mLastName.getEditText().getText().toString();
        if (StringValidator.CheckUserName(vFirstName)){
                //Correct UserName
                if (StringValidator.CheckUserName(vLastName)){
                    //Last name is Also Correct
                  mCallback.showEmailFragment(vFirstName,vLastName);
                }
                else{
                    Snackbar.make(mView,"Enter Last Name",Snackbar.LENGTH_SHORT).show();
                }
        }
        else{
            Snackbar.make(mView,"Enter First Name",Snackbar.LENGTH_SHORT).show();
        }

    }

    public interface SignUpCallback{
        void showEmailFragment(String firstName,String lastName);
        void noSignUp();
    }


}
