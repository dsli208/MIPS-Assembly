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
public class DisplayCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int year = input.nextInt();
        System.out.println("Enter the first day of the year (0 is Sunday)");
        int firstDayOfTheYear = input.nextInt();
        int month;
        for (month = 1; month <= 12; month++) {
            switch (month) {
                case 1: System.out.println("January " + year); break;
                case 2: System.out.println("February " + year); break;
                case 3: System.out.println("March " + year); break;
                case 4: System.out.println("April " + year); break;
                case 5: System.out.println("May " + year); break;
                case 6: System.out.println("June " + year); break;
                case 7: System.out.println("July " + year); break;
                case 8: System.out.println("August " + year); break;
                case 9: System.out.println("September " + year); break;
                case 10: System.out.println("October " + year); break;
                case 11: System.out.println("November " + year); break;
                case 12: System.out.println("December " + year); break;
            }
            System.out.println("S M T W T F S");
            int counter = 0;
            int spaces = firstDayOfTheYear;
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                for (int day = 1; day <= 31; day ++) {
                    if (day == 31) {
                        System.out.print(day);
                        System.out.println();
                        spaces = counter;
                        counter = 1;
                    }
                    else if (day == 1) {
                        while (spaces > 0) {
                            System.out.print("  ");
                            spaces--;
                            counter++;
                        }
                        System.out.print(day + " ");
                        counter++;
                    }
                    else if (counter % 7 == 0) {
                        System.out.println();
                        System.out.print(day + " ");
                        counter = 1;
                    }
                    else {
                    System.out.print(day + " ");
                    counter++;
                    }
                }
            }
            else if (month == 2 && year % 4 == 0)
                for (int day = 1; day <= 29; day++) {
                    if (day == 29) {
                        System.out.print(day);
                        System.out.println();
                        spaces = counter;
                        counter = 1;
                    }
                    else if (day == 1) {
                        while (spaces > 0) {
                            System.out.print("  ");
                            spaces--;
                            counter++;
                        }
                        System.out.print(day + " ");
                        counter++;
                    }
                    else if (counter % 7 == 0) {
                        System.out.println();
                        System.out.print(day + " ");
                        counter = 1;
                    }
                    else {
                        System.out.print(day + " ");
                        counter++;
                    }
                }
            else if (month == 2 && year % 4 != 0)
                for (int day = 1; day <= 28; day++) {
                    if (day == 28) {
                        System.out.print(day);
                        System.out.println();
                        spaces = counter;
                        counter = 1;
                    }
                    else if (day == 1) {
                        while (spaces > 0) {
                            System.out.print("  ");
                            spaces--;
                            counter++;
                        }
                        System.out.print(day + " ");
                        counter++;
                    }
                    else if (counter % 7 == 0) {
                        System.out.println();
                        System.out.print(day + " ");
                        counter = 1;
                    }
                    else {
                        System.out.print(day + " ");
                        counter++;
                    }
                }
            else
                for (int day = 1; day <= 30; day++) {
                    if (day == 30) {
                        System.out.print(day);
                        System.out.println();
                        spaces = counter;
                        counter = 1;
                    }
                    else if (day == 1) {
                        while (spaces > 0) {
                            System.out.print("  ");
                            spaces--;
                            counter++;
                        }
                        System.out.print(day + " ");
                        counter++;
                    }
                    else if (counter % 7 == 0) {
                        System.out.println();
                        System.out.print(day + " ");
                        counter = 1;
                    }
                    else {
                        System.out.print(day + " ");
                        counter++;
                    }
                }
        }
    }
}
