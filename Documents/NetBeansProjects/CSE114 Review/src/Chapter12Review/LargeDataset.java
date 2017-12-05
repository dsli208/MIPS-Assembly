/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author dsli
 */
public class LargeDataset {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Chapter12Review/Salary");
        if (f.exists()) {
            System.out.println("File already exists.");
            System.exit(0);
        }
        PrintWriter p = new PrintWriter(f);
        for (int i = 1; i <= 1000; i++) {
            p.print("FirstName" + i + " " + "LastName" + i + " ");
            int status = (int)(Math.random() * 3);
            int salary = 0;
            String position = "";
            switch (status) {
                case 0: salary = (int)(Math.random() * 30000 + 50000); position = "Assistant"; break;
                case 1: salary = (int)(Math.random() * 50000 + 60000); position = "Associate"; break;
                case 2: salary = (int)(Math.random() * 55000 + 75000); position = "Full"; break;
            }
            p.println(position + " $" + salary);
        }
    }
}
