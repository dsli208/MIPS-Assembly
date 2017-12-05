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
public class RightmostLowestPoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 6 points: ");
        double[][] points = new double[6][2];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }
        
        double[] rightmostLowestPoint = getRightmostLowestPoint(points);
        System.out.println("The rightmost lowest point is (" + rightmostLowestPoint[0] + ", " + rightmostLowestPoint[1] + ")");
    }
    
    public static double[] getRightmostLowestPoint(double[][] points) {
        double[] rightmostLowest = new double[2];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] >= rightmostLowest[0] && points[i][1] <= rightmostLowest[1]) {
                rightmostLowest[0] = points[i][0];
                rightmostLowest[1] = points[i][1];
            }
        }
        return rightmostLowest;
    }
}
