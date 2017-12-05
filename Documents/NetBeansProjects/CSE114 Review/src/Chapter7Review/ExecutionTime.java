/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7Review;

/**
 *
 * @author dsli
 */
public class ExecutionTime {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] list = {1, 4, 4, 2, 5, -3, 6, 2};
        int i = linearSearch(list, 4);
        int j = linearSearch(list, 7);
        int k = linearSearch(list, 6);
        int l = linearSearch(list, -3);
        int m = linearSearch(list, 4);
        int n = linearSearch(list, 5);
        long endTime = System.currentTimeMillis();
        System.out.println(i + ", " + j + ", " + k + ", " + l + ", " + m + ", " + n);
        System.out.println(endTime - startTime);
    }
    
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }
}
