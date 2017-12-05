/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.io.PrintStream;

/**
 *
 * @author dsli
 */
public class ConversionTable {
    public static void main(String[] args) {
        System.out.printf("%-10s%-10s%-10s%-10s%-10s", "Kilograms", "Pounds", " | ", "Pounds", "Kilograms\n");
        int i = 1;
        int j = 20;
        while (i < 200) {
            System.out.printf("%-10d%-10.3f%-10s%-10d%-10.3f", i, (i * 2.2), " | ", j, (j * 0.45));
            i += 2;
            j +=5;
            System.out.println();
        }
    }
}
