/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class LetterToNumber {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String grade = input.nextLine();
        char c = Character.toUpperCase(grade.charAt(0));
        int result;
        if ((c >= 'A' && c <= 'D') || c == 'F') {
            if (c == 'A')
                result = 4;
            else if (c == 'B')
                result = 3;
            else if (c == 'C')
                result = 2;
            else if (c == 'D')
                result = 1;
            else
                result = 0;
            
            System.out.println("The numeric value for " + c + " is " + result);
            }
        
        else
            System.out.println(c + " is an invalid grade.");
    }
}
