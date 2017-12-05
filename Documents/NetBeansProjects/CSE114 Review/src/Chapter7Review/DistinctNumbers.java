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
public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numbersEntered = 0;
        System.out.print("Enter 10 numbers: ");
        int[] enteredValues = new int[10];
        while (numbersEntered < 10) {
            enteredValues[numbersEntered] = input.nextInt();
            numbersEntered++;
        }
        int distinctNumbers = 0;
        for (int i = 0; i < 10; i++) {
            if (appearsPreviously(enteredValues, i) == true)
                distinctNumbers++;
        }
        
        int[] distinctArray = new int[distinctNumbers];
        int k = 0;
        for (int i = 0; k < distinctNumbers; i++) {
            if (appearsPreviously(enteredValues, i) == true) {
                distinctArray[k] = enteredValues[i];
                k++;
            }
        }
        System.out.println("There are " + distinctNumbers + " distinct numbers.");
        System.out.print("The distinct numbers are ");
        printArray(distinctArray);
        
    }
    
    public static boolean appearsPreviously(int[] n, int i) {
        boolean distinct = true;
        for (int j = i - 1; j >= 0; j--) {
            if (n[j] == n[i])
                distinct = false;
        }
        if (distinct == true)
                return true;
            else
                return false;
    }
    
    public static void printArray(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }
}
