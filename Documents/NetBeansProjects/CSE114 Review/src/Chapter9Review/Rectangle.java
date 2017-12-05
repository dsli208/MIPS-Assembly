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
public class Rectangle {
    public double width = 1;
    public double height = 1;
    public Rectangle() {}
    public Rectangle(double newWidth, double newHeight) {
        width = newWidth;
        height = newHeight;
    }
    public double getArea() {
        return (width * height);
    }
    
    public double getPerimeter() {
        return (2 * width + 2 * height);
    }
}
