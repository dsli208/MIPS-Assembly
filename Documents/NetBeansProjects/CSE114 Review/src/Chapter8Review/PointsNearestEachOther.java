/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

/**
 *
 * @author dsli
 */
public class PointsNearestEachOther {
    public static void main(String[] args) {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1}, {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2}, {5.5, 4, -0.5}};
        
        double minDistance = getDistance(points[0][0], points[0][1], points[0][2], points[1][0], points[1][1], points[1][2]);;
        double distance = getDistance(points[0][0], points[0][1], points[0][2], points[1][0], points[1][1], points[1][2]);
        double[][] currentPoints = {{points[0][0], points[0][1], points[0][2]}, {points[1][0], points[1][1], points[1][2]}};
        for (int i = 0; i < points.length - 1; i++) {
            
            for (int j = i + 1; j < points.length; j++) {
                distance = getDistance(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]);
                if (distance < minDistance) {
                    minDistance = distance;
                    for (int a = 0; a < 3; a++) {
                        currentPoints[0][a] = points[i][a];
                        currentPoints[1][a] = points[j][a];
                    }
                }
            }
        }
        System.out.println("The closest two points are (" + currentPoints[0][0] + ", " + currentPoints[0][1] + ", " + currentPoints[0][2] + ") and (" + currentPoints[1][0] + ", " + currentPoints[1][1] + ", " + currentPoints[1][2] + ")");
    }
    public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }
}
