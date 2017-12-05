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
public class SumGeometricObjects {
    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i].getArea();
        }
        return sum;
    }
    public static void main(String[] args) {
        GeometricObject[] objects = {new Circle(5), new Circle(8.9), new Rectangle(2, 5), new Rectangle(5, 6)};
        System.out.println("The sum of the areas of these objects is " + sumArea(objects));
    }
}
