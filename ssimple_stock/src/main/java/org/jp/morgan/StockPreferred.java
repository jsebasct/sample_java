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
public class StockPreferred extends Stock {

    float fixedDividend;
    
    public StockPreferred(String symbol, float lastDividend, float fixedDividend, int parValue) {
        super(symbol, lastDividend, parValue);
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }
    
    @Override
    float calculateDividendYield(int price) {
        return (fixedDividend/100) * parValue / price;
    }
}
