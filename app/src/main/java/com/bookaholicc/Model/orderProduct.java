package com.bookaholicc.Model;

import java.security.Timestamp;
import java.util.Date;

/**
 * Created by nandhu on 22/3/17.
 * This model does not hold Prodct info , rather it holds order realted Attributres
 */

public class orderProduct {

    private String pName;
    private String pid;
    private int quantity;
    public boolean delivery_now;

    public orderProduct(String pName, String pid, int quantity) {
        this.pName = pName;
        this.pid = pid;
        this.quantity = quantity;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
