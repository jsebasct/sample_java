/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jscruz
 */
public class AllStocksTest {
    
    private List<Stock> stocks;
    
    @Before
    public void init() {
        stocks = new ArrayList<Stock>();
        
        Stock s1 = new StockCommon("TEA", 0, 100);
        Stock s2 = new StockCommon("POP", 8 ,100);
        Stock s3 = new StockCommon("ALE", 23, 60);
        Stock s4 = new StockPreferred("GIN", 8, 2, 100);
        Stock s5 = new StockCommon("JOE", 13, 250);
        
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        stocks.add(s4);
        stocks.add(s5);
    }
    
    @Test
    public void testApp() {
        assertTrue( true );
    }
}
