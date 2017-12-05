
import static Chapter8Review.PointsNearestEachOther.getDistance;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class TestPointDistances {
    public static void main(String[] args) {
        double[][] points = {{-1, 0, 3}, {-1, -1, -1}, {4, 1, 1}, {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2}, {5.5, 4, -0.5}};
        
        
        for (int i = 0; i < points.length - 1; i++) {
            
            for (int j = i + 1; j < points.length; j++) {
                
                System.out.printf("%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.4f\n", points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2], getDistance(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1], points[j][2]));
                }
            }
        }
    public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }
}
