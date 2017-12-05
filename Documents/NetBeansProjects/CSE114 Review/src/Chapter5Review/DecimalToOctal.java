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
public class DecimalToOctal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal integer: ");
        int rem = input.nextInt();
        String octalReversed = "";
        while (rem > 0) {
            octalReversed += (rem % 8);
            rem /= 8;
        }
        
        String octal = "";
        for (int i = octalReversed.length() - 1; i >= 0; i--) {
            octal += octalReversed.charAt(i);
        }
        
        System.out.println(octal);
    }
}
