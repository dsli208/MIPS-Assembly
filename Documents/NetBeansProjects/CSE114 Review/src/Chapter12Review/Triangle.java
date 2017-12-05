/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

/**
 *
 * @author dsli
 */
public class Triangle {
    double side1; double side2; double side3;
    public Triangle() throws IllegalTriangleException{
        this(1.0, 1.0, 1.0);
    }
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 > side3) {
            this.side1 = side1;
            this.side2 = side2; this.side3 = side3;
        }
        else
            throw new IllegalTriangleException(side1, side2, side3);
    }
    /*public void setSide1(double side1) {
        this.side1 = side1;
    }*/
    public double getSide1() {
        return side1;
    }
    /*public void setSide2(double side2) {
        this.side2 = side2;
    }*/
    public double getSide2() {
        return side2;
    }
    /*public void setSide3(double side3) {
        this.side3 = side3;
    }*/
    public double getSide3() {
        return side3;
    }
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return (s * (s - side1) * (s - side2) * (s - side3));
    }
    public double getPerimeter() {
        return (side1 + side2 + side3);
    }
}
class IllegalTriangleException extends Exception {
    private double side1; private double side2; private double side3;
    
    public IllegalTriangleException(double side1, double side2, double side3) {
        super("Invalid combination of sides: " + side1 + " " + side2 + " " + side3);
        this.side1 = side1; this.side2 = side2; this.side3 = side3;
    }
    
    public double getFirstTwoSides() {
        return (side1 + side2);
    }
    public double getThirdSide() {
        return side3;
    }
}

class TestTriangleWithException {
    public static void main(String[] args) {
        try {
            new Triangle();
            new Triangle(3, 4, 5);
            
            new Triangle(1, 2, 7);
            new Triangle(1, 2, 5);
        }
        catch (IllegalTriangleException e) {
            System.out.println(e);
        }
        System.out.println("Number of objects created: ");
    }
}