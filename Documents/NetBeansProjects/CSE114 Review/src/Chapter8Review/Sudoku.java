/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Sudoku {
    public static void main(String[] args) {
        int[][] grid = readASolution();
        printGrid(grid);
        /*for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.print(isValid(grid));
    }
    
    public static int[][] readASolution() {
        Scanner input = new Scanner(System.in);
        int[][] grid = new int[9][9];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        return grid;
    }
    
    public static boolean isValid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (isValidRow(grid, i) == false) {
                System.out.println("Invalid row");
                return false;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            if (isValidColumn(grid, i) == false) {
                System.out.println("Invalid column");
                return false;
            }
        }
        for (int i = 0; i < grid.length; i += 3) {
            for (int j = 0; j < grid[i].length; j += 3) {
                if (isValidSquare(grid, i, j) == false) {
                    System.out.println("Invalid subsquare");
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValidRow(int[][] grid, int i) {
        for (int j = 0; j < grid[i].length - 1; j++) {
            for (int k = j + 1; k < grid[i].length; k++) {
                if ((grid[i][j] < 1 || grid[i][j] > 9) || grid[i][k] == grid[i][j])
                    return false;
            }
        }
        return true;
    }
    public static boolean isValidColumn(int[][] grid, int i) {
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int k = j + 1; k < grid[0].length; k++) {
                if ((grid[j][i] < 1 || grid[j][i] > 9) || grid[j][i] == grid[k][i])
                    return false;
            }
        }
        return true;
    }
    public static boolean isValidSquare(int[][] grid, int i, int j) {
        /*for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                System.out.print(grid[i][j] + " ");
                    if ((grid[i][j] < 1 || grid[i][j] > 9) || grid[row][col] == grid[i][j])
                        return false;
                    } 
                    System.out.println();
                }*/
        int[][] square = new int[3][3];
        int row = 0; 
        for (int x = i; x < i + 3; x++) {
            int column = 0;
            for (int y = j; y < j + 3; y++) {
                square[row][column] = grid[x][y];
                column++;
            }
            row++;
        }
        for (int a = 0; a < square.length; a++) {
            if (isValidColumn(square, a) == false)
                return false;
        }
        for (int a = 0; a < square.length; a++) {
            if (isValidRow(square, a) == false)
                return false;
        }
        return true;
    }
    
    public static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (i % 3 == 0)
                System.out.println("------------------------------------");
            for (int j = 0; j < grid[i].length; j++) {
                if (j % 3 == 0)
                    System.out.print(" | " + grid[i][j]);
                else
                    System.out.print("   " + grid[i][j]);
            }
            System.out.println();
        }
    }
}
