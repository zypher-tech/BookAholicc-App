package com.bookaholicc.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bookaholicc.Activitiy.CheckOutActivity;
import com.bookaholicc.Adapters.CartAdapter;
import com.bookaholicc.MainActivity;
import com.bookaholicc.Model.CartProduct;
import com.bookaholicc.Model.Product;
import com.bookaholicc.Network.AppRequestQueue;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.CartHandler;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.APIUtils;
import com.bookaholicc.utils.BundleKey;
import com.bookaholicc.utils.RVdecorator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.gson.Gson;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;

/**
 * Created by nandhu on 29/5/17.
 *
 * Shows Cart Products -- Uses {@link CartHandler} to provide with List of Products that the User has Added
 */

public class CartFragment extends Fragment implements CartAdapter.CartCallbacks, View.OnClickListener {


    private Context mContext;
    @BindView(R.id.cart_frame_root) FrameLayout mRoot;

    List<Product> pList;
    int totalAmount;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cart_fragment,container,false);
        ButterKnife.bind(this,v);

        pList = CartHandler.getInstance(mContext).getProducts();
        if (pList == null){
            View mNoProductsView = View.inflate(mContext,R.layout.no_ordrers,mRoot);
        }
        else{
            //
            View cartView = View.inflate(mContext,R.layout.cart_view,mRoot);
            CartAdapter mAdapter = new CartAdapter(pList,mContext,this);
            RecyclerView mList = (RecyclerView) cartView.findViewById(R.id.list);
            mList.setAdapter(mAdapter);
            mList.addItemDecoration(new RVdecorator(ContextCompat.getDrawable(mContext,R.drawable.divider)));
            mList.setLayoutManager(new LinearLayoutManager(mContext));
            Button b  = (Button) cartView.findViewById(R.id.check_out_button);
            b.setOnClickListener(this);
            totalAmount = getAmount(pList);

        }





        return v;
    }

    private int getAmount(List<Product> mList) {
        int sum = 0;
        for (int i =0;i<mList.size();i++){
            sum = sum + mList.get(i).getmPricing().get(i).getAmount();

        }
        return sum;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mContext != null){
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
        if (mContext == null){
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void removeProduct(int pos, Product p) {

    }

    @Override
    public void changeDuration(int pos, int windowId, int newAmount) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_out_button:
                checkOut();
                break;
        }
    }

    private void checkOut() {
            Gson gs  = new Gson();
            String cartString = gs.toJson(pList);

            Intent i = new Intent(mContext,CheckOutActivity.class);
            i.putExtra(BundleKey.ARG_CHECKOUT_STRING,cartString);
            i.putExtra(BundleKey.ARG_PRICE,totalAmount);
            startActivity(i);


    }
}