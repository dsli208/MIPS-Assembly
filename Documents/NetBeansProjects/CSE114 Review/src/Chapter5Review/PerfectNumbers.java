/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

/**
 *
 * @author dsli
 */
public class PerfectNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0)
                    sum = sum + j;
            }
            if (sum == i)
                System.out.print(i + " ");
        }
    }
}
