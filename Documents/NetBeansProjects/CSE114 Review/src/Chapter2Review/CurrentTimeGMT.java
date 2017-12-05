/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CurrentTimeGMT {
    public static void main(String args[]) {
        System.out.print("Enter time zone offset: ");
        Scanner input = new Scanner(System.in);
        long offset = input.nextLong();
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds/1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 12;
        long newHour = currentHour - offset;
        //System.out.println(currentHour);
        if (newHour % 12 == 0)
            newHour = 12;
        System.out.print("The current time is " + (newHour % 12) + ":" + currentMinute + ":" + currentSecond);
        if (newHour / 12 == 0)
            System.out.println(" AM");
        else
            System.out.println(" PM");
    }
}
