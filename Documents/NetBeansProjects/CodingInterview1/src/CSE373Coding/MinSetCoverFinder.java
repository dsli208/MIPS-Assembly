package CSE373Coding;

import java.io.File;
import java.io.FileNotFoundException;
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
    static int minSets = 0;
    public static void main(String[] args) throws FileNotFoundException {
        // Taking in the input
        File f = new File("C:\\Users\\dsli\\OneDrive\\College\\CSE 373\\S-K-100-175.txt");
        Scanner reader = new Scanner(f);
        String uLine = reader.nextLine();
        int u = Integer.parseInt(uLine);
        int[] universalSet = new int[u];
        int[] appearances = new int[u];
        ArrayList[] appearanceList = new ArrayList[u];
        for (int i = 0; i < universalSet.length; i++) {
            universalSet[i] = i + 1;
        }
        String numSubsetsLine = reader.nextLine();
        int numSubsets = Integer.parseInt(numSubsetsLine);
        //String placeholder = reader.nextLine();
        ArrayList[] subsets = new ArrayList[numSubsets];
        for (int i = 0; i < numSubsets; i++) {
            String input = reader.nextLine();
            String[] inputArray = input.split(" ");
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < inputArray.length; j++) {
                subset.add(Integer.parseInt(inputArray[j]));
            }
            subsets[i] = subset;
        }
        minSets = subsets.length;
        // Algorithm for determining the minimum set cover --> USE BACKTRACKING
        ArrayList<ArrayList> solutionVector = new ArrayList<ArrayList>();
        backtrack(solutionVector, 0, subsets, appearances);
        
        /*// find elements that only appear once
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
        }*/
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
    
    // Same as above, but uncovering
    public static void uncoverSubset(ArrayList<Integer> a, int[] appearances) {
        for (int i = 0; i < a.size(); i++) {
            if (appearances[a.get(i) - 1] >= 0)
                appearances[a.get(i) - 1]--;
        }
    }
    
    // Determine if every universal element is covered
    public static boolean isASolution(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        // Correct this ... we are looking for a MINIMUM set cover, so the set cover should be of the MINIMUM size
        // First, check to make sure the element is covered
        int sum = 0;
        for (int i = 0; i < appearances.length; i++) {
            if (appearances[i] <= 0) {
                return false;
            }
            else {
                sum += appearances[i];
            }
        }
        return true;
    }
    
    // If we are given a solution, proces it
    public static void processSolution(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        System.out.println(solutionVector.toString());
        System.out.println("Size: " + solutionVector.size());
    }
    
    // Construct our candidates --> Is this correct?
    public static ArrayList<ArrayList> constructCandidates(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
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
    public static void backtrack(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
        if (isASolution(solutionVector, k, subsets, appearances)) {
            processSolution(solutionVector, k, subsets, appearances);
        }
        else {
            ArrayList<ArrayList> candidates = constructCandidates(solutionVector, k, subsets, appearances);
            
            for (int i = 0; i < candidates.size(); i++) {
                ArrayList candidate = candidates.get(i);
                coverSubset(candidate, appearances);
                solutionVector.add(candidate);
                backtrack(solutionVector, k + 1, subsets, appearances);
                solutionVector.remove(candidate);
                uncoverSubset(candidate, appearances);
            }
        }
    }
}
