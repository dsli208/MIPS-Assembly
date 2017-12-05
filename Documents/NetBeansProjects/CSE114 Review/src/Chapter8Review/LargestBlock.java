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
public class LargestBlock {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the matrix (only one input, this is a square matrix): ");
        int dimensions = input.nextInt();
        int[][] matrix = new int[dimensions][dimensions];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int n = input.nextInt();
                if (n == 0 || n == 1)
                    matrix[i][j] = n;
                else
                    System.out.print("Input only 0 or 1");
            }
        }
        int[] largestBlock = findLargestBlock(matrix);
        System.out.println("The maximum square submatrix is at (" + largestBlock[0] + ", " + largestBlock[1] + ") and the maximum size is " + largestBlock[2]);
    }
    public static int[] findLargestBlock(int[][] m) {
        int[] solution = new int[3];
        int maxX = 0;
        int maxY = 0;
        int maxSize = 0;
        //Break the large square matrix into separate square submatrices
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                //"origin" for each iteration is (i, j)
                if (m[i][j] == 1)
                    if (isSquare(m, i, j) == true) {
                        if (getSize(m, i, j) > maxSize) {
                            //adjust dimensions of maximum square
                            maxX = i; maxY = j; maxSize = getSize(m, i, j);
                        }
                    }
            }
        }
        solution[0] = maxX; solution[1] = maxY; solution[2] = maxSize;
        return solution;
    }
    public static boolean isSquare(int[][] m, int i, int j) {
        int k = m.length - i;
        if (m[0].length - j < k)
            k = m.length - j;
        if (k < 2)
            return false;
        int[][] testSquare = new int[k][k];
        for (int y = 0; y < k; y++) {
            for (int x = 0; x < k; x++) {
                testSquare[y][x] = m[y + i][x + j];
            }
        }
        int maxOnesInRow = 0;
        for (int y = 0; y < testSquare.length; y++) {
            int onesInRow = 0;
            for (int x = 1; x < testSquare[y].length; x++) {
                if (testSquare[y][x] != testSquare[y][x - 1]) {
                    maxOnesInRow = onesInRow;
                    break;
                }
                else if (testSquare[y][x] == testSquare[y][x - 1])
                    onesInRow++;
            }
        }
        int maxOnesInColumn = 0;
        for (int x = 0; x < testSquare[0].length; x++) {
            int onesInColumn = 0;
            for (int y = 1; y < testSquare.length; y++) {
                if (testSquare[y][x] != testSquare[y - 1][x]) {
                    maxOnesInColumn = onesInColumn;
                    break;
                }
                else if (testSquare[y][x] == testSquare[y - 1][x])
                    onesInColumn++;
            }
        }
        if (maxOnesInColumn == maxOnesInRow)
            return false;
        return true;
    }
    
    public static int getSize(int[][] m, int i, int j) {
        int k = m.length - i;
        if (m[0].length - j < k)
            k = m.length - j;
        return k;
    }
}
