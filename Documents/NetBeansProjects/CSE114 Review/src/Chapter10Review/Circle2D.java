/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

/**
 *
 * @author dsli
 */
public class Circle2D {
    public double x = 0;
    public double y = 0;
    public double radius = 1;
    public Circle2D() {}
    public Circle2D(double x0, double y0, double newRadius) {
        radius = newRadius;
        x = x0;
        y = y0;
    }
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }
    public boolean contains(double xp, double yp) {
        double d = Math.sqrt(Math.pow(xp - x, 2) + Math.pow(yp - y, 2));
        return (d < radius);
    }
    public boolean contains(Circle2D c) {
        double d = Math.sqrt(Math.pow(c.x - x, 2) + Math.pow(c.y - y, 2));
        return (d < radius);
    }
    public boolean overlaps(Circle2D c) {
        double d = Math.sqrt(Math.pow(c.x - x, 2) + Math.pow(c.y - y, 2));
        return (d < (radius + c.radius));
    }
}
class testCircle {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println("The circle c1 has an area of " + c1.getArea() + " and a perimeter of " + c1.getPerimeter());
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5))); System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
}