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
public class MaxNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        int numberInput = input.nextInt();
        int count = 0;
        int max = 0;
        while (numberInput != 0) {
            numberInput = input.nextInt();
            if (numberInput > max) {
                max = numberInput;
                count = 1;
            }
            else if (numberInput == max)
                count++;
        }
        
        System.out.println("The largest number is " + max);
        System.out.println("It occurs " + count + " times");
    }
}
