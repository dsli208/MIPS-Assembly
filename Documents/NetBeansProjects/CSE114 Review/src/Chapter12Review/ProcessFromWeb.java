/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ProcessFromWeb {
    public static void main(String[] args) throws MalformedURLException {
        try {
            String URLString = "http://cs.armstrong.edu/liang/data/Scores.txt";
            URL url = new URL(URLString);
            int count = 0; int sum = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                sum += input.nextInt();
                count++;
            }
            int average = sum / count;
            System.out.println("The total is " + sum + " and the average is " + average);
        }
        catch (MalformedURLException e1) {
            System.out.println("Malformed URL.");
        }
        catch (IOException e2) {
            System.out.println("Bad input/output");
        }
    }
}
