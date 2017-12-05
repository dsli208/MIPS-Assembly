/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class PrimeFactorsStackOfIntegers {
    int size = 16;
    int[] elements = new int[size];
    public PrimeFactorsStackOfIntegers() {}
    public PrimeFactorsStackOfIntegers(int i) {
        size = i;
    }
    public boolean empty() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != 0)
                return false;
        }
        return true;
    }
    public int peek() {
        return elements[elements.length - 1];
    }
    
    public int pop() {
        int i = elements[elements.length - 1];
        elements[elements.length - 1] = 0;
        return i;
    }
    public int getSize() {
        int size = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i] != 0)
                size++;
        }
        return size;
    }
}
class testPrimeFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrimeFactorsStackOfIntegers p = new PrimeFactorsStackOfIntegers();
        System.out.println("Enter an integer: ");
        int n = input.nextInt();
        int i = 2;
        int j = 0;
        while (i < n) {
            if (n % i == 0) {
                boolean completelyFactored = false;
                int t = n / i;
                int r = 2;
                while (completelyFactored == false) {
                    boolean isPrime = true;
                    if (t % r == 0) {
                        isPrime = false;
                        t = t / r;
                    }
                    r++;
                    if (isPrime == true) {
                        completelyFactored = true;
                        p.elements[j] = t;
                        j++;
                    }
                }
            }
            i++;
        }
        for (int b = 0; b < p.elements.length - 2; b++) {
            if (p.elements[b] < p.elements[b + 1]) {
                int temp = p.elements[b];
                p.elements[b] = p.elements[b + 1];
                p.elements[b + 1] = temp;
            }
        }
        for (int a = 0; a < p.elements.length - 1; a++) {
            if (p.elements[a] > 1)
                System.out.print(p.elements[a] + " ");
        }
    }
}