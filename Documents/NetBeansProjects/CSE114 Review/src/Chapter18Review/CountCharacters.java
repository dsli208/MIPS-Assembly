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
public class CountCharacters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.print("Enter a character: ");
        String character = input.nextLine();
        char c = character.charAt(0);
        int count = count(s, c);
        System.out.println("The string " + s + " has the character " + c + " appear " + count + " times.");
    }
    public static int count(String str, char a) {
        int count = 0;
        if (str.charAt(0) == a || str.charAt(0) == (a - 32) || str.charAt(0) == (a + 32))
            count++;
        if (str.length() == 1)
            return count;
        else
            return count + count(str.substring(1), a);
    }
}
