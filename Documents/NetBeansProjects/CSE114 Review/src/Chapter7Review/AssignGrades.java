/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class AssignGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int students = input.nextInt();
        int[] studentsGrades = new int[students];
        System.out.print("Enter " + students + " scores: ");
        int best = 0;
        for (int i = 0; i < students; i++) {
            studentsGrades[i] = input.nextInt();
            if (studentsGrades[i] > best)
                best = studentsGrades[i];
        }
        char[] letterGrades = new char[students];
        for (int j = 0; j < students; j++) {
            if (studentsGrades[j] >= best - 10)
                letterGrades[j] = 'A';
            else if (studentsGrades[j] >= best - 20)
                letterGrades[j] = 'B';
            else if (studentsGrades[j] >= best - 30)
                letterGrades[j] = 'C';
            else if (studentsGrades[j] >= best - 40)
                letterGrades[j] = 'D';
            else
                letterGrades[j] = 'F';
            
            System.out.println("Student " + j + "'s score is " + studentsGrades[j] + " and grade is " + letterGrades[j]);
        }
    }
}
