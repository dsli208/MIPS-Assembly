/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter3Review;

/**
 *
 * @author dsli
 */
public class pickACard {
    public static void main(String args[]) {
        int card = 12;//(int)(Math.random()*13 + 1);
        int suit = (int)(Math.random() *4);
        if (card == 1)
            System.out.print("Ace ");
        else if (card == 13)
            System.out.print("King ");
        else if (card == 11)
            System.out.print("Jack ");
        else if (card == 12)
            System.out.print("Queen ");
        else
            System.out.print(card + " ");
        System.out.print("of ");
        switch(suit) {
            case(0): System.out.print("Clubs"); break;
            case(1): System.out.print("Spades"); break;
            case(2): System.out.print("Diamonds"); break;
            case(3): System.out.print("Hearts"); break;
        }
    }
}
