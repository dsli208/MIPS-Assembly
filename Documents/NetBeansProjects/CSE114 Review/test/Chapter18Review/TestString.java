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
public class TestString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String testString = "testString";
        System.out.println(testString.length() - 1);
        System.out.println(testString.substring(0, testString.length() - 2));
    }
}
