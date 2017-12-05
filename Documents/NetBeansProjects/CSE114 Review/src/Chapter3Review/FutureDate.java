/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class FutureDate {
    public static void main(String args[]) {
        System.out.println("Enter today's day: ");
        Scanner input = new Scanner(System.in);
        int currentDay = input.nextInt();
        String today;
        switch (currentDay) {
            case 0: today = "Sunday"; break;
            case 1: today = "Monday"; break;
            case 2: today = "Tuesday"; break;
            case 3: today = "Wednesday"; break;
            case 4: today = "Thursday"; break;
            case 5: today = "Friday"; break;
            case 6: today = "Saturday"; break;
            default: today = "Error"; break;
        }
        System.out.println("Enter the number of days elapsed since today: ");
        int future = input.nextInt();
        String futureDay;
        switch ((currentDay + future) % 7) {
            case 0: futureDay = "Sunday"; break;
            case 1: futureDay = "Monday"; break;
            case 2: futureDay = "Tuesday"; break;
            case 3: futureDay = "Wednesday"; break;
            case 4: futureDay = "Thursday"; break;
            case 5: futureDay = "Friday"; break;
            case 6: futureDay = "Saturday"; break;
            default: futureDay = "Error"; break;
        }
        
        System.out.println("Today is " + today + " and the future day is " + futureDay);
    }
}
