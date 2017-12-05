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
public class SortStudents {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int amountOfStudents = input.nextInt();
        String[] studentNames = new String[amountOfStudents];
        String placeholder = input.nextLine();
        System.out.print("Enter your students' names: ");
        for (int i = 0; i  < amountOfStudents; i++) {
            studentNames[i] = input.nextLine();
        }
        int[] studentScores = new int[amountOfStudents];
        System.out.print("Enter the scores for each of your students: ");
        for (int j = 0; j < amountOfStudents; j++) {
            studentScores[j] = input.nextInt();
        }
        for (int k = 0; k < amountOfStudents; k++) {
            for (int m = 0; m < k; m++) {
                if (studentScores[k] > studentScores[m]) {
                    swap(studentScores, studentNames, k, m);
                }
            }
        }
        for (int l = 0; l < amountOfStudents; l++) {
            System.out.print(studentNames[l] + " ");
            System.out.print(studentScores[l] + " ");
        }
    }
    
    public static void swap(int[] w, String[] x, int y, int z) {
        int temp = w[y];
        w[y] = w[z];
        w[z] = temp;
        String tempName = x[y];
        x[y] = x[z];
        x[z] = tempName;
    }
}
