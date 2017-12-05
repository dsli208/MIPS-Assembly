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
public class CountFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Chapter12Review/newfile");
        Scanner input = new Scanner(file);
        int characters = 0; int words = 0; int lines = 0;
        while (input.hasNext()) {
            String line = input.nextLine();
            lines++;
            words++;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ' ')
                    words++;
                else
                    characters++;
            }
        }
        System.out.println("There are " + lines + " lines, " + words + " words, and " + characters + " characters.");
    }
}
