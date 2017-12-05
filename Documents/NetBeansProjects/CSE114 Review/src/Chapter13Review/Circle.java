/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

/**
 *
 * @author dsli
 */
public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius = 1;
    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    @Override
    public double getArea() {
        return (Math.PI * radius * radius);
    }
    
    @Override
    public double getPerimeter() {
        return (2 * Math.PI * radius);
    }
    
    @Override
    public int compareTo(Circle c) {
        if (c.getRadius() > getRadius())
            return 1;
        else if (c.getRadius() < getRadius())
            return -1;
        else
            return 0;
    }
    
    @Override
    public boolean equals(Object o1) {
        if (this.compareTo((Circle) o1) == 0)
            return true;//Only works with OBJECT class
        else
            return false;
    }
}
