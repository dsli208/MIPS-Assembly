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
public class ComputeFibonacci {
    public static int runCount = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a fibonacci number: ");
        int n = input.nextInt();
        System.out.println("The fibonacci number at index " + n + " is " +  fib(n));
        System.out.println("The method runs " + runCount + " times");
    }
    public static int fib(int n) {
        runCount++;
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }
}
