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
public class CompareCosts {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter weight and price for package 1");
        double weight1 = input.nextDouble(); double price1 = input.nextDouble();
        System.out.println("Enter weight and price for package 2");
        double weight2 = input.nextDouble(); double price2 = input.nextDouble();
        double value1 = price1 / weight1;
        double value2 = price2 / weight2;
        //System.out.println(value1 + " " + value2);
        if (value1 != value2)
            System.out.println((value1 < value2) ? "Package 1 has a better value" : "Package 2 has a better value");
        else
            System.out.println("The two packages have the same value");
    }
}
