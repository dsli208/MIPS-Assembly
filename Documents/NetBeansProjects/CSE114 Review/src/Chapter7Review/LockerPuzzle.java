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
public class LockerPuzzle {
    public static void main(String[] args) {
        boolean[] lockerStatus = new boolean[100];
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j += (i + 1)) {
                if (lockerStatus[j] == true)
                    lockerStatus[j] = false;
                else
                    lockerStatus[j] = true;
            }
        }
        for (int i = 0; i < 100; i++) {
            if (lockerStatus[i] == true)
                System.out.print((i + 1) + " ");
        }
    }
}
