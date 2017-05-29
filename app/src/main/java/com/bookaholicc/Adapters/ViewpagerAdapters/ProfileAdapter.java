package com.bookaholicc.Adapters.ViewpagerAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bookaholicc.Fragments.ProfileFragments.AccountFragment;
import com.bookaholicc.Fragments.ProfileFragments.MyOrdersFragment;
import com.bookaholicc.Fragments.ProfileFragments.MyReturnsFragment;
import com.bookaholicc.utils.BundleKey;

/**
 * Created by nandhu on 23/5/17.
 * The Adapter used in {@link com.bookaholicc.Fragments.ProfileFragment}
 */

public class ProfileAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    public ProfileAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AccountFragment();
            case 1:
                return new MyOrdersFragment();
            case 2:
                return new MyReturnsFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Accounts";
            case 1:
                return "My Orders";
            case 2:
                return "Returns";
            default: return null;
        }
    }
}