package Chapter3Review;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class RockPaperScissor {
    public static void main(String args[]) {
        System.out.println("Enter 0, 1, or 2");
        Scanner input = new Scanner(System.in);
        int computerWins = 0;
        int humanWins = 0;
        boolean active = true;
        while (active) {
            short humanInput = input.nextShort();
            short compInput = (short)(Math.random() * 3);
            if ((humanInput == 0) && (compInput == 0))
                System.out.println("The computer is scissor.  You are scissor too.  It is a draw.");
            else if ((humanInput == 0) && (compInput == 1)) {
                System.out.println("The computer is rock.  You are scissor.  Computer wins.");
                computerWins++;
            }
            else if ((humanInput == 0) && (compInput == 2)) {
                System.out.println("The computer is paper.  You are scissor.  You win!");
                humanWins++;
            }
            else if ((humanInput == 1) && (compInput == 0)) {
                System.out.println("The computer is scissor.  You are rock.  You win!");
                humanWins++;
            }
            else if ((humanInput == 1) && (compInput == 1))
                System.out.println("The computer is rock.  You are rock too.  It is a draw.");
            else if ((humanInput == 1) && (compInput == 2)) {
                System.out.println("The computer is paper.  You are rock.  Computer wins.");
                computerWins++;
            }
            else if ((humanInput == 2) && (compInput == 0)) {
                System.out.println("The computer is scissor.  You are paper.  Computer wins.");
                computerWins++;
            }
            else if ((humanInput == 2) && (compInput == 1)) {
                System.out.println("The computer is rock.  You are paper.  You win!");
                humanWins++;
            }
            else if ((humanInput == 2) && (compInput == 2))
                System.out.println("The computer is rock.  You are also rock.  It is a draw!");
            
            if (computerWins - humanWins == 2 || humanWins - computerWins == 2)
                active = false;
        }
        
        if (computerWins > humanWins)
            System.out.println("Computer wins!");
        else if (humanWins > computerWins)
            System.out.println("You win!");
    }
}
