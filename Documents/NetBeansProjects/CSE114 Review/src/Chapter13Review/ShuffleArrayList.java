/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ShuffleArrayList {
    public static void main(String[] args) {
        ArrayList<Number> numberList = new ArrayList<>();
        numberList.add(445);
        numberList.add(45.30);
        numberList.add(new BigInteger("3465346794959392930260293"));
        numberList.add(new BigDecimal("5.29483298509239340238094308923"));
        numberList.add(85468658);
        numberList.add(Math.PI);
        shuffle(numberList);
    }
    
    public static void shuffle(ArrayList<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            int n = (int)(Math.random() * list.size());
            Number temp = list.get(i);
            list.set(i, list.get(n));
            list.set(n, temp);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
