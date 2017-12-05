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
public class DataSorted {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("src/Chapter12Review/Strings");
        Scanner input = new Scanner(f);
        String lastString = "";
        String outOfOrderString = "";
        boolean inOrder = true;
        while (input.hasNext() && inOrder == true) {
            String thisString = input.nextLine();
            if (thisString.compareTo(lastString) < 0) {
                inOrder = false;
                outOfOrderString = lastString;
            }
            else
                lastString = thisString;
        }
        if (inOrder == true)
            System.out.println("The strings are sorted in increasing order.");
        else {
            System.out.println("The strings that are out of order are: ");
            System.out.println(outOfOrderString);
            System.out.println(input.nextLine());
        }
    }
}
