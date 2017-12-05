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
public class StringPermutation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        displayPermutation(s);
    }
    public static void displayPermutation(String s) {
        //Invoke second displayPermutation method
        displayPermutation("", s);
    }
    
    public static void displayPermutation(String s1, String s2) {
        //Stopping condition
        if (s2.length() == 0)
            System.out.println(s1);
        //recursive call
        for (int i = 0; i < s2.length(); i++) {
            displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
        }
    }
}
