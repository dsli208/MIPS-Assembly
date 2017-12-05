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
public class Rectangle extends GeometricObject implements Comparable<Rectangle> {
    private double width = 1; private double height = 1;
    public Rectangle() {}
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return (width * height);
    }
    
    @Override
    public double getPerimeter() {
        return (2 * width + 2 * height);
    }
    
    @Override
    public int compareTo(Rectangle r) {
        if (r.getArea() > getArea())
            return 1;
        else if (r.getArea() < getArea())
            return -1;
        else
            return 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this.compareTo((Rectangle) o) == 0)
            return true;
        else
            return false;
    }
}
