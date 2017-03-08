/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jscruz
 */
abstract class Stock {
    
    private float lastDividend;
    private List<Trade> trades;

    Stock(float dividend) {
        lastDividend = dividend;
        trades = new ArrayList<Trade>();
    }
    
    abstract float calculateDividendYield(int price);

    public float getLastDividend() {
        return lastDividend;
    }

    float getPERatio(float price) {
        return lastDividend / price;
    }

//    void recordTrade(int quantity, boolean buy, float price) {
//        this.trades.add(new Trade(quantity, buy, price));
//    }
//    
//    void recordTrade(int quantity, boolean buy, float price, Timestamp time) {
//        this.trades.add(new Trade(quantity, buy, price, time));
//    }
    
    void recordTrade(Trade someTrade) {
        this.trades.add(someTrade);
    }

    float calculateVWSP(int lastMinutes) {
        
        int someTime = lastMinutes * 1000 * 60;
        Timestamp limitBeforeTime = new Timestamp(System.currentTimeMillis() - someTime);

        float up = 0;
        int shareQuantity = 0;

        for (Trade trade : trades) {
            if (trade.getTime().after(limitBeforeTime)) {
                up += trade.getPrice() * trade.getQuantity();
                shareQuantity += trade.getQuantity();
            }
        }

        float res = up / shareQuantity;
        return res;
    }

}
