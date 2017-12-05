/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class GreatCircleDistance {
    public static void main(String[] args) {
        final double radius = 6371.01;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = Math.toRadians(input.nextDouble()); double y1 = Math.toRadians(input.nextDouble());
        System.out.println("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = Math.toRadians(input.nextDouble()); double y2 = Math.toRadians(input.nextDouble());
        double d = radius * Math.acos(Math.sin((x1)) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
        System.out.println("The distance between the two points is " + d + " km");
    }
}
