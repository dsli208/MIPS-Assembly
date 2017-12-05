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
public class ComputeTuition {
    public static void main(String[] args) {
        int tuition = 10000;
        int totalCost = 0;
        for (int i = 0; i < 14; i++) {
            tuition += tuition * 0.05;
            if (i > 9 && i < 14)
                totalCost += tuition;
            
        }
        System.out.println("The total cost is " + totalCost);
    }
}
