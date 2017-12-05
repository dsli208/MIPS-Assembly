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
public class ProcessLargeDataset {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
            double totalAssistantSum = 0;
            int assistantCount = 0;
            double totalAssociateSum = 0;
            int associateCount = 0;
            double totalFullSum = 0;
            int fullCount = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                switch(input.next()) {
                    case "associate": associateCount++; totalAssociateSum += input.nextDouble(); break;
                    case "assistant": assistantCount++; totalAssistantSum += input.nextDouble(); break;
                    case "full": fullCount++; totalFullSum += input.nextDouble(); break;
                }
            }
            double assistantAverageSalary = totalAssistantSum / assistantCount;
            double associateAverageSalary = totalAssociateSum / associateCount;
            double fullAverageSalary = totalFullSum / fullCount;
            System.out.println("Assistants make $" + totalAssistantSum + " in total.  Their average salary is $" + assistantAverageSalary);
            System.out.println("Associates make $" + totalAssociateSum + " in total.  Their average salary is $" + associateAverageSalary);
            System.out.println("Full time employees make $" + totalFullSum + " in total.  Their average salary is $" + fullAverageSalary);
        }
        catch (MalformedURLException e1) {
            System.out.println("Malformed URL.");
        }
        catch (IOException e2) {
            System.out.println("Bad IO.");
        }
    }
}
