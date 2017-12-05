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
public class QuadraticFormula {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a, b, c: ");
        double a = input.nextDouble(); double b = input.nextDouble(); double c = input.nextDouble();
        double discriminant = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
        if (discriminant > 0) {
            System.out.println("The first root is: " + ((-b + discriminant) / (2 * a)));
            System.out.println("The second root is: " + (-b - discriminant) / (2 * a));
        }
        else if (discriminant == 0) {
            System.out.println("The root is :" + b / (2 * a));
            
        }
        else
            System.out.println("The equation has no real roots");
    }
}
