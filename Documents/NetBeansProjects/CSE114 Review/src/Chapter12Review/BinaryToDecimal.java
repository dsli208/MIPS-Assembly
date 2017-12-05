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
public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String binary = input.nextLine();
        System.out.println("The decimal equivalent is " + binToDecimal(binary));
    }
    public static int binToDecimal(String b) {
        int totalDecimalValue = 0;
        for (int i = 0; i < b.length(); i++) {
            totalDecimalValue = totalDecimalValue * 2 + charToInt(b.charAt(i));
        }
        return totalDecimalValue;
    }
    public static int charToInt(char c) {
        if (c == '1' || c == '0')
            return ((int)(c - 48));
        else
            throw new NumberFormatException("Binary strings can only consist of 0s and 1s");
    }
}
