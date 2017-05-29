package com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 23/5/17.
 *
 * This adapter Provides Book Recommendation If the User has Made No Orders Till yet
 *
 * // TODO: 23/5/17 Make The Layout Appear Full When Cicled , Or the Dragged
 */

public class NoOrderAdapter extends RecyclerView.Adapter<NoOrderAdapter.NoOrderProductsList> {



    private Context mContext;
    private List<Product> mList;
    private NoOrderListCallback mCallback;


    public NoOrderAdapter(Context mContext, List<Product> mList,NoOrderListCallback mCallback) {
        this.mContext = mContext;
        this.mList = mList;
        this.mCallback = mCallback;

    }

    @Override
    public NoOrderProductsList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.nor_order_list_item, parent, false);
        return new NoOrderProductsList(view);
    }


    @Override
    public void onBindViewHolder(final NoOrderProductsList holder, int position) {

        Picasso.with(mContext)
                .load(R.mipmap.bookaholic)
                .resize(60,60)
                .into(holder.mImage);
        final int pos = position;
        holder.mName.setText(mList.get(pos).getProductName());
        holder.mGenreText.setText(mList.get(pos).getGenre());
        holder.mAddtoCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCallback != null){
                    mCallback.addToCart(pos,mList.get(pos).getPid());
                }
            }
        });



    }



    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class NoOrderProductsList extends RecyclerView.ViewHolder {

//        The Varaibles used in this class
        @BindView(R.id.no_item_p_image)
        ImageView mImage;
        @BindView(R.id.no_p_name)
        TextView mName;
        @BindView(R.id.no_add_button)
        Button mAddtoCartButton;
        @BindView(R.id.no_order_genre_text)
        TextView mGenreText;
        @BindView(R.id.no_rate_text)
        TextView mPriceText;

        public NoOrderProductsList(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface NoOrderListCallback {
        void addToCart(int pos, int pid);
    }
}
