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
public class SameLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] fivePoints = new double[5][2];
        System.out.print("Enter five points: ");
        for (int i = 0; i < fivePoints.length; i++) {
            for (int j = 0; j < fivePoints[i].length; j++) {
                fivePoints[i][j] = input.nextDouble();
            }
        }
        if (sameLine(fivePoints) == true)
            System.out.println("The five points are on the same line.");
        else
            System.out.println("The five points are not on the same line.");
    }
    
    public static boolean sameLine(double[][] points) {
        double slope = (points[1][1] - points[0][1]) / (points[1][0] - points[0][0]);
        boolean onTheSameLine = true;
        for (int i = 1; i < points.length; i++) {
            if ((points[i][1] - points[i - 1][0]) / (points[i][0] - points[i - 1][0]) != slope)
                onTheSameLine = false;
        }
        return onTheSameLine;
    }
}
