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
public class CouponCollector {
    public static void main(String[] args) {
        String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
        char[] cards = {'A', '2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K'};
        int picks = 0;
        int solved = 0;
        String[] suitsPicked = new String[4];
        char[] cardsPicked = new char[4];
        while (solved < 4) {
            String suitPicked = (suits[(int)(Math.random() * 4)]);
            char cardPicked = (cards[(int)(Math.random()* 12)]);
            if (alreadyPicked(suitsPicked, suitPicked, solved - 1) == false) {
                suitsPicked[solved] = suitPicked;
                cardsPicked[solved] = cardPicked;
                solved++;
            }
            picks++;
        }
        for (int i = 0; i < 4; i++) {
            if (cardsPicked[i] == 10)
                System.out.println("10 of " + suitsPicked[i]);
            else
                System.out.println(cardsPicked[i] + " of " + suitsPicked[i]);
        }
        System.out.println("Number of picks: " + picks);
    }
    
    public static boolean alreadyPicked(String[] s, String x, int i) {
        boolean matches = false;
        for (int j = i; j >= 0; j--) {
            if (s[j] == x)
                matches = true;
        }
        return matches;
    }
}
