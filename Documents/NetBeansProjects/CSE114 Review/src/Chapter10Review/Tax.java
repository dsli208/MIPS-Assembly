/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

/**
 *
 * @author dsli
 */
public class Tax {
    private int filingStatus;
    private int[][] brackets = {{27050, 65550, 136750, 297350}, {45200, 109250, 166500, 297350},
            {22600, 54625, 83250, 148675}, {36250, 93650, 151650, 297350}};
    private double[] rates = {0.15, 0.275, 0.305, 0.355, 0.391};
    private double taxableIncome = 50000;
    public void setBrackets(int[][] i) {
        brackets = i;
    }
    public void setTaxableIncome(double i) {
        taxableIncome = i;
    }
    public void setRates(double[] i) {
        rates = i;
    }
    public void setFilingStatus(int i) {
        filingStatus = i;
    }
    public double getTaxableIncome() {
        return taxableIncome;
    }
    public int[][] getBrackets() {
        return brackets;
    }
    public double[] getRates() {
        return rates;
    }
    public int getFilingStatus() {
        return filingStatus;
    }
    //get tax
    public double getTax() {
        double rem = taxableIncome;
        double tax = 0;
        double maxValue = 0;
        int i = 0;
        while (maxValue == 0) {
            if (taxableIncome > brackets[filingStatus][i])
                maxValue = brackets[filingStatus][i];
            i++;
        }
        for (int j = i; j >=  -1; j--) {
            if (j >= 0) {
                tax += (rem - brackets[filingStatus][j]) * rates[j + 1];
                rem = brackets[filingStatus][j];

            }
            else
                tax += rem * rates[j + 1];
        }
        return tax;
    }
    public Tax() {}
    public Tax(int fileStat, int[][] newBrackets, double[] newRates, double taxInc) {
        filingStatus = fileStat;
        brackets = newBrackets;
        rates = newRates;
        taxableIncome = taxInc;
    }
}
class testTax {
    public static void main(String[] args) {
        Tax t2001 = new Tax();
        System.out.println("------------------Federal Tax Rates, 2001--------------------");
        int[][] brackets2001 = {{27050, 65550, 136750, 297350}, {45200, 109250, 166500, 297350},
            {22600, 54625, 83250, 148675}, {36250, 93650, 151650, 297350}};
        t2001.setBrackets(brackets2001);
        for (int i = 0; i < 10; i++) {
            t2001.setTaxableIncome(t2001.getTaxableIncome() + 1000);
            for (int j = 0; j < 4; j++) {
                t2001.setFilingStatus(j);
                System.out.printf("%-10.2f\t", t2001.getTax());
            }
            System.out.println();
        }
        int[][] brackets2009 = {{8350, 33950, 82250, 171550, 372950}, {16700, 67900, 137050, 208851, 372950},
            {8350, 33950, 68525, 104425, 186475}, {11950, 45500, 117450, 190200, 372950}};
        double[] rates2009 = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        System.out.println("------------------Federal Tax Rates, 2009--------------------");
        Tax t2009 = new Tax(0, brackets2009, rates2009, 50000);
        for (int i = 0; i < 10; i++) {
            t2009.setTaxableIncome(t2009.getTaxableIncome() + 1000);
            for (int j = 0; j < 4; j++) {
                t2009.setFilingStatus(j);
                System.out.printf("%-10.2f\t", t2009.getTax());
            }
            System.out.println();
        }
    }
}