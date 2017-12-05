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
public class Split {
    public static String[] split(String s, String regex) {
        String[] result = new String[5];
        int x = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < regex.length(); j++) {
                if (s.charAt(i) == regex.charAt(j)) {
                    result[x] = s.substring(last, i);
                    result[x + 1] = regex.substring(j, j + 1);
                    x += 2;
                    if (x == result.length) {
                        String[] resultCopy = new String[result.length * 2];
                        for (int a = 0; a < result.length; a++)
                            resultCopy[a] = result[a];
                        result = resultCopy;
                    }
                }
            }
        }
        return result;
    }
}
