package com.bookaholicc.Model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by nandhu on 22/5/17.
 */

public class ProductImage {
    public Bitmap bm;
    public String ImageURI;
    public  int resId ;
    public Drawable mDrawable;


    public ProductImage(int resId) {
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public ProductImage(Drawable mDrawable) {
        this.mDrawable = mDrawable;
    }

    public ProductImage(Bitmap bm) {
        this.bm = bm;
    }

    public ProductImage(String imageURI) {
        ImageURI = imageURI;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }

    public String getImageURI() {
        return ImageURI;
    }

    public void setImageURI(String imageURI) {
        ImageURI = imageURI;
    }

    public Drawable getmDrawable() {
        return mDrawable;
    }

    public void setmDrawable(Drawable mDrawable) {
        this.mDrawable = mDrawable;
    }
}
