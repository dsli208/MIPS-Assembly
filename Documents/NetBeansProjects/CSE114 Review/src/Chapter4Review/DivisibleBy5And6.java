/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

/**
 *
 * @author dsli
 */
public class DivisibleBy5And6 {
    public static void main(String[] args) {
        int counter = 0;
        for (int n = 100; n <= 1000; n++) {
            if ((n % 5 == 0) || (n % 6 == 0)) {
                System.out.print(n + " ");
                counter++;
                if (counter == 10) {
                    System.out.println();
                    counter = 0;
                }
            }
            
        }
        
    }
        
    
}
