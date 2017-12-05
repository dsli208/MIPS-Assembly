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
public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            integers.add(input.nextInt());
        }
        Collections.sort(integers);
        System.out.println(integers.toString());
    }
}
