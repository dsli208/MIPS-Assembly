/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Location {
    public int row = 0;
    public int column = 0;
    public double maxValue = 0;
    public Location() {}
    public Location(int r, int c, double m) {
        row = r; column = c; maxValue = m;
    }
    public static Location locateLargest(double[][] a) {
        double max = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        
        return new Location(row, col, max);
    }
}
class testLocation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int rows = input.nextInt(); int columns = input.nextInt();
        double[][] array = new double[rows][columns];
        System.out.println("Enter the array:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextDouble();
            }
        }
        Location l = Location.locateLargest(array);
        System.out.println("The location of the largest element is " + l.maxValue + " at (" + l.row + ", " + l.column + ")");
    }
    /*public static Location locateLargest(double[][] a) {
        double max = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        
        return new Location(row, col, max);
    }*/
}
