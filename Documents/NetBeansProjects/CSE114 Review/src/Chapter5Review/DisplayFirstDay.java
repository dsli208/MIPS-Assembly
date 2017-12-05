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
public class DisplayFirstDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter year");
        int year = input.nextInt();
        System.out.println("Enter the first day (0 is Sunday)");
        int firstDayOfYear = input.nextInt();
        int month = 1;
        int day = 1;
        for (month = 1; month <= 12; month++) {
            if (month == 3) {
                if (year % 4 == 0)
                    day = day + 29;
                else
                    day = day + 28;
            }
            else if (month == 1)
                day = firstDayOfYear;
            else if (month == 2 || month == 5 ||  month == 7|| month == 9 || month == 11)
                day = day + 31;
            else
                day = day + 30;
            
            switch(month) {
                case 1: System.out.print("January "); break;
                case 2: System.out.print("February "); break;
                case 3: System.out.print("March "); break;
                case 4: System.out.print("April "); break;
                case 5: System.out.print("May "); break;
                case 6: System.out.print("June "); break;
                case 7: System.out.print("July "); break;
                case 8: System.out.print("August "); break;
                case 9: System.out.print("September "); break;
                case 10: System.out.print("October "); break;
                case 11: System.out.print("November "); break;
                case 12: System.out.print("December "); break;
            }
            
            System.out.print("1, " + year + " is ");
            
            switch (day % 7) {
                case 0:
                    System.out.print("Sunday");
                    break;
                case 1:
                    System.out.print("Monday");
                    break;
                case 2:
                    System.out.print("Tuesday");
                    break;
                case 3:
                    System.out.print("Wednesday");
                    break;
                case 4:
                    System.out.print("Thursday");
                    break;
                case 5:
                    System.out.print("Friday");
                    break;
                case 6:
                    System.out.print("Saturday");
                    break;
                default:
                    break;
            }
            
            System.out.println();
        }
    }
}
