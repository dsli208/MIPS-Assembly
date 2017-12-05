/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class addThreeNumbers {
    public static void main(String args[]) {
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int number3 = (int) (Math.random() * 10);
        
        Scanner input = new Scanner(System.in);
        boolean unsolved = true;
        while (unsolved) {
            System.out.println("What is " + number1 + " + " + number2 + " + " + number3 + "?");
            int answer = input.nextInt();
            if (answer == number1 + number2 + number3) {
                System.out.println("Correct!");
                unsolved = false;
            }
            else
                System.out.println("Incorrect.  Try again.");
        }
    }
}
