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
public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the index for a Fibonacci number: ");
        int n = input.nextInt();
        int f0 = 0; int f1 = 1; //Initial states for the indexes of fibonaccis fib(n - 2) and f(n - 1)
        int currentFib;
        if (n == 0)
            currentFib = 0;
        else
            currentFib = 1;
        for (int i = 1; i < n; i++) {
            currentFib = f0 + f1;
            f0 = f1;
            f1 = currentFib;
        } //After the loop, currentFib is fin(n)
        System.out.println("The fibonacci number at index " + n + " is " + currentFib);
    }
}
