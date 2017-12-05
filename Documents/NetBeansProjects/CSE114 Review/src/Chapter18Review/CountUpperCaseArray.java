/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CountUpperCaseArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
        char[] c = s.toCharArray();
        int numberOfUppercase = count(c);
        System.out.println("There are " + numberOfUppercase + " uppercase letters.");
    }
    public static int count(char[] chars) {
        if (chars.length == 1) {
            if (chars[0] >= 65 && chars[0] <= 90)
                return 1;
            else
                return 0;
        }
        else
            return count(chars, 0);
    }
    public static int count(char[] chars, int high) {
        int max = 0;
        if (high >= chars.length)
            return 0;
        else if (chars[high] >= 'A' && chars[high] <= 'Z')
            max++;
        return max + count(chars, high + 1);
    }
}
