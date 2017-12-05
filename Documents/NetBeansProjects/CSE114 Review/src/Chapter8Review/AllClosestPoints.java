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
public class AllClosestPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int n = input.nextInt();
        double[][] points = new double[n][2];
        System.out.print("Input your points (x first then y): ");
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                points[i][j] = input.nextDouble();
                }
            }
        double minimumDistance = getDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
        double distance = getDistance(points[0][0], points[0][1], points[1][0], points[1][1]);
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (distance < minimumDistance)
                    minimumDistance = distance;
            }
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (distance == minimumDistance)
                    System.out.println("The closest two points are (" + points[i][0] + ", " + points[i][1] + ") and (" + points[j][0] + ", " + points[j][1] + ")");
            }
        }
        System.out.println("Their distance is " + minimumDistance);
        }
        
    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
