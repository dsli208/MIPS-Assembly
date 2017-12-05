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
public class PointPosition {
    public static void main(String args[]) {
        System.out.println("Enter three points (both x and y) for p_0, p_1, and p_2");
        Scanner input = new Scanner(System.in);
        double x0 = input.nextDouble(); double y0 = input.nextDouble(); double x1 = input.nextDouble(); double y1 = input.nextDouble(); double x2 = input.nextDouble(); double y2 = input.nextDouble();
        double location = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        if (location > 0)
            System.out.println("p2 is on the left side of the line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
        else if (location == 0)
            System.out.println("p2 is on the same line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
        else
            System.out.println("p2 is on the right side of the line from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    }
}
