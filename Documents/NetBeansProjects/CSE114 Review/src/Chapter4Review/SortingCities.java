/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter4Review;

import java.util.Scanner;

/**
 *
 * @author dsli
 */
public class SortingCities {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first city");
        String city1 = input.nextLine();
        System.out.println("Enter the second city");
        String city2 = input.nextLine();
        System.out.println("Enter the third city");
        String city3 = input.nextLine();
        
        System.out.print("The order of cities is ");
        if (city1.compareTo(city2) < 0 && city2.compareTo(city3) < 0)
            System.out.println(city1 + ", " + city2 + ", and " + city3);
        else if (city1.compareTo(city2) < 0 && city3.compareTo(city2) < 0) {
            if (city1.compareTo(city3) < 0)
                System.out.println(city1 + ", " + city3 + ", and " + city2);
            else
                System.out.println(city3 + ", " + city1 + ", and " + city2);
        }
        else if (city1.compareTo(city2) > 0 && city3.compareTo(city1) > 0)
            System.out.println(city2 + ", " + city1 + ", and " + city3);
        else {
            if (city3.compareTo(city2) > 0)
                System.out.println(city2 + ", " + city3 + ", and " + city1);
            else
                System.out.println(city3 + ", " + city2 + ", and " + city1);
        }
            
    }
}
