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
public class FindHighestScores {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = input.nextInt();
        int highestScore = 0;
        int secondHighestScore = 0;
        String highestStudent = "";
        String secondHighestStudent = "";
        for (int i = 0; i < n; i++) {
            int score = input.nextInt();
            String name = input.nextLine();
            if (score > highestScore) {
                secondHighestScore = highestScore;
                secondHighestStudent = highestStudent;
                highestScore = score;
                highestStudent = name;
            }
            else if (score < highestScore && score > secondHighestScore) {
                secondHighestScore = score;
                secondHighestStudent = name;
            }
        }
        
        System.out.println("The student who scored the highest is " + highestStudent);
        System.out.println("The student who scored the second highest is"  + secondHighestStudent);
    }
}
