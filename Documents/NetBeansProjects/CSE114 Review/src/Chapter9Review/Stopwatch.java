/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

/**
 *
 * @author dsli
 */
public class Stopwatch {
    
    private long startTime = 0;
    private long endTime = 0;
    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    public long getTime() {
        return (endTime - startTime);
    }
    public Stopwatch() {}
}
class testStopwatch {
    public static void main(String[] args) {
        Stopwatch watch1 = new Stopwatch();
        int[] numbers = new int[100000];
        int[] sorted = new int[100000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 100000);
        }
        watch1.start();
        for (int i = 0; i < numbers.length - 1; i++) {
            int minimum = 100000;
            int minIndex = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < minimum) {
                    minimum = numbers[j];
                    minIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
        watch1.stop();
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            if (i % 10 == 0)
                System.out.println();
        }
        System.out.println("The time elapsed is " + watch1.getTime());
    }
    
}