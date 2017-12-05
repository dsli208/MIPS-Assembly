/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SmallestPrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        int copyOfNumber = number;
        for (int i = 2; i <= copyOfNumber; i++) {
            if (copyOfNumber % i == 0) {
                System.out.print(i + " ");
                copyOfNumber /= i;
                i--; //this take the number back one, so it was what it was at the start of this iteration at the start of next iteration
            }
        }
    }
}
