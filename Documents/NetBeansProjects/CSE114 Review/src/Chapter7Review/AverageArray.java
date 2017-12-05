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
public class AverageArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] inputNumbers = new double[10];
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = input.nextDouble();
        }
        System.out.println("The average of the elements in this array is " + average(inputNumbers));
    }
    
    public static int average(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum / array.length);
    }
    
    public static double average(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum / array.length);
    }
}
