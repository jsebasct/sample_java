/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jcruztor
 */
public class GBCE {

    private final List<Stock> stocks;

    public GBCE() {
        stocks = new ArrayList<Stock>();

        Stock s1 = new StockCommon("TEA", 0, 100);
        Stock s2 = new StockCommon("POP", 8, 100);
        Stock s3 = new StockCommon("ALE", 23, 60);
        Stock s4 = new StockPreferred("GIN", 8, 2, 100);
        Stock s5 = new StockCommon("JOE", 13, 250);

        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        stocks.add(s4);
        stocks.add(s5);
    }

    public void addStockTrades() {
        for (Stock stock : stocks) {
            addMockStockTrade(stock);
        }
    }

    private void addMockStockTrade(Stock stock) {
        boolean buy = true;
        stock.recordTrade(new Trade(100, buy, 10));
        stock.recordTrade(new Trade(300, buy, 8));
        stock.recordTrade(new Trade(200, buy, 11));
    }

    public double calculateGeometricMean() {
        double res = 1;

        for (Stock stock : stocks) {
            res *= stock.calculateVWSP(5);
        }

        double time = Math.pow(res, 1.0 / stocks.size());
        return time;
    }
}
