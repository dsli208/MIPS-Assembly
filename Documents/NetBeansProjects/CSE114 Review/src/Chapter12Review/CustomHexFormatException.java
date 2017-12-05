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
public class CustomHexFormatException {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex string: ");
        String hex = input.nextLine();
        try {
            System.out.print("In binary form, the hex string is: " + hexToDec(hex));
        }
        catch (HexFormatException e) {
            System.out.println(e);
        }
    }
    public static int hexToDec(String h) throws HexFormatException {
        int totalSum = 0;
        for (int i = 0 ; i < h.length(); i++) {
            totalSum = totalSum * 16 + getCharValue(h.charAt(i));
        }
        return totalSum;
    }
    public static int getCharValue(char c) throws HexFormatException {
        if (c >= '0' && c <= '9')
            return ((int)(c - 48));
        else if (c >= 'A' && c <= 'F')
            return ((int)(c - 65));
        else if (c >= 'a' && c <= 'f')
            return ((int)(c - 97));
        else
            throw new HexFormatException(c);
    }
}

class HexFormatException extends Exception {
    private char c;
    
    public HexFormatException(char c) {
        super("Invalid character " + c);
        this.c = c;
    }
    
    public double getErrorChar() {
        return c;
    }
}