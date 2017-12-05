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
public class Divisible {
    public void divisibleBy2Or3() {
        BigInteger min = new BigInteger("9223372036854775808");
        BigInteger a = min;
        int j = 0;
        BigInteger ONE = BigInteger.ONE;
        BigInteger TWO = ONE.add(ONE);
        BigInteger THREE = TWO.add(ONE);
        while (j < 10) {
            a = a.add(ONE);
            BigInteger b = a.divide(TWO); BigInteger c = a.divide(THREE);
            if (b.multiply(TWO).equals(a) || c.multiply(THREE).equals(a)) {
                System.out.print(a + " ");
                j++;
            }
        }
    }
    public void divisibleBy5Or6() {
        BigInteger min = new BigInteger("9223372036854775807");
        int j = 0;
        BigInteger a = min;
        BigInteger ONE = BigInteger.ONE;
        BigInteger FIVE = new BigInteger("5");
        BigInteger SIX = new BigInteger("6");
        while (j < 10) {
            a = a.add(ONE);
            BigInteger b = a.divide(FIVE); BigInteger c = a.divide(SIX);
            if (b.multiply(FIVE).equals(a) || c.multiply(SIX).equals(a)) {
                System.out.print(a + " ");
                j++;
            }
        }
    }
}
class testDivisible {
    public static void main(String[] args) {
        Divisible d = new Divisible();
        d.divisibleBy2Or3();
        System.out.println();
        d.divisibleBy5Or6();
    }
}