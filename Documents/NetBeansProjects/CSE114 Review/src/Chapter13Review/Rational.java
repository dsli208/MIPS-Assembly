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
public class Rational extends Number implements Comparable<Rational> {
    private long[] fraction = new long[2];
    public Rational() { this(0, 1);}
    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        fraction[0] = numerator;
        fraction[1] = denominator;
    }
    //Get GCD
    private static long gcd(long n, long d) {
        long n1 = Math.abs(n);
        long n2 = Math.abs(d);
        int gcd = 1;
        
        for (int k = 1; k <= n1 && k <= n2; k++) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k;
        }
        return gcd;
    }
    //Getters for numerator/denominator
    public long getNumerator() {
        return fraction[0];
    }
    
    public long getDenominator() {
        return fraction[1];
    }
    //Add a rational number to this rational
    public Rational add(Rational secondRational) {
        long n = fraction[0] * secondRational.getDenominator() + fraction[1] * secondRational.getNumerator();
        long d = fraction[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    //Subtract
    public Rational subtract(Rational secondRational) {
        long n = fraction[0] * secondRational.getDenominator() - fraction[1] * secondRational.getNumerator();
        long d = fraction[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    //Multiply
    public Rational multiply(Rational secondRational) {
        long n = fraction[0] * secondRational.getNumerator();
        long d = fraction[1] * secondRational.getDenominator();
        return new Rational(n, d);
    }
    
    //Divide
    public Rational divide(Rational secondRational) {
        long n = fraction[0] * secondRational.getDenominator();
        long d = fraction[1] * secondRational.getNumerator();
        return new Rational(n, d);
    }
    
    @Override
    public String toString() {
        return fraction[0] + "/" + fraction[1];
    }
    
    @Override
    public boolean equals(Object o) {
        if ((this.subtract((Rational)(o))).getNumerator() == 0)
            return true;
        else
            return false;
    }
    
    @Override //Implement the abstract intValue method in Number
    public int intValue() {
        return (int)doubleValue();
    }
    
    @Override //Implement abstract floatValue method in Number
    public float floatValue() {
        return (float)doubleValue();
    }
    
    @Override //Implement doubleValue
    public double doubleValue() {
        return (double)doubleValue();
    }
    
    @Override //LongValue
    public long longValue() {
        return (long)longValue();
    }
    
    @Override //Implement the compareTo method
    public int compareTo(Rational r) {
        if (this.subtract(r).getNumerator() > 0)
            return 1;
        else if (this.subtract(r).getNumerator() < 0)
            return -1;
        else
            return 0;
    }
}
