/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class AreaOfPolygon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int n = input.nextInt();
        System.out.print("Enter the side length: ");
        double side = input.nextDouble();
        System.out.println("The area of the polygon is " + area(n, side));
    }
    
    public static double area(int n, double side) {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }
}
