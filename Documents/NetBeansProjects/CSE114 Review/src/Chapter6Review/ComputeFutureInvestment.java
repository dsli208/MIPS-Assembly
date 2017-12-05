/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ComputeFutureInvestment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount invested: ");
        double amountInvested = input.nextDouble();
        System.out.print("Enter the annual interest rate: ");
        double annualInterestRate = input.nextDouble();
        int years = 30;
        futureInvestmentValue(amountInvested, annualInterestRate / 1200, years);
    }
    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        double value = investmentAmount;
        for (int i = 1; i <= years; i++) {
            for (int j = 0; j < 12; j++) {
                value = value * (1 + monthlyInterestRate);
            }
            System.out.printf("%-10d%-10.2f\n", i, value);
        }
        return value;
    }
}
