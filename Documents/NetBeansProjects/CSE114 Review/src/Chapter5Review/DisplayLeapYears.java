/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

/**
 *
 * @author dsli
 */
public class DisplayLeapYears {
    public static void main(String[] args) {
        int counter = 0;
        int leapYearCount = 0;
        for (int i = 101; i <= 2100; i++) {
            if (i % 4 == 0) {
                System.out.print(i + " ");
                counter++;
                leapYearCount++;
                if (counter == 10) {
                    System.out.println();
                    counter = 0;
                }
            }
        }
    }
}
