/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ProcessScores {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        String textInput = input.nextLine();
        File f = new File("src/Chapter12Review/scores");
        PrintWriter p = new PrintWriter(f);
        p.print(textInput);
        p.close();
        Scanner reader = new Scanner(f);
        int sum = 0;
        int count = 0;
        while (reader.hasNext()) {
            sum += reader.nextInt();
            count++;
        }
        int average = sum / count;
        System.out.println("The total is " + sum + " and the average is " + average);
    }
}
