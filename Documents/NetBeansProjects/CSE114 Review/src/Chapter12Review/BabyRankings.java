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
public class BabyRankings {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "src/Chapter12Review/BabyNameRanking";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year (from 2001-2010): ");
        int year = input.nextInt();
        System.out.print("Enter the gender: ");
        String genderString = input.next();
        char gender = Character.toUpperCase(genderString.charAt(0));
        if (gender != 'M' || gender != 'F') {
            System.out.println("You must choose M or F.");
            System.exit(0);
        }
        System.out.print("Enter the name: ");
        String name = input.next();
        String filePath = basePath + year;
        File f = new File(filePath);
        Scanner reader = new Scanner(f);
        boolean matched = false;
        int rank = 0;
        String boyName = "";
        int boyNumber = 0;
        String girlName = "";
        int girlNumber = 0;
        while (reader.hasNextLine() && matched == false) {
            rank = reader.nextInt();
            boyName = reader.next();
            boyNumber = reader.nextInt();
            girlName = reader.next();
            girlNumber = reader.nextInt();
            if (gender == 'M' && boyName.equals(name))
                matched = true;
            else if (gender == 'F' && girlName.equals(name))
                matched = true;
        }
        System.out.println(name + " is ranked at #" + rank + " in the year " + year);
    }
}
