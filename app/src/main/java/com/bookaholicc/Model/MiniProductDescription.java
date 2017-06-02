package com.bookaholicc.Model;

/**
 * Created by nandhu on 1/6/17.
 * The Small Product Description used in {@link Combo}
 */

public class mProductDescription {
    private String productName;
    private String pid;
    private String productImage;


    public mProductDescription(String productName, String pid, String productImage) {
        this.productName = productName;
        this.pid = pid;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
