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
public class ConvertMillis {
    public static void main(String[] args) {
        long totalMillis = System.currentTimeMillis();
        System.out.println(convertMillis(totalMillis));
    }
    
    public static String convertMillis(long millis) {
        long totalSeconds = millis / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinutes = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;
        String currentTime = currentHour + ":" + currentMinutes + ":" + currentSecond;
        return currentTime;
    }
}
