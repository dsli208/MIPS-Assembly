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
public class Triangle extends GeometricObject {
    double side1 = 1; double side2 = 1; double side3 = 1;
    public Triangle() {}
    public Triangle(String color, boolean filled, double side1, double side2, double side3) {
        super(color, filled);
        this.side1 = side1; this.side2 = side2; this.side3 = side3;
    }
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double getPerimeter() {
        return (side1 + side2 + side3);
    }
    
    
    @Override
    public String toString() {
        return "The triangle has sides of lengths " + side1 + ", " + side2 + ", and " + side3 + ".  The area is " + getArea() + " and the perimeter is " + getPerimeter() + ".  The triangle is " + getColor() + " and the value of isFilled() is " + isFilled(); 
    }
    
}
class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of side1: ");
        double side1 = input.nextDouble();
        System.out.print("Enter the length of side2: ");
        double side2 = input.nextDouble();
        System.out.print("Enter the length of side3: ");
        double side3 = input.nextDouble();
        System.out.print("Enter the color of the triangle: ");
        String placeholder = input.nextLine();
        String color = input.nextLine();
        boolean filled = false;
        System.out.println("Enter Y or N.  Do you want the triangle filled? ");
        String toFillOrNot = input.nextLine();
        if (toFillOrNot.charAt(0) == 'Y')
            filled = true;
        Triangle t = new Triangle(color, filled, side1, side2, side3);
        System.out.println(t.toString());
    }
}