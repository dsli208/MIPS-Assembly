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
public class GuessBirthday {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String set1 = "1 3 5 7\n" + "9 11 13 15\n" + "17 19 21 23\n" + "25 27 29 31";
        String set2 = "2 3 6 7\n" + "10 11 14 15\n" + "18 19 22 23\n" + "26 27 30 31";
        String set3 = "4 5 6 7\n" + "12 13 14 15\n" + "20 21 22 23\n" + "28 29 30 31";
        String set4 = "8 9 10 11\n" + "12 13 14 15\n" + "24 25 26 27\n" + "28 29 30 31";
        String set5 = "16 17 18 19\n" + "20 21 22 23\n" + "24 25 26 27\n" + "28 29 30 31";
        int day = 0;
        System.out.println("Is your day in set 1? ");
        System.out.println(set1);
        String a1 = input.nextLine();
        if (a1.equals("Y"))
            day += 1;
        System.out.println("Is your day in set 2?");
        System.out.println(set2);
        String a2 = input.nextLine();
        if (a2.equals("Y"))
            day += 2;
        System.out.println("Is your day in set 3?");
        System.out.println(set3);
        String a3 = input.nextLine();
        if (a3.equals("Y"))
            day += 4;
        System.out.println("Is your day in set 4?");
        System.out.println(set4);
        String a4 = input.nextLine();
        if (a4.equals("Y"))
            day +=8;
        System.out.println("Is your day in set 5?");
        System.out.println(set5);
        String a5 = input.nextLine();
        if (a5.equals("Y"))
            day +=16;
        
        System.out.println("Your birthday is " + day);
    }
}