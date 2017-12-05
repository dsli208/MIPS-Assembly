/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class PointInTriangle {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter x and y");
        double x = input.nextDouble(); double y = input.nextDouble();
        double heightAtX = (-0.5 * x) + 100;
        if (heightAtX >= y)
            System.out.println("The point is in the triangle.");
        else
            System.out.println("The point is not in the triangle.");
    }
}
