/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Payroll {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter employee's name: ");
        String name = input.nextLine();
        System.out.println("Enter hours worked: ");
        double hours = input.nextDouble();
        System.out.println("Enter hourly pay rate: ");
        double pay = input.nextDouble();
        System.out.println("Enter federal tax withholding rate");
        double federalTax = input.nextDouble();
        System.out.println("Enter state tax withholding rate");
        double stateTax = input.nextDouble();
        System.out.println();
        System.out.println("Employee name: " + name);
        System.out.println("Hours worked: " + hours);
        System.out.printf("%-10s%-10.2f", "Pay Rate: $", pay);
        System.out.println();
        System.out.printf("%-10s%-10.2f", "Gross Pay: $", (pay * hours));
        System.out.println();
        System.out.println("Deductions: ");
        System.out.printf("%-10s%-10.2f", "Federal Withholding: ", federalTax);
        System.out.println();
        System.out.printf("%-10s%-10.2f", "State Withholding: $", stateTax);
        System.out.println();
        System.out.printf("%-10s%-10.2f",  "Total Deduction: $", (federalTax + stateTax));
        System.out.println();
        System.out.println("Net Pay: $" + ((pay * hours) - (federalTax + stateTax)));
    }
}
