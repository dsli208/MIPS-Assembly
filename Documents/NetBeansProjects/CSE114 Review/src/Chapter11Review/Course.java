/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;

/**
 *
 * @author dsli
 */
public class Course {
    private String courseName;
    ArrayList<String> students = new ArrayList<>();
    public Course(String courseName) {
        this.courseName = courseName;
    }
    public void addStudent(String student) {
        students.add(student);
    }
    public ArrayList getStudents() {
        return students;
    }
    public int getNumberOfStudents() {
        return students.size();
    }
    public String getCourseName() {
        return courseName;
    }
    public void dropStudent(String student) {
        students.remove(student);
    }
    public void clear() {
        students.clear();
    }
}

class TestCourse {
    public static void main(String[] args) {
        Course c = new Course("Class");
        c.addStudent("David");
        c.addStudent("Anna");
        c.addStudent("Joe");
        c.addStudent("Brian");
        c.addStudent("Vincent");
        c.dropStudent("Joe");
        for (int i = 0; i < c.students.size(); i++) {
            System.out.println(c.students.get(i));
        }
    }
}