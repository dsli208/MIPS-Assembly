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
public class MyPoint {
    double x = 0;
    double y = 0;
    public MyPoint() {}
    public MyPoint(double x0, double y0) {
        x = x0;
        y = y0;
    }
    public double distance(MyPoint i) {
        return Math.sqrt(Math.pow(i.x - x, 2) + Math.pow(i.y - y, 2));
    }
    
    public double distance(double x1, double y1) {
        return Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2));
    }
    
}
class testPoint {
    public static void main(String[] args) {
        MyPoint m1 = new MyPoint();
        MyPoint m2 = new MyPoint(10, 30.5);
        System.out.println(m1.distance(m2.x, m2.y));
        System.out.println(m1.distance(m2));
    }
}