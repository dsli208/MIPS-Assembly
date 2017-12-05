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
public class LinearEquations {
    private double a = 0; private double b = 0; private double c = 0; private double d = 0; private double e = 0; private double f = 0;
    public LinearEquations(double aA, double bB, double cC, double dD, double eE, double fF) {
        a = aA; b = bB; c = cC; d = dD; e = eE; f = fF;
    }
    public double getA() {return a;} public double getB() {return b;} public double getC() {return c;}  public double getD() {return d;} public double getE() {return e;}
    public double getF() {return f;}
    public boolean isSolvable() {
        if (a * d - b * c != 0)
            return false;
        else
            return true;
    }
    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }
    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}

class testEquation {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, c, d, e, and f: ");
        double a = input.nextDouble(); double b = input.nextDouble(); double c = input.nextDouble();
        double d = input.nextDouble(); double e = input.nextDouble(); double f = input.nextDouble();
        LinearEquations eq = new LinearEquations(a, b, c, d, e, f);
        if (eq.isSolvable() == true)
            System.out.println("This equation has no solution.");
        else {
            System.out.println("x = " + eq.getX());
            System.out.println("y = " + eq.getY());
        }
    }
}
