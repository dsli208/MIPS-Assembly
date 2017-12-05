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
public class BitLevelOperations {
    public static void main(String[] args) {
        //USE & (Bitwise AND) and >> OPERATORS
        //& - Bitwise AND - 10101110 & 10010010 yields 10000010, The AND of two corresponding bits yields a 1 if both bits are 1
        //>> Right shift with sign extension - 10101110 >>> 2 yields 11101011, 00101110 >> 2 yields 00001011, The operators shifts bit in the first operand right by the number of bits specified in the second operand, filling with the highest (sign) bit on the left
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        short integerInput = input.nextShort();
        
    }
}
