package com.bookaholicc.Model;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 * The Single Model of a Combo , is Constantly Updatable
 */

public class Combo
{

    private String comboId;
    private String comboName;
    private String comboImage;
    private String comboDescriptio;
    private String comboPrice;
    private int mCid;
    private List<MiniProductDescription> mListofproducts;


    public Combo(String comboId, String comboName, String comboDescriptio, String comboPrice, int mCid) {
        this.comboId = comboId;
        this.comboName = comboName;
        this.comboImage = comboImage;
        this.comboDescriptio = comboDescriptio;
        this.comboPrice = comboPrice;
        this.mCid = mCid;
    }





    public Combo(String comboId, String comboName, String comboImage, String comboDescriptio, String comboPrice, List<MiniProductDescription> mListofproducts) {
        this.comboId = comboId;
        this.comboName = comboName;
        this.comboImage = comboImage;
        this.comboDescriptio = comboDescriptio;
        this.comboPrice = comboPrice;
        this.mListofproducts = mListofproducts;
    }

    public String getComboId() {
        return comboId;
    }

    public void setComboId(String comboId) {
        this.comboId = comboId;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public String getComboImage() {
        return comboImage;
    }

    public void setComboImage(String comboImage) {
        this.comboImage = comboImage;
    }

    public String getComboDescriptio() {
        return comboDescriptio;
    }

    public void setComboDescriptio(String comboDescriptio) {
        this.comboDescriptio = comboDescriptio;
    }

    public String getComboPrice() {
        return comboPrice;
    }

    public void setComboPrice(String comboPrice) {
        this.comboPrice = comboPrice;
    }

    public List<MiniProductDescription> getMockupDescription() {
        return mListofproducts;
    }

    public void setmListofproducts(List<MiniProductDescription> mListofproducts) {
        this.mListofproducts = mListofproducts;
    }
}
