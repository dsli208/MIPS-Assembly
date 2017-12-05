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
public class EliminateDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        int numbersEntered = 0;
        int[] list = new int[10];
        while (numbersEntered < 10) {
            list[numbersEntered] = input.nextInt();
            numbersEntered++;
        }
        int[] noDuplicates = eliminateDuplicates(list);
        for (int i = 0; i < noDuplicates.length; i++) {
            System.out.print(noDuplicates[i] + " ");
        }
    }
    
    public static int[] eliminateDuplicates(int[] list) {
        int distinct = 0;
        for (int i = 0; i < list.length; i++) {
            if (matches(list, i) == true)
                distinct++;
        }
        int[] noDuplicates = new int[distinct];
        int k = 0;
        for (int i = 0; k < distinct; i++) {
            if (matches(list, i) == true) {
                noDuplicates[k] = list[i];
                k++;
            }
        }
        return noDuplicates;
    }
    
    public static boolean matches(int[] list, int i) {
        boolean matches = false;
        for (int j = i - 1; j >= 0; j--) {
            if (list[i] == list[j])
                matches = true;
        }
        if (matches == false)
            return true;
        else
            return false;
    }
}
