/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter9Review;

/**
 *
 * @author dsli
 */
public class Fan {
    private int fanSpeed = 1;
    private boolean isOn = false;
    private double radius = 5;
    String color = "Blue";
    public void setFanSpeed(int i) {
        fanSpeed = i;
    }
    public void onOff() {
        isOn = (isOn == true) ? false : true;
    }
    public void setRadius(double i) {
        radius = i;
    }
    public void setColor(String s) {
        color = s;
    }
    public boolean fanPower() {
        return isOn;
    }
    public int getFanSpeed() {
        return fanSpeed;
    }
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public Fan() {}
    public String toString() {
        if (isOn == true)
            return ("The fan speed is " + fanSpeed + ", the color is " + color + ", and the radius is " + radius);
        else
            return ("The fan is off.  It was set to a speed of " + fanSpeed + ".  The color is " + color + " and the radius is " + radius);
    }
}

class testFan{
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.onOff(); fan1.setFanSpeed(3); fan1.setRadius(10); fan1.setColor("Yellow");
        fan2.setFanSpeed(2); fan2.setRadius(5); fan2.setColor("Blue");
        System.out.println(fan1.toString()); System.out.println(fan2.toString());
    }
}
