/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[8];
        System.out.print("Enter eight integer numbers: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
        int largest = getLargestNumber(array);
        System.out.println("The largest integer in the array is " + largest);
    }
    public static int getLargestNumber(int[] a) {
        int max = 0;
        if (a.length == 1)
            return a[0];
        else
            return getLargestNumber(a, 0);
    }
    public static int getLargestNumber(int[] a, int n) {
        if (n < a.length)
            return Math.max(a[n], getLargestNumber(a, n + 1));
        else
            return 0; //When the whole array is read, this is what the "max" value will start at, and the array values will be compared in reverse order
    }
}
