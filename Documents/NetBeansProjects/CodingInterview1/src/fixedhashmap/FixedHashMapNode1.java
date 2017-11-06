/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedhashmap;

/**
 * This is the first type of node object created for the FixedHashMap.  This just has a double number and some information as its data.
 * 
 * @author dsli
 */
public class FixedHashMapNode1 {
    private double number;
    private String information;

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    
    public FixedHashMapNode1(double number, String information) {
        this.number = number;
        this.information = information;
    }
    
    @Override
    public String toString() {
        return "Number: " + this.number + "\nInformation: " + this.information;
    }
    
}
