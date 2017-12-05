/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
class GeometricObject {
    private String color = "white";
    boolean filled;
    private java.util.Date dateCreated;
    
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }
    public GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    
    public boolean isFilled() {return filled;}
    public java.util.Date getDateCreated() {return dateCreated;}
    public String toString() {
        return "created on" + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

class Triangle extends GeometricObject {
    private double side1 = 1; private double side2 = 1; private double side3 = 1;
    public Triangle() {}
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2; this.side3 = side3;
    }
    public double getSide1() {return side1;} public double getSide2() {return side2;} public double getSide3() {return side3;}
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return (s * (s - side1) * (s - side2) * (s - side3));
    }
    public double getPerimeter() {
        return (side1 + side2 + side3);
    }
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }
}
class testTriangle {
    public static void main(String[] args ) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side1, side2, and side3: ");
        double side1 = input.nextDouble(); double side2 = input.nextDouble(); double side3 = input.nextDouble();
        Triangle t = new Triangle(side1, side2, side3);
        String placeholder = input.nextLine();
        System.out.print("Enter the color: "); String color = input.nextLine();
        t.setColor(color);
        System.out.print("Fill triangle? Enter 'Y' for Yes, 'N' for No "); String fill = input.nextLine();
        if (fill.charAt(0) == 'Y')
            t.filled = true;
        else
            t.filled = false;
    }
}