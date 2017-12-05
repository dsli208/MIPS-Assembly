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
public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, and c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        solveQuadratic(a, b, c);
    }
    
    public static void solveQuadratic(double a, double b, double c) {
        double determinant = Math.pow(b, 2) - (4 * a * c);
        if (determinant > 0) {
            double root1 = (-b - Math.sqrt(determinant)) / (2 * a);
            double root2 = (-b + Math.sqrt(determinant)) / (2 * a);
            System.out.println("The two roots are " + root1 + " and " + root2);
        }
        else if (determinant == 0)
            System.out.println("The root is " + (b / (2 * a)));
        else {
            determinant /= -1;
            double baseNumber = b / (2 * a); //get the whole part of the complex number
            double imaginaryNumber = Math.sqrt(determinant) / (2 * a); //get the imaginary part
            System.out.print("The two roots are " + baseNumber + " + " + imaginaryNumber + "i and " + baseNumber + " - " + imaginaryNumber + "i");
        }
            
    }
}
