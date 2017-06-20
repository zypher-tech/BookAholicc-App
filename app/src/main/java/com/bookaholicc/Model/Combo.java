package com.bookaholicc.Model;

/**
 * Created by nandhu on 1/6/17.
 * The Single Model of a Combo , is Constantly Updatable
 */

public class Combo {



    private int comboId;
    private String comboName;
    private String comoDesc;
    private String imageURL;
    private int pricing;
    private String duration;

    public Combo(String comboId, String comBoName,String comoDesc, String imageURL, String pricing, String duration) {

    }

    public Combo(int comboId, String comBoName, String comoDesc, String imageURL, int price, String duration) {

        this.comboId = comboId;
        this.comboName = comBoName;
        this.comoDesc = comoDesc;
        this.imageURL = imageURL;
        this.pricing = price;
        this.duration = duration;
    }


    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public int getComboId() {
        return comboId;
    }

    public void setComboId(int comboId) {
        this.comboId = comboId;
    }

    public String getComoDesc() {
        return comoDesc;
    }

    public void setComoDesc(String comoDesc) {
        this.comoDesc = comoDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getPricing() {
        return pricing;
    }

    public void setPricing(int pricing) {
        this.pricing = pricing;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
