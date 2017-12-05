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
public class IntersectingPoint {
    double a = 0; double b = 0; double c = 0; double d = 0; double e = 0; double f = 0;
    public IntersectingPoint(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        a = y1 - y2;
        b = x1 - x2;
        c = y3 - y4;
        d = x3 - x4;
        e = ((y1 - y2) * x1) - ((x1 - x2) * y1);
        f = ((y3 - y4) * x3) - ((x3 - x4) * y3);
    }
    public boolean isParallel() {
        if (a * d - b * c == 0)
            return true;
        else
            return false;
    }
    public double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }
    public double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}
class test{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, and y4: ");
        double x1 = input.nextDouble(); double y1 = input.nextDouble();
        double x2 = input.nextDouble(); double y2 = input.nextDouble();
        double x3 = input.nextDouble(); double y3 = input.nextDouble();
        double x4 = input.nextDouble(); double y4 = input.nextDouble();
        IntersectingPoint testPoint = new IntersectingPoint(x1, y1, x2, y2, x3, y3, x4, y4);
        if (testPoint.isParallel() == true)
            System.out.println("There are no solutions - the two lines are parallel.");
        else {
            System.out.println("x = " + testPoint.getX() + ", y = " + testPoint.getY());
        }
    }
}