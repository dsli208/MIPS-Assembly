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
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    private double side = 1;
    public Octagon() {}
    public Octagon(double side) {this.side = side;}
    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }
    public double getArea() {
        return (2 + 4 * Math.sqrt(2)) * side * side;
    }
    
    public double getPerimeter() {
        return (8 * side);
    }
    
    @Override
    public int compareTo(Octagon o) {
        if (o.getArea() > getArea())
            return 1;
        else if (o.getArea() < getArea())
            return -1;
        else
            return 0;
    }
    //Override the clone method to implement cloneable interface
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
