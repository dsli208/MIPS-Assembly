/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.math.BigInteger;

/**
 *
 * @author dsli
 */
public class TestRational {
    public static void main(String[] args) {
        BigIntegerRational min = new BigIntegerRational("0", "1");
        BigIntegerRational sum = min;
        for (int i = 1; i < 100; i++) {
            int j = i + 1;
            String n = i + "";
            String d = j + "";
            BigIntegerRational b = new BigIntegerRational(n, d);
            sum = sum.add(b);
        }
        System.out.println(sum.toString());
    }
}
