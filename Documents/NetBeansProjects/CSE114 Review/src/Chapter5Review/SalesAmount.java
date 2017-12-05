/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter5Review;

/**
 *
 * @author dsli
 */
public class SalesAmount {
    public static void main(String[] args) {
        int basePay = 5000;
        double totalPay = 0;
        double n = 0;
        for (n = 0; totalPay < 30000; n++) {
            totalPay = basePay + 5000 * 0.08 + 5000 * 0.10 + 0.12 * n;
        }
        
        System.out.println("To make $30,000 a year, the minimum sales generated is: " + n);
    }
}
