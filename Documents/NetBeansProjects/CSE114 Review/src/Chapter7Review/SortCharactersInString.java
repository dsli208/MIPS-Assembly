/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SortCharactersInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String stringToBeSorted = input.nextLine();
        String sortedString = sort(stringToBeSorted);
        System.out.println(sortedString);
    }
    public static String sort(String s) {
        char[] c = s.toCharArray();
        boolean unsorted = true;
        while (unsorted) {
            boolean completelySorted = true;
            for (int i = 0; i < c.length - 1; i++) {
                if (c[i] > c[i + 1]) {
                    completelySorted = false;
                    char temp = c[i];
                    c[i] = c[i + 1];
                    c[i + 1] = temp;
                }
            }
            if (completelySorted == true)
                unsorted = false;
        }
        String sorted = new String(c);
        return sorted;
    }
    
}
