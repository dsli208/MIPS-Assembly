/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class BigIntegerFactorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int number = input.nextInt();
        BigInteger b = new BigInteger(number + "");
        BigInteger factorial = factorial(b);
        System.out.println("The factorial of " + number + " is " + factorial);
    }
    
    public static BigInteger factorial(BigInteger b) {
        if (b.equals("0"))
            return BigInteger.ONE;
        else {
            return b.multiply(factorial(b.subtract(BigInteger.ONE)));
        }
    }
}
