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
    private String u_id;
    private String rider;
    private String p_id;
    private String o_comment;//备注
    private int d_id;

    public Indent(LocalDateTime o_time, double cost, String address, String u_id, String rider, String p_id,String o_comment) {
        this.o_time = o_time;
        this.cost = cost;
        this.address = address;
        this.u_id = u_id;
        this.rider = rider;
        this.p_id = p_id;
        this.o_comment = o_comment;
    }

    public Indent(int o_id, LocalDateTime o_time, LocalDateTime send_time, double cost, OrderState state, String address, String u_id, String rider, String p_id, String o_comment, int d_id) {
        this.o_id = o_id;
        this.o_time = o_time;
        this.send_time = send_time;
        this.cost = cost;
        this.state = state;
        this.address = address;
        this.u_id = u_id;
        this.rider = rider;
        this.p_id = p_id;
        this.o_comment = o_comment;
        this.d_id = d_id;
    }

    public int getD_id() {
        return d_id;
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
    
    public String getUser() {
        return u_id;
    }
    
    public String getRider() {
        return rider;
    }
    
    public String getProvider() {
        return p_id;
    }
}
