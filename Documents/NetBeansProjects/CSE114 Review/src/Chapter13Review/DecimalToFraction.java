/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class DecimalToFraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decimal = input.nextLine();
        String integer = decimal.substring(0, decimal.indexOf('.'));
        String fraction = decimal.substring(decimal.indexOf('.') + 1);
        int topNumber = Integer.parseInt(integer);
        int fractionInt = Integer.parseInt(fraction);
        int wholeDenominator = (int)Math.pow(10, fraction.length());
        
        for (int i = 2; i <= fractionInt && i <= wholeDenominator; i++) {
            if (fractionInt % i == 0 && wholeDenominator % i == 0) {
                fractionInt /= i; wholeDenominator /= i;
                i--;
            }
        }
        int wholeNumerator = topNumber * wholeDenominator; //The integer part of the number in fraction form
        wholeNumerator = wholeNumerator + fractionInt;
        System.out.println("The fraction is " + wholeNumerator + "/" + wholeDenominator);
    }
}
