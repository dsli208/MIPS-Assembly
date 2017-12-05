/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ComputeTaxes {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the filing status");
        System.out.println("0 - single filer, 1 - married jointly or qualifying widow, 2- married separately, 3 - head of household");
        int status = input.nextInt();
        System.out.println("Enter taxable income: ");
        int income = input.nextInt();
        double tax;
        switch (status) {
            case 0: tax = singleFiler(income); break;
            case 1: tax = jointMarriage(income); break;
            case 2: tax = marriedSeparately(income); break;
            case 3: tax = headOfHousehold(income); break;
            default: tax = 0;
        }
        System.out.println("Tax is " + tax);
    }
    
    public static double singleFiler(int income) {
        if (income <= 8350)
            return income * 0.10;
        else if (income <= 33950)
            return 8350 * 0.10 + (income - 8350) * 0.15;
        else if (income <= 82250)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
        else if (income <= 171550)
            return 8350 * 0.10 + (33590 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
        else if (income <= 372950)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +  (income - 171550) * 0.33;
        else
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372951 - 171550) * 0.33 + (income - 372951) * 0.35;
    }
    
    public static double jointMarriage(int income) {
        if (income <= 16700)
            return income * 0.10;
        else if (income <= 67900)
            return 16700 * 0.10 + (income - 16700) * 0.15;
        else if (income <= 137050)
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
        else if (income <=208850)
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (income - 137050) * 0.28;
        else if (income <= 372950)
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (income - 208850) * 0.33;
        else
            return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
    }
    
    public static double marriedSeparately(int income) {
        if (income <= 8350)
            return income * 0.10;
        else if (income <= 33950)
            return 8350 * 0.10 + (income - 8350) * 0.15;
        else if (income <= 68525)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
        else if (income <= 104425)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
        else if (income <= 186475)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (income - 104425) * 0.33;
        else
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
    }
    
    public static double headOfHousehold(int income) {
        if (income <= 11950)
            return income * 0.10;
        else if (income <= 45500)
            return 11950 * 0.10 + (income - 11950) * 0.15;
        else if (income <= 117450)
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (income - 45500) * 0.25;
        else if (income <= 190200)
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
        else if (income <= 372950)
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +  (income - 190200) * 0.33;
        else
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
    }
}
