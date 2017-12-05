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
public class SquarePyramid {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 - i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print((int) Math.pow(2, k) + " ");
            }
            for (int l = i - 1; l >= 0; l--) {
                System.out.print((int) Math.pow(2, l) + " ");
            }
            System.out.println();
        }
    }
}
