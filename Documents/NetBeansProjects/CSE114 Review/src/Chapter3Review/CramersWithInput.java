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
public class CramersWithInput {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a, b, c, d, e, and f: ");
        double a = input.nextDouble(); double b = input.nextDouble();
        double c = input.nextDouble(); double d = input.nextDouble(); double e = input.nextDouble();
        double f = input.nextDouble();
        if (a * d - b * c > 0) {
            double x = ((e * d - b * f) / (a * d - b * c));
            double y = ((a * f - e * c) / (a * d - b * c));
            System.out.println("x is " + x + " and y is " + y);
        }
        else
            System.out.println("No solution.");
    }
}
