package com.bookaholicc.Model;

/**
 * Created by nandhu on 21/3/17.
 * The Model of an User
 */

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String eMailAddress;
    private String phoneNumber;
    private String imageUrl;
    private String isMember;
    private String isVerified;
    private int aadhaarNo;
    private int panNo;

    public User() {
    }

    /*TH Default Location for Latitude*/
    private double def_Lat;

    /*The Defalt Location for Longitude*/
    private double def_Lon;

    public User(int userId, String firstName, String lastName, String eMailAddress, String phoneNumber, String imageUrl, String isMember, String isVerified, int aadhaarNo, int panNo, double def_Lat, double def_Lon) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.isMember = isMember;
        this.isVerified = isVerified;
        this.aadhaarNo = aadhaarNo;
        this.panNo = panNo;
        this.def_Lat = def_Lat;
        this.def_Lon = def_Lon;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIsMember() {
        return isMember;
    }

    public void setIsMember(String isMember) {
        this.isMember = isMember;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public int getAadhaarNo() {
        return aadhaarNo;
    }

    public void setAadhaarNo(int aadhaarNo) {
        this.aadhaarNo = aadhaarNo;
    }

    public int getPanNo() {
        return panNo;
    }

    public void setPanNo(int panNo) {
        this.panNo = panNo;
    }

    public double getDef_Lat() {
        return def_Lat;
    }

    public void setDef_Lat(double def_Lat) {
        this.def_Lat = def_Lat;
    }

    public double getDef_Lon() {
        return def_Lon;
    }

    public void setDef_Lon(double def_Lon) {
        this.def_Lon = def_Lon;
    }
}
