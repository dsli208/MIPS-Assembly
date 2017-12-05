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
public class SumElementsColumnByColumn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[3][4];
        System.out.println("Enter a 3 - by - 4 matrix row by row:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println("The sum of the elements at column " + i + " is " + sumColumn(matrix, i));
        }
    }
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        //3 rows in this matrix
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }
}
