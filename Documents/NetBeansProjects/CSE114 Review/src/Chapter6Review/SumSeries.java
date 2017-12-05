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
public class SumSeries {
    public static void main(String[] args) {
        double max = 901;
        double min = 1;
        computePi(min, max);
    }
    
    public static void computePi(double min, double max) {
        double sum = 0;
        System.out.printf("%-5s\t\t%-5s\n", "i", "m(i)");
        for (double i = min; i <= max; i++) {
            sum += ((Math.pow(-1, i + 1)) / (2 * i - 1));
            if ((max - i) % 100 == 0)
                System.out.printf("%-5.1f\t\t%-5.4f\n", i,  sum * 4);
        }
    }
}
