/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CreditCardNumberValidation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long creditCardNumber = input.nextLong();
        int sumOfEvens = sumOfDoubleEvenPlace(creditCardNumber);
        int sumOfOdds = sumOfOddPlace(creditCardNumber);
        int totalSum = sumOfEvens + sumOfOdds;
        if (isValid((long)(totalSum)) == true)
            System.out.println(creditCardNumber + " is valid.");
        else
            System.out.println(creditCardNumber + " is invalid.");
    }
    
    public static boolean isValid(long number) {
        return (number % 10 == 0);
    }
    
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        int digits = getSize(number);
        for (int i = 0; i < digits; i++) {
            if (i % 2 != 0) {
                sum += (getDigit((int)(2 * (number % 10))));
                
            }
            number /= 10;
        }
        System.out.println(sum);
        System.out.println("|");
        return sum;
    }
    
    public static int getDigit(int number) {
        
        if (number < 9) {
            System.out.println(number);
            return number;
        }
        else {
            int d1 = number % 10;
            int d2 = number / 10;
            System.out.println(d1 + d2);
            return (d1 + d2);
        }
        
    }
    
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        int digits = getSize(number);
        for (int i = 0; i < digits; i++) {
            if (i % 2 == 0) {
                sum = sum + getDigit((int)((number % 10)));
            }
            number = number / 10;
        }
        System.out.println(sum);
        return sum;
    }
    
    public static boolean prefixMatched(long number, int d) {
        while (number > 10) {
            number /= 10;
        }
        return (number == d);
    }
    
    public static int getSize(long d) {
        int digits = 0;
        while (d > 0) {
            d = d / 10;
            digits++;
        }
        return digits;
    }
    
    public static long getPrefix(long number, int k) {
        int timesToDivide = getSize(number) - k;
        while (timesToDivide > 0) {
            number = number / 10;
            timesToDivide--;
        }
        return number;
    }
}
