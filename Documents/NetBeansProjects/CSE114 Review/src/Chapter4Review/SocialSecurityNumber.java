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
public class SocialSecurityNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter SSN: ");
        String ssn = input.nextLine();
        if (ssn.matches("\\d{3}-\\d{2}-\\d{4}"))
            System.out.println("This is a valid social security number.");
        else
            System.out.println("This is an invalid social security number");
    }
}
