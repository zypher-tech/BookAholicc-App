package com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bookaholicc.Fragments.SwipableProductFragment;
import com.bookaholicc.Model.Product;
import com.bookaholicc.utils.BundleKey;
import com.google.gson.Gson;



import java.util.List;

/**
 * Created by nandhu on 18/3/17.
// * This Adapter Provides
 * with a product from
 *
 *
 */
public class ProductSwipeAdapter extends FragmentStatePagerAdapter{



    private Context mContext;
    private List<Product> mProductList;

    public ProductSwipeAdapter(FragmentManager fm,Context c , List<Product> mList) {
        super(fm);
        this.mContext = c;
        this.mProductList = mList;
    }

    @Override
    public Fragment getItem(int position) {

        //Return a Static Fragment , With Product as argument

        Bundle b = new Bundle();
        Gson gs = new Gson();

        // Initiliaze the Fragment with Individual Fragments
        String productJson = gs.toJson(mProductList.get(position));
        b.putString(BundleKey.ARG_PRODUCT, productJson);
        SwipableProductFragment mFragment = new SwipableProductFragment();
        mFragment.setArguments(b);
        return mFragment;

    }

    @Override
    public int getCount() {
        return mProductList.size();
    }
}
