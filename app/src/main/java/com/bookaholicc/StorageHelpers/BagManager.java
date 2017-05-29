package com.bookaholicc.StorageHelpers;

import android.content.Context;

import com.bookaholicc.Model.Bag;
import com.bookaholicc.Model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 27/3/17.
 *
 */

public class BagManager {



    private static  BagManager mManger;
    private DataStore mStore;

    public BagManager(Context context) {
        mStore = DataStore.getStorageInstance(context);
    }

    public static synchronized BagManager getInstance(Context context) {
        if (mManger == null) {
            mManger = new BagManager(context);
        }
        return mManger;
    }

    public List<Bag> getAllBags(){


        return new ArrayList<>(5);
    }


    public void saveBag(Bag bag){



    }


    public void removeBag(String bagName){

    }
    public void CreateBag(Context context,String bagName){



    }


    public void addProductToBag(String bagName, Product p ){

    }


    public void removeProductFromBag(String bagName,Product p){

    }

    public void addProductsToBag(String bagName, List<Product> mBag){

    }


}
