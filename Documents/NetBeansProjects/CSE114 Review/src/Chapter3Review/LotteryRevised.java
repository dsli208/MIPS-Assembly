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
public class LotteryRevised {
    public static void main(String args[]) {
        int luckyNumber = (int)(Math.random() * 990 + 10);
        //System.out.println(luckyNumber);
        int ld3 = luckyNumber % 10;
        int ld2 = (luckyNumber / 10) % 10;
        int ld1 = ((luckyNumber / 10) / 10) % 10;
        System.out.println("Enter a three-digit number: ");
        Scanner input = new Scanner(System.in);
        int guess = input.nextInt();
        int gd3 = guess % 10;
        int gd2 = (guess / 10) % 10;
        int gd1 = (guess / 100) % 10;
        if (guess == luckyNumber)
            System.out.println("Congratulations!  You win $10,000!");
        else if (ld3 + ld2 + ld1 == gd3 + gd2 + gd1)
            System.out.println("Congratulations!  You win $3,000!");
        else if ((gd1 == ld1) || (gd2 == ld2) || (gd3 == ld3) || (gd1 == ld2) || (gd1 == ld3) || (gd2 == ld1) || (gd2 == ld3))
            System.out.println("Congratulations!  You win $1,000!");
        else
            System.out.println("Sorry, better luck next time!");
    }
}
