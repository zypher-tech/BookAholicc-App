package com.bookaholicc.Fragments.HomeFragments;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.HorizontalAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.MainFragmentAdapter;
import com.bookaholicc.DataHandler.MiniProduct;
import com.bookaholicc.Fragments.HomeFragement;
import com.bookaholicc.Model.GenreModel;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.utils.APIUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
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
    private String TAG = "EXPLORE";


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

        makeExploreRequest();

//
//
//        //Hit THe Webservice
//        //Show the Products
//
///*
//
//        if (cacheDataExists()){
//            //SHow the Data
//        }
//        else{
//            makeExploreRequest();
//        }
//
//*/

//        List<GenreModel> models = CartHandler.getInstance(mContext).getExlporeData();
//        for (GenreModel model : models) {
//
//            showView(model);
//        }





        return mView;
    }

    private boolean cacheDataExists() {
        return false;
    }

    private void makeExploreRequest() {
        Log.d(TAG, "making Explore Request");
        JsonObjectRequest mObjectRequest = new JsonObjectRequest(Request.Method.POST,APIUtils.HOME_ENDPOINT_GENRE,null,this,this);
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
        Log.d(TAG, "onResponse: "+response.toString());

        int count = 0;
        List<GenreModel> modelist = parseData(response);
        if (modelist != null) {
            count = modelist.size();
        }
        View[] mCards = new View[count];
        TextView[] mTitles = new TextView[count];
        RecyclerView[] mList = new RecyclerView[count];

        for (int i =0; i< modelist.size();i++){

            mCards[i] = LayoutInflater.from(mContext).inflate(R.layout.explore_card,mRootView,true);
            mList[i] = (RecyclerView) mCards[i].findViewById(R.id.explore_list);
            HorizontalAdapter mAdapter = new HorizontalAdapter(mContext,modelist.get(i).getProductList(),this);
            mList[i].setAdapter(mAdapter);
            mList[i].setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
            mTitles[i] = (TextView) mCards[i].findViewById(R.id.explore_card_title);
            mTitles[i].setText(modelist.get(i).getGenreName());


        }

    }



    /** this has Lots of Products within them , for all Genres we have to Add
     * indvidual container view , prepare Adapter and Show it Views and Listen for More Button Events*/





    private List<GenreModel> parseData(JSONObject response) {


        List<GenreModel> mList = null;
        try {

            JSONArray mGenresArray = response.getJSONArray("genres");
            int genreLength = mGenresArray.length();
            Log.d(TAG, "Intiliszing Genre array with "+genreLength);
            mList = new ArrayList<>(genreLength);

            for (int i =0 ;i < genreLength; i++){
                JSONObject mJsonObject  =  mGenresArray.getJSONObject(i);
                int id = mJsonObject.getInt(APIUtils.GENRE_ID);  // The Genre Id

                String genreName = mJsonObject.getString(APIUtils.GENRE_NAME);  // The Genre Model
                List<MiniProduct> mProductList =
                                    parseProduct(mJsonObject.getJSONArray(APIUtils.PRODUCTS_KEYWORD)); // The Products
                mList.add(new GenreModel(genreName,id,mProductList)); // Adding to list

            }
            return mList;
        }
        catch (Exception e){
            Log.d(TAG, "Exception in Genres  "+e.getLocalizedMessage());
            return  null;
        }

    }

    private List<MiniProduct> parseProduct(JSONArray jsonArray) {
        List<MiniProduct> mList = new ArrayList<>();
        try {

            int productsCount = jsonArray.length();
            for (int i = 0;i < productsCount; i++){
                    JSONObject mProducts = jsonArray.getJSONObject(i);
                    mList.add(new MiniProduct(mProducts.getString(APIUtils.PRODUCT_NAME_1),
                            mProducts.getString(APIUtils.IMAGE_URL),
                            mProducts.getInt(APIUtils.PID),
                            mProducts.getInt(APIUtils.PRICE)));
            }
            return mList;
        }
        catch (Exception e){

            Log.d(TAG, "Exception in Parsing Genre "+e.getLocalizedMessage());
            return  null;
        }
    }

    @Override
    public void productClicked(int pid, int genreId) {




    }
}
