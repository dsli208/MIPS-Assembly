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
        int i = 0;
        while (students[i] != student) {
            i++;
        }
        for (int j = i; j < students.length - 1; j++) {
            students[j] = students[j + 1];
        }
    }
    public void clear() {
        for (int i = 0; i < students.length; i++) {
            students[i] = "";
        }
    }
    public void increaseSize() {
        String[] studentsCopy = new String[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            studentsCopy[i] = students[i];
        }
        students = studentsCopy;
    }
}
class testCourse {
    public static void main(String[] args) {
        Course c = new Course("Class");
        c.addStudent("David");
        c.addStudent("Anna");
        c.addStudent("Joe");
        c.dropStudent("Anna");
        for (int i = 0; i < c.getStudents().length; i++) {
            System.out.println(c.getStudents()[i]);
        }
    }
}