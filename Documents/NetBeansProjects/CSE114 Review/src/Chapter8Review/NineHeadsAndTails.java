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
public class NineHeadsAndTails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511: ");
        int number = input.nextInt();
        int rem = number;
        int[][] zeroesAndOnes = new int[3][3];
        for (int i = zeroesAndOnes.length - 1; i >= 0; i--) {
            for (int j = zeroesAndOnes[i].length - 1; j >= 0; j--) {
                zeroesAndOnes[i][j] = (rem % 2);
                rem = (rem / 2);
            }
        }
        
        char[][] headsAndTails = new char[3][3];
        for (int i = 0; i < zeroesAndOnes.length; i++) {
            for (int j = 0; j < zeroesAndOnes[i].length; j++) {
                if (zeroesAndOnes[i][j] == 1)
                    headsAndTails[i][j] = 'T';
                else
                    headsAndTails[i][j] = 'H';
            }
        }
        for (int i = 0; i < headsAndTails.length; i++) {
            for (int j = 0; j < headsAndTails[i].length; j++) {
                System.out.print(headsAndTails[i][j]);
            }
            System.out.println();
        }
    }
}
