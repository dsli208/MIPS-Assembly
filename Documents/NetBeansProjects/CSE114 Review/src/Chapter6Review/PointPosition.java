/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class PointPosition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three points for po, p1, and p2 ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        if (leftOfTheLine(x1, y1, x2, y2, x3, y3) == true)
            System.out.println("(" + x3 + ", " + y3 + ") is on the left side of the line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
        else if (onTheSameLine(x1, y1, x2, y2, x3, y3) == true && onTheLineSegment(x1, y1, x2, y2, x3, y3) == false)
            System.out.println("(" + x3 + ", " + y3 + ") is on the same line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
        else if (onTheLineSegment(x1, y1, x2, y2, x3, y3) == true)
            System.out.println("(" + x3 + ", " + y3 + ") is on the same line segment from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
        else if (rightOfTheLine(x1, y1, x2, y2, x3, y3) == true)
            System.out.println("(" + x3 + ", " + y3 + ") is on the right of the side line from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
    }
    
    public static boolean leftOfTheLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) < 0);
    }
    
    public static boolean onTheSameLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        boolean sameSlope = (((y3 - y1) / (x3 - x1)) == ((y2 - y3) / (x2 - x3)));
        boolean inBetween = (((y3 >=  y1 && y3 <= y2) || (y1 <= y3 && y2 >= y3)) && ((x3 >= x1 && x3 <= x2) || (x3 <= x1 && x3 >= x2)));
        return (inBetween == true && sameSlope == true);
    }
    public static boolean onTheLineSegment(double x1, double y1, double x2, double y2, double x3, double y3) {
        return ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) == 0);
    }
    public static boolean rightOfTheLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        return ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) > 0);
    }
}
