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
public class PalindromicPrime {
    public static void main(String[] args) {
        displayPalindromicPrimes(100);
    }
    
    public static void displayPalindromicPrimes(int n) {
        int count = 0;
        int number = 0;
        while (n > 0) {
            if (isPalindrome(number) == true && isPrime(number) == true) {
                if (count == 10) {
                    System.out.println();
                    System.out.print(number + " ");
                    count = 0;
                    n--;
                }
                else {
                    System.out.print(number + " ");
                    count++;
                    n--;
                }
            }
            number++;
        }
    }
    
    public static boolean isPalindrome(int n) {
        if (n == reverse(n))
            return true;
        else
            return false;
    }
    
    public static int reverse(int n) {
        int reverseNumber = 0;
        while (n > 0) {
            reverseNumber = reverseNumber * 10 + (n % 10);
            n = n / 10;
        }
        return reverseNumber;
    }
    
    public static boolean isPrime(int n) {
        if (n % 2 != 0)
            return true;
        else
            return false;
    }
}
