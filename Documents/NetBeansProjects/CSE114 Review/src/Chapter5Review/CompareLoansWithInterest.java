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
public class CompareLoansWithInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter loan amount: ");
        double loanAmount = input.nextDouble();
        System.out.print("Enter number of years: ");
        int years = input.nextInt();
        System.out.printf("%-20s%-20s%-20s", "Interest Rate    ", "Monthly Payment    ", "Total Payment    \n");
        System.out.println();
        double interestRate = 5.00;
        double monthlyPayment = 0;
        double totalPayment = 0;
        for (interestRate = 5; interestRate <= 8; interestRate += 0.125) {
            monthlyPayment = loanAmount * (interestRate / 1200) / (1 - (1 / Math.pow(1 + (interestRate / 1200), years * 12)));
            totalPayment = monthlyPayment * years * 12;
            System.out.printf("%-20.3f%-20.2f%-20.2f", interestRate, monthlyPayment, totalPayment);
            System.out.println();
        }
    }
}
