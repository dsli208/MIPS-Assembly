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
public class Sorted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list: ");
        int length = input.nextInt();
        int[] list = new int[length];
        for (int i = 0; i < length; i++) {
            list[i] = input.nextInt();
        }
        if (isSorted(list) == true)
            System.out.println("The list is already sorted.");
        else
            System.out.println("The list is not sorted.");
    }
    
    public static boolean isSorted(int[] list) {
        boolean sorted = true;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i + 1] < list[i])
                sorted = false;
        }
        if (sorted == true)
            return true;
        else
            return false;
    }
}
