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
public class DisplayPattern {
    public static void main(String args[]) {
        int n = 5;
        displayPattern(n);
    }
    public static void displayPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print("  ");
            }
            for (int k = i; k > 0; k--) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        
    }
}
