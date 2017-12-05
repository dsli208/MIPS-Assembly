/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class ATM {
    private double[] balance = {100, 100, 100, 100, 100, 100, 100, 100, 100, 100};
    public ATM() {}
    public void deposit(int i, double n) {
        balance[i] += n;
    }
    public void withdraw(int i, double n) {
        balance[i] -= n;
    }
    public double getBalance(int i) {
        return balance[i];
    }
}
class testATM {
    public static void main(String[] args) {
        ATM a = new ATM();
        Scanner input = new Scanner(System.in);
        boolean isOn = true;
        while (isOn) {
            System.out.print("Enter an ID #: ");
            int id = input.nextInt();
            boolean activeCycle = true;
            while (activeCycle) {
                System.out.println("Main menu");
                System.out.println("1 - check balance, 2 - withdraw, 3 - deposit, 4 - exit");
                int choice = input.nextInt();
                switch (choice) {
                    case 1: System.out.println(a.getBalance(id)); break;
                    case 2: System.out.print("How much to withdraw? ");
                    double w = input.nextDouble(); a.withdraw(id, w); break;
                    case 3: System.out.print("How much to deposit? "); double d = input.nextDouble(); a.deposit(id, d); break;
                    case 4: activeCycle = false; break;
                    default: System.out.println("Invalid input. Enter a number 1 - 4 only."); break;
                }
            }
        }
    }
}