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
public class Queue {
    public int size = 8;
    public int[] elements = new int[size];
    public Queue() {}
    public int j = 0;
    public void enqueue(int v) {
        elements[j] = v;
        j++;
        if (j == elements.length) {
            int[] elementsCopy = new int[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                elementsCopy[i] = elements[i];
            }
            elements = elementsCopy;
        }
    }
    public int dequeue() {
        int elementToReturn = elements[0];
        j--;
        for (int i = 0; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        return elementToReturn;
    }
    public boolean empty() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != 0)
                return false;
        }
        return true;
    }
    public int getSize() {
        return elements.length;
    }
}
class testQueue {
    public static void main(String[] args) {
        Queue q = new Queue();
        for (int i = 0; i < 20; i++)
            q.enqueue((int)(Math.random() * 20 + 1));
        for (int i = 0; i < 20; i++) {
            System.out.println(q.dequeue());
        }
    }
}