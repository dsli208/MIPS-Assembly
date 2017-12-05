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
public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle(double radius) {
        super(radius);
    }
    
    @Override
    public int compareTo(ComparableCircle c) {
        if (getArea() < c.getArea())
            return -1;
        else if (getArea() > c.getArea())
            return 1;
        else
            return 0;
    }
    
    @Override
    public String toString() {
        return "The radius is " + getRadius() + " and the area is " + getArea();
    }
}
