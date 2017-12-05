/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

/**
 *
 * @author dsli
 */
public class Craps {
    public static void main(String[] args) {
        int timesWon = 0;
        for (int i = 0; i < 10000; i++){
            int num1 = (int) (Math.random() * 6 + 1);
            int num2 = (int) (Math.random() * 6 + 1);
            int sum = num1 + num2;
            if (sum == 7 || sum == 11) {
                System.out.println("The sum is " + sum + ".  You landed a natural.  You win!");
                timesWon++;
            }
            else if (sum == 2 || sum == 3 || sum == 12)
                System.out.println("The sum is " + sum + ".  Craps.  You lose.");
            else {
                System.out.println("The sum is " + sum + ".  The point is " + sum + ".");
                if (point(sum) == true)
                    timesWon++;
            }
        }
        System.out.println(timesWon);
    }
    
    public static boolean point(int n) {
        boolean active = true;
        while (active) {
            int num1 = (int) (Math.random() * 6 + 1);
            int num2 = (int) (Math.random() * 6 + 1);
            int sum = num1 + num2;
            if (sum == n) {
                active = false;
                System.out.println("You rolled " + sum + ".  You win!");
                return true;
            }
            else if (sum == 7) {
                active = false;
                System.out.println("You rolled 7.  You lose.");
                return true;
            }
        }
        return false;
    }
}
