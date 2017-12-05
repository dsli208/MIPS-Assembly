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
public class SortStudentsOnGrades {
    public static void main(String[] args) {
        char[][] answers = {{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                 {'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'}, {'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'}, 
                 {'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'}, {'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                 {'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}, {'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
                 {'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};
        char[] key = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
        int[][] stats = new int[answers.length][2];
        for (int i = 0; i < answers.length; i++) {
            stats[i][0] = (i + 1);
        }
        for (int i = 0; i < answers.length; i++) {
            int correctCount = 0;
            for (int j = 0; j < answers[i].length; j++) {
                if (answers[i][j] == key[j])
                    correctCount++;
            }
            stats[i][1] = correctCount;
        }
        boolean solved = false;
        while (solved == false) {
            boolean inOrder = true;
            for (int i = 0; i < answers.length - 1; i++) {
                if (stats[i][1] > stats[i + 1][1]) {
                    inOrder = false;
                    stats = swap(stats, i, i + 1);
                }
                if (inOrder == true)
                    solved = true;
            }
        }
        for (int i = 0; i < stats.length; i++) {
            for (int j = 0; j < stats[i].length; j++) {
                System.out.print(stats[i][j] + " ");
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
