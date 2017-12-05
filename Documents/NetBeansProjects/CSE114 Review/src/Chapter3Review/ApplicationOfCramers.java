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
public class ApplicationOfCramers {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4");
        double x1 = input.nextDouble(); double y1 = input.nextDouble();
        double x2 = input.nextDouble(); double y2 = input.nextDouble();
        double x3 = input.nextDouble(); double y3 = input.nextDouble();
        double x4 = input.nextDouble(); double y4 = input.nextDouble();
        double f = (y3 - y4) *  x3 - (x3 - x4) * y3;
        double e = (y1 - y2) * x1 - (x1 - x2) * y1;
        double a = y1 - y2;
        double b = x1 - x2;
        double c = y3 - y4;
        double d = x3 - x4;
        if ((a * d - b * c) == 0)
            System.out.println("The lines are parallel");
        else {
            double x = ((e * d - b * f) / (a * d - b * c));
            double y = ((a * f - e * c) / (a * d - b * c));
            System.out.println("The lines intersect at (" + x + ", " + y + ")");
        }
    }
}
