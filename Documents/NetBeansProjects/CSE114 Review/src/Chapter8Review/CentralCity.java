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
public class CentralCity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of cities: ");
        int n = input.nextInt();
        double[][] cityCoordinates = new double[n][2];
        double totalDistance = 0;
        System.out.print("Enter the coordinates of the cities: ");
        for (int i = 0; i < cityCoordinates.length; i++) {
            for (int j = 0; j < cityCoordinates[i].length; j++) {
                cityCoordinates[i][j] = input.nextDouble();
                totalDistance += cityCoordinates[i][j];
            }
        }
        totalDistance *= 1000;
        double centralX = 0; double centralY = 0;
        for (int i = 0; i < cityCoordinates.length; i++) {
            double distance = 0;
            double x = cityCoordinates[i][0];
            double y = cityCoordinates[i][1];
            for (int j = 0; j < cityCoordinates.length; j++) {
                distance += Math.sqrt(Math.pow(cityCoordinates[j][1] - y, 2) + Math.pow(cityCoordinates[j][0] - x, 2));
            }
            if (distance < totalDistance) {
                totalDistance = distance;
                centralX = x;
                centralY = y;
            }
        }
        System.out.println("The total distance to all other cities is " + totalDistance);
        System.out.println("The central city is at (" + centralX + ", " + centralY + ")");
    }
}
