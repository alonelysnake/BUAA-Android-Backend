package com.backend.entity;

import java.time.LocalDateTime;

public class Order {
    public enum OrderState {
        NOT_PAY,
        ACCEPTED,
        DELIVERING,
        FINISHED,
        CANCELED
    }
    
    private int id;
    private LocalDateTime time;
    private double cost;
    private OrderState state;
    private String address;
    private int user;
    private int rider;
    private int provider;
    
    public int getId() {
        return id;
    }
    
    public LocalDateTime getTime() {
        return time;
    }
    
    public double getCost() {
        return cost;
    }
    
    public OrderState getState() {
        return state;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getUser() {
        return user;
    }
    
    public int getRider() {
        return rider;
    }
    
    public int getProvider() {
        return provider;
    }
}
