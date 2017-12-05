/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.Date;

/**
 *
 * @author dsli
 */
public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = email;
    }
    public String getName() {return name;} public String getAddress() {return address;} public String phoneNumber() {return phoneNumber;} public String getEmailAddress() {return emailAddress;}
    public String toString() {return "The person's name is " + name + ", the address is " + address + ", the phone number is " + phoneNumber + ", and the e-mail address is " + emailAddress;}
}

class Student extends Person {
    private final int classStatus;
    public Student(String name, String address, String email, String phoneNumber, int status) {
        super(name, address, phoneNumber, email);
        classStatus = status;
    }
    @Override
    public String toString() {return "The person's name is " + getName() + ", the address is " + getAddress() + ", the phone number is " + phoneNumber() + ", and the e-mail address is " + getEmailAddress() + ", and their status is " + classStatus;}
}

class Employee extends Person {
    private String officeName;
    private double salary;
    private Date dateHired;
    public Employee(String name, String address, String phoneNumber, String email, String officeName, double salary) {
        super(name, address, phoneNumber, email);
        this.officeName = officeName;
        this.salary = salary;
    }
    public String getOfficeName() {return officeName;} public double getSalary() {return salary;} public Date getDateHired() {return dateHired;}
    @Override
    public String toString() {return "The person's name is " + getName() + ", the address is " + getAddress() + ", the phone number is " + phoneNumber() + ", and the e-mail address is " + getEmailAddress() + ".  The employee works at " + getOfficeName() + " and their salary is " + getSalary();}
}

class Faculty extends Employee {
    private String officeHours;
    private int rank;
    public Faculty(String name, String address, String phoneNumber, String email, String officeName, double salary, String officeHours, int rank) {
        super(name, address, phoneNumber, email, officeName, salary);
        this.officeHours = officeHours;
        this.rank = rank;
    }
    public String getOfficeHours() {return officeHours;} public int getRank() {return rank;}
    @Override
    public String toString() {return "The person's name is " + getName() + ", the address is " + getAddress() + ", the phone number is " + phoneNumber() + ", and the e-mail address is " + getEmailAddress() + ".  The employee works at " + getOfficeName() + " and their salary is " + getSalary() + ".  They work from " + getOfficeHours() + " and their rank is " + getRank();}
}

class Staff extends Employee {
    private String title;
    public Staff(String name, String address, String phoneNumber, String email, String officeName, double salary, String title) {
        super(name, address, phoneNumber, email, officeName, salary);
        this.title = title;
    }
    public String getTitle() {return title;}
    @Override
    public String toString() {return "The person's name is " + getName() + ", the address is " + getAddress() + ", the phone number is " + phoneNumber() + ", and the e-mail address is " + getEmailAddress() + ".  The employee works at " + getOfficeName() + " and their salary is " + getSalary() + ".  Their title is " + getTitle();}
}

class test {
    public static void main(String[] args) {
        Person p = new Person("David", "1111 Something Ave.", "5555555555", "david@something.com");
        System.out.println(p.toString());
    }
}