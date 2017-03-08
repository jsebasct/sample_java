package org.jp.morgan;

import java.sql.Timestamp;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    
    @Test
    public void testApp() {
        assertTrue( true );
    }
    
    @Test
    public void testDividendYieldCommon() {
        int lastDividend = 1;
        Stock stock = new StockCommon(lastDividend);
        
        int price = 20;
        float result = stock.calculateDividendYield(price);
        assertEquals(0.05, result, 0.01);
    }
    
    @Test
    public void testDividendYieldCommonOverZero() {
        int lastDividend = 0;
        Stock stock = new StockCommon(lastDividend);
        
        int price = 20;
        float result = stock.calculateDividendYield(price);
        assertEquals(0.0, result, 0.01);
    }
    
    @Test
    public void testDividendYieldPreferred() {
        int lastDividend = 8;
        int fixedDividend = 2;
        int parValue = 100;
        Stock stock = new StockPreferred(lastDividend, fixedDividend, parValue);
        
        int price = 10;
        float result = stock.calculateDividendYield(price);
        assertEquals(0.2, result, 0.01);
    }
    
    @Test
    public void testPERatio() {
        int lastDividend = 8;
        Stock stock = new StockCommon(lastDividend);
        
        int price = 10;
        float ratio = stock.getPERatio(price);
        assertEquals(0.8, ratio, 0.01);
    }
    
    @Test
    public void testVWAP() {
        
        int lastDividend = 8;
        Stock stock = new StockCommon(lastDividend);
        
        float price = 10;
        boolean buy = true;
        int quantity = 100;
        
        stock.recordTrade( new Trade(quantity, buy, price));
        stock.recordTrade( new Trade(300, buy, 8));
        stock.recordTrade( new Trade(200, buy, 11));
        
        float res = stock.calculateVWSP(5);
        
        assertEquals(9.333333f, res, Float.MIN_VALUE);
    }
    
    @Test
    public void testVWAPWithLimitTime() {
        
        int lastDividend = 8;
        Stock stock = new StockCommon(lastDividend);
        
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
