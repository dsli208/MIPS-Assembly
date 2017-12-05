/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class PerfectSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer m: "); int m = input.nextInt();
        ArrayList<Integer> primeFactors = new ArrayList<>();
        int number = m;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                primeFactors.add(i);
                number /= i; 
                i--;
            }
        }
        System.out.println(primeFactors.toString());
        Collections.sort(primeFactors);
        ArrayList<Integer> oddOccuringPrimeFactors = new ArrayList<>();
        for (int i = 0; i < primeFactors.size(); i++) {
            boolean recurring = false;
            for (int j = i - 1; j >= 0; j--) {
                if (Objects.equals(primeFactors.get(i), primeFactors.get(j)))
                    recurring = true;
            }
            if (recurring == false) {
                int occurences = 1;
                for (int k = i + 1; k < primeFactors.size(); k++) {
                    if (Objects.equals(primeFactors.get(k), primeFactors.get(i)))
                        occurences++;
                }
                if (occurences % 2 != 0)
                    oddOccuringPrimeFactors.add(primeFactors.get(i));
            }
        }
        System.out.println(oddOccuringPrimeFactors.toString());
        int n = 1;
        for (int i = 0; i < oddOccuringPrimeFactors.size(); i++) {
            n *= oddOccuringPrimeFactors.get(i);
        }
        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + (m * n));
    }
}
