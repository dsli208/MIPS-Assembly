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
public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);
        double a1 = rectangle1.getArea(); double p1 = rectangle1.getPerimeter();
        double a2 = rectangle1.getArea(); double p2 = rectangle2.getPerimeter();
        System.out.println("The width of rectangle 1 is " + rectangle1.width + ", the height of rectangle 1 is " + rectangle1.height + ", the perimeter of rectangle 1 is " + p1 + " and the area of rectangle 1 is " + p1);
        System.out.println("The width of rectangle 2 is " + rectangle2.width + ", the height of rectangle 2 is " + rectangle2.height + ", the perimeter of rectangle 2 is " + p2 + " and the area of rectangle 1 is " + p2);
    }
}
