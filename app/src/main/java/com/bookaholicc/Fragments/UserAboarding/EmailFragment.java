package com.bookaholicc.Fragments.UserAboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Model.User;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.utils.APIUtils;
import com.bookaholicc.utils.BundleKey;
import com.bookaholicc.utils.StringValidator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 2/6/17.
 * Called after Name has been Obtaiend
 * Reoistration always follows Name, Email & Optional things
 */

public class EmailFragment extends Fragment implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

    @BindView(R.id.email_tip)
    TextInputLayout mEmail;
    @BindView(R.id.email_pass_fip)
    TextInputLayout mPassword;
    @BindView(R.id.email_submit_button)
    Button mNextButton;
    private Context mContext;
    View mView;
    private String firstName;
    private String lastName;
    private String TAG = "EMAIL";

    private RegistrationCallback mCallback;

    public RegistrationCallback getmCallback() {
        return mCallback;
    }

    public void setmCallback(RegistrationCallback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.email_fragment, container, false);
        ButterKnife.bind(this, mView);



        /*get the Arguments from */
        if (getArguments() != null){
            firstName = getArguments().getString(BundleKey.ARG_FIRST_NAME);
            lastName = getArguments().getString(BundleKey.ARG_LAST_NAME);
        }



        mNextButton.setOnClickListener(this);


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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.email_submit_button){
            //Submit Button has Clicked

            createAccount();
        }
    }


    /** Validate the Fields, if Right then hit the Webservices */
    private void createAccount() {

        String emailAddress = mEmail.getEditText().getText().toString();
        String password = mPassword.getEditText().getText().toString();
        if (StringValidator.checkeEMail(emailAddress)){
            //correct Email
            if (StringValidator.checkPassword(password)){

                //Hit the webservice

                newjoin(emailAddress,password,firstName,lastName);


            }
            else{
                Snackbar.make(mView,"Enter Password Correctly",Snackbar.LENGTH_SHORT).show();
            }
        }
        else{
            //Wrong Email
            //give a Shake // TODO: 2/6/17 give a shake
            Snackbar.make(mView,"Enter Email Correcty",Snackbar.LENGTH_SHORT).show();

        }

    }

    private void newjoin(String emailAddress, String password, String firstName, String lastName) {
        JSONObject mUserObject = new JSONObject();
        try {
            mUserObject.put("firstName",firstName);
            mUserObject.put("lastName",password);
            mUserObject.put("emailAddress",emailAddress);
            mUserObject.put("password",password);
            JsonObjectRequest mRequest = new JsonObjectRequest(APIUtils.REGISTER_API,mUserObject,this,this);

            AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(mContext);
            mRequestQueue.addToRequestQue(mRequest);

        }
        catch (Exception e){
            Log.d(TAG, "newjoin: ");
        }
    }

    @Override
    public void onResponse(JSONObject response) {

        parseJson(response);

    }

    private void parseJson(JSONObject response) {
        try {
            String status  = response.getString("status");
            if (Objects.equals(status, "success")){
                //Registed
                User u = new User();
                u.setFirstName(response.getString("firstName"));
                u.setLastName(response.getString("lastName"));
                u.seteMailAddress(response.getString("email"));
                u.setPhoneNumber(response.getString("phoneNumber"));
                mCallback.registered(u);


            }
        }
        catch (Exception e){
            Log.d(TAG, "parseJson: Exception ");
            mCallback.notRegistered();
        }
    }

    private void showPreferncePage() {



    }

    private void AlreadyExists() {

    }

    private String getData(JSONObject response) {

        try {
            return  response.getString("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public interface RegistrationCallback{
        void registered(User u);
        void emailAlreadyExists();
        void phoneAlreadyExists();
        void notRegistered();
    }
}
