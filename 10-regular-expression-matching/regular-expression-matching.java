class Solution {

    //Solving on Dec 2025
    //intuition 3 (Bottom-up: 2D DP solution): 

        //DP (Bottom-up: Full DP solution): There are 3 scenarios:
            //1. Pattern char is a normal character and matches with string char or pattern char is a '.'
                //dp[i][j] = dp[i-1][j-1] => we consume 1 character from both str and pat
            //2. Pattern char is a '*' (current j)
                //2A. '*' means zero occurence of x 
                    //dp[i][j] = dp[i][j-2] => we consume 2 characters from the pat and skip both '*' and the 
                        //preceding character of '*'
                //2B. '*' means one or more occcurence of x
                    //dp[i][j] = if(str.charAt(i - 1) == pat.charAt(j - 2) | pat.charAt(j - 2) == '.') dp[i - 1][j]
                    //'*' consumes one str character. Pattern stays at same index and str moves back by one index 

    public boolean isMatch(String str, String pat) {
        //dp[i][j] represents if first i characters of str match with first j characters of pat
        //dp[str.length()][pat.length()] will represent if full str string matches with full pat string
        //Therefore, we need a 2D array of size str.length()+1 x pat.length()+1 

        int rows = str.length() + 1;
        int cols = pat.length() + 1;

        boolean[][] dp = new boolean[rows][cols];

        //base case
        dp[0][0] = true; //given empty pattern string and empty str string, it is true

        //given empty string and non empty pattern, it is only possible to match if 2nd character is a '*'
        //eg: str = "" will match to pat = "a*" or pat = "a*b*"
        //Therefore, fill the first row according to this condition
        for(int j = 2; j < cols; j ++){
            if(pat.charAt(j - 1) == '*'){
                dp[0][j] = dp[0][j - 2];
            }
        }

        //given empty pattern and non empty string, it is not possible to match, so fill the first col with false
        for(int i = 1; i < rows; i ++){
            dp[i][0] = false;
        }


        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                //case 1: if pat char matches str char
                if(str.charAt(i - 1) == pat.charAt(j - 1) || pat.charAt(j - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1]; //we look for previous character result from both the strings
                }

                if(pat.charAt(j - 1) == '*'){
                    //first option: * might mean 0 occurences of pat character at j - 1 in str
                    boolean zeroOccurences = dp[i][j - 2]/*skipping current character of pat to be compared */;
                    
                    //second option: * might mean 1 or more occurences of pat character at j - 1 in str but
                        //this is only possible if str.charAt(i - 1) matches with pat.charAt(j - 2) and 
                        //previous state of str.charAt(i - 1) 
                    boolean oneOrMoreOccurences = false;

                    if(str.charAt(i - 1) == pat.charAt(j - 2)/*character previous to '*' character*/ ||
                        pat.charAt(j - 2) == '.'){
                        oneOrMoreOccurences = dp[i-1][j] /*Was the previous character of str matching with the current '*' char of pat */;
                    }

                    dp[i][j] = zeroOccurences || oneOrMoreOccurences;

                }

            }
        }
        
        return dp[rows - 1][cols - 1];

    
    }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 10 Dec 2025
//     //intuition 2 (Top-Down memoization solution using a cache): use a hashmap for caching your results 
//         //"a*" -> means possible strings that this pattern could match to are ["", "a", "aa", "aaa", .....]
//             //empty string because 'a' character could be repeated 0 times
//         //".*" -> means possible strings that this pattern could match to are ["", ".", "..", "..." (triple dot), .....]

//         //Brute force:
//             //anytime we encounter a start we are going to have 2 different decisions:
//                 //1. choose to use the star and repeat the preceding character
//                 //2. do not repeat the star and move to the next character in pattern
//             //TC: O(2^n) where n is the length of the string 
        
//         //DP (Top-down memoization):
//             //we can solve this problem by DP using a cache and bring down the TC to O(n.m) where n and m are the lens of
//                 //string and pattern


//         //DP (Bottom-up: Full DP solution):
//             //

//     public boolean isMatch(String str, String pat) {
//         HashMap<String, Boolean> cacheMap = new HashMap<>(); 
//         return dfs(str, pat, cacheMap, 0, 0);        
//     }

//     //i is the pointer for string str
//     //j is the pointer for string pat
//     private boolean dfs(String str, String pat, HashMap<String, Boolean> cacheMap, int i, int j){
//         //base cases
//         String cacheKey = i + "," + j;
//         if(cacheMap.containsKey(cacheKey)){
//             return cacheMap.get(cacheKey);
//         }

//         if(i >= str.length() && j >= pat.length()){
//             return true;
//         }

//         if(j >= pat.length()){ //pattern is fully traversed but str is still not traversed
//             return false;
//         }

//         //if string character matches with pattern character or string character is a "." (dot) then matchVar will be true
//         boolean matchVar = (i < str.length() && (str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '.'));

//         //checking if the j + 1 char in pat is a "*"
//         if(j + 1 < pat.length() && pat.charAt(j + 1) == '*'){

//             boolean cacheVal = ((matchVar && dfs(str, pat, cacheMap, i + 1, j)) || //choose a star only in case of a match
//                                dfs(str, pat, cacheMap, i, j + 2));   //not choosing a star and skipping to next char 

//             cacheMap.put(cacheKey, cacheVal);
//             return cacheVal;
//         }

//         if(matchVar){
//             boolean cacheVal = dfs(str, pat, cacheMap, i + 1, j + 1);
//             cacheMap.put(cacheKey, cacheVal);
//             return cacheVal;
//         }

//         cacheMap.put(cacheKey, false);
//         return false;


//     }




// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 10 Dec 2025
    // //intuition 2 (brute force): 
    //     //"a*" -> means possible strings that this pattern could match to are ["", "a", "aa", "aaa", .....]
    //         //empty string because 'a' character could be repeated 0 times
    //     //".*" -> means possible strings that this pattern could match to are ["", ".", "..", "..." (triple dot), .....]

    //     //Brute force:
    //         //anytime we encounter a start we are going to have 2 different decisions:
    //             //1. choose to use the star and repeat the preceding character
    //             //2. do not repeat the star and move to the next character in pattern
    //         //TC: O(2^n) where n is the length of the string 
        
    //     //DP (Top-down memoization):
    //         //we can solve this problem by DP using a cache and bring down the TC to O(n.m) where n and m are the lens of
    //             //string and pattern


    //     //DP (Bottom-up: Full DP solution):
    //         //

    // public boolean isMatch(String str, String pat) {
      
    //     return dfs(str, pat, 0, 0);        
    // }

    // //i is the pointer for string str
    // //j is the pointer for string pat
    // private boolean dfs(String str, String pat, int i, int j){
    //     //base cases
    //     if(i >= str.length() && j >= pat.length()){
    //         return true;
    //     }

    //     if(j >= pat.length()){ //pattern is fully traversed but str is still not traversed
    //         return false;
    //     }

    //     //if string character matches with pattern character or string character is a "." (dot) then matchVar will be true
    //     boolean matchVar = (i < str.length() && (str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '.'));

    //     //checking if the j + 1 char in pat is a "*"
    //     if(j + 1 < pat.length() && pat.charAt(j + 1) == '*'){
    //         return ((matchVar && dfs(str, pat, i + 1, j)) || //choose a star only in case of a match
    //                dfs(str, pat, i, j + 2));   //not choosing a star and skipping to next char 
    //     }

    //     if(matchVar){
    //         return dfs(str, pat, i + 1, j + 1);
    //     }

    //     return false;


    // }


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