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
public class MyInteger {
    int value;
    MyInteger(int i) {
        value = i;
    }
    int getValue() {
        return value;
    }
    boolean isEven() {
        if (value % 2 == 0)
            return true;
        else
            return false;
    }
    boolean isOdd() {
        if (value % 2 != 0)
            return true;
        else
            return false;
    }
    boolean isPrime() {
        for (int i = 2; i < value; i++) {
            if (value % i == 0)
                return false;
            
        }
        return true;
    }
    static boolean isEven(int i) {
        if (i % 2 == 0)
            return true;
        else
            return false;
    }
    
    static boolean isOdd(int i) {
        if (i % 2 != 0)
            return true;
        else
            return false;    
    }
    static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }
    static boolean isEven(MyInteger i) {
        if (i.value % 2 == 0)
            return true;
        else
            return false;
    }
    static boolean isOdd(MyInteger i) {
        if (i.value % 2 != 0)
            return true;
        else
            return false;
    }
    static boolean isPrime(MyInteger i) {
        for (int j = 2; j < i.value; j++) {
            if (i.value % j == 0)
                return false;
        }
        return true;
    }
    boolean equals(int i) {
        if (i == value)
            return true;
        else
            return false;
    }
    boolean equals(MyInteger i) {
        if (i.value == value)
            return true;
        else
            return false;
    }
    static int parseInt(char[] c) {
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum = sum * 10 + (int)(c[i] - 48);
        }
        return sum;
    }
    static int parseString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 10 + (int)(s.charAt(i) - 48);
        }
        return sum;
    }
}
class testInteger {
    public static void main(String[] args) {
        MyInteger i1 = new MyInteger(6);
        System.out.println(i1.getValue());
        System.out.println(i1.isEven()); System.out.println(i1.isOdd()); System.out.println(i1.isPrime());
        System.out.println(MyInteger.isEven(4)); System.out.println(MyInteger.isOdd(4)); System.out.println(MyInteger.isPrime(4));
        MyInteger i2 = new MyInteger(11);
        System.out.println(i2.value);
        System.out.println(MyInteger.isEven(i2)); System.out.println(MyInteger.isOdd(i2)); System.out.println(MyInteger.isPrime(i2));
        System.out.println(MyInteger.parseString("1234"));
        char[] numbers = {'1', '2', '3', '4'};
        System.out.println(MyInteger.parseInt(numbers));
    }
}