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
    
    private final String symbol;
    private final double lastDividend;
    private final int parValue;
    
    private final List<Trade> trades;

    Stock(String symbol, float dividend, int parValue) {
        this.symbol = symbol;
        this.lastDividend = dividend;
        this.parValue = parValue;
        
        trades = new ArrayList<Trade>();
    }
    
    abstract double calculateDividendYield(int price);

    public String getSymbol() {
        return symbol;
    }
    
    public double getLastDividend() {
        return lastDividend;
    }
    
    public int getParValue() {
        return parValue;
    }

    public double getPERatio(float price) {
        return price / getLastDividend();
    }
    
    public void recordTrade(Trade someTrade) {
        this.trades.add(someTrade);
    }

    public float calculateVWSP(int lastMinutes) {
        
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

        float res = shareQuantity > 0 ? up / shareQuantity: 0;
        return res;
    }

}
