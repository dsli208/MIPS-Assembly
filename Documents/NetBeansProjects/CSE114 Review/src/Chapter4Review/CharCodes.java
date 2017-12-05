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
public class CharCodes {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input code");
        //int code = input.nextInt();
        //System.out.print((char) code);
        String code = input.next();
        char c = code.charAt(0);
        System.out.println((int) c);
    }
}
