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
public class ZellerCongruence {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter year, month (1-12), and day");
        int year = input.nextInt(); int m = input.nextInt(); int q = input.nextInt();
        int k = year % 100;
        int j = year / 100;
        int h = (q + (26 * (m + 1) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        switch (h) {
            case 0: System.out.println("Saturday"); break;
            case 1: System.out.println("Sunday"); break;
            case 2: System.out.println("Monday"); break;
            case 3: System.out.println("Tuesday"); break;
            case 4: System.out.println("Wednesday"); break;
            case 5: System.out.println("Thursday"); break;
            case 6: System.out.println("Friday"); break;
        }
    }
}
