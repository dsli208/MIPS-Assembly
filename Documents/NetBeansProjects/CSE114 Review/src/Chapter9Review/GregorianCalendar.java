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
public class GregorianCalendar {
    public static void main(String[] args) {
        java.util.GregorianCalendar cal = new java.util.GregorianCalendar();
        System.out.println(cal.get(cal.YEAR) + ", " + (cal.get(cal.MONTH) + 1) + ", " + cal.get(cal.DAY_OF_MONTH));
        cal.setTimeInMillis(1234567898765L);
        System.out.println(cal.get(cal.YEAR) + ", " + (cal.get(cal.MONTH) + 1) + ", " + cal.get(cal.DAY_OF_MONTH));
    }
}
