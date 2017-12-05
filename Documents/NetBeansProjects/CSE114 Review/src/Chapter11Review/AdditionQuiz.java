/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class AdditionQuiz {
    public static void main(String[] args) {
        int num1 = (int)(Math.random() * 50);
        int num2 = (int)(Math.random() * 50);
        ArrayList<Integer> attemptedAnswers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("What is " + num1 + " + " + num2 + "? ");
        boolean unsolved = true;
        while (unsolved) {
            int answer = input.nextInt();
            if (answer == (num1 + num2)) {
                unsolved = true;
                System.out.println("Correct!");
            }
            else {
                boolean matches = false;
                for (int i = 0; i < attemptedAnswers.size(); i++) {
                    if (attemptedAnswers.get(i) == answer)
                        matches = true;
                }
                if (matches == true)
                    System.out.println("You already entered " + answer);
                else
                    attemptedAnswers.add(answer);
            }
        }
    }
}
