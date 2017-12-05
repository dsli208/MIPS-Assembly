/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ComputeAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean noZero = true;
        int positiveCount = 0;
        int negativeCount = 0;
        int count = 0;
        double total = 0;
        System.out.println("Enter integers (if you enter 0, the input ends)");
        while (noZero) {
            
            int number = input.nextInt();
            
            total = total + number;
            if (number > 0) {
                positiveCount++; count++;
            }
            else if (number < 0) {
                negativeCount++; count++;
            }
            else
                noZero = false;
        }
        
        System.out.println("The number of positives is " + positiveCount);
        System.out.println("The number of negatives is " + negativeCount);
        System.out.println("The total is " + total);
        System.out.println("The average is " + (total / count));
    }
}
