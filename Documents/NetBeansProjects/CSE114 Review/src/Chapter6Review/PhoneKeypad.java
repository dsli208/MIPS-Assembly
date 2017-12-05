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
public class PhoneKeypad {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phone number: ");
        String phoneNumber = input.nextLine();
        //if (phoneNumber.matches("\\d{1}\\d{3}\\d{3}\\d{4}") || phoneNumber.matches("\\d{3}\\d{3}\\d{4}")) {
        if (phoneNumber.length() == 10 || phoneNumber.length() == 11) {    
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (phoneNumber.charAt(i) >= '0' && phoneNumber.charAt(i) <= '9')
                    System.out.print(phoneNumber.charAt(i));
                else if ((phoneNumber.charAt(i) >= 'a' && phoneNumber.charAt(i) <= 'z') || (phoneNumber.charAt(i) >= 'A' && phoneNumber.charAt(i) <= 'Z'))
                    System.out.print(getNumber(phoneNumber.charAt(i)));
            }
        }
            
    }
    
    public static int getNumber(char uppercaseLetter) {
        if ((uppercaseLetter >= 'a' && uppercaseLetter <= 'c') || (uppercaseLetter >= 'A' && uppercaseLetter <= 'C'))
                return 2;
        else if ((uppercaseLetter >= 'd' && uppercaseLetter <= 'f') || (uppercaseLetter >= 'D' && uppercaseLetter <= 'F'))
            return 3;
        else if ((uppercaseLetter >= 'g' && uppercaseLetter <= 'i') || (uppercaseLetter >= 'G' && uppercaseLetter <= 'I'))
            return 4;
        else if ((uppercaseLetter>= 'j' && uppercaseLetter <= 'l') || (uppercaseLetter >= 'J' && uppercaseLetter <= 'L'))
            return 5;
        else if ((uppercaseLetter >= 'm' && uppercaseLetter <= 'o') || (uppercaseLetter >= 'M' && uppercaseLetter <= 'O'))
            return 6;
        else if ((uppercaseLetter >= 'p' && uppercaseLetter <= 's') || (uppercaseLetter >= 'P' && uppercaseLetter <= 'S'))
            return 7;
        else if ((uppercaseLetter >= 't' && uppercaseLetter <= 'v') || (uppercaseLetter >= 'T' && uppercaseLetter <= 'V'))
            return 8;
        else
            return 9;
    }
}
