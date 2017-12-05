/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class HexToBinary {
    public static void main(String[] args) {
        System.out.println("Enter a hex number ");
        Scanner input = new Scanner(System.in);
        String hexNumber = input.next();
        int hexToRem;
        String decimalToBinary = "";
        if (hexNumber.charAt(0) >= '0' && hexNumber.charAt(0) <= '9') {
            hexToRem = (int) (hexNumber.charAt(0) - 48);
            //decimalToBinary = Integer.parseInt(hexNumber.charAt(0) + "", 2);
            int binary = 0;
            int i = 0;
            while (hexToRem > 0) {
                binary += (hexToRem % 2) * Math.pow(10, i);
                hexToRem /= 2;
                i++;
            }
            System.out.println("The binary value is: " + binary);
        }
        else if (hexNumber.charAt(0) >= 'A' && hexNumber.charAt(0) <= 'F') {
            hexToRem = (int) (hexNumber.charAt(0) - 55);
            int binary = 0;
            int i = 0;
            while (hexToRem > 0) {
                binary += (hexToRem % 2) * Math.pow(10, i);
                hexToRem /= 2;
                i++;
            }
            System.out.print("The binary value is: ");
            System.out.println(binary);
        }
        else {
            System.out.println(hexNumber.charAt(0) + " is an invalid input");
            System.exit(1);
        }
        
        
            
    }
}
