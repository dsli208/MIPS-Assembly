/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Vertex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a, b, and c: ");
        double a = input.nextDouble(); double b = input.nextDouble(); double c = input.nextDouble();
        getCenter(a, b, c);
    }
    public static void getCenter(double a, double b, double c) {
        double h = b / (-2 * a);
        double k = c - Math.pow(h, 2);
        System.out.println("h is " + h + " and k is " + k);
    }
}
