package org.jp.morgan;

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
        assertEquals(0.05, result, 0.05);
    }
    
    @Test
    public void testDividendYieldPreferred() {
        int lastDividend = 1;
        int fixedDividend = 2;
        int parValue = 100;
        Stock stock = new StockPreferred(lastDividend, fixedDividend, parValue);
        
        int price = 20;
        float result = stock.calculateDividendYield(price);
        assertEquals(0.05, result, 0.05);
    }
}
