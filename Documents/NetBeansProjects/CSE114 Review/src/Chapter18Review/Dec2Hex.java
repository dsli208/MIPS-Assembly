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
public class Dec2Hex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int dec = input.nextInt();
        System.out.println("The hexadecimal equivalent is " + dec2Hex(dec));
    }
    public static String dec2Hex(int value) {
        if (value == 0)
            return "";
        else {
            int rem = (value % 16);
            if (rem == 15)
                return dec2Hex(value / 16) + "" + 'F';
            else if (rem == 14)
                return dec2Hex(value / 16) + "" + 'E';
            else if (rem == 13)
                return dec2Hex(value / 16) + "" + 'D';
            else if (rem == 12)
                return dec2Hex(value / 16) + "" + 'C';
            else if (rem == 11)
                return dec2Hex(value / 16) + "" + 'B';
            else if (rem == 10)
                return dec2Hex(value / 16) + "" + 'A';
            else
                return dec2Hex(value / 16) + "" + rem;
        }
    }
}
