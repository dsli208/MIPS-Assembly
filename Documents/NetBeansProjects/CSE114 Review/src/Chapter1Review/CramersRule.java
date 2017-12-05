/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1Review;

/**
 *
 * @author dsli
 */
public class CramersRule {
    //Based off Liang, chapter 1 exercise 13
    public static void main(String args[]) {
        System.out.println("Format in ax + by = e and cx + dy = f");
        double a = 3.4;
        double b = 50.2;
        double c = 2.1;
        double d = 0.55;
        double e = 44.5;
        double f = 5.9;
        System.out.println("The equations are: " + a + "x + " + b + "y = " + e);
        System.out.println(c + "x + " + d + "y = " + f);
        gety(a, b, c, d, e, f);
        getx(a, b, c, d, e, f);
    }
    
    public static void gety(double a, double b, double c, double d, double e, double f) {
        double y = ((a * f) - (e * c)) / ((a * d) - (b * c));
        System.out.println("The value of y is: " + y);
    }
    
    public static void getx(double a, double b, double c, double d, double e, double f) {
        double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
        System.out.println("The value of x is: " + x);
    }
}
