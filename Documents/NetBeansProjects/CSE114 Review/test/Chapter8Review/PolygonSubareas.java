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
public class PolygonSubareas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, and y4: ");
        double[][] array = new double[4][2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        double[] areas = getAreas(array);
        boolean unsorted = true;
        while (unsorted) {
            boolean inOrder = true;
            for (int i = 1; i < areas.length; i++) {
                if (areas[i] < areas[i - 1]) {
                    inOrder = false;
                    double temp = areas[i];
                    areas[i] = areas[i - 1];
                    areas[i - 1] = temp;
                }
                if (inOrder == true)
                    unsorted = false;
            }
            for (int i= 0; i < areas.length; i++) {
                System.out.print(areas[i] + " ");
            }
        }
    }
    public static double[] getAreas(double[][] n) {
        double[] sides = new double[4];
        for (int i = 0; i < 4; i++) {
            if (i == 0)
                sides[i] = Math.sqrt(Math.pow(n[i][0] - n[sides.length - 1][0], 2) + Math.pow(n[i][1] - n[sides.length - 1][1], 2));
            else
                sides[i] = Math.sqrt(Math.pow(n[i][0] - n[i - 1][0], 2) + Math.pow(n[i][1] - n[i - 1][1], 2));
            System.out.println(sides[i]);
        }
        /*double side1 = Math.sqrt(Math.pow(n[1][0] - n[0][0], 2) + Math.pow(n[1][1] - n[0][1], 2));
        double side2 = Math.sqrt(Math.pow(n[2][0] - n[1][0], 2) + Math.pow(n[2][1] - n[1][1], 2));
        double side3 = Math.sqrt(Math.pow(n[3][0] - n[2][0], 2) + Math.pow(n[3][1] - n[2][1], 2));
        double side4 = Math.sqrt(Math.pow(n[0][0] - n[3][0], 2) + Math.pow(n[0][1] - n[3][1], 2));*/
        double[][] m = {{n[0][0], n[0][1]}, {n[2][0], n[2][1]}, {n[1][0], n[1][1]}, {n[3][0], n[3][1]}};
        double a = m[0][1] - m[1][1];
        double b = m[0][0] - m[1][0];
        double c = m[2][1] - m[3][1];
        double d = m[2][0] - m[3][0];
        double e = ((m[0][1] - m[1][1]) * m[0][0]) - ((m[0][0] - m[1][0]) * m[0][1]);
        double f = ((m[2][1] - m[3][1]) * m[2][0]) - ((m[2][0] - m[3][0]) * m[2][1]);
        double x = (e * d - b * f) / (a * d - b * c);
        System.out.println("x is " + x);
        double y = (a * f - e * c) / (a * d - b * c);
        System.out.println("y is " + y);
        double[] triangleSides = new double[4];
        for (int i = 0; i < triangleSides.length; i++) {
            triangleSides[i] = Math.sqrt(Math.pow(x - n[i][0], 2) + Math.pow(y - n[i][1], 2));
        }
        /*double firstSide = Math.sqrt(Math.pow(x - n[0][0], 2) + Math.pow(y - n[0][1], 2));
        double secondSide = Math.sqrt(Math.pow(n[1][1] - y, 2) + Math.pow(n[1][0] - x, 2));
        double thirdSide = Math.sqrt(Math.pow(n[2][0] - x, 2) + Math.pow(n[2][1] - y, 2));
        double fourthSide = Math.sqrt(Math.pow(x - n[3][0], 2) + Math.pow(y - n[3][1], 2));*/
        double[] areas = new double[4];
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                double s = (sides[i] + Math.sqrt(Math.pow(x - n[i][0], 2) + Math.pow(y - n[i][1], 2)) + Math.sqrt(Math.pow(x - n[sides.length - 1][0], 2) + Math.pow(y - n[sides.length - 1][1], 2)));
                System.out.println(s);
                areas[i] = Math.sqrt(s * (s - sides[i]) * (s - Math.sqrt(Math.pow(x - n[i][0], 2) + Math.pow(y - n[i][1], 2))) * (s - Math.sqrt(Math.pow(x - n[sides.length - 1][0], 2) + Math.pow(y - n[sides.length - 1][1], 2))));
            }
            else {
                double s = (sides[i] + Math.sqrt(Math.pow(x - n[i][0], 2) + Math.pow(y - n[i][1], 2)) + Math.sqrt(Math.pow(x - n[i - 1][0], 2) + Math.pow(y - n[i - 1][1], 2)));
                System.out.println(s);
            areas[i] = Math.sqrt(s * (s - sides[i]) * (s - Math.sqrt(Math.pow(x - n[i][0], 2) + Math.pow(y - n[i][1], 2))) * (s - Math.sqrt(Math.pow(x - n[i - 1][0], 2) + Math.pow(y - n[i - 1][1], 2))));
            }
        }
        return areas;
    }
}
