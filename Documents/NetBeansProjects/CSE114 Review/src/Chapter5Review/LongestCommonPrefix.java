/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String string1 = input.nextLine();
        System.out.print("Enter the second string: ");
        String string2 = input.nextLine();
        int activeLength = (string1.length() > string2.length() ? string2.length() : string1.length());
        boolean active = true;
        String common = "";
        while (active) {
            for (int i = 0; i < activeLength; i++) {
                if (string1.charAt(i) == string2.charAt(i))
                    common += string1.charAt(i);
                else if (string1.charAt(i) != string2.charAt(i))
                    active = false;
            }
        }
        
        if (common.length() >= 1)
            System.out.println("The common prefix is " + common);
        else
            System.out.println(string1 + " and " + string2 + " have no common prefix");
    }
}
