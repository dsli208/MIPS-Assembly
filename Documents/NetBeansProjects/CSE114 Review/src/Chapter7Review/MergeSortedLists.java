/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class MergeSortedLists {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list1: ");
        int list1Length = input.nextInt();
        int[] list1 = new int[list1Length];
        for (int i = 0; i < list1Length; i++) {
            list1[i] = input.nextInt();
        }
        list1 = sortList(list1);
        System.out.print("Enter list2: ");
        int list2Length = input.nextInt();
        int[] list2 = new int[list2Length];
        for (int i = 0; i < list2Length; i++) {
            list2[i] = input.nextInt();
        }
        list2 = sortList(list2);
        int[] combinedList = new int[list1Length + list2Length];
        for (int i = 0; i < list1.length; i++) {
            combinedList[i] = list1[i];
        }
        for (int i = 0; i < list2.length; i++) {
            combinedList[list1Length + i] = list2[i];
        }
        combinedList = sortList(combinedList);
        System.out.print("The merged list is: ");
        for (int i = 0; i < combinedList.length; i++) {
            System.out.print(combinedList[i] + " ");
        }
    }
    public static int[] sortList(int[] i) {
        boolean unsorted = true;
        while (unsorted) {
            boolean completelySorted = true;
            for (int x = 0; x < i.length - 1; x++) {
                if (i[x] > i[x + 1]) {
                    completelySorted = false;
                    int temp = i[x];
                    i[x] = i[x + 1];
                    i[x + 1] = temp;
                }
            }
            if (completelySorted == true)
                unsorted = false;
        }
        return i;
    }
}
