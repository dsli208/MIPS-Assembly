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
public class OccurencesOfSpecifiedChar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.print("Enter a character: ");
        String character = input.nextLine();
        char c = character.charAt(0);
        int occurences = count(s, c);
        System.out.println("The character " + c + " occurs " + occurences + " times in the String " + s);
    }
    public static int count(String s, char a) {
        if (s.length() == 1) {
            if (s.charAt(0) == a || s.charAt(0) == a + 32 || s.charAt(0) == a - 32)
                return 1;
            else
                return 0;
        }
        else
            return count(s, a, s.length() - 1);
    }
    public static int count(String s, char a, int high) {
        if (s.charAt(high) == a || s.charAt(high) == (a + 32) || s.charAt(high) == (a - 32))
            return 1 + count(s.substring(0, high), a);
        else
            return count(s.substring(0, high), a);
    }
}
