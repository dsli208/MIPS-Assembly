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
public class NumberOfYears {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int numberMinutes = input.nextInt();
        int minsPerYear = 60 * 24 * 365;
        int years = numberMinutes / minsPerYear;
        int rem = numberMinutes % minsPerYear;
        int days = rem / (60 * 24);
        System.out.println(years +" years " + days + " days." );
    }
}
