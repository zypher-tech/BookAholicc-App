package com.bookaholicc.Activitiy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bookaholicc.Adapters.ViewpagerAdapters.ExamDetailsAdapter;
import com.bookaholicc.CustomUI.ParallaxPagerTransformer;
import com.bookaholicc.R;
import com.bookaholicc.utils.BundleKey;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 21/7/17.
 * The Main Page Which breaks Exam in Details page
 */

public class ExamDetailActivity extends AppCompatActivity {


    @BindView(R.id.exam_detail_pager)
    ViewPager mPager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_activity);
        ButterKnife.bind(this);

        if (getIntent() != null){
             int examCode = getIntent().getIntExtra(BundleKey.ARG_EXAM_BASE,0);
            ParallaxPagerTransformer mParallaxPagerTransformer = new ParallaxPagerTransformer(R.id.transformer_image);
            ExamDetailsAdapter mAdapter = new ExamDetailsAdapter(getSupportFragmentManager(),examCode);
            mPager.setAdapter(mAdapter);
        }


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
