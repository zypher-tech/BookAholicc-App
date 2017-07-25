package com.bookaholicc.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholicc.Adapters.ViewpagerAdapters.MainFragmentAdapter;
import com.bookaholicc.CustomUI.NavigationTabStrip;
import com.bookaholicc.Fragments.HomeFragments.NewArrivalsFragment;
import com.bookaholicc.MainActivity;
import com.bookaholicc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by nandhu on 29/5/17.
 * The Fragment Showed in  {@link MainActivity}
 * Make Sure to Cache The Values
 */

public class HomeFragement extends Fragment {
    private Context mContext;
    @BindView(R.id.nav_strip)
    NavigationTabStrip mTab;
    @BindView(R.id.main_pager)
    ViewPager mPager;


    MainFragmentAdapter mAdapter;


    String[] pageTitles = {"New Arrival's", "Explore", "Exam Corner"};
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.home_fragment, container, false);
        unbinder = ButterKnife.bind(this, v);
        setUpPager();
        return v;
    }


    private void setUpPager() {


        mAdapter = new MainFragmentAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.setOffscreenPageLimit(3);
        mTab.setTitles(pageTitles);

        mTab.setViewPager(mPager);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null){
                unbinder.unbind();
            }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}