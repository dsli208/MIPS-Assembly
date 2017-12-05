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
public class BeanMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        int ballsToDrop = input.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        int numberOfSlots = input.nextInt();
        int[] slots = new int[numberOfSlots];
        for (int i = 0; i < ballsToDrop; i++) {
            char[] leftRight = new char[numberOfSlots - 1];
            for (int j = 0; j < numberOfSlots - 1; j++) {
                int lr = (int)(Math.random() * 2);
                if (lr == 0)
                    leftRight[j] = 'L';
                else
                    leftRight[j] = 'R';
                System.out.print(leftRight[j]);
            }
            System.out.println();
            int rows = 0;
            for (int k = 0; k < leftRight.length; k++) {
                if (leftRight[k] == 'R')
                    rows++;
            }
            slots[rows]++;
        }
        //System.out.println("0\t1\t2\t3\t4\t5\t");
        /*for (int k = 0; k < numberOfSlots; k++) {
            for (int l = 0; l < slots[k]; l++) {
                int x = k;
                while (x > 0) {
                    System.out.print("\t");
                    x--;
                }
                System.out.println(0);
            }
        }*/
        for (int k = 0; k < numberOfSlots; k++) {
            System.out.print(k + ": ");
            for (int l = 0; l < slots[k]; l++) {
                System.out.print(0 + "\t");
            }
            System.out.println();
        }
    }
}
