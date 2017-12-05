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
public class CDValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter initial deposit: ");
        double value = input.nextDouble();
        System.out.println("Enter percentage yield: ");
        double percentYield = input.nextDouble();
        System.out.println("Enter number of months: ");
        int months = input.nextInt();
        for (int i = 0; i < months; i++) {
            value = value + (value * percentYield / 1200);
        }
        
        System.out.println("The value after " + months + " months is $" + value);
    }
}
