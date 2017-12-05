/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class MyStack {
    private ArrayList<Object> list = new ArrayList<>();
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int getSize() {
        return list.size();
    }
    public Object peek() {
        return list.get(getSize() - 1);
    }
    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }
    public void push(Object o) {
        list.add(o);
    }
    
    public void reverse() {
        Collections.reverse(list);
    }
    
    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }
}
class CustomArrayStack extends MyStack {
    CustomArrayStack() {}
}

class TestStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter five strings: ");
        MyStack c = new CustomArrayStack();
        for (int i = 0; i < 5; i++) {
            c.push(input.nextLine());
        }
        c.reverse();
        System.out.println(c.toString());
    }
}