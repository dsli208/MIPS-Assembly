/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class MarkovMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3 x 3 matrix row by row: ");
        double[][] matrix = new double[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        int perfectSums = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            double columnSum = 0;
            for (int j = 0; j < matrix.length; j++) {
                columnSum += matrix[j][i];
            }
            if (columnSum == 1)
                perfectSums++;
        }
        if (perfectSums == matrix.length)
            System.out.println("This is a Markov matrix");
        else
            System.out.println("This is not a Markov matrix.");
    }
}
