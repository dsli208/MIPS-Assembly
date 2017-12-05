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
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, and y3: ");
        double[][] trianglePoints = new double[3][2];
        for (int i = 0; i < trianglePoints.length; i++) {
            for (int j = 0; j < trianglePoints[i].length; j++) {
                trianglePoints[i][j] = input.nextDouble();
            }
        }
        double area = getTriangleArea(trianglePoints);
        if (area == 0)
            System.out.println("The points are on the same line.");
        else
        System.out.println("The area of the triangle is " + area);
    }
    
    public static double getTriangleArea(double[][] points) {
        double side1 = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2));
        double side2 = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2));
        double side3 = Math.sqrt(Math.pow(points[0][0] - points[2][0], 2) + Math.pow(points[0][1] - points[2][1], 2));
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        if ((points[1][1] - points[0][1]) / (points[1][0] - points[0][0]) == (points[2][1] - points[1][1]) / (points[2][0] - points[1][0]))
            return 0;
        return area;
    }
}
