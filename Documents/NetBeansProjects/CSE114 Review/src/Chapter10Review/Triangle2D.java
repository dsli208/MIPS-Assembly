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
public class Triangle2D {
    public MyPoint p1 = new MyPoint(0, 0);
    public MyPoint p2 = new MyPoint(1, 1);
    public MyPoint p3 = new MyPoint(2, 5);
    public Triangle2D() {}
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = new MyPoint(p1.x, p1.y);
        this.p2 = new MyPoint(p2.x, p2.y);
        this.p3 = new MyPoint(p3.x, p3.y);
    }
    public double getArea() {
        double s = (Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)) + Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)) + Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2))) / 2;
        double area = Math.sqrt(s * (s - Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2))) * (s - Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2))));
        return area;
    }
    public boolean contains(MyPoint p) {
        double s = 1 / (2 * getArea()) * (p1.y * p3.x - p1.x * p3.y + (p3.y - p1.y) * p.x + (p1.x - p3.x) * p.y);
        double t = 1 / (2 * getArea()) * (p1.x * p2.y - p1.y * p2.x + (p1.y - p2.y) * p.x + (p2.x - p1.x) * p.y);
        if (s <= 0 || t <= 0 || (1 - s - t) <= 0)
            return false;
        return true;
    }
    public boolean contains(Triangle2D t) {
        boolean fits = (t.getArea() < getArea());
        if (contains(t.p3) == true && contains(t.p2) == true && contains(t.p1) == true && fits == true)
            return true;
        return false;
    }
    public boolean overlaps(Triangle2D t) {
        if (contains(t.p3) == true || contains(t.p2) == true || contains(t.p1) == true || contains(p1) == true || contains(p2) == true || contains(p3) == true)
            return true;
        else
            return false;
    }
    public double getPerimeter() {
        return (Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)) + Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)) + Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)));
    }
}
class testTriangle {
    public static void main(String[] args) {
        Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
        System.out.println(t1.getArea());
        System.out.println(t1.getPerimeter());
        System.out.println(t1.contains(new MyPoint(3, 3)));
        System.out.println(t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
        System.out.println(t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));
    }
}