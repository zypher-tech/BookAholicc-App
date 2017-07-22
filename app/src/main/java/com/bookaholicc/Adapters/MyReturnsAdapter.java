package com.bookaholicc.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholicc.Model.Return;
import com.bookaholicc.R;

import java.util.List;

/**
 * Created by nandhu on 20/7/17.
 */

public class MyReturnsAdapter extends RecyclerView.Adapter<MyReturnsAdapter.ReturnItem>{
    private final List<Return> mList;
    private final Context mContext;

    public MyReturnsAdapter(Context mContext, List<Return> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }


    @Override
    public ReturnItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReturnItem(LayoutInflater.from(mContext).inflate(R.layout.cart_item,parent,false));

    }

    @Override
    public void onBindViewHolder(ReturnItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ReturnItem extends RecyclerView.ViewHolder{

        public ReturnItem(View itemView) {
            super(itemView);
        }
    }
}
