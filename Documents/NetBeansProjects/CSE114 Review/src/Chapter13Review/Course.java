/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.util.Date;

/**
 *
 * @author dsli
 */
public class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;
    
    public Course(String courseName) {
        this.courseName = courseName;
    }
    
    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }
    
    public String[] getStudents() {
        return students;
    }
    
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void dropStudent(String student) {
        boolean matched = false;
        int i = 0;
        while (matched == false && i < students.length) {
            if (students[i] == student)
                matched = true;
            i++;
        }
        if (matched == true) {
            for (int j = i; j < students.length - 1; j++) {
                students[j] = students[j + 1];
            }
        }
    }
    
    //DEEP COPY
    public Object clone() throws CloneNotSupportedException {
        //Shallow/deep copy
        Course courseClone = (Course)super.clone();
        return courseClone;
    }
}
