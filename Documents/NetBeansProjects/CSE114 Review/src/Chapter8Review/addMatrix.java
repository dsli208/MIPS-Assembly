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
public class addMatrix {
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
            for (int j = 0; j < matrix2[i].length; j++){
                matrix2[i][j] = input.nextDouble();
            }
        }
        double[][] combinedMatrix = addMatrix(matrix1, matrix2);
        for (int i = 0; i < combinedMatrix.length; i++) {
            for (int j = 0; j < combinedMatrix[i].length; j++) {
                System.out.print(combinedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a[0].length][b.length];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
}
