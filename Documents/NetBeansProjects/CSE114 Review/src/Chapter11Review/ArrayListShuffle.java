/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dsli
 */
public class ArrayListShuffle {
    public static void main(String[] args) {
        ArrayList<Integer> shuffleList = new ArrayList<>();
        shuffleList.add(9);
        shuffleList.add(2);
        shuffleList.add(6);
        shuffleList.add(7);
        shuffleList.add(3);
        shuffle(shuffleList);
    }
    
    public static void shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}