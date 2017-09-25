/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedhashmap;

/**
 * Object 2 for the FixedHashMap, contains Person info
 * 
 * @author dsli
 */
public class FixedHashMapNode2 {
    private String name;
    private String address;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public FixedHashMapNode2(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + "\nAddress: " + this.address + "\nAge: " + this.age;
    }
}
