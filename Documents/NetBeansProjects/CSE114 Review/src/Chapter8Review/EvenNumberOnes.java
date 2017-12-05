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
public class EvenNumberOnes {
    public static void main(String[] args) {
        int[][] matrix = new int[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 2);
            }
        }
        int evenRows = 0;
        int evenColumns = 0;
        for (int i = 0; i < matrix.length; i++) {
            int onesInRow = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    onesInRow++;
            }
            if (onesInRow % 2 == 0)
                evenRows++;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int onesInColumn = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1)
                    onesInColumn++;
            }
            if (onesInColumn % 2 == 0)
                evenColumns++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                
            }
            System.out.println();
        }
        if (evenRows == matrix.length)
            System.out.println("All rows have an even amount of 1's.");
        else
            System.out.println(evenRows + " rows have an even amount of 1's.");
        
        if (evenColumns == matrix[0].length)
            System.out.println("All columns have an even amount of 1's.");
        else
            System.out.println(evenColumns + " columns have an even amount of 1's.");
    }
}
