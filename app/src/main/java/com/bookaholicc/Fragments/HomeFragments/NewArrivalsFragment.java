package com.bookaholicc.Fragments.HomeFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.NewArrivalListAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.MainFragmentAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.SwipeAdapterNewArrivals;
import com.bookaholicc.CustomUI.InkPageIndicator;
import com.bookaholicc.Fragments.HomeFragement;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.CartHandler;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;
import com.bookaholicc.utils.NetworkUtils;

import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.bookaholicc.R.attr.layoutManager;


/**
 * Created by nandhu on 30/5/17.
 * Diplayed in {@link HomeFragement}
 * provided by {@link MainFragmentAdapter}
 */

public class NewArrivalsFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener, SwipeAdapterNewArrivals.ComboInterface, NewArrivalListAdapter.NewArrvialsListCallback {


    private Context mContext;
    private View mView;
    @BindView(R.id.new_arrivals_root)
    FrameLayout mRootFrame;



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
        mView = LayoutInflater.from(mContext).inflate(R.layout.new_arrivals_fragment,container,false);
        ButterKnife.bind(this,mView);


        //Hit the Webservice;
        //Show the Results
        //Unitll Then SHow Loading results

/*

        if (cachedResultsExists()){

        }
        else{
            makeRequestAndStoreCache();
        }
*/








        return mView;
    }

    private void inflateBottom(View mInfaltedView, List<Product> mListforBottom) {


    }

    private void infalteTop(View mInfaltedView, List<Product> mListForTop) {


    }

    private void makeRequestAndStoreCache() {
        JsonObjectRequest mNewArrivalsRequest = new JsonObjectRequest(APIUtils.HOME_ENDPOINT_NEW_ARRIALS,
                null,this,this);
    }

    private boolean cachedResultsExists() {
        DataStore mStore = DataStore.getStorageInstance(mContext);
        return mStore.isNewArrivalsDataPresent();
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



        List<Product> mListForTop = CartHandler.getInstance(mContext).getMockProducts();
        List<Product> mListforBottom = CartHandler.getInstance(mContext).getMockProducts();

        View mInfaltedView = View.inflate(mContext,R.layout.new_arrivals_content,mRootFrame);
        infalteTop(mInfaltedView,mListForTop);
        /*-----------------------*/



        InkPageIndicator mIndicator = (InkPageIndicator) mInfaltedView.findViewById(R.id.indicator);

        SwipeAdapterNewArrivals mAdapter1 = new SwipeAdapterNewArrivals(mListForTop,mContext,this);
        ViewPager mTopPager = (ViewPager) mInfaltedView.findViewById(R.id.home_top_pager);
        if (mTopPager != null) {

            mTopPager.setAdapter(mAdapter1);
        }
        if (mIndicator != null && mTopPager != null && mTopPager.isShown()) {

            mIndicator.setViewPager(mTopPager);
        }
        /*----------------*/
        RecyclerView mListView = (RecyclerView) mInfaltedView.findViewById(R.id.new_arrivals_list);
        mListView.setLayoutManager(new GridLayoutManager(mContext,2));





        if (mListView != null && mListView.isShown()){
            NewArrivalListAdapter mAdapter = new NewArrivalListAdapter(mContext,mListforBottom,this);
            mListView.setAdapter(mAdapter);
            mListView.setNestedScrollingEnabled(false);
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mContext, GridLayoutManager.VERTICAL);
            mListView.addItemDecoration(dividerItemDecoration);


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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onPause() {
        super.onPause();
    }



    /** Got the Response here
     * Remove the Loading view and Show the Recycler view
     * with Data Sources
     *
     * */

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void ComboproductClicked(Product p) {

    }

    @Override
    public void addToCart(int pos, int pid) {

    }
}
