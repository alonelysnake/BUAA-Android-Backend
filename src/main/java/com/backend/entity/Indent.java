package com.backend.entity;

import java.time.LocalDateTime;

public class Indent {
    public enum OrderState {
        NOT_PAY,
        PAID,
        NOT_ACCEPT,
        ACCEPTED,
        DELIVERING,
        FINISHED,
        CANCELED
    }
    
    private int o_id;
    private LocalDateTime o_time;
    private double cost;
    private OrderState state=OrderState.PAID;
    private String address;//送货地址
    private int u_id;
    private int rider;
    private int p_id;
    private String o_comment;

    public Indent(LocalDateTime o_time, double cost, String address, int u_id, int rider, int p_id,String o_comment) {
        this.o_time = o_time;
        this.cost = cost;
        this.address = address;
        this.u_id = u_id;
        this.rider = rider;
        this.p_id = p_id;
        this.o_comment = o_comment;
    }

    public String getO_comment() {
        return o_comment;
    }

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
