/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class RankingSummary {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");
        String basePath = "src/Chapter12Review/BabyNameRanking";
        for (int year = 2001; year < 2011; year++) {
            String filePath = basePath + year;
            File f = new File(filePath);
            Scanner input = new Scanner(f);
            String[] boyNames = new String[5];
                String[] girlNames = new String[5];
            for (int i = 0; i < 5; i++) {
                int rank = input.nextInt();
                boyNames[i] = input.next();
                int boyNumber = input.nextInt();
                girlNames[i] = input.next();
                int girlNumber = input.nextInt();
            }
            System.out.printf("%-15d%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", year, boyNames[0], boyNames[1], boyNames[2], boyNames[3], boyNames[4], girlNames[0], girlNames[1], girlNames[2], girlNames[3], girlNames[4]);
        }
    }
}
