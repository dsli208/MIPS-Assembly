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
public class LatinSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number n: ");
        int n = input.nextInt();
        char minChar = (char)(65);
        char maxChar = (char)(64 + n);
        char[][] matrix = new char[n][n];
        System.out.println("Enter " + n + " rows of " + n + " letters separated by spaces.");
        String placeholder = input.nextLine();
        for (int i = 0; i < matrix.length; i++) {
            String chars = input.nextLine();
            int k = 0;
            for (int j = 0; j < chars.length(); j++) {
                if (j % 2 == 0) {
                    matrix[i][k] = chars.charAt(j);
                    k++;
                }
            }
        }
        boolean isValid = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minChar || matrix[i][j] > maxChar)
                    isValid = false;
            }
        }
        boolean isLatinSquare = true;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                for (int k = j + 1; k < matrix[i].length; k++) {
                    if (matrix[i][j] == matrix[i][k])
                        isLatinSquare = false;
                }
             }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length - 1; j++) {
                for (int k = j + 1; k < matrix.length; k++) {
                    if (matrix[j][i] == matrix[k][i])
                        isLatinSquare = false;
                }
             }
        }
        if (isLatinSquare == true)
            System.out.println("The input array is a Latin square.");
        else if (isValid == true && isLatinSquare == false)
            System.out.println("The input array is not a valid Latin square.");
        else
            System.out.println("Invalid input.  You must input letters from " + minChar + " to " + maxChar);
    }
}
