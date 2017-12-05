package Chapter3Review;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class sortIntegers {
    public static void main(String args[]) {
        System.out.println("Enter three integers: ");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt(); int num2 = input.nextInt(); int num3 = input.nextInt();
        if (num1 > num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        
        if (num1 > num3) {
            int temp = num3;
            num3 = num1;
            num1 = temp;
        }
        
        if (num2 > num3) {
            int temp = num3;
            num3 = num2;
            num2 = temp;
        }
        
        
        
        System.out.print("The numbers are " + num1 + " " + num2 + " " + num3);
    }
}
