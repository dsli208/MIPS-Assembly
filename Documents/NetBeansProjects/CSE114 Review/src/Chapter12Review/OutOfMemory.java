/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import static Chapter18Review.BigIntegerFactorial.factorial;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class OutOfMemory {
    public static void main(String[] args) {
        try {
            BigInteger b = new BigInteger("100000000");
            BigInteger c = b;
            for (int i = 0; i < 10000; i++) {
                c = c.multiply(b);
            }
            System.out.println("Success!");
        }
        catch (OutOfMemoryError e) {
            System.out.println("Out of memory.");
        }
    }
}
