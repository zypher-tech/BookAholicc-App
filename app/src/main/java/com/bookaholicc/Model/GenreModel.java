package com.bookaholicc.Model;

import com.bookaholicc.DataHandler.MiniProduct;

import java.util.List;

/**
 * Created by nandhu on 1/6/17.
 *
 */

public class GenreModel {
    private String genreName;
    private int genreId;
    private List<MiniProduct> mList;


    public GenreModel(String genreName, int genreId, List<MiniProduct> mList) {
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

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public List<MiniProduct> getProductList() {
        return mList;
    }

    public void setmList(List<MiniProduct> mList) {
        this.mList = mList;
    }
}
