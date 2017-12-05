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
public class BubbleSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] testArray = new double[10];
        System.out.print("Enter ten numbers: ");
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = input.nextDouble();
        }
        double[] sortedArray = sort(testArray);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }
    public static double[] sort(double[] a) {
        boolean solved = false;
        while (solved == false) {
            boolean correctOrder = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] < a[i + 1]) {
                    correctOrder = false;
                    double temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                } 
            }
            if (correctOrder == true)
                solved = true;
        }
        return a;
    }
}
