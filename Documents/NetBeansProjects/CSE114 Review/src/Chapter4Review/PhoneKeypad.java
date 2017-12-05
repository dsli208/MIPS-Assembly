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
public class PhoneKeypad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a letter: ");
        String letter = input.nextLine();
        char c = Character.toLowerCase(letter.charAt(0));
        if ((c >= 'a') && (c <= 'z')) {
            System.out.print("The corresponding number is ");
            if (c >= 'a' && c <= 'c')
                System.out.print(2);
            else if (c >= 'd' && c <= 'f')
                System.out.print(3);
            else if (c >= 'g' && c <= 'i')
                System.out.print(4);
            else if (c >= 'j' && c <= 'l')
                System.out.print(5);
            else if (c >= 'm' && c <= 'o')
                System.out.print(6);
            else if (c >= 'p' && c <= 's')
                System.out.print(7);
            else if (c >= 't' && c <= 'v')
                System.out.print(8);
            else
                System.out.print(9);
        }        
        else
            System.out.println(c + " is an invalid input");
    }
}
