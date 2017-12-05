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
public class BinToDec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String bin = input.nextLine();
        System.out.println("The decimal equivalent is " + bin2Dec(bin));
    }
    public static int bin2Dec(String binString) {
        //Use doubling
        if (binString.length() == 0)
            return 0;
        else {
            return (2 * bin2Dec(binString.substring(0, binString.length() - 1))) + Integer.parseInt(binString.substring(binString.length() - 1));
        }
    }
}
