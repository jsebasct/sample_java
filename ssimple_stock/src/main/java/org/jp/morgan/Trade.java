/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

import java.sql.Timestamp;

/**
 *
 * @author jscruz
 */
public class Trade {

    private int quantity;
    private boolean buy;
    private float price;
    private Timestamp time;
    
    public Trade(int quantity, boolean buy, float price) {
        this(quantity, buy, price, new Timestamp(System.currentTimeMillis()));
    }
    
    public Trade(int quantity, boolean buy, float price, Timestamp time) {
        this.quantity = quantity;
        this.buy = buy;
        this.price = price;
        this.time = time;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isBuy() {
        return buy;
    }

    public float getPrice() {
        return price;
    }

    public Timestamp getTime() {
        return time;
    }
    
}
