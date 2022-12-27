package com.backend.entity;

public class DishIndent {
    private int o_id;
    private int d_id;
    private int sum;
    
    public DishIndent() {
    }
    
    public DishIndent(int o_id, int d_id, int sum) {
        this.o_id = o_id;
        this.d_id = d_id;
        this.sum = sum;
    }
    
    public int getSum() {
        return sum;
    }
    
    public int getOrderId() {
        return o_id;
    }
    
    public int getDishId() {
        return d_id;
    }
}
