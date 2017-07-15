package com.bookaholicc.Model;

/**
 * Created by nandhu on 1/7/17.
 * The Products sis Convereted to this model for convience , it hides all attribs associated with product and send only what is neccessary
 */

public class CartProduct {


    private int pid;
    private String productName;

    public CartProduct(int pid, String productName) {
        this.pid = pid;
        this.productName = productName;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
