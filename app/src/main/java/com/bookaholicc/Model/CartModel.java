package com.bookaholicc.Model;

/**
 * Created by nandhu on 22/3/17.
 *
 */

public class CartModel {
    int pid;
    String pName;
    int quantity ;
    int price;
    String photoPath;

    public CartModel(int pid, String pName, int quantity, int price, String photoPath) {
        this.pid = pid;
        this.pName = pName;
        this.quantity = quantity;
        this.price = price;
        this.photoPath = photoPath;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
