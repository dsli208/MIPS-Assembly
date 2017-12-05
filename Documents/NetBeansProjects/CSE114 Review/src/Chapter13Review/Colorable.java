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
public interface Colorable {
    //List abstract strings below, for this example it's howToColor() - you are not implementing so they end with semicolons as if they are statements!
    public abstract String howToColor();
}

class Square extends GeometricObject implements Colorable {
    private double side = 1;
    @Override
    public String howToColor() {
        return "Color all four sides";
    }
    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }
    @Override
    public double getPerimeter() {
        return side * 4;
    }
    
    public Square() {}
    public Square(double side) {
        this.side = side;
    }
}

class testColorable {
    public static void main(String[] args) {
        Square s = new Square();
        System.out.println(s.howToColor());
    }
}