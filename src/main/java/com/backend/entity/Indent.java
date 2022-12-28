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
    private LocalDateTime o_time;//下单时间
    private LocalDateTime send_time;//配送时间
    private double cost;
    private OrderState state=OrderState.PAID;
    private String address;//送货地址
    private int u_id;
    private Integer rider;
    private int p_id;
    private String o_comment;//备注

    public Indent(LocalDateTime o_time, double cost, String address, int u_id, Integer rider, int p_id,String o_comment) {
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
    
    public Integer getRider() {
        return rider;
    }
    
    public int getProvider() {
        return p_id;
    }
}
