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
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.print("Enter ten integers: ");
        for (int i = 0; i < 10; i++) {
            integers.add(input.nextInt());
        }
        removeDuplicate(integers);
    }
    public static void removeDuplicate(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j))
                    list.remove(j);
            }
        }
        System.out.println("The distinct integers are " + list.toString());
    }
}
