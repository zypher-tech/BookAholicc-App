package com.bookaholicc.Model;

import java.util.List;

/**
 * Created by nandhu on 20/7/17.
 * The Return object for this user
 */


// Since Each user can use multiple dates to read
    // we have to have  COmplete object for user

public class Return {

    int userId;
    int pid;
    String imageURL;
    String pName;
    String returnTime;

    public Return(int userId, String imageURL, String pName, String returnTime) {
        this.userId = userId;
        this.imageURL = imageURL;
        this.pName = pName;
        this.returnTime = returnTime;
    }
}
