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
public class RowSorting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[3][3];
        System.out.println("Enter a 3 x 3 matrix row by row: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextDouble();
            }
        }
        matrix = sortRows(matrix);
        System.out.println("The row sorted array is: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static double[][] sortRows(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            boolean sorted = false;
            while (sorted == false) {
                boolean inOrder = true;
                for (int j = 1; j < m[i].length; j++) {
                    if (m[i][j] < m[i][j - 1]) {
                        inOrder = false;
                        double temp = m[i][j];
                        m[i][j] = m[i][j - 1];
                        m[i][j - 1] = temp;
                    }
                    if (inOrder == true)
                        sorted = true;
                }
            }
        }
        return m;
    }
}
