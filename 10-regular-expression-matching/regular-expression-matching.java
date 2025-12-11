class Solution {

    //Solving on 10 Dec 2025
    //intuition 2 (brute force): 
        //"a*" -> means possible strings that this pattern could match to are ["", "a", "aa", "aaa", .....]
            //empty string because 'a' character could be repeated 0 times
        //".*" -> means possible strings that this pattern could match to are ["", ".", "..", "..." (triple dot), .....]

        //Brute force:
            //anytime we encounter a start we are going to have 2 different decisions:
                //1. choose to use the star and repeat the preceding character
                //2. do not repeat the star and move to the next character in pattern
            //TC: O(2^n) where n is the length of the string 
        
        //DP (Top-down memoization):
            //we can solve this problem by DP using a cache and bring down the TC to O(n.m) where n and m are the lens of
                //string and pattern


        //DP (Bottom-up: Full DP solution):
            //

    public boolean isMatch(String str, String pat) {
      
        return dfs(str, pat, 0, 0);        
    }

    //i is the pointer for string str
    //j is the pointer for string pat
    private boolean dfs(String str, String pat, int i, int j){
        //base cases
        if(i >= str.length() && j >= pat.length()){
            return true;
        }

        if(j >= pat.length()){ //pattern is fully traversed but str is still not traversed
            return false;
        }

        //if string character matches with pattern character or string character is a "." (dot) then matchVar will be true
        boolean matchVar = (i < str.length() && (str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '.'));

        //checking if the j + 1 char in pat is a "*"
        if(j + 1 < pat.length() && pat.charAt(j + 1) == '*'){
            // return (dfs(str, pat, i, j + 2) || //choose a star only in case of a match
            //        (matchVar && dfs(str, pat, i + 1, j)));   //not choosing a star and skipping to next char 
            return ((matchVar && dfs(str, pat, i + 1, j)) || //choose a star only in case of a match
                   dfs(str, pat, i, j + 2));   //not choosing a star and skipping to next char 
        }

        if(matchVar){
            return dfs(str, pat, i + 1, j + 1);
        }

        return false;


    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 09 Dec 2025

    // //intuition 1: This is a DP question. What is the subproblem here?  
    //     //Sub-problem: Does the previous substring matches with pattern?
    //     //It is a 2D DP question. 
    //     //Form a 2D boolean matrix that stores true/false for the whole substring till  
    //         //that cell. If any of the cells become false, break the loop and return
    //         //last cell. The default value of any boolean array is false, so a false will
    //         //be returned.

    //         //To get our answer at dp[patSize - 1][strSize - 1] the we need to know if
    //             //dp[patSize - 2][strSize - 2] (diagonally backward) is a true.
    //         //For any * fill the preceding character for the length of str (increase length of pat) or until
    //             //a different character is encountered

    //     //Base case: 
            

    //     //Recurrence relation:
    //         //See if current character 

    // public boolean isMatch(String str, String pat) {
    //     //dp[i][j] will represent if string till j index is macthing with the pattern that we have
    //         //till i.
         
    //     // if(str.length() != pat.length()) return false; //this is not right, as 
    //         //str = "aaaa" and pat "a*" should give true and not false

    //     if(pat.length() - str.length() > 1) return false; //eg: pat = "a*a", str = "a"

        

    //     return true;

        
    // }
}