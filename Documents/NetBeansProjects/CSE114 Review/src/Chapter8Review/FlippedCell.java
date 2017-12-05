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
public class FlippedCell {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[6][6];
        System.out.println("Enter a 6 x 6 matrix row by row: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean accepted = false;
                while (accepted == false) {
                    int nextNumber = input.nextInt();
                    if (nextNumber == 0 || nextNumber == 1) {
                        matrix[i][j] = nextNumber;
                        accepted = true;
                        
                    }
                    else
                        System.out.println("Invalid input.  Enter 0 or 1");
                    }
                }
            }
        int r = 0;
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            int numberOfOnes = 0;
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 1)
                    numberOfOnes++;
            }
            if (numberOfOnes % 2 != 0)
                r = i;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int numberOfOnes = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {
                if (matrix[j][i] == 1)
                    numberOfOnes++;
            }
            if (numberOfOnes % 2 != 0)
                c = i;
        }
        System.out.println("The flipped cell is (" + r + ", " + c + ")");
    }
}
