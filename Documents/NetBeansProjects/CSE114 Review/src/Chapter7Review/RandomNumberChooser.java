/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

/**
 *
 * @author dsli
 */
public class RandomNumberChooser {
    public static void main(String[] args) {
        System.out.print(getRandom(1, 54));
    }
    
    public static int getRandom(int i, int j) {
        int[] randomArray = new int[j - i];
        for (int x = 1; x < j - i; x++) {
            randomArray[x] = x + i;
        }
        int n = (int)(Math.random()*j + 1);
        return randomArray[n];
    }
}
