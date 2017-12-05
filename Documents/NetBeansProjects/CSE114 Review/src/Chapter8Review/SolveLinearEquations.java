/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter8Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SolveLinearEquations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a[0][0], a[0][1], a[1][0], and a[1][1]");
        double[][] a = new double[2][2];
        a[0][0] = input.nextDouble();
        a[0][1] = input.nextDouble();
        a[1][0] = input.nextDouble();
        a[1][1] = input.nextDouble();
        double[] b = new double[2];
        System.out.println("Enter b[0] and b[1]");
        b[0] = input.nextDouble();
        b[1] = input.nextDouble();
        double[] answer = {0, 0};
        if (a[0][0] * a[1][1] - a[0][1] * a[1][0] == 0)
            System.out.println("The equation has no solution.");
        else {
            answer = linearEquation(a, b);
            System.out.println("x = " + answer[0]);
            System.out.println("y = " + answer[1]);
        }
    }
    
    public static double[] linearEquation(double[][] a, double[] b) {
        double[] array = new double[2];
        array[0] = (b[0] * a[1][1] - b[1] * a[0][1]) / (a[0][0] * a[1][1] - a[0][1] * a[1][0]);
        array[1] = ((b[1] * a[0][0] - b[0] * a[1][0]) / (a[0][0] * a[1][1] - a[0][1] * a[1][0]));
        return array;
    }
}
