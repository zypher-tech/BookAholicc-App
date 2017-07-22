package com.bookaholicc.Fragments.ProfileFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Adapters.ViewpagerAdapters.ListAdapters.NoOrderAdapter;
import com.bookaholicc.Adapters.ViewpagerAdapters.ProfileAdapter;
import com.bookaholicc.Fragments.ProfileFragment;
import com.bookaholicc.Model.Order;
import com.bookaholicc.Model.Product;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.CartHandler;
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
 * <p>
 * provided by {@link ProfileAdapter}
 */

public class MyOrdersFragment extends Fragment implements NoOrderAdapter.NoOrderListCallback, Response.Listener<JSONObject>, Response.ErrorListener {
    private static final String TAG = "BOOKAHOLIC";



    //The Root Layouts & Indicator Views

    @BindView(R.id.orders_loading_indicator)
    ProgressBar mProgressIndicator;
    @BindView(R.id.indicator_text)
    TextView mIndicatorText;
    @BindView(R.id.order_frame)
    FrameLayout mIndicatorFrame;
    @BindView(R.id.order_root_frame)
    FrameLayout mRootFrame;




    /*These View are used Only if No Order Layout is Inflated*/
    //No order Pager
    @Nullable @BindView(R.id.no_order_image)
    ImageView mNoOrderImage;
    @Nullable  @BindView(R.id.no_order_text)
    TextView mNoOrderText;
    @Nullable @BindView(R.id.no_orders_loading_indicator)
    ProgressBar mNoOrdersLoadingIndicator;
    @Nullable @BindView(R.id.no_orderindicator_text)
    TextView mNoOrderindicatorText;
    @Nullable @BindView(R.id.no_order_loading_frame)
    RelativeLayout mNoOrderLoadingFrame;
    @Nullable @BindView(R.id.no_orders_root_frame)
    FrameLayout mNoOrdersRootFrame;
    private Context mContext;


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
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_orders, container, false);
        ButterKnife.bind(this, view);

        getOrders();


        //FIrst Hit the Webservices get Any orders
        // Before that check that oRders are presnet in Local;
        //If No ORders Present call No Previos orders

        return view;
    }

    private void getOrders() {
        int userId  = DataStore.getStorageInstance(mContext).getUserId();

        JSONObject mJsonObject  = new JSONObject();
        try {
            mJsonObject.put(APIUtils.USER_ID,userId);
            JsonObjectRequest mREq = new JsonObjectRequest(Request.Method.POST,APIUtils.GET_MY_ORDERS,mJsonObject,this,this);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    public void showNoOrders() {

//        Hit the JSON Webservices here
        try {

            if (mRootFrame != null) {


                mRootFrame.removeAllViews();
                View noOrders = View.inflate(mContext, R.layout.no_ordrers, mRootFrame);
                ButterKnife.bind(this, noOrders);
            }
//            ImageView cart = (ImageView) noOrders.findViewById(R.id.no_order_image);
//            TextView mNoOrderText = noOrders.findViewById(R.id.);
//            FrameLayout mLoadingIndicatorFrame;
//            ProgressBar mNoOrderindicator ;
//            TextView noOrderIndicatorText;
//            RelativeLayout mIndicatorHOlder;



            try {
                if (mNoOrdersRootFrame != null){
                    mNoOrdersRootFrame.removeAllViews();
                    View ListView = View.inflate(mContext,R.layout.recyler_view,mNoOrdersRootFrame);
                    RecyclerView mList = (RecyclerView) ListView.findViewById(R.id.list);
//                    List<Product> mListProducts = CartHandler.getInstance(mContext).getMockProducts();
//                    NoOrderAdapter mListAdapter = new NoOrderAdapter(mContext, mListProducts,this);
                }

            }

            catch (Exception e){
                Log.d(TAG, "showNoOrders: Exeption");
            }

        }
        catch (Exception e ){
            Log.d(TAG, "Exception in showNoOrders: ");
        }
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
        if (mContext != null) {
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
    public void addToCart(int pos, int pid) {

    }

    @Override
    public void onResponse(JSONObject response) {
        try {
            List<Order> mOrders = getResponse(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private List<Order> getResponse(JSONObject response) throws JSONException {
        List<Order> mOrders = new ArrayList<>();
        JSONArray mArray = response.getJSONArray(APIUtils.ORDERS);
        for (int i =0; i< mArray.length();i++){
            JSONObject m  = mArray.getJSONObject(i);

        }
        return null;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d(TAG, "onErrorResponse:");
    }
}
