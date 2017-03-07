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
    public void testMultiplication() {
        int lastDividend = 1;
        Stock stock = new Stock(lastDividend);
        float result = stock.calculateDividendYield(20);
        assertEquals(0.05, result, 0.05);
    }
}
