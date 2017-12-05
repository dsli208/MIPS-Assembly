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
public class SumMajorDiagonalInAMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[4][4];
        System.out.println("Enter a 4 - by - 4 matrix row by row: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        System.out.println("The sum of the elements in the major diagonal is " + sumMajorDiagonal(matrix));
    }
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0, j = 0; i < m.length; i++, j++) {
            sum += m[i][j];
        }
        return sum;
    }
}
