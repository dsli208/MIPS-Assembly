package CSE373Coding;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dsli
 */
public class MinSetCoverFinder {
    public static void main(String[] args) {
        // Taking in the input
        Scanner reader = new Scanner(System.in);
        int u = reader.nextInt();
        int[] universalSet = new int[u];
        int[] appearances = new int[u];
        ArrayList[] appearanceList = new ArrayList[u];
        int[] covered = new int[u];
        for (int i = 0; i < universalSet.length; i++) {
            universalSet[i] = i + 1;
        }
        int numSubsets = reader.nextInt();
        String placeholder = reader.nextLine();
        ArrayList[] subsets = new ArrayList[numSubsets];
        for (int i = 0; i < numSubsets; i++) {
            String input = reader.nextLine();
            String[] inputArray = input.split(" ");
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < inputArray.length; j++) {
                subset.add(Integer.parseInt(inputArray[j]));
            }
        }
        
        // Algorithm for determining the minimum set cover
        
        // find elements that only appear once
        for (int i = 0; i < subsets.length; i++) {
            ArrayList<Integer> currSubset = subsets[i];
            for (int j = 0; j < currSubset.size(); j++) {
                appearances[currSubset.get(j) - 1]++;
                appearanceList[currSubset.get(j)].add(i);
            }
        }
        
        for (int i = 0; i < appearances.length; i++) {
            if (appearances[i] == 1) { // the element appears only once, so we MUST use this subset
                ArrayList<Integer> subset = (ArrayList)appearanceList[i].get(0);
            }
        }
    }
    
    // Determines whether an element in the universal set is covered
    public static boolean isCovered(int n, int[] universal) {
        for (int i = 0; i < universal.length; i++) {
            if (universal[i] == n)
                return true;
        }
        return false;
    }
    
    // The below two methods reset appearances
    public static void resetCountArray(int[] count, boolean[] appears) {
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        resetAppearances(appears);
    }
    
    private static void resetAppearances(boolean[] appears) {
        for (int i = 0; i < appears.length; i++) {
            appears[i] = false;
        }
    }
    
    public static void coverSubset(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            
        }
    }
    
    public static boolean isASolution(int[] appearances) {
        for (int i = 0; i < appearances.length; i++) {
            if (appearances[i] <= 0) {
                return false;
            }
        }
        return true;
    }
    
    
}
