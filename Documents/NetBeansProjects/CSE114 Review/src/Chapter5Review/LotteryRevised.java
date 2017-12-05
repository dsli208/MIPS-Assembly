/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class LotteryRevised {
    public static void main(String[] args) {
        int num1 = (int)(Math.random()* 10);
        int num2 = (int)(Math.random()* 10);
        while (num2 == num1)
            num2 = (int)(Math.random()* 10);
        String luckyNumber = num1 + "" + num2;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a two digit number");
        String answer = input.nextLine();
        if (answer.charAt(0) == luckyNumber.charAt(0) && answer.charAt(1) == luckyNumber.charAt(1))
            System.out.print("Exact match!  You win $10,000");
        else if (answer.charAt(0) == luckyNumber.charAt(1) && answer.charAt(1) == luckyNumber.charAt(0))
            System.out.print("Digits match.  You win $3,000");
        else if (answer.charAt(0) == luckyNumber.charAt(0) || answer.charAt(1) == luckyNumber.charAt(1) || answer.charAt(0) == luckyNumber.charAt(1) || answer.charAt(1) == luckyNumber.charAt(0))
            System.out.print("One digit matches.  You win $1,000");
        else if (answer.length() != 2)
            System.out.print("Invalid input");
        else
            System.out.print("No match.  Better luck next time.");
    }
}
