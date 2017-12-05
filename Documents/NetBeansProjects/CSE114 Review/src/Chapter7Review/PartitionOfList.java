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
public class PartitionOfList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter list: ");
        int length = input.nextInt();
        int[] list = new int[length]; 
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }
        final int pivot = list[0];
        int pivotIndex = partition(list);
        list = swap(list, 0, pivotIndex);
        System.out.println();
        for (int i = 0; i < pivotIndex; i++) {
            if (list[i] > pivot) {
                int j = pivotIndex + 1;
                boolean indexNotFound = true;
                while (indexNotFound) {
                    if (list[j] < pivot) {
                        indexNotFound = false;
                    }
                    else
                        j++;
                }
                list = swap(list, i, j);
            }
        }
        System.out.print("After the partition, the list is: ");
        for (int i = 0; i < length; i++) {
            System.out.print(list[i] + " ");
        }
    }
    
    public static int partition(int[] list) {
        int pivot = list[0];
        int pivotIndex = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < pivot) {
                pivotIndex++;
            }
        }
        return pivotIndex;
    }
    
    public static int[] swap(int[] list, int x, int y) {
        int temp = list[x];
        list[x] = list[y];
        list[y] = temp;
        return list;
    }
}
