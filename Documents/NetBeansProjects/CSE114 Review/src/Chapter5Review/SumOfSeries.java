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
public class SumOfSeries {
    public static void main(String[] args) {
        double sum = 0;
        for (double n = 1.0; n < 98.0; n++) {
            sum += n / (n + 2);
        }
        
        System.out.println("The sum is " + sum);
    }
}
