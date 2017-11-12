
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class TestBacktrack {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        buildArrayList(a);
        System.out.println(a.toString());
    }
    
    public static void buildArrayList(ArrayList<Integer> a) {
        a.add(13); a.add(25);
    }
}
