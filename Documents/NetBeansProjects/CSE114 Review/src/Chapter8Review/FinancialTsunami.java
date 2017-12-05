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
public class FinancialTsunami {
    public static void main(String[] args) {
        //Banks lend money to each other.  In tough economic times, if a bank goes bankrupt, it may not be able to pay back the loan. 
        // A bank's total assets are its current balance plus its loans to other banks.
        //The banks current balances are 25, 125, 175, 75, and 181 million dollars, respectively.  The directed edge from node1 to node2 indicates
        //that bank 1 lends 40 million dollars to bank 2.
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of banks and the limit: ");
        int numberOfBanks = input.nextInt();
        double limit = input.nextDouble();
        double[] bankBalances = new double[numberOfBanks];
        double[][] borrowers = new double[numberOfBanks][numberOfBanks];
        for (int i = 0; i < numberOfBanks; i++) {
            System.out.println("Enter the balance for bank " + i + ", then enter the amount of banks borrowing, the number of the bank borrowing, and how much the bank is borrowing (for each bank borrowing)");
            bankBalances[i] = input.nextDouble();
            int banksBorrowing = input.nextInt();
            while (banksBorrowing > 0) {
                int j = input.nextInt();
                borrowers[j][i] = input.nextDouble();
                banksBorrowing--;
            }
        }
        for (int i = 0; i < borrowers.length; i++) {
            for (int j = 0; j < borrowers[i].length; j++) {
                System.out.print(borrowers[i][j] + "\t");
            }
            System.out.println();
        }
        boolean incomplete = true;
        System.out.print("The unsafe banks are ");
        boolean[] isUnsafe = new boolean[numberOfBanks];
        while (incomplete) {
            boolean goAgain = false;
            for (int i = 0; i < numberOfBanks; i++) {
                double sumOfLoans = 0;
                for (int j = 0; j < borrowers.length; j++) {
                    sumOfLoans += borrowers[j][i];
                }
                if (sumOfLoans + bankBalances[i] < limit && isUnsafe[i] == false) {
                    System.out.print(i + " ");
                    isUnsafe[i] = true;
                    for (int j = 0; j < borrowers.length; j++) {
                        borrowers[i][j] = 0;
                    }
                    goAgain = true;
                }
            }
            if (goAgain == false)
                incomplete = false;
        }
        System.out.println();
        for (int i = 0; i < borrowers.length; i++) {
            for (int j = 0; j < borrowers[i].length; j++) {
                System.out.print(borrowers[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
