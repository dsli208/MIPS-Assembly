/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class BoundingRectangle {
    public static Rectangle2D getRectangle(double[][] points) {
        double maxY = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][1] > maxY)
                maxY = points[i][1];
        }
        double minY = maxY;
        for (int i = 0; i < points.length; i++) {
            if (points[i][1] < minY)
                minY = points[i][1];
        }
        double maxX = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > maxX)
                maxX = points[i][0];
        }
        double minX = maxX;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] < minX)
                minX = points[i][0];
        }
        double height = maxY - minY; double width = maxX - minX; double y = minY + ((maxY - minY) / 2); double x = minX + ((maxX - minX) / 2);
        return new Rectangle2D(x, y, width, height);
    }
    
}

class testBoundingRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter five points: ");
        double[][] testArray = new double[5][2];
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                testArray[i][j] = input.nextDouble();
            }
        }
        BoundingRectangle b = new BoundingRectangle();
        Rectangle2D r = b.getRectangle(testArray);
        System.out.println("The bounding rectangle's center is (" + r.x + ", " + r.y + "), the width is " + r.width + ", and the height is " + r.height);
    }
}