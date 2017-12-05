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
public class HelperReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
        reverseDisplay(s);
    }
    public static void reverseDisplay(String value) {
        reverseDisplay(value, value.charAt(value.length() - 1));
    }
    public static void reverseDisplay(String value, char c) {
        if (value.length() == 1)
            System.out.print(c);
        else {
            System.out.print(c);
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
}
