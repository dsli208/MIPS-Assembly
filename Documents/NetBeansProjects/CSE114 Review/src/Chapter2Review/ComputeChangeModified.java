/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ComputeChangeModified {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter change (Last two digits are cents)");
        int initialChange = input.nextInt();
        int cents = initialChange % 100;
        int dollars = initialChange / 100;
        int quarters = cents / 25;
        int quarterRem = cents % 25;
        int dimes = quarterRem / 10;
        int dimeRem = quarterRem % 10;
        int nickels = dimeRem / 5;
        int pennies = dimeRem % 5;
        //System.out.print("There are " + dollars + " dollars " + quarters + " quarters " + dimes + " dimes " + nickels + " nickels " + pennies + " pennies.");
        System.out.println((dollars == 1) ? (dollars + " dollar") : (dollars + " dollars"));
        System.out.println((quarters == 1) ? (quarters + " quarter") : (quarters + " quarters"));
        System.out.println((dimes == 1) ? (dimes + " dime") : (dimes + " dimes"));
        System.out.println((nickels == 1) ? (nickels + " nickel") : (nickels + " nickels"));
        System.out.println((pennies == 1) ? (pennies + " penny") : (pennies + " pennies"));
    }
}
