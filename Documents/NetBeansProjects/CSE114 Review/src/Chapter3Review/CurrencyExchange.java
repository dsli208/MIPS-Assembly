/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CurrencyExchange {
    public static void main(String args[]) {
        System.out.println("Enter status (0 to convert from USD to RMB or 1 for vice versa)");
        Scanner input = new Scanner(System.in);
        int status = input.nextInt();
        if (status == 0) {
            System.out.println("Enter USD: ");
            double USD = input.nextDouble();
            System.out.println(USD * 6.81 + " RMB yuan");
        }
        else {
            System.out.println("Enter RMB: ");
            double RMB = input.nextDouble();
            System.out.print(RMB / 6.81 + " USD");
        }
    }
}
