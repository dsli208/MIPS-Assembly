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
public class Emirp {
    public static void main(String[] args) {
        int count = 100;
        int counter = 0;
        int num = 0;
        while (count > 0) {
            if (isPrime(num) == true && isPalindrome(num) == false) {
                if (counter == 10) {
                    System.out.println();
                    counter = 0;
                    System.out.print(num + " ");  
                }
                else {
                    System.out.print(num + " ");
                    counter++;
                }
                
                count--;
            }
            num++;
        }
    }
    
    public static boolean isPrime(int num) {
        return (num % 2 != 0);
    }
    
    public static boolean isPalindrome(int num) {
        return (num == reverse(num));
    }
    
    public static int reverse(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum * 10 + (num % 10);
            num = num / 10;
        }
        return sum;
    }
}
