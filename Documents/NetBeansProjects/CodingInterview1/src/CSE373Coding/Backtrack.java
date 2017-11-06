package backtracking;

import java.util.Arrays;

public class Backtrack {
    
    private boolean finished = false;
    
    public static void main(String args[]){
        // Printing permutations using backtracking 
        // {1, 2, 3}
        int input[] = {1,2,3,4}, solutionVector[] = new int[input.length];
        boolean isInArray[] = new boolean[input.length];
        Backtrack bk = new Backtrack();
        bk.backtrack(solutionVector, 0, input, isInArray);
    }
    
    // Check to see if the current solution vector is a potential 
    // solution
    private boolean isASolution(int solutionVector[], 
            int currentIndex, int input[]){
        // If we have filled in (input.length) elements into solution vector
        // then we have a solution
        return currentIndex == input.length;
    }
    
    // Do something with the solution 
    private void processSolution(int solutionVector[], 
            int currentIndex, int input[]){
        System.out.println(Arrays.toString(solutionVector));
    }
    
    // Determines what candidates are possible for the kth index in
    // solution vector based on the elements already in the3 solution vector
    private int[] constructCandidates(int solutionVector[], 
            int currentIndex, int input[], boolean isInArray[]){
        int candidates[] = new int[input.length - currentIndex];
        for(int i = 0, j = 0; i < input.length; ++i){
            if(!isInArray[i]){ 
                // any element not already in the solution vector is a possible 
                // candidate
                candidates[j++] = i;
            }
        }
        return candidates;
    }
    
    public void backtrack(int solutionVector[], 
            int currentIndex, int input[], boolean isInArray[]) {
        // Check if we've filled up the solution vector
        if(isASolution(solutionVector, currentIndex, input)){
            // print it
            processSolution(solutionVector, currentIndex, input);
        }
        else{
            // get candidates
            int candidates[] = 
            constructCandidates(
                solutionVector, 
                currentIndex, input, isInArray
            );
            for(int i = 0; i < candidates.length; ++i){
                // place candidate into solution vector
                solutionVector[currentIndex] = input[candidates[i]];
                // mark candidate as placed into solution
                isInArray[candidates[i]] = true;
                // continue with backtracking
                backtrack(solutionVector, currentIndex+1,input, isInArray);
                // unmark candidate 
                // (we will replace candidate with new candidate upon next iteration
                // therefore we can set old candidate as not in the solution vector
                isInArray[candidates[i]] = false;
            }
        }
    }
}
