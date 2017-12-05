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
public class ShuffleRows {
    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        shuffle(m);
    }
    public static void shuffle(int[][] m) {
        int shuffles = m.length * 2;
        while (shuffles > 0) {
            int num1 = (int)(Math.random() * m.length);
            int num2 = (int)(Math.random() * m.length);
            int temp0 = m[num1][0];
            m[num1][0] = m[num2][0];
            m[num2][0] = temp0;
            int temp1 = m[num1][1];
            m[num1][1] = m[num2][1];
            m[num2][1] = temp1;
            shuffles--;
        }
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
