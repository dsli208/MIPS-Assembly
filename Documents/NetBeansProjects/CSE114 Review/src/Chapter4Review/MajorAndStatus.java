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
public class MajorAndStatus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String status = input.nextLine();
        String subject;
        String gradeLevel;
        if (status.length() == 2 && status.charAt(1) < '5') {
            if (status.charAt(0) == 'M')
                subject = "Mathematics";
            else if (status.charAt(0) == 'C')
                subject = "Computer Science";
            else if (status.charAt(0) == 'I')
                subject = "Information Technology";
            else
                subject = "";
        
            if (status.charAt(1) == '1')
                gradeLevel = "Freshman";
            else if (status.charAt(1) == '2')
                gradeLevel = "Sophomore";
            else if (status.charAt(1) == '3')
                gradeLevel = "Junior";
            else if (status.charAt(1) == '4')
                gradeLevel = "Senior";
            else
                gradeLevel = "";
            
            System.out.println(subject + " " + gradeLevel);
        }
        else
            System.out.println("Invalid input");
    }
}
