package com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bookaholicc.Fragments.HomeFragments.OffersFragment;
import com.bookaholicc.Fragments.TileSubFragment;
import com.bookaholicc.Model.Combo;
import com.bookaholicc.R;
import com.bookaholicc.utils.ScreenUtil;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 * The Adapter used in {@link OffersFragment}
 * It Provides st Images separated by a margin
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder>{


    private  List<Drawable> mDrwabales;
    private Context mContext;
    private  List<Combo> mList;
    private ImageCallback mCallback;





    public ImageAdapter(Context mContext, List<Combo> mComboList, ImageCallback callback) {
        this.mCallback  = callback;
        this.mContext = mContext;
        this.mList = mComboList;

    }

    public ImageAdapter(Context mContext, ImageCallback mCallback,List<Drawable> mDrawables) {
        this.mContext = mContext;
        this.mDrwabales = mDrawables;
        this.mCallback = mCallback;
    }

    @Override
    public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
     return new ImageHolder(LayoutInflater.from(mContext).inflate(R.layout.image_view_land,parent,false));
    }

    @Override
    public void onBindViewHolder(ImageHolder holder, final int position) {
        Glide.with(mContext)
                .load(R.mipmap.fifaa)
                .into(holder.mImageView);
        final  int pos = position;
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallback != null){
                    mCallback.imageClicked(mList.get(pos).getComboId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ImageHolder extends RecyclerView.ViewHolder{


        private ImageView mImageView;


        public ImageHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.top_image);

        }
    }

    public interface ImageCallback{
        void imageClicked(int pid);
    }



}
