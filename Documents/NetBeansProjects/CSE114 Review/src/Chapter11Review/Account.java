/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

/**
 *
 * @author dsli
 */
public class Account {
    private int accountNumber;
    private double balance;
    private double annualInterest;
    public void setAccountNumber(int i) {this.accountNumber = i;} public void setBalance(double b) {balance = b;} public void setAnnualInterest(double i) {annualInterest = i;}
    public int getAccountNumber() {return accountNumber;} public double getBalance() {return balance;} public double getAnnualInterest() {return annualInterest;}
    public String toString() {
        return "Account number is " + accountNumber + ", balance is " + balance + ", and annual interest is " + annualInterest + "%";
    }
    public Account(int accountNumber, double balance, double annualInterest) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.annualInterest = annualInterest;
    }
    public void deposit(double money) {
        balance += money;
    }
    public void withdraw(double money) {
        balance -= money;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(int accountNumber, double balance, double annualInterest) {
        super(accountNumber, balance, annualInterest);
    }
    @Override
    public void withdraw(double money) {
        if (money > getBalance())
            System.out.println("You cannot withdraw more than your balance.");
    }
    
    @Override
    public String toString() {
        return "The account number is " + getAccountNumber() + ", the balance is " + getBalance() + ", and the annual interest is " + getAnnualInterest();
    }
}

class CheckingAccount extends Account {
    private double overdrawLimit; private double overdraw; private double total;
    public CheckingAccount(int accountNumber, double balance, double annualInterest, double overdrawLimit) {
        super(accountNumber, balance, annualInterest);
        this.overdrawLimit = overdrawLimit;
        this.overdraw = overdrawLimit;
        this.total = balance + overdraw;
    }
    
    @Override
    public void withdraw(double money) {
        if (money > getBalance() && money < total) {
            total -= money;
            setBalance(0);
            overdraw -= (money - overdraw);
        }
        else if (money < getBalance()) {
            total-= money;
            setBalance(total - overdraw);
        }
    }
    public String toString() {
        return "The account number is " + getAccountNumber() + ", the balance is " + getBalance() + ", and the annual interest is " + getAnnualInterest() + ".  The total money that can be withdrawed is " + total + " and the overdraw limit is " + overdrawLimit;
    }
}
class TestAccount {
    public static void main(String[] args) {
        Account checking = new CheckingAccount(11111, 5000, 0.04, 1000);
        System.out.println(checking.toString());
        checking.withdraw(5150);
        System.out.println(checking.toString());
        Account savings = new SavingsAccount(12345, 10000, 0.08);
        savings.deposit(2000);
        System.out.println(savings.toString());
    }
}