/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

/**
 *
 * @author dsli
 */
public class smallestSquaredofN {
    public static void main(String[] args) {
        boolean unsolved = true;
            while (unsolved) {
                for (int i = 12000; i > 0; i--) {
                    if (Math.pow(i, 3) < 12000) {
                        System.out.print("The smallest integer whose square is larger than 12,000 is " + i);
                        unsolved = false;
                        break;
                }
            }
        }
    }
}
