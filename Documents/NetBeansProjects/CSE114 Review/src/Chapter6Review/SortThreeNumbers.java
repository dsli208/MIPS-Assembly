/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SortThreeNumbers {
    public static void main(String[] args) {
        System.out.println("Enter three numbers: ");
        Scanner input = new Scanner(System.in);
        double num1 = input.nextInt();
        double num2 = input.nextInt();
        double num3 = input.nextInt();
        displaySortedNumbers(num1, num2, num3);
    }
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        /*if (num1 < num2 && num1 < num3) {
            System.out.print(num1 + " ");
            if (num2 < num3)
                System.out.print(num2 + " " + num3);
            else
                System.out.print(num3 + " " + num2);
        }*/
        if (num1 > num3) {
            double temp = num1;
            num1 = num3;
            num3 = temp;
        }
        
        if (num2 > num3) {
            double temp = num2;
            num2 = num3;
            num3 = temp;
        }
        
        System.out.println(num1 + " " + num2 + " " + num3);
    }
}
