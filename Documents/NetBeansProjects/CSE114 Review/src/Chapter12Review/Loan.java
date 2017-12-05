/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter12Review;

/**
 *
 * @author dsli
 */
public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;
    
    public Loan() {
        this(2.5, 1, 1000);
    }
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }
    
    public double getAnnualInterestRate() {
        if (annualInterestRate <= 0)
            throw new IllegalArgumentException("Annual interest rate must be greater than zero");
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    
    public int getNumberOfYears() {
        if (numberOfYears <= 0)
            throw new IllegalArgumentException("Number of years must be greater than zero");
        return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    
    public double getLoanAmount() {
        if (loanAmount <= 0)
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        return loanAmount;
    }
    
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
    
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}

class TestLoanWithException {
    public static void main(String[] args ) {
        Loan l = new Loan(0, 2, 5000);
        try {
            System.out.println(l.getAnnualInterestRate());
        }
        catch(IllegalArgumentException e) {
            System.out.println("One of your variables was set to zero");
        }
    }
}