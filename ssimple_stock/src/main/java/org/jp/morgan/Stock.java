/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

/**
 *
 * @author jscruz
 */
abstract class Stock {
    
    int lastDividend;

    Stock(int dividend) {
        lastDividend = dividend;
    }

    float calculateDividendYield(int price) {
        return lastDividend / price;
    }
}
