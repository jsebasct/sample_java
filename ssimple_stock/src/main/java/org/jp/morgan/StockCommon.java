/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

/**
 *
 * @author jcruztor
 */
public class StockCommon extends Stock {

    public StockCommon(String symbol, float lastDividend, int parValue) {
        super(symbol, lastDividend, parValue);
    }
    
    float calculateDividendYield(int price) {
        return getLastDividend() / price;
    }
    
}
