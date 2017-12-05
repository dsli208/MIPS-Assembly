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
public class RandomCharacters {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 0; i < 100; i++) {
            if (counter % 10 == 0) {
                System.out.println();
                System.out.print(getRandomUpperCaseLetter() + " ");
                counter++;
                
            }
            else {
                System.out.print(getRandomUpperCaseLetter() + " ");
                counter++;
            }
            
        }
        System.out.println();
        counter = 0;
        
        for (int i = 0; i < 100; i++) {
            if (counter % 10 == 0) {
                System.out.println();
                System.out.print(getRandomDigit() + " ");
                counter++;
            }
            else {
                System.out.print(getRandomDigit() + " ");
                counter++;
            }
        }
    }
    
    public static char getRandomUpperCaseLetter() {
        return getRandomCharacter('A', 'Z');
    }
    
    public static char getRandomCharacter(char ch1, char ch2) {
        return ((char)(ch1 + Math.random()* (ch2 - ch1)));
    }
    
    public static char getRandomDigit() {
        return getRandomCharacter('0', '9');
    }
}
