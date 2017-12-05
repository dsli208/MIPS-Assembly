/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

import java.util.Date;

/**
 *
 * @author dsli
 */
public class Account {
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated = new Date();
    public Account() {}
    public Account(int customID, double startBalance) {
        balance = startBalance;
        id = customID;
    }
    public void setId(int newID) {
        id = newID;
    }
    
    public void setBalance(double newBalance) {
        balance = newBalance;
    }
    
    public void setAnnualInterestRate(double newAnnualInterest) {
        annualInterestRate = newAnnualInterest;
    }
    
    public int getId() {
        return id;
    }
    
    public double getBalance() { return balance; } public double getAnnualInterestRate() {return annualInterestRate;}
    public String getDate() {
        return dateCreated.toString();
    }
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }
    public double getMonthlyInterest() {
        return (balance * (annualInterestRate / 12));
    }
    public void withdraw(double money) {
        balance -= money;
    }
    public void deposit(double money) {
        balance += money;
    }
}

class testAccount {
    public static void main(String[] args) {
        Account test = new Account(1122, 20000);
        test.setAnnualInterestRate(0.045);
        test.withdraw(2500);
        test.deposit(3000);
        System.out.println("The balance is " + test.getBalance() + ", the monthly interest is " + (test.getMonthlyInterest()) + ", and the account was created on " + test.getDate());
    }
}
