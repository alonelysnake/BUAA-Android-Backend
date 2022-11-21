package com.backend.entity;

import java.time.LocalDateTime;

public class Indent {
    public enum OrderState {
        NOT_PAY,
        ACCEPTED,
        DELIVERING,
        FINISHED,
        CANCELED
    }
    
    private int o_id;
    private LocalDateTime o_time;
    private double cost;
    private OrderState state;
    private String address;
    private int u_id;
    private int rider;
    private int p_id;
    
    public int getId() {
        return o_id;
    }
    
    public LocalDateTime getTime() {
        return o_time;
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
        return u_id;
    }
    
    public int getRider() {
        return rider;
    }
    
    public int getProvider() {
        return p_id;
    }
}
