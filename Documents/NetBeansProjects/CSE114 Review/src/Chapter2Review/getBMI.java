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
public class getBMI {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight (lbs)");
        double pounds = input.nextDouble();
        System.out.print("Enter height (in)");
        double inches = input.nextDouble();
        double kilograms = pounds * 0.45359237;
        double meters = inches * 0.0254;
        double BMI = kilograms / Math.pow(meters,2);
        System.out.print(BMI);
    }
}
