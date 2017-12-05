/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String[] puzzles = {"COMPUTER SCIENCE", "MARCHING BAND"};
        File f = new File("src/Chapter12Review/puzzles");
        Scanner reader = new Scanner(f);
        while (reader.hasNext()) {
        boolean activeGame = true;
        while (activeGame == true) {
            int stars = 0;
            String puzzleToSolve = reader.next();
            String gamePuzzle = "";
            for (int i = 0; i < puzzleToSolve.length(); i++) {
                gamePuzzle += Character.toUpperCase(puzzleToSolve.charAt(i));
            }
            char[] puzzleArray = gamePuzzle.toCharArray();
            char[] hiddenPuzzle = gamePuzzle.toCharArray();
            for (int i = 0; i < hiddenPuzzle.length; i++) {
                if (puzzleArray[i] >= 'A' && puzzleArray[i] <= 'Z') {
                    hiddenPuzzle[i] = '*';
                    stars++;
                }
            }
            boolean solved = false;
            while (solved == false) {
                System.out.println(hiddenPuzzle);
                System.out.println("Enter a letter: ");
                String answer = input.nextLine();
                char c = Character.toUpperCase(answer.charAt(0));
                boolean lettersAppeared = false;
                for (int i = 0; i < puzzleArray.length; i++) {
                    if (c == puzzleArray[i] && hiddenPuzzle[i] == '*') {
                        hiddenPuzzle[i] = c; stars--; lettersAppeared = true;
                    }
                }
                if (lettersAppeared == false)
                    System.out.println(c + " has already been entered.");
                if (stars == 0) {
                    solved = true;
                    System.out.println("Congratulations!  The puzzle is " + gamePuzzle);
                }
            }
            if (solved == true)
                activeGame = false;
        }
        }
    }
}
