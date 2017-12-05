/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SmallestFactorsOfInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer: ");
        int number = input.nextInt();
        int factorProduct = 1;
            for (int i = 2; i < number; i++) {
                int n = number;
                if (n % i == 0) {
                    n = n / i;
                    boolean smallestFactor = false;
                    while (smallestFactor == false) {
                    /*factor = (number / i);
                    number = number / factor;*/
                        for (int j = 2; j < n; j++) {
                            boolean isPrime = true;
                            if (n % j == 0) {
                                isPrime = false;
                                n = n / j;
                                if (n == 2) {
                                    smallestFactor = true;
                                    break;
                                }
                            }
                            //else if (j < n - 1)
                                //continue;
                            if (isPrime == true) {
                                smallestFactor = true;
                            }
                        }
                        if (smallestFactor == true) {
                            System.out.print(n + " ");
                            factorProduct *= n;
                            System.out.println(factorProduct);
                        }
                    }
                }
                /*else if ((number % i != 0) && (i > 1))
                    continue;*/
            }
            //System.out.print(number + " ");
        }
}
