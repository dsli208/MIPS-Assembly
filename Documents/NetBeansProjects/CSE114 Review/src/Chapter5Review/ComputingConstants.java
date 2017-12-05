/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

/**
 *
 * @author dsli
 */
public class ComputingConstants {
    public static void main(String[] args) {
        computePi(0.0);
        computeEulers(0.0);
    }
    
    public static void computePi(double i) {
        for (double j = 1.0; j <= 10.0; j++) {
            double sum = 0;
            for (double k = i; k < j * 10000.0; k++) {
                sum = sum + (Math.pow(-1, k + 1) / ((2 * k) - 1));
            }
            System.out.println("The value of PI for " + (j * 10000.0) + " is " + (sum * 4));
        }
    }
    
    public static void computeEulers(double i) {
        for (double j = 1.0; j <= 10.0; j++) {
            double sum = 0;
            for (double k = i; k < 10000 * j; k++) {
                double factorial = 1;
                for (double l = k; l > 1; l--) {
                    factorial = factorial * l;
                }
                sum += 1/factorial;
            }
            System.out.println("The value of e for " + (j * 10000.0) + " is " + sum);
        }
    }
}
