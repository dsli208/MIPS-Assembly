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
public class ISBNAsString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String isbn = input.nextLine();
        //Count the number of digits missing
        int digitsMissing = 9 - isbn.length();
        String zeroes = "";
        while (digitsMissing > 0) {
            zeroes = zeroes + '0';
            digitsMissing--;
        }
        String total = zeroes + isbn;
        int checksum = 0;
        //int checksum = ((total.charAt(0) * 1 + total.charAt(1) * 2 + total.charAt(2) * 3 + total.charAt(3) * 4 + total.charAt(4) * 5 + total.charAt(5) * 6 + total.charAt(6) * 7 + total.charAt(7) * 8 + total.charAt(8) * 9) % 11);
        for (int i = 0; i < total.length(); i++) {
            System.out.print(total.charAt(i));
            checksum = ((total.charAt(i) * (i + 1)) % 11);
        }    
        
        if (checksum == 10)
            System.out.print("X");
        else
            System.out.print(checksum);
        /*if (checksum == 10)
            System.out.println("The ISBN-10 number is " +  total + "X");
        else
            System.out.println("The ISBN-10 number is " + total + "" + checksum);*/
    }
}
