/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class QuadraticEquation {
    private double a = 1;
    private double b = 0;
    private double c = 0;
    public QuadraticEquation(double aA, double bB, double cC) {
        a = aA;
        b = bB;
        c = cC;
    }
    public double getDiscriminant() {
        return (Math.pow(b, 2) - 4 * a * c);
    }
    public double getRoot1() {
        double discriminant = (Math.pow(b, 2) - 4 * a * c);
        if (discriminant < 0)
            return 0;
        else
            return ((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
    }
    public double getRoot2() {
        double discriminant = (Math.pow(b, 2) - 4 * a * c);
        if (discriminant < 0)
            return 0;
        else
            return ((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a));
    }
}
class testQuadratic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, and c: ");
        double a = input.nextDouble(); double b = input.nextDouble(); double c = input.nextDouble();
        QuadraticEquation q = new QuadraticEquation(a, b, c);
        if (q.getDiscriminant() > 0)
            System.out.println("The roots are " + q.getRoot1() + " and " + q.getRoot2());
        else if (q.getDiscriminant() == 0)
            System.out.println("The root is " + q.getRoot1());
        else
            System.out.println("There are no real roots.");
    }
}