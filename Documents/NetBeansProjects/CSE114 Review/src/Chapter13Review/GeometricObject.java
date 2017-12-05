/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter13Review;

import java.util.Date;

/**
 *
 * @author dsli
 */
public abstract class GeometricObject extends Object{
    private String color = "White";
    private boolean filled = false;
    private Date dateCreated;
    
    //Default geometric object
    protected GeometricObject() {
        dateCreated = new Date();
    }
    
    //Construct a geometric object with color and filled value
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }
    
    //Return color
    public String getColor() {
        return color;
    }
    
    //Set color
    public void setColor(String color) {
        this.color = color;
    }
    
    //Return filled
    public boolean isFilled() {
        return filled;
    }
    
    //Set filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    //Get date created
    public Date getDateCreated() {
        return dateCreated;
    }
    
    //Abstract methods getArea() and getPerimeter()
    public abstract double getArea();
    public abstract double getPerimeter();

}
