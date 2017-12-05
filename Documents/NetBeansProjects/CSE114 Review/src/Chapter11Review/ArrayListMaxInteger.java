/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author dsli
 */
public class ArrayListMaxInteger {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        boolean activeInput = true; //condition for maintaining the below while loop
        System.out.print("Enter numbers: ");
        while (activeInput) {
            if (input.nextInt() == 0)
                activeInput = false;
            else
                list.add(input.nextInt());
        }
        int max = max(list);
        System.out.println("The maximum element is " + max);
    }
    
    public static Integer max(ArrayList<Integer> list) {
        Integer max = 0;
        Collections.sort(list);
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max)
                max = list.get(i);
        }*/
        max = list.get(list.size() - 1);
        return max;
    }
}
