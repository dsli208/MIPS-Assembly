/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class IndexOutOfBounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] randomArray = new int[100];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int)(Math.random() * 100);
        }
        System.out.print("Enter the index of the array: ");
        int index = input.nextInt();
        try {
            System.out.println("The element at index " + index + " is " + randomArray[index]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Enter a number from 0 - 99");
        }
    }
}
