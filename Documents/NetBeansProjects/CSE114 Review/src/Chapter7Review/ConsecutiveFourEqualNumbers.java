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
public class ConsecutiveFourEqualNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int numberOfValues = input.nextInt();
        int[] values = new int[numberOfValues];
        System.out.print("Enter the values: ");
        for (int i = 0; i < values.length; i++) {
            values[i] = input.nextInt();
        }
        boolean hasConsecutives = false;
        int consecutives = 1;
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                consecutives++;
                if (consecutives == 4)
                    hasConsecutives = true;
            }
            else //if (values[i] != values[i - 1])
                consecutives = 1;
        }
        if (hasConsecutives == true)
            System.out.println("The list has consecutive fours.");
        else
            System.out.println("The list does not have consecutive fours.");
    }
}
