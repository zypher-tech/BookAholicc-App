package com.bookaholicc.Fragments;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.ImageAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.SwipeAdapterNewArrivals;
import com.bookaholicc.CustomUI.InkPageIndicator;
import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.Model.Combo;
import com.bookaholicc.Model.Product;
import com.bookaholicc.Model.ProductImage;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.CartHandler;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.BundleKey;
import com.bookaholicc.utils.GListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.like.LikeButton;
import com.like.OnLikeListener;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by nandhu on 20/5/17.
 *
 */

public class SwipableProductFragment extends Fragment  implements GListener.Callbacks,  ImageAdapter.ImageCallback, SwipeAdapterNewArrivals.ComboInterface, View.OnClickListener, OnLikeListener {


    private static final int LOGIN_REQUEST_CODE = 2255;



    @BindView(R.id.vp_root)
    CardView mRoot;
    Product p; // The Product That we Show
    @BindView(R.id.vp_image_pager)
    ViewPager imagePager;
    @BindView(R.id.top_indicator)
    InkPageIndicator mPagerIndicator;



    //Summary
    @BindView(R.id.vp_about_book_text_vale)
    TextView mSummary;




    //Product Name
    @BindView(R.id.vp_pname)
    WhitenyBooksFont pName;
    //Additional Info/Author name
    @BindView(R.id.vp_addln_info)
    WhitenyBooksFont pAdditionalInfo;
    @BindView(R.id. vp_price_text) WhitenyBooksFont mPrice;
    @BindView(R.id.vp_time_text)  WhitenyBooksFont mDurationText;
    @BindView(R.id.textView10) TextView mGenreText;

    //The like Count Switcer
    @BindView(R.id.tsLikesCounter)
    TextSwitcher mSwithcer;



    //The heart button
    @BindView(R.id.like_button)
    LikeButton mLikeButton;


    private Context mContext;
    //ADd to Cart

    @BindView(R.id.vp_add_to_cart)
    Button mAddtoCart;


    private static SwipableProductFragment mFragemt = null;


    /*THe Flag Which holds Whether The Prduct is already in cart or nOt*/
    private boolean b;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.swipe_product_view, container, false);
        ButterKnife.bind(this, v);


        final GestureDetector mGdt = new GestureDetector(mContext,new GListener(this));


        if (getArguments() != null){
            //Arguments--> JSON ---> Model

            Gson gson = new Gson();
            String Json = getArguments().getString(BundleKey.ARG_PRODUCT);
            p = gson.fromJson(Json, Product.class);
        }



        mAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addtoCart();
            }
        });

        pName.setText(p.getProductName());
        pAdditionalInfo.setText(p.getAuthorName());

        mSummary.setText(p.getSummary());
        mPrice.setText(p.getPrice());
        mDurationText.setText(p.getDuration());











        Combo c = new Combo(45,"asd","Adasd",p.getImageURL(),245,"45");
        List<Combo> c1 = new ArrayList<>();
        c1.add(c);
//
        SwipeAdapterNewArrivals mImageAdapter = new SwipeAdapterNewArrivals(c1,mContext,this);
        imagePager.setAdapter(mImageAdapter);
        mPagerIndicator.setViewPager(imagePager);
        //setting Listeners
        mAddtoCart.setOnClickListener(this);
        mSummary.setOnClickListener(this);
        mLikeButton.setOnLikeListener(this);

//
        mLikeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                mSwithcer.setText("1");
            }

            @Override
            public void unLiked(LikeButton likeButton) {
                mSwithcer.setText("3");
            }
        });
//
        return v;
//
//        v.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                Log.d(TAG, "onTouch: v");
//                return false;
//            }
//        });
//
//        mRoot.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                mGdt.onTouchEvent(motionEvent);
//                return true;
//            }
//        });
////        mList.setLayoutManager(new LinearLayoutManager(mContext));
//
//          View  c =  getLayoutInflater(savedInstanceState).inflate(R.layout.product_container_icons,mList,true);
//
//
//        return v;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments() != null) {
//            /*Gson gs = new Gson();
//            String pJson = getArguments().getString(BundleKey.ARG_PRODUCT);
//            this.p = gs.fromJson(pJson, Product.class);
//            Log.d(TAG, "onCreate: VP FRAG got Product " + p.getPid());*/
//
//        }


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




    @Override
    public void addtoCart() {

        // todo Change Button Behaviour

        boolean  isAdded = CartHandler.getInstance(mContext).addProductToCart(p);
        if (isAdded){
            Log.d(TAG, "Added");
        }
        else{
            Log.d(TAG, "Not Added");
        }

    }

    @Override
    public void removeFromCart() {

    }

//    @Override
//    public void imageClicked(ProductImage p) {
//
//    }

    @Override
    public void imageClicked(int pid) {

    }

    @Override
    public void ComboproductClicked(Product p) {
        Toast.makeText(mContext,"Image Clicked",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vp_add_to_cart:
                addtoCart();

                break;
            case R.id.vp_about_book_text_vale:
                Toast.makeText(mContext,"About",Toast.LENGTH_LONG).show();
                break;


        }
    }

    @Override
    public void liked(LikeButton likeButton) {

    }

    @Override
    public void unLiked(LikeButton likeButton) {

    }
}
