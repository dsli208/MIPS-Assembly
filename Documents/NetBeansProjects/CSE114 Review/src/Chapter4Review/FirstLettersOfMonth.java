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
public class FirstLettersOfMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a month (first three letters)");
        String mon = input.nextLine();
        System.out.println("Enter a year");
        int year = input.nextInt();
        
        String month = mon.toLowerCase();
        int days;
        switch (month) {
            case "oct":
            case "dec":
            case "aug":
            case "jul":
            case "may":
            case "jan": days = 31; break;
            case "feb": 
                if (year % 4 == 0)
                    days = 29;
                else
                    days = 28;
                break;
            case "sep":
            case "jun":
            case "mar":
            case "nov":
            case "apr": days = 30;
            default: days = 0;
        }
        
        System.out.println(month + " " + year + " has " + days + " days.");
    }
}
