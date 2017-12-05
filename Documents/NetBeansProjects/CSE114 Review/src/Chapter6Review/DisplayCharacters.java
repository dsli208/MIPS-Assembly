/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter6Review;

/**
 *
 * @author dsli
 */
public class DisplayCharacters {
    public static void main(String[] args) {
        char c1 = 'c';
        char c2 = 'p';
        int n = 10;
        printChars(c1, c2, n);
    }
    public static void printChars(char ch1, char ch2, int numberPerLine) {
        if (ch1 > ch2)
            System.out.println("Invalid input.  First character should be less than the second.");
        else {
            int counter = 0;
            for (char c = ch1; c <= ch2; c++) {
                if (counter == numberPerLine) {
                    System.out.println();
                    System.out.print(c + " ");
                    counter = 0;
                }
                else {
                    System.out.print(c + " ");
                    counter++;
                }
            }
        }
            
    }
}
