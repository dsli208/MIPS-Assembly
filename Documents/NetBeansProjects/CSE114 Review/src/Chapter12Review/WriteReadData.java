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
public class WriteReadData {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Chapter12Review/Exercise12_15");
        
        if (f.exists() == true) {
            System.out.println("The file already exists.");
            System.exit(0);
        }
        PrintWriter p = new PrintWriter(f); //Must come after the previous if statement; if before, then it assume a new file has already been created
        int numbersToPrint = 100;
        while (numbersToPrint > 0) {
            p.print((int)(Math.random() * 100 + 1) + " ");
            numbersToPrint--;
        }
        p.close();
        Scanner reader = new Scanner(f);
        int[] i = new int[100];
        int j = 0;
        while (reader.hasNext() && j < 100) {
            i[j] = reader.nextInt();
            j++;
        }
        boolean sorted = false;
        while (sorted == false) {
            boolean inOrder = true;
            for (int x = 1; x < i.length; x++) {
                if (i[x] < i[x - 1]) {
                    inOrder = false;
                    int temp = i[x];
                    i[x] = i[x - 1];
                    i[x - 1] = temp;
                }
                if (inOrder == true)
                    sorted = true;
            }
        }
        for (int k = 0; k < i.length; k++) {
            System.out.print(i[k] + " ");
            if (k % 10 == 0)
                System.out.println();
        }
    }
}
