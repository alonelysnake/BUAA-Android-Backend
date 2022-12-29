package com.backend.entity;

public class Dish {
    private int d_id;
    private int p_id;
    private double curPrice;
    private double price;
    private int sale;
    private int d_likes;
    private int d_dislikes;
    private String imgUrl;
    private boolean isHot;
    private boolean isTop;
    private String ingredient;
    private String name;
    private boolean isOver;
    private String pinyin;

    public Dish(int d_id, int p_id, double curPrice, double price, int sale, int d_likes, int d_dislikes, String imgUrl, boolean isHot, boolean isTop, String ingredient, String name, boolean isOver, String pinyin) {
        this.d_id = d_id;
        this.p_id = p_id;
        this.curPrice = curPrice;
        this.price = price;
        this.sale = sale;
        this.d_likes = d_likes;
        this.d_dislikes = d_dislikes;
        this.imgUrl = imgUrl;
        this.isHot = isHot;
        this.isTop = isTop;
        this.ingredient = ingredient;
        this.name = name;
        this.isOver = isOver;
        this.pinyin = pinyin;
    }

    public Dish(int p_id, double curPrice, double price, int sale, int d_likes, int d_dislikes, String imgUrl, boolean isHot, boolean isTop, String ingredient, String name, boolean isOver, String pinyin) {
        this.p_id = p_id;
        this.curPrice = curPrice;
        this.price = price;
        this.sale = sale;
        this.d_likes = d_likes;
        this.d_dislikes = d_dislikes;
        this.imgUrl = imgUrl;
        this.isHot = isHot;
        this.isTop = isTop;
        this.ingredient = ingredient;
        this.name = name;
        this.isOver = isOver;
        this.pinyin = pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public int getD_id() {
        return d_id;
    }

    public int getP_id() {
        return p_id;
    }

    public int getSale() {
        return sale;
    }

    public int getD_likes() {
        return d_likes;
    }

    public int getD_dislikes() {
        return d_dislikes;
    }

    public String getPinyin() {
        return pinyin;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getName() {
        return name;
    }

    public boolean isHot() {
        return isHot;
    }

    public boolean isTop() {
        return isTop;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getLikes() {
        return d_likes;
    }

    public int getDislikes() {
        return d_dislikes;
    }

    public int getId() {
        return d_id;
    }
    
    public int getProvider() {
        return p_id;
    }

    public double getCurPrice() {
        return curPrice;
    }

    public double getPrice() {
        return price;
    }
    
    public int getSaleNum() {
        return sale;
    }
}
