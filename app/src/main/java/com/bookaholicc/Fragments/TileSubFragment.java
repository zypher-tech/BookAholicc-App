package com.bookaholicc.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholicc.Activitiy.ExamDetailActivity;
import com.bookaholicc.Activitiy.ViewProductActivity;
import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.ImageAdapter;
import com.bookaholicc.CustomUI.InkPageIndicator;
import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;
import com.bookaholicc.utils.BundleKey;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 20/7/17.
 * <p>
 * The Tiles Sub Fragment which is used in Second Part of Exam Corner
 */

public class TileSubFragment extends Fragment implements  ImageAdapter.ImageCallback{

    @BindView(R.id.s_title_text)
    WhitenyBooksFont mSubText;
    @BindView(R.id.s_list)
    RecyclerView mList;
    private Context mContext;
    private String TAG  = "TILES_SUB";

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = LayoutInflater.from(mContext).inflate(R.layout.tile_sub, container, false);
        ButterKnife.bind(this, mView);

        if (getArguments() != null){
            int examCode = getArguments().getInt(BundleKey.ARG_EXAM_BASE);

            //Model ready For Adapter
            //Buila A Staggered Adapter and Animate it
            // Use click Listenres and Forward it Another Fragment

            ImageAdapter mAdapter = new ImageAdapter(mContext,this,getIcons(examCode));
            mList.setAdapter(mAdapter);
            mList.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
            mList.setHasFixedSize(true);

        }



        return mView;
    }

    private List<Drawable> getIcons(int examCode) {

        List<Drawable> mDrawables  = DataStore.getStorageInstance(mContext).getDrawables(examCode);
        return  mDrawables;




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
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
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mContext == null) {
            mContext = context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void imageClicked(int pid) {
        Log.d(TAG, "imageClicked:" + pid);
        //Some Image has been clicked
        Intent i = new Intent(mContext, ExamDetailActivity.class);
        i.putExtra(BundleKey.EXAM_ID,pid); // // TODO: 21/7/17 Changeit to exam code
        startActivity(i);
    }
}
