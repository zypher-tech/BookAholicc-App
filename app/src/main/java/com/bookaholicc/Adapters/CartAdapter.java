package com.bookaholicc.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bookaholicc.CustomUI.OpenSansTextView;
import com.bookaholicc.Fragments.CartFragment;
import com.bookaholicc.Model.PriceInfo;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 22/6/17.
 *
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Cartholder> {

    private CartCallbacks mCartCallbacks;
    private List<Product> mlist ;
    private Context mContext;
    private String TAG = "CART_ADAPTER";


    public CartAdapter(List<Product> mCartList, Context mContext, CartCallbacks mCallback) {
        this.mCartCallbacks = mCallback;
        this.mContext = mContext;
        this.mlist = mCartList;

    }

    @Override
    public Cartholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(mContext).inflate(R.layout.cart_item,parent,false);
        return new Cartholder(v);
    }

    @Override
    public void onBindViewHolder(Cartholder holder, int position) {


        // Cart Products
        Glide.with(mContext)
                .load(mlist.get(position).getImageURL())
                .into(holder.mCartImage);
        //

        holder.mName.setText(mlist.get(position).getProductName());
        holder.mPrice.setText(mlist.get(position).getPrice());
        final List<PriceInfo> mInfo = mlist.get(position).getmPricing();
        if (mInfo == null){
            Log.d(TAG, "onBindViewHolder: Null Pricing Adapter");
        }




        //prepare Adapter for Class SPinner
        DurationSpinner
                mAdapter = new DurationSpinner(mContext,R.layout.simple_spinner,mInfo);

        holder.mDurationSpinner.setAdapter(mAdapter);
        holder.mDurationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Log.d(TAG, "onItemSelected: New Amount for  "+mInfo.get(i).getAmount());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        holder.itemView.setScaleX(0);
        holder.itemView.setScaleY(0);

        holder.itemView.setAlpha(0.1f);
        holder.itemView.animate().setInterpolator(new DecelerateInterpolator(1.5f))
                .scaleY(1)
                .scaleX(1)
                .alpha(1)
                .setStartDelay(200)
                .setDuration(600)
                .start();



    }



    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class Cartholder extends RecyclerView.ViewHolder{


        @BindView(R.id.cart_item_image)
        ImageView mCartImage;
        @BindView(R.id.cart_item_pname)
        TextView mName;
        @BindView(R.id.cart_item_price) TextView mPrice;
        @BindView(R.id.cart_item_spinner)
        Spinner mDurationSpinner;


        @BindView(R.id.cart_item_page_count)
        OpenSansTextView mPageConunt;

        @BindView(R.id.cart_item_reading_dur) OpenSansTextView mReadingDuration;
        public Cartholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface CartCallbacks{
        void removeProduct(int pos,Product p);
        void changeDuration(int pos,int windowId,int newAmount);

    }
}
