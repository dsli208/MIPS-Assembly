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
public class VehiclePlate {
    public static void main(String[] args) {
        char c1 = (char)(Math.random()* 26 + 65);
        char c2 = (char)(Math.random() * 26 + 65);
        char c3 = (char)(Math.random() * 26 + 65);
        short d1 = (short)(Math.random() * 10);
        short d2 = (short)(Math.random() * 10);
        short d3 = (short)(Math.random() * 10);
        short d4 = (short)(Math.random() * 10);
        System.out.println(c1 + "" + c2 + "" + c3 + "" + d1 + "" + d2 + "" + d3 + "" + d4);
    }
}
