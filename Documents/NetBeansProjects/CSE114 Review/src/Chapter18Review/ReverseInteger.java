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
public class ReverseInteger {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int value = input.nextInt();
        reverseDisplay(value);
    }
    public static void reverseDisplay(int value) {
        System.out.print((value % 10));
        if (value / 10 > 0)
            reverseDisplay(value / 10);
    }
}
