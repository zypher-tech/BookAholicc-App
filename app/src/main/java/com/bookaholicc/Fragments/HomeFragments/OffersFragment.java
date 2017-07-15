package com.bookaholicc.Fragments.HomeFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.ImageAdapter;
import com.bookaholicc.Fragments.HomeFragement;
import com.bookaholicc.Model.Combo;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.CartHandler;
import com.bookaholicc.utils.APIUtils;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 30/5/17.
 * The Fragment shown in {@link HomeFragement}
 */

public class OffersFragment extends Fragment implements Response.ErrorListener, Response.Listener<JSONObject>, ImageAdapter.ImageCallback {


    @BindView(R.id.list_view)
    RecyclerView mListView;
    @BindView(R.id.exam_root)
    FrameLayout mRootFrame;
    private Context mContext;
    private View mView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;

    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = LayoutInflater.from(mContext).inflate(R.layout.offers_fragment, container, false);
        ButterKnife.bind(this, mView);

        //Hit THe Webservice
        //SHow Data

//        if (cachedDataExists()){
//            showCachedData();
//        }
//        else{
//            makeReqestAndSave();
//        }
//

        List<Combo> Mlist = CartHandler.getInstance(mContext).getMockCombo();
        setViewValues(Mlist);


        return mView;
    }

    private void makeReqestAndSave() {
        JsonObjectRequest mObjectRequest = new JsonObjectRequest(APIUtils.HOME_ENDPOINT_OFFERS, null, this, this);
        AppRequestQueue mRequestQueue = AppRequestQueue.getInstance(mContext);
        mRequestQueue.addToRequestQue(mObjectRequest);

    }

    private void showCachedData() {

    }

    private boolean cachedDataExists() {
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null) {
            mContext = null;
        }
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
    public void onResume() {
        super.onResume();
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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        List<Combo> mComboList = parseData(response);
        setViewValues(mComboList);
    }

    private void setViewValues(List<Combo> mComboList) {
        ImageAdapter mImageAdapter = new ImageAdapter(mContext, mComboList, this);
        mListView.setAdapter(mImageAdapter);
        mListView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));



    }

    private List<Combo> parseData(JSONObject response) {
        return null;
    }

    @Override
    public void imageClicked(int pid) {
        Toast.makeText(mContext,"Combo Id"+pid,Toast.LENGTH_LONG).show();
    }
}
