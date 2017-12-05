/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class GCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int int1 = input.nextInt(); int int2 = input.nextInt();
        int gcd = getGCD(int1, int2);
        System.out.println(gcd);
    }
    
    public static int getGCD(int n1, int n2) {
        //Base case
        if (n1 % n2 == 0)
            return n2;
        //Recursive call
        else
            return getGCD(n2, n1 % n2);
    }
}
