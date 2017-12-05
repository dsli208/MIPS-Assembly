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
public class PentagonPointCoordinates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter radius of the bounding circle: ");
        double r = input.nextDouble();
        double angle = 0;
        System.out.println("The coordinates of the five points are: ");
        for (int i = 0; i < 5; i++) {
            System.out.println("Point " + (i + 1) + ": " + r * Math.sin(angle) + ", " + r * Math.cos(angle));
            angle = angle + 2 * (Math.PI) / 5;
        }
    }
}
