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
public class ApproximateSquareRoot {
    public static void main(String[] args) {
        int n = 100;
        double approximation = sqrt(n);
        System.out.println("The approximation is " + approximation);
    }
    public static double sqrt(int n) {
        double lastGuess = n;
        double nextGuess = 0;
        boolean solved = false;
        while (solved == false) {
            nextGuess = (lastGuess + (n / lastGuess)) / 2;
            if (Math.abs(nextGuess - lastGuess) < 0.001)
                solved = true;
            else
                lastGuess = nextGuess;
        }
        return nextGuess;
    }
}
