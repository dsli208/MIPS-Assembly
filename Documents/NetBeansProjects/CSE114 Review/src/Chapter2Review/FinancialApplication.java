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
public class FinancialApplication {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter subtotal: ");
        double subtotal = input.nextDouble();
        System.out.println("Enter gratuity: ");
        double gratuityRate = input.nextDouble();
        double newGratuityRate = gratuityRate/100;
        double gratuity = subtotal * newGratuityRate;
        double total = subtotal + gratuity;
        System.out.print("The gratuity is " + gratuity + " and the total is " + total);
    }
}
