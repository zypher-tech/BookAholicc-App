package com.bookaholicc.Fragments.HomeFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bookaholicc.Adapters.ViewpagerAdapters.MainFragmentAdapter;
import com.bookaholicc.Fragments.HomeFragement;
import com.bookaholicc.R;
import com.bookaholicc.utils.NetworkUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 30/5/17.
 * Diplayed in {@link HomeFragement}
 * provided by {@link MainFragmentAdapter}
 */

public class NewArrivalsFragment extends Fragment {


    private Context mContext;
    private View mView;
    @BindView(R.id.new_arrivals_root)
    FrameLayout mRootFrame;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

            mContext = context;

    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.new_arrivals_fragment,container,false);
        ButterKnife.bind(this,mView);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mRootFrame.removeAllViews();
        View Root = View.inflate(mContext,R.layout.profile_frag,mRootFrame);

        //Hit the Webservice;
        //Show the Results
        //Unitll Then SHow Loading results




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
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
