/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class isVowel {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char c = Character.toUpperCase(s.charAt(0));
        char d = s.charAt(0);
        if (c >= 'A' && c <= 'z') {
            if ((c == 'A') || (c == 'E') || (c == 'I')|| (c == 'O') || c =='U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                System.out.println(d + " is a vowel");
            else
                System.out.println(d + " is a consonant");
        }
        else
            System.out.println("Invalid input.");
    }
}
