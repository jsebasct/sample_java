package org.jp.morgan;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * TODO public fields
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        Stock st = new StockCommon(10);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        
        Instant instant = timestamp.toInstant();
        System.out.println(instant);
        
        float max = Float.MAX_VALUE + Float.MAX_VALUE;
        System.out.println(max);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        
        double res = Math.pow(70824.54760943209, 0.25);
        
        
        List<Integer> st = null; //new ArrayList<Integer>();
        for (Integer x : st) {
            
        }
        System.out.println("-->" + res);
    }
}
