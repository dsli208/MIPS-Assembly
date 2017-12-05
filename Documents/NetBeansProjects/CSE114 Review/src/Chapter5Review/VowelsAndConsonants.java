/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class VowelsAndConsonants {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = input.nextLine();
        String analyze = word.toLowerCase();
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (analyze.charAt(i) == 'a' || analyze.charAt(i) == 'e' ||analyze.charAt(i) == 'i' || analyze.charAt(i) == 'o' || analyze.charAt(i) == 'u')
                vowelCount++;
            else if (analyze.charAt(i) > 'a' && analyze.charAt(i) <= 'z')
                consonantCount++;
        }
        
        System.out.println("The number of vowels is " + vowelCount);
        System.out.println("The number of consonants is " + consonantCount);
    }
}
