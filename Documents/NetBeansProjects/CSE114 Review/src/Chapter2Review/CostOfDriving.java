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
public class CostOfDriving {
    public static void main(String args[]) {
        System.out.println("Enter the driving distance: ");
        Scanner input = new Scanner(System.in);
        double miles = input.nextDouble();
        System.out.println("Enter miles/gallon");
        double mpg = input.nextDouble();
        System.out.print("Enter price/gallon");
        double ppg = input.nextDouble();
        System.out.println("The cost of driving is: " + (miles * ppg) / mpg);
    }
}
