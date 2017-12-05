/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CombineLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.print("Enter 5 integers for list1: ");
        for (int i = 0; i < 5; i++) {list1.add(input.nextInt());}
        System.out.print("Enter 5 integers for list2: "); for (int i = 0; i < 5; i++) {list2.add(input.nextInt());}
        ArrayList<Integer> combined = union(list1, list2);
        System.out.println(combined.toString());
    }
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> combined = new ArrayList<>(list1);
        combined.addAll(list2);
        return combined;
    }
}
