package com.bookaholicc.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholicc.Fragments.CartFragment;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;

import java.util.List;

/**
 * Created by nandhu on 22/6/17.
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

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public static class Cartholder extends RecyclerView.ViewHolder{

        public Cartholder(View itemView) {
            super(itemView);
        }
    }

    public interface CartCallbacks{
        void removeProduct(int pos,Product p);

    }
}
