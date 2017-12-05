/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

/**
 *
 * @author dsli
 */
public class ComputeTax {
    public static void main(String[] args) {
        System.out.printf("%-15s\t\t%-15s\t\t%-15s\t\t%-15s\t\t%-15s\n", "Taxable Income", "Single", "Married Joint", "Married Separately", "Head of House");
        for (double i = 50000; i <= 60000; i += 50) {
            System.out.printf("%-15.0f\t%-15.0f\t%-15.0f\t%-15.0f\t%-15.0f\n", i, computeTax(0, i), computeTax(1, i), computeTax(2, i), computeTax(3, i));
        }
    }
    public static double computeTax(int status, double taxableIncome) {
        //0 - single, 1 - married jointly, 2 - married separately, 3 - head of household
        if (status == 0) {
            if (taxableIncome <= 8350)
            return taxableIncome * 0.10;
        else if (taxableIncome <= 33950)
            return 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
        else if (taxableIncome <= 82250)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxableIncome - 33950) * 0.25;
        else if (taxableIncome <= 171550)
            return 8350 * 0.10 + (33590 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (taxableIncome - 82250) * 0.28;
        else if (taxableIncome <= 372950)
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +  (taxableIncome - 171550) * 0.33;
        else
            return 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372951 - 171550) * 0.33 + (taxableIncome - 372951) * 0.35;
        }
        else if (status == 1) {
            if (taxableIncome <= 16700)
                return taxableIncome * 0.10;
            else if (taxableIncome <= 67900)
                return 16700 * 0.10 + (taxableIncome - 16700) * 0.15;
            else if (taxableIncome <= 137050)
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (taxableIncome - 67900) * 0.25;
            else if (taxableIncome <=208850)
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (taxableIncome - 137050) * 0.28;
            else if (taxableIncome <= 372950)
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (taxableIncome - 208850) * 0.33;
            else
                return 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (taxableIncome - 372950) * 0.35;
        }
        else if (status == 2) {
            if (taxableIncome <= 8350)
                return taxableIncome * 0.10;
            else if (taxableIncome <= 33950)
                return 8350 * 0.10 + (taxableIncome - 8350) * 0.15;
            else if (taxableIncome <= 68525)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (taxableIncome - 33950) * 0.25;
            else if (taxableIncome <= 104425)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (taxableIncome - 68525) * 0.28;
            else if (taxableIncome <= 186475)
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (taxableIncome - 104425) * 0.33;
            else
                return 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (taxableIncome - 186475) * 0.35;
        }
        else {
            if (taxableIncome <= 11950)
            return taxableIncome * 0.10;
        else if (taxableIncome <= 45500)
            return 11950 * 0.10 + (taxableIncome - 11950) * 0.15;
        else if (taxableIncome <= 117450)
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (taxableIncome - 45500) * 0.25;
        else if (taxableIncome <= 190200)
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (taxableIncome - 117450) * 0.28;
        else if (taxableIncome <= 372950)
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 +  (taxableIncome - 190200) * 0.33;
        else
            return 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (taxableIncome - 372950) * 0.35;
        }
    }
}
