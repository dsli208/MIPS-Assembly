/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

/**
 *
 * @author dsli
 */
public class TestStock {
    public static void main(String[] args) {
        Stock oracle = new Stock("ORCL", "Oracle");
        oracle.previousClosingPrice = 34.5;
        oracle.currentPrice = 34.35;
        System.out.println("The change in percentage is " + oracle.getChangedPercent() + "%");
    }
}
