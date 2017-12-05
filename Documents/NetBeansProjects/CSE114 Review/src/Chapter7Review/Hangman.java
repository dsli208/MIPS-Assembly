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
public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] puzzles = {"JAVA PROGRAM", "COMPUTER SCIENCE", "STONY BROOK UNIVERSITY", "MARCHING BAND", "NATIONAL HOCKEY LEAGUE"};
        boolean active = true;
        int puzzleNumber = 0;
        while (active) {
            String wordToGuess = puzzles[puzzleNumber];
            char[] answer = wordToGuess.toCharArray();
            char[] puzzle = new char[answer.length];
            int stars = 0;
            for (int i = 0; i < puzzle.length; i++) {
                if (answer[i] == ' ')
                    puzzle[i] = ' ';
                else {
                    puzzle[i] = '*';
                    stars++;
                }
            }
            boolean unsolved = true;
            int misses = 0;
            while (unsolved) {
                System.out.print("Enter a letter in the word (only the first letter in the input will be used): ");
                for (int i = 0; i < puzzle.length; i++) {
                    System.out.print(puzzle[i]);
                }
                System.out.print(" ");
                String letterGuess = input.nextLine();
                char c = letterGuess.charAt(0);
                boolean alreadyInWord = false;
                boolean lettersRevealed = false;
                for (int i = 0; i < answer.length; i++) {
                    if (c == puzzle[i])
                        alreadyInWord = true;
                    else if (c == answer[i]) {
                        puzzle[i] = c;
                        lettersRevealed = true;
                        stars--;
                    }
                }
                if (alreadyInWord == true)
                    System.out.println(c + " is already in the word.");
                else if (lettersRevealed == false && alreadyInWord == false) {
                    System.out.println(c + " is not in the word.");
                    misses++;
                }
                if (stars == 0) {
                    unsolved = false;
                }
            }
            System.out.println("The word is " + wordToGuess + ".  You missed " + misses + " times.");
            System.out.print("Do you want to guess another word?  Enter Y or N: ");
            String playAgain = input.nextLine();
            boolean responseReceived = false;
            while (responseReceived == false) {
                if (playAgain.charAt(0) == 'Y') {
                    responseReceived = true;
                    if (puzzleNumber < puzzles.length - 1)
                        puzzleNumber++;
                    else
                        puzzleNumber = 0;
                }
                else if (playAgain.charAt(0) == 'N') {
                    responseReceived = false;
                    active = false;
                    System.out.println("Thanks for playing!");
                }
                else
                    System.out.println("Invalid input.  Enter Y or N only.");
            }
        }
    }
}
