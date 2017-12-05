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
public class CompoundValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the principle amount of money: ");
        double principle = input.nextDouble();
        System.out.print("Enter the annial interest rate: ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Enter the number of months: ");
        int months = input.nextInt();
        double value = 0;
        
        for (int i = 1; i <= months; i++) {
            value = (principle + value) * (1 + (annualInterestRate / 1200));
        }
        System.out.println("AFter " + months + " months, the value in the account is $" + value);
    }
}
