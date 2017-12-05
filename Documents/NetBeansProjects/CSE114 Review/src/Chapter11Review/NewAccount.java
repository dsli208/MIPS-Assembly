/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dsli
 */
public class NewAccount {
    ArrayList<Transaction> transactions = new ArrayList<>();
    private Date dateCreated;
    private String name;
    private int accountNumber;
    private double annualInterest;
    private double balance;
    public void setAccountNumber(int i) {this.accountNumber = i;} public void setBalance(double b) {balance = b;} public void setAnnualInterest(double i) {annualInterest = i;}
    public int getAccountNumber() {return accountNumber;} public double getBalance() {return balance;} public double getAnnualInterest() {return annualInterest;} public String getName() {return name;}
    public double getMonthlyInterestRate() {return getAnnualInterest() / 1200;}
    public double getMonthlyInterest() {return getMonthlyInterestRate() * balance;}
    public String getArrayList() {
        String arrayListString = "";
        for (int i = 0; i < transactions.size(); i++)
                    arrayListString += transactions.get(i).toString();
        return arrayListString;
    }
    public String toString() {
        return "Account number is " + accountNumber + ", balance is " + balance + ", and annual interest is " + annualInterest + "%.  The owner of this account is " + getName() + "\n" + getArrayList();
                
    }
    public NewAccount(int accountNumber, double balance, double annualInterest, String name) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.annualInterest = annualInterest;
        this.name = name;
    }
    public void deposit(double money) {
        balance += money;
        transactions.add(new Transaction('D', money, balance, "Add money into account"));
    }
    public void withdraw(double money) {
        balance -= money;
        transactions.add(new Transaction('W', money, balance, "Withdraw money"));
    }
}
class Transaction {
    private Date dateOfTransaction;
    private char type;
    private double amount;
    private double balance;
    private String description;
    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }
    public String toString() {
        return "Transaction type: " + type + "\n Transaction amount: " + amount + "\n Balance: " + balance + "\n Description of transaction: " + description + "\n";
    }
}
class TestNewAccount {
    public static void main(String[] args) {
        NewAccount a = new NewAccount(1122, 1000, 1.5, "George");
        a.deposit(30); a.deposit(40); a.deposit(50);
        a.withdraw(5); a.withdraw(4); a.withdraw(2);
        System.out.println(a.toString());
    }
}