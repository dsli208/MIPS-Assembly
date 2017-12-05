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
public class sort2DArray {
    public static void main(String[] args) {
        int[][] array = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};
        sort(array);
    }
    public static void sort(int[][] m) {
        boolean sorted = false;
        while (sorted == false) {
            boolean completelySorted = true;
            for (int i = 0; i < m.length - 1; i++) {
                if (m[i][0] > m[i + 1][0]) {
                    completelySorted = false;
                    m = swap(m, i, i + 1);
                }
                if (m[i][0] == m[i + 1][0] && m[i][1] > m[i + 1][1]) {
                    completelySorted = false;
                    m = swap(m, i, i + 1);
                }
            }
            if (completelySorted == true)
                sorted = true;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] swap(int[][] m, int i, int j) {
        int temp1 = m[i][1];
        m[i][1] = m[j][1];
        m[j][1] = temp1;
        int temp0 = m[i][0];
        m[i][0] = m[j][0];
        m[j][0] = temp0;
        return m;
    }
}
