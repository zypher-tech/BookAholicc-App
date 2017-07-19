package com.bookaholicc.Fragments.ProfileFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bookaholicc.Adapters.ViewpagerAdapters.ProfileAdapter;
import com.bookaholicc.CustomUI.WhitenyBooksFont;
import com.bookaholicc.Fragments.ProfileFragment;
import com.bookaholicc.R;
import com.bookaholicc.StorageHelpers.DataStore;
import com.bookaholicc.utils.BundleKey;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nandhu on 23/5/17.
 * The Fragment used in {@link ProfileFragment}
 * <p>
 * provided by {@link ProfileAdapter}
 */

public class AccountFragment extends Fragment implements OnMapReadyCallback {


    private static final String TAG = "BK ACCOUNT FRAG: ";
    @BindView(R.id.acct_name_value)
    WhitenyBooksFont mUserName;
    @BindView(R.id.acct_phone_value)
    WhitenyBooksFont mPhoneNumber;
    @BindView(R.id.acct_email_value)
    WhitenyBooksFont mEmail;
    @BindView(R.id.map)
    MapView mMap;
    @BindView(R.id.pv_delivery_container)
    RelativeLayout mMapCard;
    private Context mContext;
    private MapView mMapView;

    private boolean isMapStarted = false;
    private GoogleMap map;
    DataStore mStore;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    private void showLoginOrSignUpPage() {




    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Infalting Views
        View view = LayoutInflater.from(mContext).inflate(R.layout.account_frag, container, false);
        ButterKnife.bind(this, view);

        MapView mapView = (MapView) view.findViewById(R.id.map);


        mapView.onCreate(savedInstanceState);

        // Gets to GoogleMap from the MapView and does initialization stuff
        mapView.getMapAsync(this);


        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this.getActivity());


        if (mStore == null) {
            mStore = DataStore.getStorageInstance(mContext);
        }


//        if (savedInstanceState == null){
//            //New Map
//            SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
//                    .findFragmentById(R.id.map);
//            mapFragment.getMapAsync(this);
//            isMapStarted = true;
//        }
//        else{
//            if (isMapStarted){
//                //Map Is Already Started
//
//            }else {
//                SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager()
//                        .findFragmentById(R.id.map);
//                mapFragment.getMapAsync(this);
//                isMapStarted = true;
//            }
//        }


//
//
//        mMapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap mMap) {
//                googleMap = mMap;
//
//                // For showing a move to my location button
//                if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    //    ActivityCompat#requestPermissions
//                    // here to request the missing permissions, and then overriding
//                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                    //                                          int[] grantResults)
//                    // to handle the case where the user grants the permission. See the documentation
//                    // for ActivityCompat#requestPermissions for more details.
//                    return;
//                }
//                googleMap.setMyLocationEnabled(true);
//
//                // For dropping a marker at a point on the Map
//                LatLng sydney = new LatLng(12.97, 77.59);
//                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));
//
//                // For zooming automatically to the location of the marker
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//            }
//        });


        return view;
    }

    private boolean isSignedIn() {
        return mStore.isLoggedIn();
    }

    private void populateValues() {

        if (mStore != null){
            if (mPhoneNumber != null){
                mPhoneNumber.setText(mStore.getPhoneNumber());
            }
            else{

            }

            if (mUserName != null){
                mUserName.setText(mStore.getUserName());
            }
            if (mEmail != null){
                mEmail.setText(mStore.getEmail());
            }
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
        outState.putBoolean(BundleKey.IS_MAP_STARTED, isMapStarted);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mStore == null) {
            mStore = DataStore.getStorageInstance(mContext);
        }





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
    public void onMapReady(GoogleMap googleMap) {
        //Get The Lat lng
        //Get hte Address ,Make Marker & Update
        // Updates the location and zoom of the MapView
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(12.97, 77.59), 12);
        googleMap.animateCamera(cameraUpdate);
    }


}
