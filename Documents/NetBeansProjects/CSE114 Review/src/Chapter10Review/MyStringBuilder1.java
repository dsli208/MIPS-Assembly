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
public class MyStringBuilder1 {
    StringBuilder str;
    public MyStringBuilder1(String s) {
        str.append(s);
    }
    public MyStringBuilder1 append(MyStringBuilder1 s) {
        return new MyStringBuilder1(s);
    }
}
