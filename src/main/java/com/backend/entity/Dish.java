package com.backend.entity;

public class Dish {
    private int d_id;
    private int p_id;
    private double discount;
    private double price;
    private int sale;
    private int d_likes;
    private int d_dislikes;
    //TODO 详细信息


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
    
    public double getDiscount() {
        return discount;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getSaleNum() {
        return sale;
    }
}
