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

    int fixedDividend;
    int parValue;
    
    public StockPreferred(int lastDividend, int fixedDividend, int parValue) {
        super(lastDividend);
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
    }
    
    @Override
    float calculateDividendYield(int price) {
        return lastDividend * parValue / price;
    }
}
