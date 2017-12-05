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
public class ISBNNumber {
    public static void main(String args[]) {
        System.out.print("Enter the first 9 digits of an ISBN Number: ");
        Scanner input = new Scanner(System.in);
        int first9Digits = input.nextInt();
        int d9 = first9Digits % 10;
        int first8Digits = first9Digits / 10;
        int d8 = first8Digits % 10;
        int first7Digits = first8Digits / 10;
        int d7 = first7Digits % 10;
        int first6Digits = first7Digits / 10;
        int d6 = first6Digits % 10;
        int first5Digits = first6Digits / 10;
        int d5 = first5Digits % 10;
        int first4Digits = first5Digits / 10;
        int d4 = first4Digits % 10;
        int first3Digits = first4Digits / 10;
        int d3 = first3Digits % 10;
        int first2Digits = first3Digits / 10;
        int d2 = first2Digits % 10;
        int d1 = first2Digits / 10;
        int checksum = ((d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11);
            
        if (checksum == 10)
            System.out.println("The ISBN-10 number is " + d1 + "" + d2 + "" + d3 + "" + d4 + "" + d5 + "" + d6 + "" + d7 + "" + d8 + "" + d9 + "X");
        else
            System.out.println("The ISBN-10 number is " + d1 + "" + d2 + "" + d3 + "" + d4 + "" + d5 + "" + d6 + "" + d7 + "" + d8 + "" + d9 + "" + checksum);
        
        //System.out.println(((d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 + 7 + d8 * 8 + d9 * 9) % 11));
    }
}
