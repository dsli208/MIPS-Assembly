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
public class ComputeCommissions {
    public static void main(String[] args ) {
        double salesAmount = 10000;
        computeCommissions(salesAmount);
    }
    
    public static void computeCommissions(double salesAmount) {
        double commission = 0;
        System.out.printf("%-5s\t\t%-5s\n", "Sales Amount", "Commission");
        for (double i = salesAmount; i <= 100000; i+= 5000) {
            if (i <= 5000)
                commission = 0.08 * salesAmount;
            else if (i <= 10000)
                commission = 0.08 * 5000 + (i - 5000) * 0.10;
            else
                commission = 0.08 * 5000 + (10000 - 5000) * 0.10 + (i - 10000) * 0.12;
            System.out.printf("%-5.2f\t\t%-5.2f\n", i, commission);
        }
    }
}
