package Chapter7Review;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class ReviseSelectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextDouble();
        }
        double[] sortedArray = selectionSort(array);
        for (int j = 0; j < sortedArray.length; j++) {
            System.out.print(sortedArray[j] + " ");
        }
    }
    
    public static double[] selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double currentMax = list[i];
            int currentMaxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMax < list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }
            
            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
        return list;
    }
}