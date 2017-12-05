/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter2Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class WindChillTemperature {
    public static void main(String args[]) {
        System.out.print("Enter the temperature in Fahrenheit between -58F and 41F");
        Scanner input = new Scanner(System.in);
        double outsideTemp = input.nextDouble();
        System.out.print("Enter the wind speed in mph");
        double windSpeed = input.nextDouble();
        if ((outsideTemp < -58 || outsideTemp > 41) || (windSpeed < 2))
            System.out.print("Invalid input.");
        else
            System.out.print(getWindChillIndex(outsideTemp, windSpeed));
    }
    public static double getWindChillIndex(double t, double v) {
        return 35.74 + 0.6215 * t - 35.75 * Math.pow(v, 0.16) + 0.4275 * t * Math.pow(v, 0.16);
    }
}
