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
public class TicTacToe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] ticTacToe = new char[3][3];
        for (int i = 0; i < ticTacToe.length; i++) {
            for (int j = 0; j < ticTacToe[i].length; j++) {
                ticTacToe[i][j] = ' ';
            }
        }
        boolean activeGame = true;
        int turns = 0;
        char activePlayer;
        while (activeGame) {
            printGameBoard(ticTacToe);
            if (turns % 2 == 0)
                activePlayer = 'X';
            else
                activePlayer = 'O';
            boolean activeTurn = true;
            int row = -1;
            int column = -1;
            while (activeTurn) {
                boolean rowEntered = false;
                boolean columnEntered = false;
                while (rowEntered == false) {
                System.out.print("Enter a row (0, 1, or 2) for player " + activePlayer + ":");
                row = input.nextInt();
                if (row > 2 || row < 0)
                    System.out.println("Invalid input.  Try again.");
                else
                    rowEntered = true;
                }
            while (columnEntered == false) {
                System.out.print("Enter a column (0, 1, or 2) for player " + activePlayer + ":");
                column = input.nextInt();
                if (column > 2|| column < 0)
                    System.out.println("Invalid input.  Try again.");
                else
                    columnEntered = true;
                }
            if (ticTacToe[row][column] == ' ') {
                ticTacToe[row][column] = activePlayer;
                activeTurn = false;
                if (isThereAWinner(ticTacToe, activePlayer) == true) {
                    activeGame = false;
                    System.out.println(activePlayer + " wins the game!");
                    printGameBoard(ticTacToe);
                }
                turns++;
            }
            else
                System.out.println("That space is already taken.  Try again.");
            }  
        }
    }
    public static void printGameBoard(char[][] c) {
        System.out.println("-------------");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print("| " + c[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
    public static boolean isThereAWinner(char[][] c, char x) {
        boolean threeInARow = false;
        
        for (int i = 0; i < c.length; i++) {
            boolean consistent = true;
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] != x || hasWhiteSpaces(c, x, 0, 0) == true)
                    consistent = false;
            }
            if (consistent == true)
                threeInARow = true;
        }
        for (int i = 0; i < c[0].length; i++) {
            boolean consistent = true;
            for (int j = 0; j < c.length; j++) {
                if (c[i][j] !=x || hasWhiteSpaces(c, x, 0, 0) == true)
                    consistent = false;
            }
            if (consistent == true)
                threeInARow = true;
        }
        boolean majorDiagonal = true;
        for (int i = 0, j = 0; i < c.length; i++, j++) {
            if (c[i][j] != x || hasWhiteSpaces(c, x, 0, 0) == true)
                majorDiagonal = false;
        }
        if (majorDiagonal== true)
                threeInARow = true;
        boolean subDiagonal = true;
        for (int i = 2, j = 0; j < c[0].length; i--, j++) {

            if ((c[i][j] != x) || hasWhiteSpaces(c, x, 2, 0) == true)
                subDiagonal = false;
            
        }
        if (subDiagonal == true)
                threeInARow = true;
        
        if (threeInARow == true)
            return true;
        else
            return false;
    }
    public static boolean hasWhiteSpaces(char[][] c, char x, int i, int j) {
        if (c[i][j] == ' ')
            return true;
        else
            return false;
    }
}
