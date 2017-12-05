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
public class PrimeNumbers {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 2; i <= 1000; i++) {
        if ((i % 2 != 0) && (counter == 8)) {
            System.out.print(i + " ");
            counter = 0;
            System.out.println();
        }
        else if ((i % 2 != 0) && (counter < 8)) {
            System.out.print(i + " ");
            counter++;
        }
    }
}
}
