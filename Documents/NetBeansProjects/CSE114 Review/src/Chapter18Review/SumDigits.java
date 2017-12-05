/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SumDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long n = input.nextLong();
        int sum = sumDigits(n);
        System.out.println("The sum of the digits is " + sum);
    }
    public static int sumDigits(long n) {
        int sum = 0;
        if (n == 0)
            return sum;
        else {
            sum += (int)(n % 10);
            return sum  + sumDigits(n / 10);
        }
    }
}
