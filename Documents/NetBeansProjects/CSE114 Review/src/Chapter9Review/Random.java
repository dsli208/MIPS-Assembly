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
public class Random {
    public static void main(String[] args) {
        java.util.Random random1 = new java.util.Random(1000);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(random1.nextInt(100) + "\t");
            }
            System.out.println();
        }
    }
}
