package com.bookaholicc.StorageHelpers;

import android.content.Context;

/**
 * Created by nandhu on 20/3/17.
 * The Utitles
 */

public class AddressUtils {



    private DataStore mStore;

    private static AddressUtils mAddressUtils;

    public AddressUtils(Context context) {
        mStore = DataStore.getStorageInstance(context);
    }


    public static synchronized AddressUtils getInstance(Context context) {
        if (mAddressUtils == null) {
            mAddressUtils = new AddressUtils(context);
        }
        return mAddressUtils;
    }


    public  boolean isLocationSaved(){
        return mStore.isLocationSaved();
    }

    public void  locationSaved(){
        mStore.setLocationSaved(true);
    }


/*
    public void setDefaultLocation(Place p){
        mStore.saveUserLocation(p);
    }

    public void saveLocation(Place place) {
       mStore.saveUserLocation(place);
    }

    public Place getUserLocation(){
        return mStore.getUserLocation();
    }*/
}
