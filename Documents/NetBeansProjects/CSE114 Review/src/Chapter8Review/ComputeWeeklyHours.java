/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

/**
 *
 * @author dsli
 */
public class ComputeWeeklyHours {
    public static void main(String[] args) {
        int[][] workHours = {{2, 4, 3, 4, 5, 8, 8}, {7, 3, 4, 3, 3, 4, 4}, {3, 3, 4, 3, 3, 2, 2}, {9, 3, 4, 7, 3, 4, 1}, {3, 5, 4, 3, 6, 3, 8},
            {3, 4, 4, 6, 3, 4, 4}, {3, 7, 4, 8, 3, 8, 4}, {6, 3, 5, 9, 2, 7, 9}};
        int[][] totalHours = new int[workHours.length][2];
        for (int i = 0; i < workHours.length; i++) {
            totalHours[i][0] = i;
            int sum = 0;
            for (int j = 0; j < workHours[i].length; j++) {
                sum += workHours[i][j];
            }
            totalHours[i][1] = sum;
        }
        boolean unsorted = true;
        while (unsorted) {
            boolean inOrder = true;
            for (int i = 0; i < totalHours.length - 1; i++) {
                if (totalHours[i][1] > totalHours[i + 1][1]) {
                    inOrder = false;
                    totalHours = swap(totalHours, i, i + 1);
                }
            }
            if (inOrder == true)
                unsorted = false;
        }
        for (int i = 0; i < totalHours.length; i++) {
            for (int j = 0; j < totalHours[i].length; j++) {
                System.out.print(totalHours[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] swap(int[][] n, int i, int j) {
        int temp1 = n[i][1];
        n[i][1] = n[j][1];
        n[j][1] = temp1;
        int temp0 = n[i][0];
        n[i][0] = n[j][0];
        n[j][0] = temp0;
        return n;
    }
}
