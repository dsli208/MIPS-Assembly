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
public class CancellationError {
    public static void main(String[] args) {
        double sum = 0.0;
        for (int n = 50000; n > 0; n--) {
            sum += 1.0/n;
        }
        System.out.printf("%s%.2f", "The sum is ", sum);
    }
}
