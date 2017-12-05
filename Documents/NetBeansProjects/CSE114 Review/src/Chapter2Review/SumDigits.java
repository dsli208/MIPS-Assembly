/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SumDigits {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000");
        int inputNumber = input.nextInt();
        int num = inputNumber % 10;
        
        int sum = 0;
        sum = sum + num;
        System.out.println("The sum is: " + sum);
    }
    
}
