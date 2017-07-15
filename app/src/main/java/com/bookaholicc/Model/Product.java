package com.bookaholicc.Model;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandhu on 5/2/17.
 * THe Model Class for A product
 *
 *
 *
 * {@param type} == if 0 --set it as book
 *  1 -- set it as book
 *  2 -- set it as console
 *  3 -- set it as games cd
 */




public class Product {


    private final String oru_price;
    private final String imageURL;
    private final String duration;
    private final String publisherName;
    // Generic attributes
    /*Product Id*/
    private int pid;

    /*Product name*/
    private String productName;

    /*Prodct Description*/
    private String productDesc;

    /*Author Name*/
    private String authorName;

    /*Publisher Name*/

    /*MRP */
    private String mrp;

    /*OUR pricing  */
    private String isTopRated;
    /**/
    private  String genre;
    private String isBestSeller;

    /*Base Categoru*/
    private String baseCateogory;
    /* SUb CAtegory */
    private String subCategory;
    /*Summary */
    private String summary;

    /*Picturen Path*/

    private String picPath;


    /*The Price Variable*/
    private String price;

    private String quantity;

    public Product(int pid, String productName,
                   String productDesc, String auhtorName,
                   String publisherName, String mrp,
                   String isTopRated, String isBestSeller,
                   String bookSummary, String base_category,
                   String sub_category, String our_price,
                   String duration, String iamgeUrl) {




        this.pid = pid;
        this.productName = productName;
        this.productDesc = productDesc;
        this.authorName = auhtorName;
        this.publisherName = publisherName;
        this.isTopRated = isTopRated;
        this.isBestSeller = isBestSeller;
        this.subCategory = sub_category;
        this.baseCateogory = base_category;
        this.duration = duration;
        this.imageURL = iamgeUrl;
        this.summary = bookSummary;
        this.mrp = mrp;
        this.oru_price = our_price;

    }


    public String getOru_price() {
        return oru_price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDuration() {
        return duration;
    }

    public String getPublisherName() {
        return publisherName;
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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getIsTopRated() {
        return isTopRated;
    }

    public void setIsTopRated(String isTopRated) {
        this.isTopRated = isTopRated;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsBestSeller() {
        return isBestSeller;
    }

    public void setIsBestSeller(String isBestSeller) {
        this.isBestSeller = isBestSeller;
    }

    public String getBaseCateogory() {
        return baseCateogory;
    }

    public void setBaseCateogory(String baseCateogory) {
        this.baseCateogory = baseCateogory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}