package com.backend.entity;

public class Dish {
    private int id;
    private int provider;
    private double discount;
    private double originPrice;
    private int saleNum;
    //TODO 详细信息
    
    public int getId() {
        return id;
    }
    
    public int getProvider() {
        return provider;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public double getOriginPrice() {
        return originPrice;
    }
    
    public int getSaleNum() {
        return saleNum;
    }
}
