/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class OccurencesOfLetters {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String basePath = ("src/Chapter12Review/");
        String pathAddition = input.nextLine();
        String filePath = basePath + pathAddition;
        File f = new File(filePath);
        Scanner reader = new Scanner(f);
        int[] letterCount = new int[26];
        while (reader.hasNext()) {
            String line = reader.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c >= 'A' && c <= 'Z')
                    letterCount[(int)(c - 65)]++;
                else if (c >= 'a' && c <= 'z')
                    letterCount[(int)(c - 97)]++;
            }
        }
        for (int i = 0; i < letterCount.length; i++) {
            System.out.println("There are " + letterCount[i] + " " + (char)(i + 65) + "'s"); 
       }
    }
}
