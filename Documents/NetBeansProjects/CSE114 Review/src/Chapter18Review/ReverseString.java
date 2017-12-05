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
public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String value = input.nextLine();
        reverseDisplay(value);
    }
    public static void reverseDisplay(String value) {
        System.out.print(value.charAt(value.length() - 1));
        if (value.length() > 1)
            reverseDisplay(value.substring(0, value.length() - 1));
    }
}
