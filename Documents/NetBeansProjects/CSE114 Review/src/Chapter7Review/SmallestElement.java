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
public class SmallestElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] array = new double[10];
        int i = 0;
        while (i < 10){
            array[i] = input.nextDouble();
            i++;
        }
        double minimum = min(array);
        System.out.println("The minimum element in this array is " + minimum);
    }
    
    public static double min(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        return min;
    }
}
