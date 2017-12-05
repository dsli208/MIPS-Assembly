/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

/**
 *
 * @author dsli
 */
public class MersennePrime {
    public static void main(String[] args) {
        System.out.printf("%s\t%s\n", "p", "2^p - 1");
        for (int p = 0; p <= 31; p++) {
            if (mersennePrime(p) == true)
                System.out.printf("%d\t%d\n", p, (int) Math.pow(2, p) - 1);
        }
    }
    public static boolean mersennePrime(int p) {
        return (p % 2 != 0);
    }
}
