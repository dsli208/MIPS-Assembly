package CSE373Coding;

import java.util.ArrayList;
import java.util.Arrays;
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
        
        // Algorithm for determining the minimum set cover --> USE BACKTRACKING
        
        
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
    
    // When we add to the set cover, go into the covered array and mark the appropriate elements as covered
    public static void coverSubset(ArrayList<Integer> a, int[] appearances) {
        for (int i = 0; i < a.size(); i++) {
            appearances[a.get(i) - 1]++;
        }
    }
    
    // Determine if every universal element is covered
    public static boolean isASolution(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        for (int i = 0; i < appearances.length; i++) {
            if (appearances[i] <= 0) {
                return false;
            }
        }
        return true;
    }
    
    // If we are given a solution, proces it
    public void processSolution(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        System.out.println(solutionVector.toString());
    }
    
    // Construct our candidates --> Is this correct?
    public ArrayList constructCandidates(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        // A candidate is a subset used to create the minimum set cover
        ArrayList candidates = new ArrayList<>(); // Correct solution? Ask about this in office hours today
        // Anything not in the solution vector yet can be a candidate
        for (int i = 0; i < subsets.length; i++) {
            if (!(solutionVector.contains(subsets[i]))) {
                candidates.add(subsets[i]);
            }
        }
        return candidates;
    }
    
    // Backtracking function
    public void backtrack(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        if (isASolution(solutionVector, k, subsets, appearances)) {
            processSolution(solutionVector, k, subsets, appearances);
        }
        else {
            k++;
            ArrayList candidates = constructCandidates(solutionVector, k, subsets, appearances);
            
            for (int i = 0; i < candidates.size(); i++) {
                
            }
        }
    }
}
