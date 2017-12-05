/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

/**
 *
 * @author dsli
 */
public class MyCharacter {
    char c;
    public MyCharacter(char c) {
        this.c = c;
    }
    public int compare(char x) {
        if (x == c)
            return 0;
        else if (x > c)
            return 1;
        else
            return -1;
    }
    public static int numericValue(char c) {
        return (int)(c);
    }
    
}
