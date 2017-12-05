/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

/**
 *
 * @author dsli
 */
public class SumSeries {
    public static void main(String[] args) {
        double i = 10;
        double sum = sumSeries(i);
        System.out.println("The sum of the series 1 / n ending at n = " + i + " is " + sum);
        System.out.println("The sum of the series n / (n + 1) ending at n = " + i + " is " + sumSeries2(i));
        System.out.println("The sum of the series n / (2n + 1) ending at n = " + i + " is " + sumSeries3(i));
    }
    
    //For the series 1 / n
    public static double sumSeries(double i) {
        if (i == 1)
            return i;
        else
            return (1 / i) + sumSeries(i - 1);
    }
    
    //For the series n / (n + 1)
    public static double sumSeries2(double i) {
        if (i == 1)
            return (1/2);
        else
            return (i / (i + 1))+ sumSeries2(i - 1);
    }
    
    //For the series n / (2n + 1)
    public static double sumSeries3(double i) {
        if (i == 1)
            return (1/3);
        else
            return (i / (2 * i + 1)) + sumSeries3(i - 1);
    }
}
