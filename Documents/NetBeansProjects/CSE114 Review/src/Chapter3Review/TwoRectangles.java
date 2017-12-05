package Chapter3Review;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class TwoRectangles {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter r1's center x- and y- coordinates, width, and height");
        double r1x = input.nextDouble(); double r1y = input.nextDouble(); double r1w = input.nextDouble(); double r1h = input.nextDouble();
        System.out.println("Enter r2's center x- and y- coordinates, width, and height");
        double r2x = input.nextDouble(); double r2y = input.nextDouble(); double r2w = input.nextDouble(); double r2h = input.nextDouble();
        if ((r2y + r2h/2 <= r1y + r1h/2) && (r2y - r2h/2 >= r1y - r1h/2) && (r2x - r2w/2 >= r1x - r1w/2) && (r2x + r2w/2 <= r1x + r1w/2))
            System.out.println("r2 is inside r1");
        else if (((r2x - r2w/2 > r1x + r1w/2) || (r2x + r2w/2 < r1x - r1w/2)) && ((r2y + r2h/2 < r1y - r1h/2) || (r2y - r2h/2 > r1y + r1h/2)))
            System.out.println("r2 is outside r1");
        else
            System.out.println("r2 overlaps r1");
    }
}
