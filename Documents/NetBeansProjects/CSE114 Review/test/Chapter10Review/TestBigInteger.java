/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.math.BigInteger;

/**
 *
 * @author dsli
 */
public class TestBigInteger {
    public static void main(String[] args) {
        largeFactorial();
    }
    
    public static void firstMethod() {
        BigInteger a = new BigInteger("9223372036854775807");
        BigInteger b = new BigInteger("2");
        BigInteger c = a.multiply(b);
        System.out.println(c);
    }
    
    public static void largeFactorial() {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= 50; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }
        System.out.println(result);
    }
}
