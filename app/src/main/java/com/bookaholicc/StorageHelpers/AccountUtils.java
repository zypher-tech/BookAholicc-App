package com.bookaholicc.StorageHelpers;

import android.content.Context;

/**
 * Created by nandhu on 19/3/17.
 *
 *
 *  Helper Method Associated With User Accounts;

 */


public class AccountUtils {
    private static AccountUtils mAccountUtils;
    private DataStore mStore;

    public AccountUtils(Context context) {
        mStore = DataStore.getStorageInstance(context);

    }

    public static synchronized AccountUtils getInstance(Context context) {
        if (mAccountUtils == null) {
            mAccountUtils = new AccountUtils(context);
        }
        return mAccountUtils;
    }


    public void saveUserName(String name){
        mStore.setUserName(name);
    }


    public void saveUserEmail(String email){
        mStore.setEmailId(email);
    }

    public  boolean isLoggedin(){
        return mStore.isLoggedIn();
    }


    public  void saveLoggedIn(boolean b){

        mStore.setLoggedIn(b);

    }


    public String getPhotoUrl(){

        return mStore.getpicturePath();

    }

    public void putPhotoUrl(String url){
        mStore.setProPicturePath(url);
    }

    public String getPhoneNumber() {
        if (isPhoneNumberPresent()){
            return mStore.getPhoneNumber();
        }
        else{
            return null;
        }
    }

    private boolean isPhoneNumberPresent() {
        return mStore.isPhoneNumberPresent();
    }
}


