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
public class DaysInYear {
    public static void main(String[] args) {
        int startYear = 2000;
        int endYear = 2020;
        for (int calendarYear = startYear; calendarYear <= endYear; calendarYear++) {
            System.out.println("The year " + calendarYear + " has " + numberOfDaysInAYear(calendarYear) + " days");
        }
    }
    public static int numberOfDaysInAYear(int year) {
        if (year % 4 == 0)
            return 366;
        else
            return 365;
    }
}
