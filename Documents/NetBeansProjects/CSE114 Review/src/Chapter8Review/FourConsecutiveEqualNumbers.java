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
public class FourConsecutiveEqualNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int rows = input.nextInt();
        int columns = input.nextInt();
        int[][] array = new int[rows][columns];
        System.out.println("Enter the matrix below: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextInt();
            }
        }
        for (int i = 0; i < array.length; i++) {
            //boolean fourInARow = false;
            int consecutive = 1;
            for (int j = 0; j < array[i].length - 1; j++) {
                if (array[i][j] == array[i][j + 1]) {
                    consecutive++;
                    if (consecutive == 4) {
                        System.out.println("There are four " + array[i][j] + "'s in a row.");
                        consecutive = 1;
                    }
                }
            }
        }
        for (int i = 0; i < columns; i++) {
            //boolean fourInAColumn = false;
            int consecutive = 1;
            for (int j = 0; j < rows - 1; j++) {
                if (array[j][i] == array[j + 1][i]) {
                    consecutive++;
                    if (consecutive == 4) {
                        System.out.println("There are four " + array[j][i] + "'s in a column.");
                        consecutive = 1;
                    }
                }
            }
        }
        //get diagonals for Lower half of the array
        for (int i = 1; i < array.length - 2; i++) {
            int consecutive = 1;
            for (int k = i, j = 1; k < array.length - 1; k++, j++) {
                if (array[k][j] == array[k - 1][j - 1]) {
                    consecutive++;
                    if (consecutive == 4) {
                        System.out.println("There are four " + array[k][j] + "'s in a diagonal");
                        consecutive = 1;
                    }
                }
            }
        }
        //get diagonals for Upper half of array
        for (int i = 1; i < array[0].length - 2; i++) {
            int consecutive = 1;
            for (int k = 1, j = i; j < array[0].length - 1; k++, j++) {
                if (array[k][j] == array[k - 1][j - 1]) {
                    consecutive++;
                    if (consecutive == 4) {
                        System.out.println("There are four " + array[k][j] + "'s in a diagonal");
                        consecutive = 1;
                    }
                }
            }
        }
        //Get subdiagonals for upper half
        for (int i = array.length - 1; i > 0; i--) {
            int consecutive = 1;
            for (int k = i, j = 0; k > 0; k--, j++) {
                if (array[k][j] == array[k - 1][j + 1]) {
                    consecutive++;
                    if (consecutive == 4) {
                        System.out.println("There are four " + array[k][j] + "'s in a diagonal");
                        consecutive = 1;
                    }
                }
            }
        }
        //get subdiagonals for lower half
        for (int i = 0; i < array[0].length - 2; i++) {
            int consecutive = 1;
            for (int k = array.length - 1, j = i; j < array[i].length - 2; k--, j++) {
                if (array[k][j] == array[k - 1][j + 1]) {
                    consecutive++;
                    if (consecutive == 4) {
                        System.out.println("There are four " + array[k][j] + "'s in a diagonal.");
                        consecutive = 1;
                    }
                }
            }
        }
        /*for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }*/
    }
}
