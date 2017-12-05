/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class MeanStandardDeviation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");
        double inputNumber;
        double sum = 0;
        double sumSquared = 0;
        for (int i = 0; i < 10; i++) {
            inputNumber = input.nextDouble();
            sum = sum + inputNumber;
            sumSquared = sumSquared + Math.pow(inputNumber, 2);
        }
        double n = 10;
        double mean = sum / n;
        double deviation = Math.sqrt((sumSquared - ( Math.pow(sum, 2) / n)) / (n - 1));
        System.out.println("The mean is " + mean);
        System.out.println("The standard deviation is " + deviation);
    }
}
