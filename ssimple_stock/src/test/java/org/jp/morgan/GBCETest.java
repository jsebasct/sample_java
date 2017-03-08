/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jp.morgan;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jscruz
 */
public class GBCETest {

    private GBCE gbce;

    @Before
    public void init() {
        gbce = new GBCE();
    }

    @Test
    public void testApp() {
        gbce.addStockTrades();
        double res = gbce.calculateGeometricMean();
        assertEquals(9.3333, res, 0.001);
    }

}
