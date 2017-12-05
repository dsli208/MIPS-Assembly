/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter11Review;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SumArrayList {
    public static void main(String[] args) {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            numbers.add(input.nextDouble());
        }
        double sum = sum(numbers);
        System.out.println("The sum is " + sum);
    }
    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
