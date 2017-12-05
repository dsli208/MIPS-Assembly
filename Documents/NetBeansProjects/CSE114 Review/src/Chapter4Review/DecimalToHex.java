/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class DecimalToHex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer between 1 - 15");
        int number = input.nextInt();
        System.out.print("The hex value is ");
        if (number > 0 && number < 16) {
            if (number == 10)
                System.out.println("A");
            else if (number == 11)
                System.out.println("B");
            else if (number == 12)
                System.out.println("C");
            else if (number == 13)
                System.out.println("D");
            else if (number == 14)
                System.out.println("E");
            else if (number == 15)
                System.out.println("F");
            else
                System.out.println(number);
        }
        else
            System.out.println("Invalid input");
    }
}
