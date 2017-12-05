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
public class ReverseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] inputNumbers = new double[10];
        for (int n = 0; n < 10; n++) {
            inputNumbers[n] = input.nextDouble();
        }
        double[] reverse = reverse(inputNumbers);
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i] + " ");
        }
    }
    public static double[] reverse(double[] n) {
        double[] reverse = new double[n.length];
        for (int i = 0, j = n.length - 1; i < n.length; i++, j--) {
            reverse[j] = n[i];
        }
        return reverse;
    }
}
