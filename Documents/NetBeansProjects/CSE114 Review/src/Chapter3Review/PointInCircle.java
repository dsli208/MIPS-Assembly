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
public class PointInCircle {
    public static void main(String args[]) {
        System.out.println("Enter coordinates of point");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt(); int y = input.nextInt();
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        if (distance <= 10)
            System.out.print("Point (" + x + ", " + y + ") is on the circle");
        else
            System.out.print("Point (" + x + ", " + y + ") is not on the circle");
    }
}
