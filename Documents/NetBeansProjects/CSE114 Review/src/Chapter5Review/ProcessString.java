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
public class ProcessString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String word = input.nextLine();
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0)
                System.out.print(word.charAt(i));
        }
    }
}
