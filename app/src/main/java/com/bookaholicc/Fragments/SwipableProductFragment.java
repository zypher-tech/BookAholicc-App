package com.strictlyindian.rentsmart.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.google.gson.Gson;
import com.like.LikeButton;
import com.like.OnLikeListener;
import com.squareup.picasso.Picasso;
import com.strictlyindian.rentsmart.Adapters.ComboAdapter;
import com.strictlyindian.rentsmart.Adapters.ImageAdapter;
import com.strictlyindian.rentsmart.CustomUI.InkPageIndicator;
import com.strictlyindian.rentsmart.Model.Product;
import com.strictlyindian.rentsmart.Model.ProductImage;
import com.strictlyindian.rentsmart.R;
import com.strictlyindian.rentsmart.utils.BundleKey;
import com.strictlyindian.rentsmart.utils.GListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by nandhu on 20/5/17.
 *
 */

public class SwipableProductFragment extends Fragment  implements GListener.Callbacks, ImageAdapter.ImageInterface {


    private static final int LOGIN_REQUEST_CODE = 2255;



    @BindView(R.id.vp_root)
    CardView mRoot;
    Product p; // The Product That we Show
    @BindView(R.id.vp_image_pager)
    ViewPager imagePager;
    @BindView(R.id.top_indicator)
    InkPageIndicator mPagerIndicator;




    @BindView(R.id.vp_pname)
    TextView pName;
    @BindView(R.id.vp_addln_info)
    TextView pAdditionalInfo;


    //The like Count Switcer
    @BindView(R.id.tsLikesCounter)
    TextSwitcher mSwithcer;

    //The heart button
    @BindView(R.id.like_button)
    LikeButton mLikeButton;
    private Context mContext;


    private static SwipableProductFragment mFragemt = null;


    /*THe Flag Which holds Whether The Prduct is already in cart or nOt*/
    private boolean b;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.swipe_product_view, container, false);
        ButterKnife.bind(this, v);


        final GestureDetector mGdt = new GestureDetector(mContext,new GListener(this));



        Log.d(TAG, "setting Trans Name : "+getArguments().getString(BundleKey.TRANS_NAME));



        List<ProductImage> mList = populateImages();

        ImageAdapter mAdapter = new ImageAdapter(mContext, mList ,this);
        imagePager.setAdapter(mAdapter);
        mPagerIndicator.setViewPager(imagePager);

        mLikeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                mSwithcer.setText("124");
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                mSwithcer.setText("123");
            }
        });


        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Log.d(TAG, "onTouch: v");
                return false;
            }
        });

        mRoot.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mGdt.onTouchEvent(motionEvent);
                return true;
            }
        });
//        mList.setLayoutManager(new LinearLayoutManager(mContext));

//        View  c =  getLayoutInflater(savedInstanceState).inflate(R.layout.product_container_icons,mList,true);


        return v;
    }

    private List<ProductImage> populateImages() {
        List<ProductImage> mImages = new ArrayList<>();
        mImages.add(new ProductImage(R.mipmap.fifa));
        mImages.add(new ProductImage(R.mipmap.godofwar));
        mImages.add(new ProductImage(R.mipmap.sapiens));
        mImages.add(new ProductImage(R.mipmap.ac2));
        return  mImages;

            }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            /*Gson gs = new Gson();
            String pJson = getArguments().getString(BundleKey.ARG_PRODUCT);
            this.p = gs.fromJson(pJson, Product.class);
            Log.d(TAG, "onCreate: VP FRAG got Product " + p.getPid());*/

        }


    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
    }


    public static SwipableProductFragment newInstance(Product product) {
        Bundle b = new Bundle();
        Gson gs = new Gson();
        String productJson = gs.toJson(product);
        b.putString(BundleKey.ARG_PRODUCT, productJson);
        if (mFragemt == null) {
            mFragemt = new SwipableProductFragment();
        }
        mFragemt.setArguments(b);
        return mFragemt;
    }

    @Override
    public void addtoCart() {
        Log.d(TAG, "addtoCart: ");
        Animation maAnimationUtils = AnimationUtils.loadAnimation(mContext,R.anim.cart_pulldown);
        mRoot.startAnimation(maAnimationUtils);

    }

    @Override
    public void removeFromCart() {

    }

    @Override
    public void imageClicked(ProductImage p) {

    }
}
