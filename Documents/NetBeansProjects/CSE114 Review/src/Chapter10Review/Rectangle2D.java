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
public class Rectangle2D {
    public double x = 0; public double y = 0; public double width = 1; public double height = 1;
    public Rectangle2D() {}
    public Rectangle2D(double x, double y, double width, double height) {
        this.height = height;
        this.width = width;
        this.y = y;
        this.x = x;
    }
    public void setHeight(double height) { this.height = height; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() {return height;} public double getWidth() {return width;}
    public double getArea() {return height * width;} public double getPerimeter() {return (2 * height + 2 * width); }
    public boolean contains(double x, double y) {
        boolean xInside = (Math.abs(x - this.x) < width);
        boolean yInside = (Math.abs(y - this.y) < height);
        if (xInside == true && yInside == true)
            return true;
        return false;
    }
    public boolean contains(Rectangle2D r) {
        boolean fits = (r.getArea() < getArea());
        if (r.x + r.width / 2 < x + width / 2 && r.y + r.width / 2 < y + height / 2)
            return true;
        return false;
    }
    public boolean overlaps(Rectangle2D r) {
        if (r.x + r.width / 2 > x - width / 2)
            return true;
        else if (r.x - r.width / 2 < x + width / 2)
            return true;
        else if (r.y + r.height / 2 > y - height / 2)
            return true;
        else if (r.y - r.height / 2 < y + height / 2)
            return true;
        else
            return false;
    }
    
}
class testRectangle {
    public static void main(String[] args) {
        Rectangle2D r1 = new Rectangle2D(2, 2, 5.5, 4.9);
        System.out.println(r1.contains(3, 3));
        System.out.println(r1.contains(new Rectangle2D(4, 5, 10.5, 3.2)));
        System.out.println(r1.overlaps(new Rectangle2D(3, 5, 2.3, 5.4)));
    }
}