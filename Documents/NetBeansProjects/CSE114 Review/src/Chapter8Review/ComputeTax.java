/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ComputeTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets = {{8350, 33950, 82250, 171550, 372950}, {16700, 67900, 137050, 208851, 372950},
            {8350, 33950, 68525, 104425, 186475}, {11950, 45500, 117450, 190200, 372950}};
        System.out.println("0 - single filer, 1 - married filing jointly, 2 - married filing separately, 3 - head of household");
        System.out.print("Enter the number for tax filing status: ");
        int i = input.nextInt();
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();
        double rem = income;
        int ratesIndex = 0;
        int bracketsIndex = -1;
        double tax = 0;
        for (int j = 0; j < brackets[i].length; j++) {
            if (income > brackets[i][j]) {
                bracketsIndex++;
                ratesIndex++;
            }
        }
        for (int j = bracketsIndex; j >= -1; j--) {
            if (j == -1)
                tax += rem * rates[j + 1];
            else {
                tax += (rem - brackets[i][j]) * rates[j + 1];
                rem = brackets[i][j];
            }
        }
        System.out.println("The tax is " + tax);
    }
}
