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
public class ConnectFour {
    public static void main(String[] args) {
        char[][] gameBoard = new char[6][7];
        System.out.println(gameBoard.length);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++)
                gameBoard[i][j] = ' ';
        }
        Scanner input = new Scanner(System.in);
        print(gameBoard);
        boolean solved = false;
        char activePlayer = 'R';
        int turns = 0;
        while (solved == false) {
            if (turns % 2 == 0)
                activePlayer = 'R';
            else
                activePlayer = 'Y';
            System.out.print("Drop a " + activePlayer + " disk at column (0 - 6): ");
            int n = input.nextInt();
            int i = gameBoard.length - 1;
            boolean spotsFound = false;
            while (spotsFound == false) {
                if (gameBoard[i][n] == ' ') {
                    gameBoard[i][n] = activePlayer;
                    spotsFound = true;
                    print(gameBoard);
                        if (isThereAWinner(gameBoard) == true) {
                            System.out.println("Player " + activePlayer + " wins the game!");
                            solved = true;
                    }
                }
                if (i > 0)
                    i--;
                else {
                    spotsFound = true;
                    System.out.println("There are no available spots in this column.  Try again.");
                }
            }
            print(gameBoard);
            turns++;
        }
    }
    public static void print(char[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(" | " + c[i][j]);
            }
            System.out.println(" | ");
        }
        System.out.println("------------------------");
    }
    
    public static boolean isThereAWinner(char[][] c) {
//        //rows
        for (int i = 0; i < c.length; i++) {
            int consecutive = 1;
            for (int j = 0; j < c[i].length - 2; j++) {
                if (c[i][j] == c[i][j + 1] && hasWhiteSpaces(c, i, j) == false) {
                    consecutive++;
                    if (consecutive == 4)
                        return true;
                }
                else
                    consecutive = 1;
            }
        }
        //columns
        for (int i = 0; i < c[0].length; i++) {
            int consecutive = 1;
            for (int j = 0; j < c.length - 2; j++) {
                if (c[j][i] == c[j + 1][i] && hasWhiteSpaces(c, j, i) == false) {
                    consecutive++;
                    if (consecutive == 4)
                        return true;
                }
                else
                    consecutive = 1;
            }
        }
        //Diagonals, lower half
        for (int i = 1; i < c.length; i++) {
            int consecutive = 1;
            for (int k = i, j = 1; k < c.length - 1; k++, j++) {
                if (c[k][j] == c[k - 1][j - 1] && hasWhiteSpaces(c, k, j) == false) {
                    consecutive++;
                    if (consecutive == 4) {
                        return true;
                    }
                }
                else
                    consecutive = 1;
            }
        }
        
        //Diagonals, upper half
        for (int i = 1; i < c[0].length - 2; i++) {
            int consecutive = 1;
            for (int k = 1, j = i; k < c.length && j < c[0].length; k++, j++) {
                if (c[k][j] == c[k - 1][j - 1] && hasWhiteSpaces(c, k, j) == false) {
                    consecutive++;
                    if (consecutive == 4)
                        return true;
                }
                else
                    consecutive = 1;
            }
        }
        //From-bottom diagonals, upper half
        for (int i = c.length - 2; i > 0; i--) {
            int consecutive = 1;
            for (int k = i,j = 1; k >= 0 && j < c[i].length; k--, j++) {
                if (c[k][j] == c[k + 1][j - 1] && hasWhiteSpaces(c, k, j) == false) {
                    consecutive++;
                    if (consecutive == 4)
                        return true;
                }
                else
                    consecutive = 1;
            }
        }
        //From-bottom diagonals, lower half
        for (int i = 1; i < c[0].length - 1; i++) {
            int consecutive = 1;
            for (int k = c.length - 2, j = i; k >= 0 && j < c[i].length; k--, j++) {
                System.out.println(k + " " + j + " " + i);
                if (c[k][j] == c[k + 1][j - 1] && hasWhiteSpaces(c, k, j) == false) {
                    consecutive++;
                    if (consecutive == 4)
                        return true;
                }
                else
                    consecutive = 1;
            }
        }
        return false;
    }
    
    public static boolean hasWhiteSpaces(char[][] c, int i, int j) {
        if (c[i][j] == ' ')
            return true;
        else
            return false;
    }
}
