/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class GuessCapitals {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        String[][] capitals = {{"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"}, {"California", "Sacramento"}, {"Colorado", "Denver"}, {"Connecticut", "Hartford"}, {"Delaware", "Dover"}, {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"}};
        for (int i = 0; i < capitals.length; i++) {
            System.out.print("What is the capital of " + capitals[i][0] + "? ");
            String answer = input.nextLine();
            if (answer == capitals[i][1]) {
                System.out.println("Correct!");
                count++;
            }
            else
                System.out.println("The correct answer should be" + capitals[i][1]);
        }
        System.out.println("The correct count is " + count);
    }
}
