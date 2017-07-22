package com.bookaholicc.Fragments.ProfileFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.MyReturnsAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.ProfileAdapter;
import com.bookaholicc.Fragments.ProfileFragment;
import com.bookaholicc.Model.Return;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 23/5/17.
 * The Fragment used in {@link ProfileFragment}
 *
 * provided by {@link ProfileAdapter}
 *
 */

public class MyReturnsFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {


    private Context mContext ;
    @BindView(R.id.return_root)
    FrameLayout mRoot;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Infalting Views
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_returns,container,false);
        ButterKnife.bind(this,view);


        getReturns();



        return view;
    }

    private void getReturns() {
        JSONObject mJsonObject = new JSONObject();
        try {
            mJsonObject.put(APIUtils.USER_ID, DataStore.getStorageInstance(mContext).getUserId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest mRequest = new JsonObjectRequest(Request.Method.POST,APIUtils.GET_RETURNS,mJsonObject,this,this);
        AppRequestQueue mAppRequestQueue = AppRequestQueue.getInstance(mContext);
        mAppRequestQueue.addToRequestQue(mRequest);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null){
            mContext = null;
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onResponse(JSONObject response) {


        List<Return> mList = getReturnBooks(response);
        if (mList == null){

            /// SHow No // TODO: 20/7/17 Show Empty View

        }
        else {
            // Show Return View
            MyReturnsAdapter myReturnsAdapter= new MyReturnsAdapter(mContext,mList);
            View mV = View.inflate(mContext,R.layout.recyler_view,mRoot);
            RecyclerView mListV = (RecyclerView) mV.findViewById(R.id.list);
            mListV.setLayoutManager(new LinearLayoutManager(mContext));
            mListV.setAdapter(myReturnsAdapter);


        }

    }

    private List<Return> getReturnBooks(JSONObject response) {
        try {
            List<Return> mList = new ArrayList<>();
            JSONArray mArray = response.getJSONArray(APIUtils.PRODUCTS_KEYWORD);
            for (int i =0;i<mArray.length();i++){
                JSONObject mObject = mArray.getJSONObject(i);
                mList.add(new Return(mObject.getInt(APIUtils.USER_ID),mObject.getString(APIUtils.IMAGE_URL),mObject.getString(APIUtils.PRODUCT_NAME),mObject.getString(APIUtils.RETURN_TIME)));
//                mList.add()
            }
            return mList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;

        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {



    }
}
