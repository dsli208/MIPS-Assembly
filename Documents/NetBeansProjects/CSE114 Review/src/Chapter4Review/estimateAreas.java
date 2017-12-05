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
public class estimateAreas {
    public static void main(String[] args) {
        //Let x be latitude, y longitude
        double x_Atlanta = Math.toRadians(33.84); double y_Atlanta = Math.toRadians(-84.47);
        double y_Orlando = Math.toRadians(-81.52); double x_Orlando = Math.toRadians(28.4);
        double y_Savannah = Math.toRadians(-81.21); double x_Savannah = Math.toRadians(32.01);
        double y_Charlotte = Math.toRadians(-80.96); double x_Charlotte = Math.toRadians(35.13);
        double distanceFromOrlandoToSavannah = calculateDistance(x_Orlando, y_Orlando, x_Savannah, y_Savannah);
        double distanceFromSavannahToCharlotte = calculateDistance(x_Savannah, y_Savannah, x_Charlotte, y_Charlotte);
        double distanceFromOrlandoToAtlanta = calculateDistance(x_Orlando, y_Orlando, x_Atlanta, y_Atlanta);
        double distanceFromAtlantaToCharlotte = calculateDistance(x_Atlanta, y_Atlanta, x_Charlotte, y_Charlotte);
        double distanceFromSavannahToAtlanta = calculateDistance(x_Atlanta, y_Atlanta, x_Savannah, y_Savannah);
        double area1 = getAreaOfTriangle(distanceFromOrlandoToAtlanta, distanceFromOrlandoToSavannah, distanceFromSavannahToAtlanta);
        double area2 = getAreaOfTriangle(distanceFromSavannahToAtlanta, distanceFromAtlantaToCharlotte, distanceFromSavannahToCharlotte);
        System.out.println("The area enclosed by these four cities is: " + (area1 + area2) + " km^2");
        
    }
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
    
        final double radius = 6371.01;
        double d = radius * Math.acos(Math.sin((x1)) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
        return d;
    }
    
    public static double getAreaOfTriangle(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
