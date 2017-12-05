/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

/**
 *
 * @author dsli
 */
public class Polygon {
    private int n = 3; private double side = 1; private double x = 0; private double y = 0;
    public Polygon() {}
    public Polygon(int nSides, double s) {
        n = nSides;
        side = s;
    }
    public Polygon(int nSides, double s, double x0, double y0) {
        n = nSides;
        side = s;
        x = x0; y = y0;
    }
    public void setSides(int sides) {
        n = sides;
    }
    public void setSideLength(double l) {
        side = l;
    }
    public void setX(double x0) {
        x = x0;
    }
    public void setY(double y0) {
        y = y0;
    }
    public int getNumberOfSides() {
        return n;
    }
    public double getSideLength() {
        return side;
    }
    public double getxCoordinate() {
        return x;
    }
    public double getyCoordinate() {
        return y;
    }
    public double getPerimeter() {
        return (side * n);
    }
    public double getArea() {
        return (n * side * side) / (4 * Math.tan(Math.PI / n));
    }
}

class testPolygon {
    public static void main(String[] args) {
        Polygon p1 = new Polygon();
        Polygon p2 = new Polygon(6, 4);
        Polygon p3 = new Polygon(10, 4, 5.6, 7.8);
        System.out.println("The area of the first polygon is " + p1.getArea() + " and the perimeter is " + p1.getPerimeter());
        System.out.println("The area of the second polygon is " + p2.getArea() + " and the perimeter is " + p2.getPerimeter());
        System.out.println("The area of the third polygon is " + p3.getArea() + " and the perimeter is " + p3.getPerimeter());
    }
}
