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
public class ISBN13 {
    public static void main(String[] args) {
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        Scanner input = new Scanner(System.in);
        String isbn12 = input.nextLine();
        int checksum = 0;
        String isbn13 = "";
        if (isbn12.length() == 12) {
            for (int i = 0; i < isbn12.length(); i++) {
                int digit = i + 1;
                if (digit % 2 == 0)
                    checksum = checksum + 3 * isbn12.charAt(i);
                else if (digit % 2 == 1)
                    checksum += isbn12.charAt(i);
            }
            System.out.println(checksum);
            checksum = 10 - (checksum % 10);
            if (checksum == 10)
                isbn13 = isbn12 + "" + 0;
            else
                isbn13 = isbn12 + "" + checksum;
            System.out.println("The ISBN-13 number is " + isbn13);
        }
        else
            System.out.println(isbn12 + " is an invalid input.");
        
            
    }
}
