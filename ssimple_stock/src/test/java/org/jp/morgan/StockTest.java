package org.jp.morgan;

import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

/**
 * Unit test for Stock.
 */
public class StockTest {
    
    private Stock stock;
    
    @Before
    public void init() {
        int lastDividend = 1;
        stock = new StockCommon("StockX", lastDividend, 100);
    }
    
    @Test
    public void testDividendYieldCommon() {
        int price = 20;
        double result = stock.calculateDividendYield(price);
        assertEquals(0.05, result, 0.01);
    }
    
    @Test
    public void testDividendYieldCommonOverZero() {
        int price = 20;
        stock = new StockCommon("StockX", 0, 100);
        double result = stock.calculateDividendYield(price);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    public void testDividendYieldPreferred() {
        int lastDividend = 8;
        int fixedDividendPercent = 2;
        int parValue = 100;
        Stock stock = new StockPreferred("X", lastDividend, fixedDividendPercent, parValue);
        
        int price = 10;
        double result = stock.calculateDividendYield(price);
        assertEquals(0.2, result, 0.01);
    }
    
    @Test
    public void testPERatio() {
        int price = 10;
        double ratio = stock.getPERatio(price);
        assertEquals(10.0f, ratio, 0.01);
    }
    
    @Test
    public void testVWAP() {
        boolean buy = true;
        stock.recordTrade( new Trade(100, buy, 10));
        stock.recordTrade( new Trade(300, buy, 8));
        stock.recordTrade( new Trade(200, buy, 11));
        
        float res = stock.calculateVWSP(5);
        assertEquals(9.333333f, res, Float.MIN_VALUE);
    }
    
    @Test
    public void testVWAPWithLimitTime() {
        
        float price = 10;
        boolean buy = true;
        int quantity = 100;
        
        stock.recordTrade( new Trade(quantity, buy, price));
        stock.recordTrade( new Trade(300, buy, 8));
        stock.recordTrade( new Trade(200, buy, 11));
        
        final int tenMinutes = 10 * 60 * 1000;
        Timestamp someTimeAgo = new Timestamp(System.currentTimeMillis() - tenMinutes);
        stock.recordTrade( new Trade(200, buy, 11, someTimeAgo));
        
        float res = stock.calculateVWSP(5);
        
        assertEquals(9.333333f, res, Float.MIN_VALUE);
    }
}
