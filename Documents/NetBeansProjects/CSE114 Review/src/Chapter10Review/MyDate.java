/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

import java.util.GregorianCalendar;

/**
 *
 * @author dsli
 */
public class MyDate {
    private long year = (java.util.GregorianCalendar.YEAR);
    private long month = (java.util.GregorianCalendar.MONTH);
    private long day = java.util.GregorianCalendar.DAY_OF_MONTH;
    public MyDate() {
        GregorianCalendar c = new GregorianCalendar();
        this.year = c.get(GregorianCalendar.YEAR);
        this.month = c.get(GregorianCalendar.MONTH);
        this.day = c.get(GregorianCalendar.DAY_OF_MONTH);
    }
    public MyDate(long elapseTime) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTimeInMillis(elapseTime);
        this.year = c.get(GregorianCalendar.YEAR);
        this.month = c.get(GregorianCalendar.MONTH);
        this.day = c.get(GregorianCalendar.DAY_OF_MONTH);
    }
    public MyDate(long y, long m, long d) {
        this.year = y;
        this.month = m;
        this.day = d;
    }
    public long getYear() {return year;} public long getMonth() {return month;} public long getDay() {return day;}
    public void setDate(long elapsedTime) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTimeInMillis(elapsedTime);
        this.year = c.get(GregorianCalendar.YEAR);
        this.month = c.get(GregorianCalendar.MONTH);
        this.day = c.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
class testMyDate {
    public static void main(String[] args) {
        MyDate d1 = new MyDate();
        MyDate d3 = new MyDate(561555550000L);
        MyDate d2 = new MyDate(34344444133101L);
        System.out.println(d1.getYear() + " " + d1.getMonth() + " " + d1.getDay());
        System.out.println(d2.getYear() + " " + d2.getMonth() + " " + d2.getDay());
        System.out.println(d3.getYear() + " " + d3.getMonth() + " " + d3.getDay());
    }
}