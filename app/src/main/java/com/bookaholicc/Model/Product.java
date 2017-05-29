package com.bookaholicc.Model;

import android.os.Parcel;
import android.os.Parcelable;

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




public class Product implements Parcelable {



        // Generic attributes
    private int pid;
    private String productName;
    private String summary;
    private int rating;
    private  String picPath;
    private int price ;
    private String duration ;
    private int likeCount;
    // This is the Differentiator Attribute
    private int categoryId;
    private boolean liked = false;
    private boolean isAvailble = true;

    // when Customer Picks his own Duration  , we Need to increment price
    /*totoal price =  priceOffset * Duration */
    private int priceOffset ;
    private List<PriceInfo> mPriceList = new ArrayList<>();

    public int getPriceOffset() {
        return priceOffset;
    }

    public void setPriceOffset(int priceOffset) {
        this.priceOffset = priceOffset;
    }

    public List<PriceInfo> getmPriceList() {
        return mPriceList;
    }

    public void setmPriceList(ArrayList<PriceInfo> mPriceList) {
        this.mPriceList = mPriceList;
    }

    public boolean isMutliplayer() {
        return isMutliplayer;
    }

    public void setMutliplayer(boolean mutliplayer) {
        isMutliplayer = mutliplayer;
    }

    //Books
    private  String ISBN;
    private String authorName;
    private String authorId;
    private String bookSummary;
    private boolean isTopSeller;
    private int genreId;
    private String genreName;
    private String maxReadDuration;


    // Consoles
    private String color;
    private String capacity;
    private String brand;

    //Games
    private String genre;
    private String gamePlayDuration;
    private boolean isMutliplayer;
    private int genreIdgames;
    private String studios;



    /*Constructor For Books */




    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public boolean isTopSeller() {
        return isTopSeller;
    }

    public void setTopSeller(boolean topSeller) {
        isTopSeller = topSeller;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getMaxReadDuration() {
        return maxReadDuration;
    }

    public void setMaxReadDuration(String maxReadDuration) {
        this.maxReadDuration = maxReadDuration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGamePlayDuration() {
        return gamePlayDuration;
    }

    public void setGamePlayDuration(String gamePlayDuration) {
        this.gamePlayDuration = gamePlayDuration;
    }

    public boolean getIsMutliplayeravaliable() {
        return isMutliplayer;
    }

    public void setIsMutliplayeravaliable(boolean isMutliplayeravaliable) {
        this.isMutliplayer = isMutliplayeravaliable;
    }

    public int getGenreIdgames() {
        return genreIdgames;
    }

    public void setGenreIdgames(int genreIdgames) {
        this.genreIdgames = genreIdgames;
    }

    public String getStudios() {
        return studios;
    }

    public void setStudios(String studios) {
        this.studios = studios;
    }

    public Product(int pid, String productName, String summary, int rating, String picPath,
                   int price, String duration, int likeCount, int categoryId, boolean liked, boolean isAvailble, int type) {
        this.pid = pid;
        this.productName = productName;
        this.summary = summary;
        this.rating = rating;
        this.picPath = picPath;
        this.price = price;
        this.duration = duration;
        this.likeCount = likeCount;
        this.categoryId = categoryId;
        this.liked = liked;
        this.isAvailble = isAvailble;
        this.type = type;
    }

    public Product(Parcel in) {
        this.pid = in.readInt();
        this.productName   = in.readString();
        this.price  = in.readInt();
        this.categoryId  = in.readInt();
        this.summary = in.readString();
        this.duration = in.readString();
        this.likeCount  = in.readInt();
        in.readTypedList(mPriceList,PriceInfo.CREATOR);


    }

    public Product(int pid, String productName, ArrayList<PriceInfo> mPriceList, String authorName, String bookSummary) {
        this.pid = pid;
        this.productName = productName;
        this.mPriceList = mPriceList;
        this.authorName = authorName;
        this.bookSummary = bookSummary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isAvailble() {
        return isAvailble;
    }

    public void setAvailble(boolean availble) {
        isAvailble = availble;
    }

    public int getType() {
        return type;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }



    public void setType(int type) {
        this.type = type;
    }

    private  int type ;

    public boolean isLiked() {
        return liked;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getLikeCount() {
        return "35";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(pid);
        dest.writeString(productName);
        dest.writeString(summary);
        dest.writeInt(price);
        dest.writeString(duration);
        dest.writeInt(likeCount);
        dest.writeInt(categoryId);
        dest.writeValue(liked);
        dest.writeValue(isAvailble);
        dest.writeTypedList(mPriceList);

        switch (categoryId){
            case 0:
                //books values
                dest.writeString(ISBN);
                dest.writeString(authorName);
                dest.writeString(authorId);
                dest.writeString(bookSummary);
                dest.writeValue(isTopSeller);
                dest.writeString(genreName);
                dest.writeString(maxReadDuration);
                break;
            case 1 :


                //COnsoles
                dest.writeString(color);
                dest.writeString(capacity);
                dest.writeString(brand);

                break;
            case 2:
                dest.writeString(genre);
                dest.writeString(genre);
                dest.writeString(gamePlayDuration);
                dest.writeInt(genreIdgames);
                dest.writeValue(isMutliplayer);
                dest.writeString(studios);
                break;
            case 3 :
                break;
            case 4 :
                break;


        }

        //




    }
    @SuppressWarnings("unused")
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };



    public class Book{
        String authorName;
        String IsBn;
    }
}






