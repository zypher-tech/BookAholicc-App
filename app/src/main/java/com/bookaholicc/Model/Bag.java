package com.bookaholicc.Model;

/**
 * Created by nandhu on 27/3/17.
 * The Model Class for an hotel
 */

public class Bag {
    private String bagId;
    private String bagName;
    private String productcount;

    public Bag(String bagId, String bagName, String productcount) {
        this.bagId = bagId;
        this.bagName = bagName;
        this.productcount = productcount;
    }

    public String getBagId() {
        return bagId;
    }

    public void setBagId(String bagId) {
        this.bagId = bagId;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName;
    }

    public String getProductcount() {
        return productcount;
    }

    public void setProductcount(String productcount) {
        this.productcount = productcount;
    }
}
