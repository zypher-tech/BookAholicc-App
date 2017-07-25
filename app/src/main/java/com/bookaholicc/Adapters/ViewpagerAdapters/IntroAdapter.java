package com.bookaholicc.Adapters.ViewpagerAdapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bookaholicc.R;

/**
 * Created by nandhu on 26/7/17.
 *
 */

public class IntroAdapter  extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;

    public IntroAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        switch (position){
            case 0:

                View itemView = mLayoutInflater.inflate(R.layout.intro_item_1, container, false);
                container.addView(itemView);
                return itemView;
            case 1:
                View itemView2 = mLayoutInflater.inflate(R.layout.intro_item_2, container, false);
                container.addView(itemView2);
                return itemView2;
            case 2:
                View itemView3 = mLayoutInflater.inflate(R.layout.intro_item_3, container, false);
                container.addView(itemView3);
                return itemView3;
            default:
                return null;
        }

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}

