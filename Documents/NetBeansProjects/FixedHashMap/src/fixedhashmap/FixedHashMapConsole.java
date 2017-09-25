/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedhashmap;

import java.util.Scanner;

/**
 * Sample program that tests the FixedHashMap using custom FixedHashMapNode
 * objects
 *
 * @author dsli
 */
public class FixedHashMapConsole {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your fixed hash map size: ");
        int size = s.nextInt();
        FixedHashMap map = new FixedHashMap(size);
        String placeholder = s.nextLine();
        boolean run = true;
        while (run) {
            System.out.println("Select a choice from the options below: \nS - Set a key/value pair in the HashMap\nG - get a key/value pair\nD - Delete a key/value pair\nL - get the load factor\nQ - quit");
            String input = s.nextLine();
            char charInput = Character.toUpperCase(input.charAt(0));
            switch (charInput) {
                case 'S': {
                    System.out.print("Enter a key to reference your object: ");
                    String key = s.nextLine();
                    System.out.print("Enter a value 1-3 to determine what type of object you'd like to store: ");
                    int type = s.nextInt();
                    String placeholder1 = s.nextLine();
                    if (type == 1) {
                        System.out.print("Enter a decimal/floating point number: ");
                        double num1 = s.nextDouble();
                        String placeholder2 = s.nextLine();
                        System.out.print("Enter some information: ");
                        String info1 = s.nextLine();
                        try {
                            boolean set1 = map.set(key, new FixedHashMapNode1(num1, info1));
                            if (!set1) {
                                System.out.println("Error.  Insertion of the new object failed.  Try again");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("The FixedHashMap is full.  Remove some objects first.");
                        }
                    } else if (type == 2) {
                        System.out.print("Enter your name: ");
                        String name = s.nextLine();
                        System.out.print("Enter your address: ");
                        String address = s.nextLine();
                        System.out.print("Enter your age: ");
                        int age = s.nextInt();
                        String placeholder2 = s.nextLine();
                        try {
                            boolean set2 = map.set(key, new FixedHashMapNode2(name, address, age));
                            if (!set2) {
                                System.out.println("Error.  Insertion of the new object failed.  Try again.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("The FixedHashMap is full.  Remove some objects first.");
                        }
                    } else if (type == 3) {

                    } else {
                        System.out.println("Invalid input.  Try again.");
                    }
                }
                break;
                case 'G': {
                    System.out.print("Enter a key: ");
                    String key = s.nextLine();
                    if (map.get(key) == null) {
                        System.out.println("No object found.");
                    } else {
                        System.out.println(map.get(key));
                    }
                }
                break;
                case 'D': {
                    System.out.print("Enter a key: ");
                    String key = s.nextLine();
                    boolean deleteValue = map.delete(key);
                    if (deleteValue == false) {
                        System.out.println("No object found.");
                    } else {
                        System.out.println("Delete successful.");
                    }
                }
                break;
                case 'L':
                    System.out.println(map.load());
                    break;
                case 'Q':
                    System.out.println("Thank you for using the FixedHashMap.");
                    run = false;
                    break;
                default:
                    System.out.println("Invalid input.  Try again.");
            }
        }
    }

}
