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
public class TwinPrimes {
    public static void main(String[] args) {
        for (int i = 0; i + 2 < 1000; i++) {
            if (isPrime(i) == true && isPrime (i + 2) == true)
                System.out.println("(" + i + ", " + (i + 2) + ")");
        }
    }
    
    public static boolean isPrime(int n) {
        return (n % 2 != 0);
    }
}
