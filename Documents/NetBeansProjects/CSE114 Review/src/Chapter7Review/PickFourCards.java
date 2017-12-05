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
public class PickFourCards {
    public static void main(String[] args) {
        String[] suits = {"Kings", "Hearts", "Diamonds", "Spades"};
        int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        
        int picks = 0;
        int[] cardsSum = new int[4];
        String[] suitsPicked = new String[4];
        boolean sum24 = false;
        while (sum24 == false) {
            int sum = 0;
            int cardsPicked = 0;
            while (cardsPicked < 4) {
                String suitPicked = suits[(int)(Math.random() * 4)];
                int cardPicked = cards[(int)(Math.random() * 13)];
                if (alreadyExists(suitsPicked, suitPicked, cardsSum, cardPicked, cardsPicked) == false) {
                    cardsSum[cardsPicked] = cardPicked;
                    suitsPicked[cardsPicked] = suitPicked;
                    cardsPicked++;
                }
                picks++;
            }
            for (int i = 0; i < 4; i++) {
                sum += cardsSum[i];
            }
            if (sum == 24)
                sum24 = true;
        }
        System.out.println("The total number of picks for the sum of 24 is: " + picks);
    }
    
    public static boolean alreadyExists(String[] s, String suit, int[] i, int card, int n) {
        boolean matches = false;
        for (int a = n - 1; a >= 0; a--) {
            if ((i[a] == card) && (s[a] == suit))
                matches = true;
            else
                matches = false;
        }
        return matches;
    }
}
