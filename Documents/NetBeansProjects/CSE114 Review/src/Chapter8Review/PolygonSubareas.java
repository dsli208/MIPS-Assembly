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
            }
            if (inOrder == true)
                unsorted = false;
        }
        for (int i= 0; i < areas.length; i++) {
                System.out.print(areas[i] + " ");
            }
    }
    public static double[] getAreas(double[][] n) {
        //Get lengths of sides of polygon (n[side][0] is an x, n[side][1] is a y)
        double side1 = Math.sqrt(Math.pow(n[1][0] - n[0][0], 2) + Math.pow(n[1][1] - n[0][1], 2));
        double side2 = Math.sqrt(Math.pow(n[2][0] - n[1][0], 2) + Math.pow(n[2][1] - n[1][1], 2));
        double side3 = Math.sqrt(Math.pow(n[3][0] - n[2][0], 2) + Math.pow(n[3][1] - n[2][1], 2));
        double side4 = Math.sqrt(Math.pow(n[0][0] - n[3][0], 2) + Math.pow(n[0][1] - n[3][1], 2));
        //Get the intersection point of the two diagonals, create array with all the points of intersection of the sides of the polygon itself
        double[][] m = {{n[0][0], n[0][1]}, {n[2][0], n[2][1]}, {n[1][0], n[1][1]}, {n[3][0], n[3][1]}};
        double a = m[0][1] - m[1][1];
        double b = m[0][0] - m[1][0];
        double c = m[2][1] - m[3][1];
        double d = m[2][0] - m[3][0];
        double e = ((m[0][1] - m[1][1]) * m[0][0]) - ((m[0][0] - m[1][0]) * m[0][1]);
        double f = ((m[2][1] - m[3][1]) * m[2][0]) - ((m[2][0] - m[3][0]) * m[2][1]);
        double x = (e * d - b * f) / (a * d - b * c);
        double y = (a * f - e * c) / (a * d - b * c); // x and y are the intersection point coordinates
        double[] areas = new double[4]; //array with areas of each of the four triangles
        //get lengths of triangle sides (sides inside the polygon)
        double sidet1 = Math.sqrt(Math.pow(x - n[0][0], 2) + Math.pow(y - n[0][1], 2));
        double sidet2 = Math.sqrt(Math.pow(x - n[1][0], 2) + Math.pow(y - n[1][1], 2));
        double sidet3 = Math.sqrt(Math.pow(x - n[2][0], 2) + Math.pow(y - n[2][1], 2));
        double sidet4 = Math.sqrt(Math.pow(x - n[3][0], 2) + Math.pow(y - n[3][1], 2));
        //get s - values
        double s1 = (side1 + sidet1 + sidet4) / 2;
        double s2 = (side2 + sidet1 + sidet2) / 2; double s3 = (side3 + sidet2 + sidet3) / 2; double s4 = (side4 + sidet3 + sidet4) / 2;
        //get areas
        areas[0] = Math.sqrt(s1 * (s1 - side1) * (s1 - sidet1) * (s1 - sidet4)); areas[1] = Math.sqrt(s2 * (s2 - side2) * (s2 - sidet1) * (s2 - sidet2));
        areas[2] = Math.sqrt(s3 * (s3 - side3) * (s3 - sidet2) * (s3 - sidet3)); areas[3] = Math.sqrt(s4 * (s4 - side4) * (s4 - sidet3) * (s4 - sidet4));
        return areas;
    }
}
