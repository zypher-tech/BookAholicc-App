package com.bookaholicc.Adapters.ViewpagerAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bookaholicc.Fragments.HomeFragments.ExamFragment;
import com.bookaholicc.Fragments.HomeFragments.ExploreFragment;
import com.bookaholicc.Fragments.HomeFragments.NewArrivalsFragment;
/**
 * Created by nandhu on 20/4/17.
 * The Adapter Which is used in {@link com.bookaholicc.MainActivity}
 *
 *
 */
public class MainFragmentAdapter extends FragmentStatePagerAdapter{

    private Context mContext;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


        switch (position){
            case 0:
                NewArrivalsFragment mFragment = new NewArrivalsFragment();
                return  mFragment;
            case 1:
                ExploreFragment mExplore = new ExploreFragment();
                return  mExplore;

            case 2:
                ExamFragment mExam = new ExamFragment();
                return  mExam;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

  /*  @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "NEW ARRIVALS";
            case 1:
                return "WHAT'S POPULAR";
            case 2:
                return "EXAM CORNER";
            default: return null;
        }
    }*/
}
