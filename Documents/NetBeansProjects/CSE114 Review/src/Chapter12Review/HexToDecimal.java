/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class HexToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        try {
            System.out.println("The decimal value for hex number " + hex + " is " + hexToDecimal(hex.toUpperCase()));
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    
    public static int hexCharToDecimal(char c) {
        if (c >= 'A' && c <= 'F')
            return 10 + (c - 'A');
        else if (c > 'F')
            throw new NumberFormatException("Character must be from 0 - 9, or from A - F");
        else
            return c - '0';
    }
}
