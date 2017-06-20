package com.bookaholicc.DataHandler;

import com.bookaholicc.Model.MiniProductDescription;

import java.security.Timestamp;
import java.util.List;

/**
 * Created by nandhu on 20/6/17.
 *
 */

class Order  {

    private boolean isAccepted;
    private List<MiniProduct> mList;
    private boolean orderStatus;
    private  int orderId;
    private int amount;
    private int userId;
    private  String firstName;
    private String lastName;
    private String phoneNumber;
    private double orderLat;
    private double orderLon;
    private Timestamp orderInsertedAt;
    private Timestamp orderAcceptedAt;
    private Timestamp riderAcceptedAt;
    private Timestamp dispatchedAt;
    private Timestamp returnDate;
    private Timestamp deliveredAt;
    private Timestamp returnedAt;
    private Timestamp returnCondtion;

    public Order(List<MiniProduct> mList, int amount, int userId, String firstName, String lastName, String phoneNumber, double orderLat, double orderLon) {
        this.mList = mList;
        this.amount = amount;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.orderLat = orderLat;
        this.orderLon = orderLon;
    }

    public Order(List<MiniProduct> mProducts, String firstName, String phoneNumber, double orderLat, double orderLon) {
        this.mList = mProducts;
        this.firstName  = firstName;
        this.phoneNumber = phoneNumber;
        this.orderLat = orderLat;
        this.orderLon = orderLon;
    }
}
