package com.bookaholicc.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bookaholicc.Fragments.CartFragment;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;
import com.bumptech.glide.Glide;

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
        public Cartholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface CartCallbacks{
        void removeProduct(int pos,Product p);

    }
}
