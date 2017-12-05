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
public class FilesInDirectory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file directory: ");
        String directory = input.nextLine();
        long numberOfFiles = getNumberOfFiles(new File(directory));
    }
    public static long getNumberOfFiles(File directory) {
        long size = 0; //Store total size, 0 is the starting condition
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (int i = 0; i < files.length; i++) {
                
            }
        }
    }
}
