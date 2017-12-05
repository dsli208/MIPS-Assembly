/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class TwoIntegerInputMismatch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        try {
            int result = sum(num1, num2);
            System.out.println(num1 + " + " + num2 + " = " + result);
        }
        catch (InputMismatchException e){
            System.out.println("Exception: you must enter TWO INTEGERS");
        }
    }
    public static int sum(int n1, int n2) {
        if (n1 == 0 || n2 == 0)
            throw new InputMismatchException("You must enter two numbers");
        return n2 + n1;
    }
}
