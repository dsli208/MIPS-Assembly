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
public class Summation {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i < 625; i++) {
            sum += 1/((Math.sqrt(i)) + Math.sqrt(i + 1));
        }
        System.out.println("The sum is " + sum);
    }
}
