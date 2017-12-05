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
public class multiplyMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix1: ");
        double[][] matrix1 = new double[3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = input.nextDouble();
            }
        }
        System.out.print("Enter matrix2: ");
        double[][] matrix2 = new double[3][3];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = input.nextDouble();
            }
        }
        double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.printf("%.1f\t", resultMatrix[i][j]);
            }
            System.out.println();
        }
    }
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a[0].length][b.length];
        for (int i = 0; i < a.length; i++) { //for each row in the matrix
            for (int j = 0; j < b[0].length; j++) { //for each column in matrix a & c
                for (int k = 0; k < b.length; k++) { // for each row to be multiplied with the last step
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }
}
