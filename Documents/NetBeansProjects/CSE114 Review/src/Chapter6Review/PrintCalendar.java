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
public class PrintCalendar {
    public static void main(String[] args) {
        System.out.println("Enter a year: ");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        System.out.println("Enter a month: ");
        int month = input.nextInt();
        printMonthTitle(year, month);
        printMonthBody(month, year);
    }
    
    public static int getStartDay(int year, int month) {
        if (month == 1 || month == 2)
            month += 12;
        return (1 + (26 * (month + 1) / 10) + (year % 100) + (year % 100) / 4 + (year / 400) + (5 * year / 100)) % 7;
    }
    
    public static void printMonthTitle(int year, int month) {
        System.out.println(getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        System.out.println("----------------------------");
    }
    
    public static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June";break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December"; break;
        }
        return monthName;
    }
    
    public static int getNumberOfDaysInMonth(int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        else
            return ((year % 4 == 0) ? 29 : 28);
    }
    
    public static void printMonthBody(int month, int year) {
        int days = getNumberOfDaysInMonth(month, year);
        int counter = 0;
        int firstDay = getStartDay(year, month);
        while (firstDay > 0) {
            System.out.print("   ");
            firstDay--;
            counter++;
        }
        System.out.print(" 1 ");
        for (int i = 2; i <= days; i++) {
            if (counter == 7) {
                System.out.println();
                counter = 1;
                System.out.print(" " + i + " ");
            }
            else {
                System.out.print(" " + i + " ");
                counter++;
            }
        }
    }
}
