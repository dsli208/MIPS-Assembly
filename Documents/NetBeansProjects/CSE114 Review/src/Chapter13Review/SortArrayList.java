/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dsli
 */
public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(76.236);
        list.add(2);
        list.add(Math.E);
        list.add(new BigInteger("609348904384893489034809340897"));
        sort(list);
    }
    public static void sort(ArrayList<Number> list) {
        boolean sorted = false;
        while (sorted == false) {
            boolean inOrder = true;
            for (int i = 0; i < list.size() - 1; i++) {
                Number first = list.get(i);
                Number second = list.get(i + 1);
                if (first.doubleValue() > second.doubleValue()) {
                    inOrder = false;
                    list.set(i, second);
                    list.set(i + 1, first);
                }
            }
            if (inOrder == true)
                sorted = true;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
