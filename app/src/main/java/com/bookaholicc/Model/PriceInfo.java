package com.bookaholicc.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by nandhu on 5/3/17.
 * This class holds Prices
 */
public class PriceInfo  implements Parcelable ,Serializable{
    private int price;
    private String days;

    public PriceInfo(int price, String days) {
        this.price = price;
        this.days = days;
    }


    public PriceInfo(Parcel in) {
        price = in.readInt();
        days = in.readString();
    }

    public static final Creator<PriceInfo> CREATOR = new Creator<PriceInfo>() {
        @Override
        public PriceInfo createFromParcel(Parcel in) {
            return new PriceInfo(in);
        }

        @Override
        public PriceInfo[] newArray(int size) {
            return new PriceInfo[size];
        }
    };

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int i) {

        dest.writeString(days);
        dest.writeInt(price);


    }
}
