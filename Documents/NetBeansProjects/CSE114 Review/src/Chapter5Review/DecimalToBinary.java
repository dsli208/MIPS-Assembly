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
public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.print("Enter a decimal integer: ");
        Scanner input = new Scanner(System.in);
        int decimalInt = input.nextInt();
        int rem = decimalInt;
        String binaryNumberReversed = "";
        while (rem > 0) {
            binaryNumberReversed += (rem % 2);
            rem = rem / 2;
            
        }
        String binaryNumber = "";
        for (int i = binaryNumberReversed.length() - 1; i >= 0; i--) {
            binaryNumber += binaryNumberReversed.charAt(i);
        }
        System.out.print(binaryNumber);
    }
}
