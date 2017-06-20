package com.bookaholicc.Model;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 * The Single Model of a Combo , is Constantly Updatable
 */

public class Combo {



    private String comboId;
    private String comboName;
    private String comoDesc;
    private String imageURL;
    private String pricing;
    private String duration;

    public Combo(String comboId, String comBoName,String comoDesc, String imageURL, String pricing, String duration) {
        this.comboId = comboId;
        this.comboName = comBoName;
        this.comoDesc = comoDesc;
        this.imageURL = imageURL;
        this.pricing = pricing;
        this.duration = duration;
    }



    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
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

    public String getPricing() {
        return pricing;
    }

    public void setPricing(String pricing) {
        this.pricing = pricing;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
