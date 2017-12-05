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
public class IdenticalArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];
        System.out.println("Enter the 1st 3 x 3 array: ");
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = input.nextInt();
            }
        }
        System.out.println("Enter the 2nd 3 x 3 array: ");
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] = input.nextInt();
            }
        }
        if (equals(m1, m2) == true)
            System.out.println("These arrays are strictly identical.");
        else
            System.out.println("These arrays are not strictly identical.");
    }
    
    public static boolean equals(int[][] m1, int[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 1; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j])
                    return false;
            }
        }
        return true;
    }
}
