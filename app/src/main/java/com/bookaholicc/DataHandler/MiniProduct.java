package com.bookaholicc.DataHandler;

/**
 * Created by nandhu on 20/6/17.
 *
 *
 */

public class MiniProduct {
    private String productName;
    private String imageURL;
    private String pid;

    public MiniProduct(String productName, String imageURL, String pid) {
        this.productName = productName;
        this.imageURL = imageURL;
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
