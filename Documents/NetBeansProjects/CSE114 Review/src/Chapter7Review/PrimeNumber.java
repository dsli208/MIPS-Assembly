package Chapter7Review;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int[] first50Primes = new int[50];
        int totalCount = 0;
        int rowCount = 0;
        int number = 2;
        while (totalCount < 50) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0)
                    isPrime = false;
            }
            if (isPrime == true) {
                first50Primes[totalCount] = number;
                totalCount++;
            }
            number++;
        }
        for (int i = 0; i < 50; i++) {
            if (rowCount % 10 == 0) {
                System.out.println();
                rowCount = 0;
                System.out.print(first50Primes[i] + " ");
            }
            else {
                System.out.print(first50Primes[i] + " ");
                
            }
            rowCount++;
            totalCount++;
        }
    }
}
