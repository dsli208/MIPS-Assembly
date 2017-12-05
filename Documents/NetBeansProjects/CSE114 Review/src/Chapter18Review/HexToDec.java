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
public class HexToDec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hexadecimal string: ");
        String hex = input.nextLine();
        System.out.println("The decimal equivalent is " + hex2Dec(hex));
    }
    public static int hex2Dec(String hexString) {
        //This method works the same as Binary to Decimal, except its by multiples of 16, not 2
        if (hexString.length() == 0)
            return 0;
        else {
            if (hexString.charAt(hexString.length() - 1) == 'F')
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + 15;
            else if (hexString.charAt(hexString.length() - 1) == 'E')
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + 14;
            else if (hexString.charAt(hexString.length() - 1) == 'D')
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + 13;
            else if (hexString.charAt(hexString.length() - 1) == 'C')
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + 12;
            else if (hexString.charAt(hexString.length() - 1) == 'B')
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + 11;
            else if (hexString.charAt(hexString.length() - 1) == 'A')
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + 10;
            else
                return (hex2Dec(hexString.substring(0, hexString.length() - 1)) * 16) + Integer.parseInt(hexString.substring(hexString.length() - 1));
        }
    }
}
