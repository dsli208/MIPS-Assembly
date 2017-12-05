/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Complex {
    private double a = 0;
    private double b = 0;
    public double getRealPart() {
        return a;
    }
    public double getImaginaryPart() {
        return b;
    }
    
    @Override
    public String toString() {
        return(a + " + " + b + "i");
    }
    
    public Complex() {}
    public Complex(double a) {
        this.a = a;
    }
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public Complex add(Complex c) {
        double real = a + c.a;
        double imaginary = b + c.b;
        return new Complex(real, imaginary);
    }
    
    public Complex subtract(Complex c) {
        double real = a - c.a;
        double imaginary = b - c.b;
        return new Complex(real, imaginary);
    }
    
    public Complex multiply(Complex c) {
        double real = a * c.a - b * c.b;
        double imaginary = b * c.a + a * c.b;
        return new Complex(real, imaginary);
    }
    
    public Complex divide(Complex c) {
        double real = (a * c.a + b * c.b) / (Math.pow(c.a, 2) + Math.pow(c.b, 2));
        double imaginary = (b * c.a - a * c.b) / (Math.pow(c.a, 2) + Math.pow(c.b, 2));
        return new Complex(real, imaginary);
    }
    
    public double absoluteValue() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
}

class testComplex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a1 = input.nextDouble(); double b1 = input.nextDouble();
        Complex complex1 = new Complex(a1, b1);
        System.out.print("Enter the second complex number: ");
        double a2 = input.nextDouble(); double b2 = input.nextDouble();
        Complex complex2 = new Complex(a2, b2);
        System.out.println("(" + complex1.toString() + ") + (" + complex2.toString() + ")" + " = " + complex1.add(complex2).toString());
        System.out.println("(" + complex1.toString() + ") - (" + complex2.toString() + ")" + " = " + complex1.subtract(complex2).toString());
        System.out.println("(" + complex1.toString() + ") * (" + complex2.toString() + ")" + " = " + complex1.multiply(complex2).toString());
        System.out.println("(" + complex1.toString() + ") / (" + complex2.toString() + ")" + " = " + complex1.divide(complex2).toString());
        System.out.println("|(" + complex1.toString() + ")| = " + complex1.absoluteValue());
    }
}