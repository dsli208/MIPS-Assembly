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
public class NestedPatterns {
    public static void main(String[] args) {
        patternA(6);
        patternB(6);
        patternC(6);
        patternD(6);
    }
    
    public static void patternA(int i) {
        System.out.println("Pattern A: ");
        for (int j = 1; j <= i; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
    
    public static void patternB(int i) {
        System.out.println("Pattern B:");
        for (int j = i; j >= 1; j--) {
            for (int k = 1; k <= j; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
    
    public static void patternC(int i) {
        System.out.println("Pattern C:");
        for (int j = 1; j <= i; j++) {
            for (int k = 1; k <= i - j; k++) {
                System.out.print(" ");
            }
            for (int l = 1; l <= j; l++) {
                System.out.print(l);
            }
            System.out.println();
        }
    }
    
    public static void patternD(int i) {
        System.out.println("Pattern D:");
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < j; k++) {
                System.out.print(" ");
            }
            for (int l = 1; l <= i - j; l++) {
                System.out.print(l);
            }
            
            System.out.println();
        }
    }
}
