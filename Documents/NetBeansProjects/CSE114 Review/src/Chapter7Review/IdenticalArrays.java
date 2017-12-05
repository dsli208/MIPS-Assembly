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
public class IdenticalArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list 1: ");
        int list1Length = input.nextInt();
        int[] list1 = new int[list1Length];
        for (int i = 0; i < list1Length; i++) {
            list1[i] = input.nextInt();
        }
        System.out.print("Enter list 2: ");
        int list2Length = input.nextInt();
        int[] list2 = new int[list2Length];
        for (int i = 0; i < list2Length; i++) {
            list2[i] = input.nextInt();
        }
        boolean identical = true;
        int sum1 = 0;
        int sum2 = 0;
        if (list1Length == list2Length) {
            for (int i = 0; i < list1Length; i++) {
                sum1 += list1[i]; sum2 += list2[i];
                if (list1[i] != list2[i])
                    identical = false;
            }
        }
        else
            identical = false;
        if (identical == true)
            System.out.println("The two lists are strictly identical");
        else if (sum1 == sum2)
            System.out.println("The two lists are not strictly identical");
        else
            System.out.println("The two lists are not identical");
    }
}
