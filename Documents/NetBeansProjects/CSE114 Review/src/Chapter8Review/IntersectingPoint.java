/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class IntersectingPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double[][] a = new double[4][2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = input.nextDouble();
            }
        }
        double[] intersectingPoint = getIntersectingPoint(a);
        System.out.println("x = " + intersectingPoint[0]);
        System.out.println("y = " + intersectingPoint[1]);
    }
    public static double[] getIntersectingPoint(double[][] points) {
        double[] intersectingPoint = new double[2];
        double a = points[0][1] - points[1][1];
        double b = points[0][0] - points[1][0];
        double c = points[2][1] - points[3][1];
        double d = points[2][0] - points[3][0];
        double e = ((points[0][1] - points[1][1]) * points[0][0]) - ((points[0][0] - points[1][0]) * points[0][1]);
        double f = ((points[2][1] - points[3][1]) * points[2][0]) - ((points[2][0] - points[3][0]) * points[2][1]);
        if (a / b == c / d)
            return null;
        
        intersectingPoint[0] = (e * d - b * f) / (a * d - b * c);
        intersectingPoint[1] = (a * f - e * c) / (a * d - b * c);
        return intersectingPoint;
    }
}
