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
public class CompoundValue {
    public static void main(String args[]) {
        System.out.print("Enter monthly saving amount: ");
        Scanner input = new Scanner(System.in);
        int principle = input.nextInt();
        double accountValue = 0;
        double monthlyInterest = 0.00417;
        for (int i = 0; i < 6; i++) {
            accountValue = (principle + accountValue) * (1 + monthlyInterest);
        }
        
        System.out.println("After 6 months, the account value is $" + accountValue);
    }
}
