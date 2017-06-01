package com.bookaholicc.Model;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 *
 */

public class GenreModel {
    private String genreName;
    private String genreId;
    private List<Product> mList;


    public GenreModel(String genreName, String genreId, List<Product> mList) {
        this.genreName = genreName;
        this.genreId = genreId;
        this.mList = mList;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public List<Product> getProductList() {
        return mList;
    }

    public void setmList(List<Product> mList) {
        this.mList = mList;
    }
}
