package com.bookaholicc.Fragments.HomeFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.HorizontalAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.MainFragmentAdapter;
import com.bookaholicc.Fragments.HomeFragement;
import com.bookaholicc.Model.GenreModel;
import com.bookaholicc.Model.Product;
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
 * Showed By {@link HomeFragement}
 * provided by {@link MainFragmentAdapter}
 */

public class ExploreFragment extends Fragment implements Response.ErrorListener, Response.Listener<JSONObject>,HorizontalAdapter.Horizontalcallback {

    private Context mContext;
    private View mView;

    @BindView(R.id.explore_root_frame)
    FrameLayout mRootView;


    @BindView(R.id.adding_layout)
    LinearLayout mAddingLayout;


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
        mView = LayoutInflater.from(mContext).inflate(R.layout.explore_fragment,container,false);
        ButterKnife.bind(this,mView);



        //Hit THe Webservice
        //Show the Products

/*

        if (cacheDataExists()){
            //SHow the Data
        }
        else{
            makeExploreRequest();
        }

*/

        List<GenreModel> models = CartHandler.getInstance(mContext).getExlporeData();
        for (GenreModel model : models) {

            showView(model);
        }





        return mView;
    }

    private boolean cacheDataExists() {
        return false;
    }

    private void makeExploreRequest() {
        JsonObjectRequest mObjectRequest = new JsonObjectRequest(APIUtils.HOME_ENDPOINT_POPULAR,null,this,this);
        AppRequestQueue mRequestQueue =   AppRequestQueue.getInstance(mContext);
        mRequestQueue.addToRequestQue(mObjectRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null){
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

        List<GenreModel> modelist = parseData(response);
        for (GenreModel model : modelist) {
            showView(model);

        }
    }

    /** this has Lots of Products within them , for all Genres we have to Add
     * indvidual container view , prepare Adapter and Show it Views and Listen for More Button Events*/

    private void showView(GenreModel cModel) {

            //Add View , prpare Adapter
            String genreName = cModel.getGenreName();
            String genreId = cModel.getGenreId();
            List<Product> mList = cModel.getProductList();
            HorizontalAdapter mAdapter = new HorizontalAdapter(mContext,mList,this);
            View cardView =LayoutInflater.from(mContext).inflate(R.layout.explore_card,mRootView,false);


            RecyclerView mListView = (RecyclerView) cardView.findViewById(R.id.explore_list);
            TextView mGenreText  = (TextView) cardView.findViewById(R.id.explore_card_title);
            Button moreButton = (Button) cardView.findViewById(R.id.explore_button);
            mListView.setAdapter(mAdapter);
            mListView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,true));
            mGenreText.setText(genreName);

        mAddingLayout.addView(cardView);


        }



    private List<GenreModel> parseData(JSONObject response) {
        return null;
    }

    @Override
    public void productClicked(int pid, int genreId) {

    }
}
