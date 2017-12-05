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
public class LargestRowColumn {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int)(Math.random() * 2);
            }
        }
        int rowIndex = -1;
        
        int maxRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowCount = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (matrix[i][j] == 1)
                    rowCount++;
            }
            if (rowCount > maxRowCount) {
                maxRowCount = rowCount;
                rowIndex = i;
            }
            System.out.println();
        }
        int columnIndex = -1;
        int maxColumnCount = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int columnCount = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1)
                    columnCount++;
            }
            if (columnCount > maxColumnCount) {
                maxColumnCount = columnCount;
                columnIndex = i;
            }
        }
        System.out.println("The largest row index: " + rowIndex);
        System.out.println("The largest column index: " + columnIndex);
    }
}
