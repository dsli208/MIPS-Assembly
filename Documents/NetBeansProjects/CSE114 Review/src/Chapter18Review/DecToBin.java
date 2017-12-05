/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class DecToBin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int dec = input.nextInt();
        System.out.println("The number in binary form is " + dec2Bin(dec));
    }
    public static String dec2Bin(int value) {
        if (value == 0)
            return "";
        int binaryDigit = (value % 2);
        return dec2Bin(value / 2) + "" + binaryDigit;
    }
}
