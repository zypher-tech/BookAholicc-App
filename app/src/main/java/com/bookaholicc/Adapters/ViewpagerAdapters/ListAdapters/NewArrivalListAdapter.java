package com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.Fragments.HomeFragments.NewArrivalsFragment;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;
import com.bookaholicc.utils.ScreenUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 31/5/17.
 * The Adapter used in {@link NewArrivalsFragment}
 *
 */

public class NewArrivalListAdapter extends RecyclerView.Adapter<NewArrivalListAdapter.NewArrivalListItem> {


    private Context mContext;
    private List<Product> mList;
    private NewArrvialsListCallback mCallback;


    public NewArrivalListAdapter(Context mContext, List<Product> mList, NewArrvialsListCallback mCallback) {
        this.mContext = mContext;
        this.mList = mList;
        this.mCallback = mCallback;

    }

    @Override
    public NewArrivalListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewArrivalListItem(LayoutInflater.from(mContext).inflate(R.layout.product_grid_item, parent, false));
    }


    @Override
    public void onBindViewHolder(final NewArrivalListItem holder, int position) {
        //First Set the image
        Picasso.with(mContext)
                .load(mList.get(position).getImageURL())
                .resize(ScreenUtil.getScreenWidth(mContext),ScreenUtil.getScreenHeight(mContext))
                .priority(Picasso.Priority.NORMAL)
                .centerCrop()
                .into(holder.mProductImage);

        holder.mAuthorName.setText(mList.get(position).getAuthorName());
        holder.mProductName.setText(mList.get(position).getProductName());
        holder.mPriceText.setText(mList.get(position).getOru_price());
        holder.mCompleteDuration.setText(mList.get(position).getDuration());
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    /**
     * The View Holder Class for this list
     */
    public static class NewArrivalListItem extends RecyclerView.ViewHolder {
        ImageView mProductImage;
        WhitenyBooksFont mProductName;
        WhitenyBooksFont mAuthorName;
        WhitenyBooksFont mPriceText;
        WhitenyBooksFont mCompleteDuration;

        public NewArrivalListItem(View itemView) {
            super(itemView);

            mProductImage = (ImageView) itemView.findViewById(R.id.p_item_image);
            mProductName = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_pname);
            mAuthorName = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_addn_info);
            mPriceText = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_price);
            mCompleteDuration = (WhitenyBooksFont) itemView.findViewById(R.id.p_item_com_duration);
        }
    }

    public interface NewArrvialsListCallback {
        void addToCart(int pos, int pid);
    }
}