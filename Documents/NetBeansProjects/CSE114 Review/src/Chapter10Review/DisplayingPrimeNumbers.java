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
public class DisplayingPrimeNumbers {
    int j = 0;
    int size = 16;
    int[] elements = new int[size];
    public DisplayingPrimeNumbers() {}
    public DisplayingPrimeNumbers(int i) {
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
    public void push(int i) {
        elements[j] = i;
        j++;
        if (j == elements.length) {
            int[] elements2 = new int[elements.length * 2];
            for (int k = 0; k < elements.length; k++) {
                elements2[k] = elements[k];
            }
            elements = elements2;
        }
        
    }
}
class DisplayPrimeNumbers {
    public static void main(String[] args) {
        DisplayingPrimeNumbers d = new DisplayingPrimeNumbers();
        int testInt = 120;
        for (int i = 3; i < testInt; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    isPrime = false;
            }
            if (isPrime == true) {
                System.out.println(i);
                d.push(i);
            }
        }
        boolean unsorted = true;
        while (unsorted) {
            boolean inOrder = true;
            for (int i = 1; i < d.elements.length; i++) {
                if (d.elements[i] > d.elements[i - 1]) {
                    inOrder = false;
                    int temp = d.elements[i];
                    d.elements[i] = d.elements[i - 1];
                    d.elements[i -1] = temp;
                }
            }
            if (inOrder == true)
                unsorted = false;
        }
        for (int i = 0; i < d.elements.length; i++) {
            System.out.print(d.elements[i] + " ");
        }
    }
}