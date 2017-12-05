/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

/**
 *
 * @author dsli
 */
public class CountSingleDigits {
    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 100; i++) {
            int random = (int)(Math.random()* 10);
            counts[random]++;
        }
        for (int j = 0; j < 10; j++) {
            System.out.print(counts[j] + " ");
        }
    }
}
