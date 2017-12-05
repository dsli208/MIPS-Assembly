/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

import java.util.Date;

/**
 *
 * @author dsli
 */

public class DateObject {
    public static void main(String[] args) {
        Date date = new Date(10000);
        for (int i = 0; i < 8; i++) {
            date.setTime((long)(Math.pow(10, i)) * 10000);
            System.out.println("The elapsed time since Jan 1, 1970 is " + date.getTime() + " milliseconds.");
            System.out.println(date.toString());
        }
    }
}
