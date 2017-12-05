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
public class LoanAmortization {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double loanAmount = input.nextDouble();
        double balance = loanAmount;
        double years = input.nextDouble();
        double annualInterestRate = input.nextDouble();
        double monthlyPayment = loanAmount * (annualInterestRate / 1200) / (1 - (1 / (Math.pow(1 + (annualInterestRate / 1200), years * 12))));
        double totalPayment = monthlyPayment * years * 12;
        double interest = 0;
        double principal = 0;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "Payment#    ", "Interest    ", "Principal    ", "Balance    ");
        for (int paymentNumber = 1; paymentNumber < 13; paymentNumber++) {
            interest = (annualInterestRate / 1200) * balance;
            principal = monthlyPayment - interest;
            balance = balance - principal;
            System.out.printf("%-15d%-15.2f%-15.2f%-15.2f\n", paymentNumber, interest, principal, balance);
        }
    }
}
