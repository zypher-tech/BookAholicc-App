package com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 * The Adapter used for Disaplaying in HorizontalAdapter Scrolling Fashion
 * {@link com.bookaholicc.Fragments.HomeFragments.ExploreFragment}
 */

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizaontalItem> {


    private Context mContext;
    private List<Product> mList;
    private Horizontalcallback mCallback;


    public HorizontalAdapter(Context mContext, List<Product> mList, Horizontalcallback mCallback) {
        this.mContext = mContext;
        this.mList = mList;
        this.mCallback = mCallback;

    }

    @Override
    public HorizontalAdapter.HorizaontalItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HorizontalAdapter.HorizaontalItem(LayoutInflater.from(mContext).inflate(R.layout.horizontal_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final HorizontalAdapter.HorizaontalItem holder, int position) {


    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    /**
     * The View Holder Class for this list
     */
    public static class HorizaontalItem extends RecyclerView.ViewHolder {
        ImageView mProductImage;
        WhitenyBooksFont mProductName;
        WhitenyBooksFont mAuthorName;
        WhitenyBooksFont mPriceText;
        WhitenyBooksFont mCompleteDuration;

        public HorizaontalItem(View itemView) {
            super(itemView);

            mProductImage = (ImageView) itemView.findViewById(R.id.p_item_image);
            mProductName = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_pname);
            mAuthorName = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_addn_info);
            mPriceText = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_price);
            mCompleteDuration = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_com_duration);
        }
    }

    public interface Horizontalcallback {
        void productClicked(int pid,int genreId);
    }
}
