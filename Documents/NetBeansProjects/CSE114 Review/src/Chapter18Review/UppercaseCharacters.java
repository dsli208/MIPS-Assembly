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
public class UppercaseCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        int uppercase = uppercaseChars(s);
        System.out.println("There are " + uppercase + " uppercase characters in the String " + s);
    }
    public static int uppercaseChars(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) >= 65 && s.charAt(0) <= 90)
                return 1;
            else
                return 0;
        }
        else
            return uppercaseChars(s, 0);
    }
    public static int uppercaseChars(String s, int n) {
        if (s.charAt(n) >= 65 && s.charAt(n) <= 90)
            return 1 + uppercaseChars(s.substring(n + 1));
        else
            return uppercaseChars(s.substring(n + 1));
    }
}
