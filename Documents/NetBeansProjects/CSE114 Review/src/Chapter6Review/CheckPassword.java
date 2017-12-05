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
public class CheckPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        if (checkPassword(password) == true)
            System.out.println("Valid password");
        else
            System.out.println("Invalid password");
    }
    
    public static boolean checkPassword(String s) {
        int charCount = 0;
        int digitCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))
                charCount++;
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                charCount++;
                digitCount++;
            }
        }
        
        if (charCount >= 8 && digitCount >= 2)
            return true;
        else
            return false;
    }
}
