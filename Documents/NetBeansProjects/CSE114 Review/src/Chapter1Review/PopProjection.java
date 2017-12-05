/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter1Review;

/**
 *
 * @author dsli
 */
public class PopProjection {
    public static void main(String args[]) {
        int pop = 312032486;
        int yearTime = 31536000;
        int numberBorn = yearTime / 7;
        int numberDead = yearTime / 13;
        int newImmigrants = yearTime / 45;
        for (int i = 0; i < 5; i++) {
            pop = pop + numberBorn + newImmigrants - numberDead;
        }
        
        System.out.println("The population after five years is " + pop + " people.");
    }
}
