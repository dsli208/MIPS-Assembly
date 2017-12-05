
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class TestStringArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] test = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter string: ");
            test[i] = input.nextLine();
            System.out.println(i);
        }
    }
}
