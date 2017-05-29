package com.bookaholicc.StorageHelpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.bookaholicc.Model.CartModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by nandhu on 16/3/17.
 *
 *
 *
 * We User GSON as a way to serialize and Deserialize Java Objects , especially carts and List
 *
 * After saving to Bag we use Sync
 *  //TODO: look into the Sync Adapter
 *
 *
 */

public class DataStore {


    private static final String SHARED_PREFS_FILE  = "REPLAY"; // The Shared prfs  File Name

//    User Assoicated Key names
    private static final String USER_NAME_TAG = "LOGIN_USER_NAME";
    private static final String PHONE_NUMBER_TAG  = "PHONE_NUMBER";
    private static final String EMAIL_ID_TAG = "EMAIL_ID";
    private static final String STATE_ID = "STATE_ID";
    private static final String USER_ID = "USER_ID";
    private static final String PASSWORD = "PASSWORD";
    private static final String STATE_NAME = "STATE_NAME";
    private static final String PICTURE_PATH = "PIC_PATH";

//    App Associated
    private static final String IS_FIRST_TIME = "IS_FIRST_TIME";





   //wish L
    private static final String WISH_LIST_STRING = "asda";

    //User Addres Vairables
    private static final String USER_LAT = "LAT";
    private static final String USER_LON = "LONG";
    private static final String USER_ADDRESS_TEXT = "ADD";
    private static final String USER_PLACE_NAME = "PLACE_NAME";
    private static final String CART_LIST_STRING = "CART_LIST";
    private static final String TAGI = "DATA_STORE";
    private static final String IS_LOC_SAVED = "LOCATION_SAVED";
    private static final String IS_LOGGED_IN = "LOGIN";
    private static final String RECYCLER_VIEW_GRID = "GRID";
    private static final String IS_PHONE_NUMBER_PRESENT = "PHONE";



    private static DataStore mStore = null;
    private String IS_WISH_LIST_SAVED = "WISH";
    private String IS_LOC_FIRST_TIME = "LOCATION_FLAG";
    private String GCMKey = "GCM_KEY";

    public static synchronized DataStore getStorageInstance(Context context) {
        if (mStore == null) {
            mStore = new DataStore(context);
        }
        return mStore;
    }


    private SharedPreferences.Editor editor = null;
    private SharedPreferences mSharedPrefrences = null;

    private Context mContext = null;
    public DataStore(Context mContext) {
        this.mContext = mContext;
        mSharedPrefrences = (SharedPreferences) this.mContext.getSharedPreferences(SHARED_PREFS_FILE,Context.MODE_PRIVATE);
        if (mSharedPrefrences != null){
            editor = mSharedPrefrences.edit();
        }
    }


    public  String getUserId() {
        return mSharedPrefrences.getString(USER_ID,null);
    }

    public void setEmailId(String emailIdTag) {
        editor.putString(EMAIL_ID_TAG, emailIdTag);
        editor.commit();
    }


    public void setStateId(String stateId) {
        editor.putString(STATE_ID, stateId);
        editor.commit();
    }

    public void setStateName(String stateName) {
        editor.putString(STATE_NAME,stateName);
        editor.commit();
    }

    public  void setUserName(String userNameTag) {
        editor.putString(USER_NAME_TAG, userNameTag);
        editor.commit();
    }

    public  void setPhoneNumberTag(String phoneNumberTag) {
        editor.putString(PHONE_NUMBER_TAG, phoneNumberTag);
        editor.commit();
    }


    public  String getStateId() {
        return mSharedPrefrences.getString(STATE_ID,null);
    }



    public  String getStateName() {
        return mSharedPrefrences.getString(STATE_NAME,null);
    }

    public  String getUserName() {
        return mSharedPrefrences.getString(USER_NAME_TAG,null);
    }

    public  String getPhoneNumber() {
        return mSharedPrefrences.getString(PHONE_NUMBER_TAG,null);
    }











    public  void setIsFirstTime(boolean value) {
        editor.putBoolean(IS_FIRST_TIME,value);
        editor.commit();
    }

    public  boolean isFirstTime(){
        return mSharedPrefrences.getBoolean(IS_FIRST_TIME,true);
    }

    public String getPassWord() {
        return mSharedPrefrences.getString(PASSWORD,null);
    }





    public void setPassword(String password) {
        editor.putString(PASSWORD,password);
        editor.apply();
    }


    public void setProPicturePath(String picturePath) {
        editor.putString(PICTURE_PATH,picturePath);
        editor.apply();
    }

    public String getpicturePath() {
        return mSharedPrefrences.getString(PICTURE_PATH,null);
    }

    public boolean isWishLishPresent() {
        return mSharedPrefrences.getBoolean(IS_WISH_LIST_SAVED,false);

    }

    public void setWishListSaved() {
        editor.putBoolean(IS_WISH_LIST_SAVED,true);
        editor.commit();
    }

    public void saveWishListProductString(JSONArray response) {
        editor.putString(WISH_LIST_STRING,response.toString());
        editor.commit();
    }

    public String getWishListString() {
        return mSharedPrefrences.getString(WISH_LIST_STRING,null);
    }

        /*A boolean Flag Representing that no Previous Location is saved for this user*/

    public boolean isFirstTimeLocationSelected() {
        return mSharedPrefrences.getBoolean(IS_LOC_FIRST_TIME,true);
    }


//
//
//    public void saveUserLocation(Place place) {
//        editor.putString(USER_LAT, String.valueOf(place.getLatLng().latitude));
//        editor.putString(USER_LON, String.valueOf(place.getLatLng().longitude));
//        editor.putString(USER_ADDRESS_TEXT, (String) place.getAddress());
//        editor.putString(USER_PLACE_NAME, (String) place.getName());
//        editor.commit();
//    }

    public void setLocationSaved(boolean b) {

            //means Location is saved , therefore ,location is not being selected for First time
            editor.putBoolean(IS_LOC_FIRST_TIME,b);
            editor.commit();
        }



//    public boolean isSignedIn(BaseActivity baseActivity) {
//        return false;
//    }



    public List<CartModel> getCartProducts() {
        Type type = new TypeToken<List<CartModel>>(){}.getType();
        Gson gson = new Gson();
        List<CartModel> cartList = gson.fromJson(mSharedPrefrences.getString(CART_LIST_STRING,null), type);
        if (cartList == null){
            return null;
        }
        return cartList;
    }

    public void saveCartList(List<CartModel> mCartProducts) {
        Gson gson = new Gson();

        String cart_list_string = gson.toJson(mCartProducts);
        editor.putString(CART_LIST_STRING,cart_list_string);
        editor.commit();
        Log.d("TAG","saving cart List in File = " + cart_list_string);
    }




    public void saveGCMKEY(String gcm) {
        editor.putString(GCMKey,gcm);
    }

    public boolean isLocationSaved() {
        return mSharedPrefrences.getBoolean(IS_LOC_SAVED,false);
    }
//
//    public Place getUserLocation() {
//
//
//        Place p = null;
//        return p;
//
//    }


    public boolean isLoggedIn() {
        return mSharedPrefrences.getBoolean(IS_LOGGED_IN,false);
    }

    public void setLoggedIn(boolean b) {
        editor.putBoolean(IS_LOGGED_IN,b);
        editor.apply();
    }

    public void setRecylerViewType(boolean isGrid) {
        editor.putBoolean(RECYCLER_VIEW_GRID,isGrid);
        editor.apply();
    }

    public boolean getViewType() {
        return mSharedPrefrences.getBoolean(RECYCLER_VIEW_GRID,true);
    }

    public boolean isPhoneNumberPresent() {
        return mSharedPrefrences.getBoolean(IS_PHONE_NUMBER_PRESENT,false);
    }
}
