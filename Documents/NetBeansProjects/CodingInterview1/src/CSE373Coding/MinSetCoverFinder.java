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
    ArrayList<ArrayList> solutionVector;
    boolean printed;
    ArrayList<ArrayList<ArrayList>> solutionList;
    ArrayList[] subsets;
    int[] appearances;
    
    public MinSetCoverFinder(ArrayList[] subsets, int[] appearances) {
        this.printed = false;
        this.solutionVector = new ArrayList<ArrayList>();
        this.solutionList = new ArrayList<ArrayList<ArrayList>>();
    }

    // Determines whether an element in the universal set is covered
    public boolean isCovered(int n, int[] universal) {
        for (int i = 0; i < universal.length; i++) {
            if (universal[i] == n) {
                return true;
            }
        }
        return false;
    }

    // The below two methods reset appearances
    public void resetCountArray(int[] count, boolean[] appears) {
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        resetAppearances(appears);
    }

    private void resetAppearances(boolean[] appears) {
        for (int i = 0; i < appears.length; i++) {
            appears[i] = false;
        }
    }

    // When we add to the set cover, go into the covered array and mark the appropriate elements as covered
    public void coverSubset(ArrayList<Integer> a, int[] appearances) {
        for (int i = 0; i < a.size(); i++) {
            appearances[a.get(i) - 1]++;
        }
    }

    // Same as above, but uncovering
    public void uncoverSubset(ArrayList<Integer> a, int[] appearances) {
        for (int i = 0; i < a.size(); i++) {
            if (appearances[a.get(i) - 1] >= 0) {
                appearances[a.get(i) - 1]--;
            }
        }
    }

    // Determine if every universal element is covered --> Don't necessarily PROCESS THE SOLUTION YET
    public boolean isASolution(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances, ArrayList<ArrayList<ArrayList>> solutionList) {
        // Correct this ... we are looking for a MINIMUM set cover, so the set cover should be of the MINIMUM size
        // First, check to make sure the element is covered
        int sum = 0;
        for (int i = 0; i < appearances.length; i++) {
            if (appearances[i] <= 0) {
                return false;
            } else {
                sum += appearances[i];
            }
        }

        return true;
    }

    // If we are given a solution, proces it
    public void processSolution(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances, ArrayList<ArrayList<ArrayList>> solutionList) {
        int minsets = subsets.length;
        ArrayList<ArrayList> minSubset = new ArrayList<ArrayList>();
        for (int i = 0; i < solutionList.size(); i++) {
            ArrayList<ArrayList> list = solutionList.get(i);
            if (list.size() < minsets) {
                minSubset = list;
                minsets = list.size();
            }
        }
        System.out.println("Size of minimum set cover: " + minsets);
        System.out.println(minSubset.toString());
    }

    // Construct our candidates --> Is this correct?
    public ArrayList<ArrayList> constructCandidates(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances) {
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
    public void backtrack(ArrayList<ArrayList> solutionVector, int k, ArrayList[] subsets, int[] appearances, ArrayList<ArrayList<ArrayList>> solutionList) {
        if (isASolution(solutionVector, k, subsets, appearances, solutionList)) {
            solutionList.add(solutionVector);
            //if (!printed) {
            processSolution(solutionVector, k, subsets, appearances, solutionList);
            printed = true;
            //System.exit(0);
            //}
        } else {
            ArrayList<ArrayList> candidates = constructCandidates(solutionVector, k, subsets, appearances);

            for (int i = 0; i < candidates.size(); i++) {
                ArrayList candidate = candidates.get(i);
                coverSubset(candidate, appearances);
                solutionVector.add(candidate);
                backtrack(solutionVector, k + 1, subsets, appearances, solutionList);
                solutionVector.remove(candidate);
                uncoverSubset(candidate, appearances);

            }

        }
    }

}

class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        // Taking in the input - EDIT THE STRING PARAMETER OF FILE TO ACCOMMODATE YOUR FILE INPUT
        File f = new File("C:\\Users\\dsli\\OneDrive\\College\\CSE 373\\s-rg-8-10.txt");
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
        for (int i = 0; i < numSubsets && reader.hasNextLine(); i++) {
            String input = reader.nextLine();
            if (input.isEmpty()) {
                ArrayList<Integer> subset = new ArrayList<Integer>();
                subsets[i] = subset;
            } else {
                String[] inputArray = input.split(" ");
                ArrayList<Integer> subset = new ArrayList<Integer>();
                for (int j = 0; j < inputArray.length; j++) {
                    subset.add(Integer.parseInt(inputArray[j]));
                }
                subsets[i] = subset;
            }
        }
        //minSets = subsets.length;
        // Algorithm for determining the minimum set cover --> USE BACKTRACKING
        ArrayList<ArrayList> solutionVector = new ArrayList<ArrayList>();
        ArrayList<ArrayList<ArrayList>> solutions = new ArrayList<ArrayList<ArrayList>>();
        MinSetCoverFinder m = new MinSetCoverFinder(subsets, appearances);
        m.backtrack(solutionVector, 0, subsets, appearances, solutions);
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
}
