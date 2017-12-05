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
public class DisplayCurrentDate {
    public static void main(String[] args) {
        long totalMilliseconds = System.currentTimeMillis();
        getSecondsMinutesHoursDays(totalMilliseconds);
    }
    
    public static void getSecondsMinutesHoursDays(long millis) {
        long totalSeconds = millis / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;
        long totalDays = totalHours / 24;
        //long currentDay = getDayCount(totalDays);
        long currentDayOfYear = totalDays % 365;
        long totalYears = totalDays / 365;
        totalDays = totalDays + (int)(totalYears / 4);
        long currentYear = 1970 + totalYears;
        long currentMonth = getMonths(totalDays);
        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond);
        //System.out.println(currentYear + "/" + currentMonth + "/" + currentDay);
    }
    public static boolean isLeapYear(long year) {
        return (year % 4 == 0);
    }
    
    public static int getDayCount(long totalDays) {
        long total = totalDays;
        int monthCount = 0;
        while (totalDays > 28) {
            if (monthCount % 12 == 0 || monthCount % 12 == 6 || monthCount % 12 == 2 || monthCount % 12 == 4 || monthCount % 12 == 7 || monthCount % 12 == 9 || monthCount % 12 == 11) {
                total -= 31;
            }
            else if (monthCount % 12 == 1) {
                if (monthCount % 48 == 0)
                    total -= 29;
                else
                    total -= 28;
            }
            else {
                total -= 30;
            }
            monthCount++;
            if (monthCount % 12 == 0)
                monthCount = 0;
        }
        return (int)(total);
    }
    
    public static int getMonths(long totalDays) {
        int monthCount = 0;
        while (totalDays > 28) {
            if (monthCount % 12 == 0 || monthCount % 12 == 6 || monthCount % 12 == 2 || monthCount % 12 == 4 || monthCount % 12 == 7 || monthCount % 12 == 9 || monthCount % 12 == 11) {
                totalDays = totalDays - 31;
            }
            else if (monthCount % 12 == 1) {
                if (monthCount % 48 == 0)
                    totalDays -= 29;
                else
                    totalDays -= 28;
            }
            else {
                totalDays -= 30;
            }
            monthCount++;
            if (monthCount % 12 == 0)
                monthCount = 0;
        }
        return monthCount;   
    }
    public static void getDate(long millis) {
        long totalSeconds = millis / 1000;
        
    }
}
