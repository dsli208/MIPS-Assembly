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
public class Time {
    public long hour;
    public long minute;
    public long second;
    public Time() {
        long totalSeconds = System.currentTimeMillis() / 1000;
        second = totalSeconds % 60;
        long totalMins = totalSeconds / 60;
        minute = totalMins % 60;
        long totalHours = totalMins / 60;
        hour = totalHours % 24;
    }
    public Time(long millis) {
        long totalSeconds = millis / 1000;
        second = totalSeconds % 60;
        long totalMins = totalSeconds / 60;
        minute = totalMins % 60;
        long totalHours = totalMins / 60;
        hour = totalHours % 24;
    }
    public Time(long nHour, long nMin, long nSecond) {
        hour = nHour;
        minute = nMin;
        second = nSecond;
    }
    public void setTime(long elapseTime) {
        long totalSeconds = elapseTime/ 1000;
        second = totalSeconds % 60;
        long totalMins = totalSeconds / 60;
        minute = totalMins % 60;
        long totalHours = totalMins / 60;
        hour = totalHours % 24;
    }
    public long getHour() {
        return hour;
    }
    public long getMinute() {
        return minute;
    }
    public long getSecond() {
        return second;
    }
}
class testTime {
    public static void main(String[] args) {
        Time t1 = new Time();
        Time t2 = new Time(555550000);
        System.out.println("Time 1: " + t1.getHour() + ":" + t1.getMinute() + ":" + t1.getSecond());
        System.out.println("Time 2: " + t2.getHour() + ":" + t2.getMinute() + ":" + t2.getSecond());
    }
}