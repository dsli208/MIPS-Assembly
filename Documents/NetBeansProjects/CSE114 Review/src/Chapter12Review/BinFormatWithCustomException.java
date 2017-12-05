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
public class BinFormatWithCustomException {
    public static void main(String[] args) throws BinaryFormatException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String bin = input.nextLine();
        System.out.println("In decimal form, the binary string is: " + binToDec(bin));
    }
    public static int binToDec(String b) throws BinaryFormatException {
        int totalSum = 0;
        for (int i = 0; i < b.length(); i++) {
            totalSum = totalSum * 2 + getIntValue(b.charAt(i));
        }
        return totalSum;
    }
    public static int getIntValue(char c) throws BinaryFormatException {
        if (c == '0' || c == '1')
            return ((int)(c - 48));
        else
            throw new BinaryFormatException(c);
    }
}

class BinaryFormatException extends Exception {
    private char c;
    public BinaryFormatException(char c) {
        super("Invalid integer " + c);
        this.c = c;
    }
}
