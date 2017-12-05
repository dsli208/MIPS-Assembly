/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

/**
 *
 * @author dsli
 */
public class RandomPointsOnCircle {
    public static void main(String[] args) {
        double r = 40.0;
        double angle1 = Math.random()* (2 * Math.PI);
        double angle2 = Math.random()* (2 * Math.PI);
        double angle3 = Math.random()* (2 * Math.PI);
        double x_1 = r * Math.cos(angle1); double y_1 = r * Math.sin(angle1);
        double x_2 = r * Math.cos(angle2); double y_2 = r * Math.sin(angle2);
        double x_3 = r * Math.cos(angle3); double y_3 = r * Math.sin(angle3);
        System.out.println("The coordinates of the three points are: (" + x_1 + ", " + y_1 + ") (" + x_2 + ", " + y_2 + ") (" + x_3 + ", " + y_3 + ")");
        //Get length of each side
        double a = Math.sqrt(Math.pow(x_2 - x_1, 2) + Math.pow(y_2 - y_1, 2)); // distance from 1 to 2
        double b = Math.sqrt(Math.pow(x_3 - x_2, 2) + Math.pow(y_3 - y_2, 2)); // distance from 2 to 3
        double c = Math.sqrt(Math.pow(x_1 - x_3, 2) + Math.pow(y_1 - y_3, 2)); // distance from 3 to 1
        //Get angles ***
        double triangleAngle1 = Math.acos((Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b));
        double triangleAngle2 = Math.acos((Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / (2 * c * b));
        double triangleAngle3 = Math.acos((Math.pow(c, 2) + Math.pow(a, 2) - Math.pow(b, 2)) / (2 * a * c));
        System.out.println("The three angles are " + triangleAngle1 + " " + triangleAngle2 + " " + triangleAngle3);
        System.out.println(triangleAngle1 + triangleAngle2 + triangleAngle3);
    }
}
