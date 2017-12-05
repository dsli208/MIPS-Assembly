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
public class MersennePrime {
    public void mersennePrime() {
        for (int p = 0; p <= 100; p++) {
            BigInteger a = BigInteger.ONE;
            BigInteger b = new BigInteger("2");
            BigInteger c = BigInteger.ONE;
            BigInteger d = BigInteger.ONE;
            for (int j = p; j > 0; j--) {
                c = c.multiply(b);
                d = c.subtract(a);
            }
            System.out.printf("%-20d%-20d\n", p, d);
        }
        System.out.println();
    }
}
class testPrime1 {
    public static void main(String[] args) {
        MersennePrime m = new MersennePrime();
        m.mersennePrime();
    }
}