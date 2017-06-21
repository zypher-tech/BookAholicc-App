package com.bookaholicc.Adapters.ViewpagerAdapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholicc.Model.Combo;
import com.squareup.picasso.Picasso;
import com.bookaholicc.Model.Product;
import com.bookaholicc.utils.ScreenUtil;
import com.bookaholicc.CustomUI.FourThreeImageView;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;
import com.bookaholicc.utils.ScreenUtil;

import java.util.List;

import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by nandhu on 16/3/17.
 * The Adapter which is used in {@link }
 *
 */

public class SwipeAdapterNewArrivals extends PagerAdapter {




    private List<Combo> mList;
    private Context mContext;
    private ComboInterface mCallback ;







    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        (container).removeView((View) object);
    }

    @Override
    public int getCount() {

            return mList.size();

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.image_view_land, container, false);
        ButterKnife.bind(this, layout);
        ImageView image = (ImageView) layout.findViewById(R.id.top_image);
        Picasso.with(mContext).load(mList.get(position).getImageURL())
                .resize(ScreenUtil.getScreenWidth(mContext),ScreenUtil.getScreenHeight(mContext))
                .centerInside()
                .transform(new RoundedCornersTransformation(15,5))
                .into(image);
        container.addView(layout);


         return layout;
    }

    public SwipeAdapterNewArrivals(List<Combo> mList, Context mContext, ComboInterface mCallback) {
        this.mList = mList;
        this.mContext = mContext;
        this.mCallback = mCallback;
    }

    public interface ComboInterface {
        void ComboproductClicked(Product p);
        }
    }

