/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter18Review;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class NonrecursiveDirectorySize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Prompt the user to enter a directory
        System.out.print("Enter a directory or a file: ");
        String directory = input.nextLine();
        
        //Display the size
        System.out.println(getSize(new File(directory)) + " bytes.");
    }
    
    /*public static long getSize(File file) {
        long size = 0; //Store the total size of all files
        
        if (file.isDirectory()) {
            File[] files = file.listFiles(); //All files and subdirectories
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]); //Recursive call
            }
        }
        else {//Base case
            size += file.length();
        }
        return size;
    }*/
    
    public static long getSize(File file) {
        long size = file.length(); //Store the total size of all files
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            File[] subFiles;
            for (int i = 0; files != null && i < files.length; i++ ) {
                size += files[i].length();
                if (files[i].isDirectory()) {
                    subFiles = files[i].listFiles();
                    for (int j = 0; subFiles != null && j < subFiles.length; j++) {
                        size += subFiles[j].length();
                    }
                }
            }
        }
        return size;
    }
}
