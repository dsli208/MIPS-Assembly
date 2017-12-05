/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author dsli
 */
public class ApproximateE {
    public static void main(String[] args) {
        approximate(100);
    }
    public static void approximate(double l) {
        BigDecimal e = new BigDecimal("0");/
        BigDecimal a = BigDecimal.ONE;
        for (int i = 1; i < l; i++) {
            BigDecimal b = BigDecimal.ONE;
            for (int j = 1; j <= i; j++) {
                b = b.multiply(new BigDecimal(i + ""));
            }
            BigDecimal d = a.divide(b, 25, BigDecimal.ROUND_UP);
            e = d.add(b);
        }
        
        System.out.println(e);
    }
}
