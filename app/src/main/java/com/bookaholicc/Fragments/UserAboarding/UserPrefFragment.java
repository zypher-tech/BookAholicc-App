package com.bookaholicc.Fragments.UserAboarding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.bookaholicc.Model.Tags;
import com.bookaholicc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 2/6/17.
 *
 * This Fragment Collects Some Preferences about the user
 * And Displays Books According to The Exam
 * todo: add Preference Like Appy geek Rotatble View
 *
 */

public class UserPrefFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private Context mContext;


    @BindView(R.id.up_confirm_button)
    Button confirmButton ;



    private UserPrefsCallback mCallback;

    public UserPrefsCallback getmCallback() {
        return mCallback;
    }

    public void setmCallback(UserPrefsCallback mCallback) {
        this.mCallback = mCallback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = LayoutInflater.from(mContext).inflate(R.layout.user_pref_fragment, container, false);
        ButterKnife.bind(this, mView);
        //Setup the Rotatable View


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
        if (confirmButton != null){
            confirmButton.setOnClickListener(this);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
    public void onClick(View view) {
        if (view.getId() == R.id.up_confirm_button){






        }

    }

    public interface UserPrefsCallback{
        void prefsRegsitered(Tags tag);
        void noPrefsRegistered();
    }
}
