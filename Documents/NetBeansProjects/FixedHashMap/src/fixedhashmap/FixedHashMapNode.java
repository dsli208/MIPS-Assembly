/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixedhashmap;

/**
 *
 * @author dsli
 */
public class FixedHashMapNode {
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
    
    public FixedHashMapNode(double number, String information) {
        this.number = number;
        this.information = information;
    }
    
    
}
