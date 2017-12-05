/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Deviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] inputNumbers = new double[10];
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = input.nextDouble();
        }
        
        System.out.println("The mean is " + mean(inputNumbers));
        System.out.println("The standard deviation is " + deviation(inputNumbers));
    }
    
    public static double deviation(double[] x) {
        double mean = mean(x);
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i] - mean, 2);
        }
        return Math.sqrt(sum / 9);
    }
    
    public static double mean(double[] x) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return (sum / 10);
    }
}
