/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CharacterCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a character");
        String word = input.nextLine();
        String character = input.nextLine();
        if (character.length() == 1) {
            char c = character.charAt(0);
            System.out.println("The occurences of " + c + " in " + word + " is " + count(word, c));
        }
        else
            System.out.println("Invalid input");
    }
    
    public static int count(String str, char a) {
        int charCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                charCount++;
        }
        
        return charCount;
    }
}
