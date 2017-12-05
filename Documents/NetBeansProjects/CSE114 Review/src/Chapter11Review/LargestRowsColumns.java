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
public class LargestRowsColumns {
    
    public static void main(String[] args) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int most1sInRow = 0;
        int most1sInColumn = 0;
        System.out.print("Enter the array size n: ");
        int n = input.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int)(Math.random() * 2);
            }
        }
        for (int i = 0; i < array.length; i++) {
            int consecutive = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1)
                    consecutive++;
            }
            if (consecutive > most1sInRow) {
                most1sInRow = consecutive;
                rows.clear();
                rows.add(i);
            }
            else if (consecutive == most1sInRow) {
                rows.add(i);
            }
        }
        for (int i = 0; i < array[0].length; i++) {
            int consecutive = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j][i] == 1)
                    consecutive++;
            }
            if (consecutive > most1sInColumn) {
                most1sInColumn = consecutive;
                columns.clear();
                columns.add(i);
            }
            else if (consecutive == most1sInColumn) {
                columns.add(i);
            }
        }
        System.out.println("The random array is:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("The largest row index: ");
        for (int i = 0; i < rows.size(); i++) {
            System.out.print(rows.get(i) + " ");
        }
        System.out.println();
        System.out.print("The largest column index: ");
        for (int i = 0; i < columns.size(); i++) {
            System.out.print(columns.get(i) + " ");
        }
    }
}
