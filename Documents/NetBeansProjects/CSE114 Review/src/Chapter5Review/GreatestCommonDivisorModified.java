/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class GreatestCommonDivisorModified {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int d = (num1 > num2)? num2: num1;
        while (d > 0) {
            if (num1 % d == 0 && num2 % d == 0) {
                System.out.println(d + " is the GCD for " + num1 + " and " + num2);
                break;
            }
            else
                d--;
                
        }
    }
}
