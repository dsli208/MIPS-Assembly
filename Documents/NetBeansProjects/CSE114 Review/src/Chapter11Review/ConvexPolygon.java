/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ConvexPolygon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numOfPoints = input.nextInt();
        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        System.out.println("Enter " + numOfPoints + " points (x first then y): "); 
        for (int i = 0; i < numOfPoints; i++) {
            x.add(input.nextDouble());
            y.add(input.nextDouble());
        }
    }
}
