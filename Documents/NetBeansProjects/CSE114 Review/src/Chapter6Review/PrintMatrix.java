/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class PrintMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n ");
        int n = input.nextInt();
        printMatrix(n);
    }
    
    public static void printMatrix(int n) {
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print((int)(Math.random() * 2));
            }
            System.out.println();
        }
    }
}
