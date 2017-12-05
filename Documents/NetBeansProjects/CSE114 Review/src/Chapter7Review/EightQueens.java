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
public class EightQueens {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] chessBoard = new char[8][8];
        printBoard(chessBoard);
        boolean unsolved = true;
            int turns = 0;
            while (turns < 8) {
                System.out.println("Enter a row and column to put your queen on.");
                int row = input.nextInt();
                int col = input.nextInt();
                chessBoard[row][col] = 'Q';
                printBoard(chessBoard);
                turns++;
            }
            if (isValid(chessBoard) == true)
                System.out.println("You win!");
            else
                System.out.println("You lose!");

    }
    public static boolean isValid(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            int rowCount = 0;
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] == 'Q') {
                    rowCount++;
                }
            }
            if (rowCount != 1)
                return false;
        }
        for (int i = 0; i < c[0].length; i++) {
            int columnCount = 0;
            for (int j = 0; j < c.length; j++) {
                if (c[j][i] == 'Q')
                    columnCount++;
            }
            if (columnCount != 1)
                return false;
        }
        //Diagonals from top, bottom half
        for (int i = 1; i < c.length; i++) {
            int fromTopDiagonalCount = 0;
            for (int j = i, k = 1; j < c[i].length && k < c.length; j++, k++) {
                if (c[j][k] == c[j - 1][k - 1])
                    fromTopDiagonalCount++;
            }
            if (fromTopDiagonalCount != 1)
                return false;
        }
        //Diagonals from top, top half
        for (int i = 1; i < c[0].length; i++) {
            int fromTopDiagonalCount = 0;
            for (int j = 1, k = i; j < c.length && k < c[i].length; j++, k++) {
                if (c[j][k] == c[j - 1][k - 1])
                    fromTopDiagonalCount++;
            }
            if (fromTopDiagonalCount != 1)
                return false;
        }
        
        //Diagonals from bottom, top half
        for (int i = c.length - 2; i > 0; i--) {
            int fromBottomDiagonalCount = 0;
            for (int j = i, k = 1; j > 0 && k < c[i].length; j--, k++) {
                if (c[j][k] == c[j + 1][k - 1])
                    fromBottomDiagonalCount++;
            }
            if (fromBottomDiagonalCount != 1)
                return false;
        }
        
        //Diagonals from bottom, bottom half
        for (int i = 1; i < c[0].length; i++) {
            int fromBottomDiagonalCount = 0;
            for (int j = c.length - 2, k = i; j > 0 && k < c[i].length; j--, k++) {
                if (c[j][k] == c[j + 1][k - 1])
                    fromBottomDiagonalCount++;
            }
            if (fromBottomDiagonalCount != 1)
                return false;
        }
        return true;
    }
    public static void printBoard(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(" | " + c[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println("------------------------");
    }
}
