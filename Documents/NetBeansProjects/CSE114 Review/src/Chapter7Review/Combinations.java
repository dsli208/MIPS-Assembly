/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Combinations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        int[] integers = new int[10];
        for (int i = 0; i < 10; i++) {
            integers[i] = input.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(integers[i] + " " + integers[j]);
            }
            for (int j = i + 1; j < 10; j++) {
                System.out.println(integers[i] + " " + integers[j]);
            }
        }
    }
}
