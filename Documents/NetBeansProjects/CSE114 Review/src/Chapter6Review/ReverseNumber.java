/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int integer = input.nextInt();
        if (isPalindrome(integer) == true)
            System.out.print(integer + " is a palindrome.");
        else
            System.out.println(integer + " is not a palindrome.");
    }
    
    public static int reverse(int n) {
        int nReverse = 0;
        int nRem = n;
        int digit;
        while (nRem != 0) {
            digit = nRem % 10;
            nReverse = 10 * nReverse + digit;
            nRem = nRem / 10;
        }
        return nReverse;
    }
    
    public static boolean isPalindrome(int n) {
        if (reverse(n) == n)
            return true;
        else
            return false;
    }
}
