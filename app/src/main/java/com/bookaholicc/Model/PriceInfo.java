package com.bookaholicc.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by nandhu on 5/3/17.
 * This class holds Prices
 */
public class PriceInfo {
    private int windowId;
    private int amount;

    public PriceInfo(int windowId, int amount) {
        this.windowId = windowId;
        this.amount = amount;
    }

    public int getWindowId() {
        return windowId;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
