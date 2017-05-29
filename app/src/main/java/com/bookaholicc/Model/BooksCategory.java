package com.bookaholicc.Model;

/**
 * Created by nandhu on 23/4/17.
 * The Model which holds category Information
 */

public class BooksCategory {

    private int categoryId;
    private String categoryName;

    public BooksCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
