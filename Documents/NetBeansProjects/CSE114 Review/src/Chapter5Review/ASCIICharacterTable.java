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
public class ASCIICharacterTable {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 33; i < 127; i++) {
            System.out.print((char) i);
            counter++;
            if (counter == 10) {
                System.out.println();
                counter = 0;
            }
        }
    }
}
