/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.math.BigInteger;

/**
 *
 * @author dsli
 */
public class SquareNumbers {
    public void findSquareNumber() {
        int minimum = (int)(Math.sqrt(Long.MAX_VALUE));
        int k = 0;
        while (k < 10) {
            minimum += 1;
            String s = Integer.toString(minimum);
            BigInteger min = new BigInteger(s);
            BigInteger max = min.pow(2);
            System.out.print(max + " ");
            k++;
        }
    public SquareNumbers() {}
}
class testSquare {
    public static void main(String[] args) {
        SquareNumbers s = new SquareNumbers();
        s.findSquareNumber();
    }
}