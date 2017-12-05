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
public class OccurencesSpecifiedCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        char[] c = s.toCharArray();
        System.out.print("Enter a character: ");
        String charInput = input.nextLine();
        char character = charInput.charAt(0);
        int occurences = count(c, character);
        System.out.println("The character " + character + " occurs " + occurences + " times in the String " + s);
    }
    public static int count(char[] c, char a) {
        if (c.length == 0) {
            if (c[0] == a || c[0] == a + 32 || c[0] == a - 32)
                return 1;
            else
                return 0;
        }
        else
            return count(c, a, 0);
    }
    public static int count(char[] c, char a, int high) {
        int max = 0;
        if (high >= c.length)
            return 0;
        else {
            if (c[high] == a || c[high] == a + 32 || c[high] == a - 32)
                max++;
            return max + count(c, a, high + 1);
        }
    }
}
