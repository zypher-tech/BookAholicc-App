package com.bookaholicc.Fragments.ExamDetailFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bookaholicc.R;

import butterknife.ButterKnife;

/**
 * Created by nandhu on 22/7/17.
 * used in {@link com.bookaholicc.Activitiy.ExamDetailActivity}
 * provided by {@link com.bookaholicc.Adapters.ViewpagerAdapters.ExamDetailsAdapter}
 *
 *
 * It Prvovides All the Info about the Exam and its Feild
 */

public class ExamInfoFragment extends Fragment{

    private Context mContext;

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
        View mView  = LayoutInflater.from(mContext).inflate(R.layout.exam_info,container,false);
        ButterKnife.bind(this,mView);


        return mView;
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
        mContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
