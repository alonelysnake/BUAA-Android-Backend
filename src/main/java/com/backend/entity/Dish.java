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
