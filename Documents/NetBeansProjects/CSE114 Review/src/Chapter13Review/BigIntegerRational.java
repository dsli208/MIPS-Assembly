/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.math.BigInteger;

/**
 *
 * @author dsli
 */
public class BigIntegerRational extends Number {
    private BigInteger numerator;
    private BigInteger denominator;
    public BigIntegerRational(String n, String d) {
        numerator = new BigInteger(n);
        denominator = new BigInteger(d);
        BigInteger gcd = numerator.gcd(denominator);
    }
    public BigIntegerRational(BigInteger n, BigInteger d) {
        numerator = n;
        denominator = d;
    }
    public BigIntegerRational() {
        numerator = new BigInteger("0");
        denominator = BigInteger.ONE;
    }
    
    public BigInteger getNumerator() {
        return numerator;
    }
    public BigInteger getDenominator() {
        return denominator;
    }
    public BigIntegerRational add(BigIntegerRational b) {
        BigInteger n = numerator.multiply(b.getDenominator()).add(b.getNumerator().multiply(denominator));
        BigInteger d = denominator.multiply(b.getDenominator());
        return new BigIntegerRational(n, d);
    }
    
    public BigIntegerRational subtract(BigIntegerRational b) {
        BigInteger n = numerator.multiply(b.getDenominator()).subtract(b.getNumerator().multiply(denominator));
        BigInteger d = denominator.multiply(b.getDenominator());
        return new BigIntegerRational(n, d);
    }
    public BigIntegerRational multiply(BigIntegerRational b) {
        BigInteger n = numerator.multiply(b.getNumerator());
        BigInteger d = denominator.multiply(b.getDenominator());
        return new BigIntegerRational(n, d);
    }
    public BigIntegerRational divide(BigIntegerRational b) {
        BigInteger n = numerator.multiply(b.getDenominator());
        BigInteger d = denominator.multiply(b.getNumerator());
        return new BigIntegerRational(n, d);
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    @Override
    public int intValue() {
        return (int)doubleValue();
    }
    
    @Override
    public double doubleValue() {
        return doubleValue();
    }
    
    @Override
    public long longValue() {
        return longValue();
    }
    
    @Override
    public float floatValue() {
        return floatValue();
    }
    
}
