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
public class ExploreMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the matrix: ");
        int matrixSize = input.nextInt();
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 2);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        boolean hasRows = false;
        for (int i = 0; i < matrix.length; i++) {
            boolean isRow = true;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[i][j - 1])
                    isRow = false;
            }
            if (isRow == true) {
                System.out.println("All " + matrix[i][0] + "'s on row " + i);
                hasRows = true;
            }
        }
        if (hasRows == false)
            System.out.println("No same numbers in a row.");
        boolean hasColumns = false;
        for (int i = 0; i < matrix.length; i++) {
            boolean isColumn = true;
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[j][i] != matrix[j- 1][i])
                    isColumn = false;
            }
            if (isColumn == true) {
                System.out.println("All " + matrix[0][i] + "'s on column " + i);
                hasColumns = true;
            }
        }
        if (hasColumns == false)
            System.out.println("No same numbers in a column.");
        boolean isMajorDiagonal = true;
        for (int i = 1, j = 1; i < matrix.length; i++, j++) {
            if (matrix[i][j] != matrix[i - 1][j - 1])
                isMajorDiagonal = false;
        }
        if (isMajorDiagonal == true)
            System.out.println("All " + matrix[0][0] + "'s on the major diagonal.");
        else
            System.out.println("No same numbers on the major diagonal.");
        boolean isSubDiagonal = true;
        for (int i = matrix.length - 1, j = 0; i > 0; i--, j++) {
            if (matrix[i][j] != matrix[i - 1][j + 1])
                isSubDiagonal = false;
        }
        if (isSubDiagonal == true)
            System.out.println("All " + matrix[matrix.length][0] + "'s on the sub-diagonal.");
        else
            System.out.println("No same numbers on the sub-diagonal.");
    }
}
