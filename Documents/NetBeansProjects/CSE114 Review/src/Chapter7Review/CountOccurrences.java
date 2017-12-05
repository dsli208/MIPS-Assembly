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
public class CountOccurrences {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 100: ");
        boolean activeInput = true;
        int n = 50;
        int[] inputValues = new int[n];
        int i = 0;
        while (activeInput) {
            int nextInput = input.nextInt();
            
            if (nextInput == 0) {
                activeInput = false;
            }
            else if (i == n) {
                n = n * 2;
                int[] newArray = new int[n];
                newArray = inputValues;
            }
            else {
                inputValues[i] = nextInput;
                i++;
            }
        }
        int finalValues = 0;
        for (int j = 0; j < inputValues.length; j++) {
            if (inputValues[j] != 0)
                finalValues++;
        }
        
        int[] finalArray = new int[finalValues];
        for (int k = 0; k < finalValues; k++) {
            finalArray[k] = inputValues[k];
        }
        
        for (int a = 0; a < finalArray.length; a++) {
            int count = 0;
            for (int b = a; b < finalArray.length; b++) {
                if (finalArray[b] == finalArray[a])
                    count++;
                
            }
            boolean matches = false;
            for (int c = a - 1; c >= 0; c--) {
                
                if (finalArray[c] == finalArray[a])
                    matches = true;
            }
            if (matches == false)
                System.out.println(finalArray[a] + " occurs " + count + " times.");
        }
    }
}
