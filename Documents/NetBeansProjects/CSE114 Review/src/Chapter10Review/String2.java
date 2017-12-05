/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter10Review;

/**
 *
 * @author dsli
 */
public class String2 {
    public String2(String s) {
        str = s;
    }
    private String str;
    public int compare(String s) {
        return (s.compareTo(str));
    }
    public String2 substring(int begin) {
        return new String2 (str.substring(begin));
    }
    
    public String2 toUpperCase() {
        String u = str.toUpperCase();
        return new String2(u);
    }
    
    public char[] toChars() {
        char[] c = str.toCharArray();
        return c;
    }
    
    public static String2 valueOf(boolean b) {
        return (b == true ? new String2("True") : new String2("False"));
    }
    public String toString() {
        return str;
    }
}
class testString2 {
    public static void main(String[] args) {
        String2 s = new String2("Java program");
        System.out.println(s.compare("Java program"));
        System.out.println(s.substring(5));
        String2 u = s.toUpperCase();
        System.out.println(u);
    }
}