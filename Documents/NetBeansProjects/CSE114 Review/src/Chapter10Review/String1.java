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
public class String1 {
    public String1(char[] chars) {
        c = chars;
    }
    private char[] c;
    public char charAt(int index) {
        return c[index];
    }
    public int length() {
        return c.length;
    }
    public String1 substring(int begin, int end) {
        int length = end - begin;
        char[] sub = new char[length];
        for (int i = 0; i < sub.length; i++) {
            sub[i] = c[begin + 1];
        }
        String1 s = new String1(sub);
        return s;
    }
    public String1 toLowerCase() {
        for (int i = 0; i < c.length; i++) {
            char a = Character.toLowerCase(c[i]);
            c[i] = a;
        }
        return new String1(c);

    }
    public boolean equals(String1 s) {
        if (s.length() != this.length())
            return false;
        for (int i = 0; i < c.length; i++) {
            if (this.charAt(i) != s.charAt(i))
                return false;
        }
        return true;
    }
    public static String1 valueOf(int i) {
        String s = i + "";
        char[] c1 = s.toCharArray();
        String1 s1 = new String1(c1);
        return s1;
        //return new String1(new char[(char)(i)]);
    }
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < c.length; i++) {
            s += c[i];
        }
        return s;
    }
}
class String1Class {
    public static void main(String[] args) {
        char[] subject = {'J', 'A', 'V', 'A', ' ', 'P', 'R', 'O', 'G', 'R', 'A', 'M'};
        char[] subject2 = {'J', 'A', 'V', 'A', ' ', 'P', 'R', 'O', 'G', 'R', 'A', 'M'};
        String1 test = new String1(subject);
        System.out.println(test.charAt(2));
        String1 test2 = test;
        System.out.println(test2.charAt(0) == 'J');
        String1 test3 = new String1(subject);
        System.out.println(test.equals(test3));
        System.out.println(test);
        System.out.println(test2);
        System.out.println(test3);
    }
}