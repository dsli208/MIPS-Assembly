/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class CreateDirectory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String basePath = ("src/Chapter12Review/");
        
        System.out.print("Enter a directory name: ");
        String directoryName = input.nextLine();
        String newPath = basePath + directoryName;
        File f = new File(newPath);
        if (f.mkdirs() == true)
            System.out.println("Directory created successfully.");
        else
            System.out.println("Directory already exists.");
    }
}
