/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class LocateLargestElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of ROWS and COLUMNS of the array: ");
        int rows = input.nextInt();
        int columns = input.nextInt();
        double[][] array = new double[rows][columns];
        System.out.println("Enter the array: ");
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        int[] largestElement = locateLargest(array);
        System.out.println("The location of the largest element is at (" + largestElement[0] + ", " + largestElement[1] + ")");
    }
    public static int[] locateLargest(double[][] a) {
        int[] largestElement = new int[2];
        double largest = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > largest) {
                    largestElement[0] = i;
                    largestElement[1] = j;
                    largest = a[i][j];
                }
            }
        }
        return largestElement;
    }
}
