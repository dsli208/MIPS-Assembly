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
public class BigIntegerPrime {
    public void primeNumbers() {
        BigInteger min = new BigInteger("Long.MAX_VALUE");
        BigInteger v = min;
        int k = 0;
        while (k < 5) {
            v = v.add(BigInteger.ONE);
            boolean isPrime = true;
            for (long i = 2; i < Long.MAX_VALUE; i++) {
                BigInteger u = new BigInteger("i");
                
            }
        }
    }
}
