class Solution {


    /*
    1-Minute Interview Explanation

        “I use dynamic programming where dp[i][j] represents whether the first i characters of the string match 
            //the first j characters of the pattern.

        If the current pattern character is a normal character or . and it matches the string character, then the
            //result depends on the previous characters: dp[i][j] = dp[i-1][j-1].

        The tricky part is handling *. The * always applies to the previous pattern character. It has two possibilities:
            • Zero occurrence: we skip the previous character and *, so dp[i][j] = dp[i][j-2].
            • One or more occurrences: if the previous character matches the string character (or is .), we consume 
                //one character from the string but stay on the same pattern, so dp[i][j] = dp[i-1][j].

        If either case is true, the current state is true.

        I initialize the base cases for empty strings, build the table bottom-up, and return dp[m][n].

        The time and space complexity are both O(m × n).” 
    */






    //Re-Solving on 28 Feb 2026
    //intuition 1: 
        //* can match zero or multiple characters matching to preceding characters

        //recurrence relation: There are 3 scenarios
            //1. If we get normal character in str that matches with patChar or patChar is a '.'
                //Then the current dp state will depend on the previous dp state when both of the
                    //characters from str and pat were not present, i.e. dp[i][j] = dp[i-1][j-1]
            //2. If we get '*' in pat, then we have two sub-choices:
                //2A. We can skip the current element comparison, in which case the current state
                    //will depend on previous dp state when '*' and its preceding character were
                    //not present, while character from str stays as it is. dp[i][j] = dp[i][j-2]
                
                //2B. We can interpret '*' as one or more occurences of x. If current strChar matches
                    //with character preceding to '*' or the character preceding to '*' is '.', then
                    //the current dp state will depend on previous dp state where given current 
                    //strChar is not present and patStr is as it is, i.e. dp[i][j] = d[i-1][j]
            
        //Base case:
            //Given 0 length of str and 0 length of pat, it is possible to match str with pat
                //dp[0][0] = true;
            //Given 0 length of str and non-zero length of pat, it is possible to match str
                //with pat only if second character in pat is a '*' else not possible
                //if(pat.charAt(j-1) == '*') dp[0][j] = dp[i][j-2]; 
            
            //Given non-zero length of str and zero length of pat, it is not possible to match str
                //with pat.
                //dp[i][0] = false;  

    public boolean isMatch(String str, String pat) {

        //dp[i][j] represents whether first i characters of str match with first j
            //characters of string pat
        //dp[str.length][pat.length] will represent whether the str matches with the
            //whole pat.
        //Therefore, we need a 2D dp matrix of size str.length+1 x pat.length+1

        int rows = str.length() + 1;
        int cols = pat.length() + 1;

        boolean[][] dp = new boolean[rows][cols];

        //base cases
        dp[0][0] = true;

        //filling first row
        for(int j = 2; j < cols; j ++){
            int i = 0;
            dp[i][j] = pat.charAt(j-1) == '*' ? dp[i][j-2] : false;
        }

        //filling first col
        for(int i = 1; i < rows; i ++){
            int j = 0;
            dp[i][j] = false;
        }


        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                char strChar = str.charAt(i-1);
                char patChar = pat.charAt(j-1);                
        
                if(patChar == '*'){
                    char prevPatChar = pat.charAt(j-2);
                    //skipping current pat char
                    dp[i][j] = dp[i][j-2];

                    //considering current pat char
                    boolean considerCurrPatChar = (prevPatChar == strChar || prevPatChar == '.') ? 
                        dp[i-1][j] : false; //current strChar is consumed while patChar ('*') stays as is
                    dp[i][j] = dp[i][j] || considerCurrPatChar;
                }

                else{
                    boolean match = strChar == patChar || patChar == '.';
                    dp[i][j] = match ? dp[i-1][j-1] : false;
                }
            }
        }

        return dp[rows-1][cols-1];
    
    }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // /*
    // 1-Minute Interview Explanation

    //     “I use dynamic programming where dp[i][j] represents whether the first i characters of the string match 
    //         //the first j characters of the pattern.

    //     If the current pattern character is a normal character or . and it matches the string character, then the
    //         //result depends on the previous characters: dp[i][j] = dp[i-1][j-1].

    //     The tricky part is handling '*'. The '*' always applies to the previous pattern character. It has two possibilities:
    //         -Zero occurrence: we skip the previous character and *, so dp[i][j] = dp[i][j-2].
    //         -One or more occurrences: if the previous character matches the string character (or is .), we consume 
    //             //one character from the string but stay on the same pattern, so dp[i][j] = dp[i-1][j].

    //     If either case is true, the current state is true.

    //     I initialize the base cases for empty strings, build the table bottom-up, and return dp[m][n].

    //     The time and space complexity are both O(m × n).” 
    // */

    // //Solving on 13 Dec 2025
    // //intuition 3 (Bottom-up: 2D DP solution): 

    //     //DP (Bottom-up: Full DP solution): There are 3 scenarios:
    //         //1. Pattern char is a normal character and matches with string char or pattern char is a '.'
    //             //dp[i][j] = dp[i-1][j-1] => we consume 1 character from both str and pat and now the current
    //                 //state depends on the previous state when the current element from both the strings were
    //                 //not chosen
    //         //2. Pattern char is a '*' (current j in dp and "j-1" index in pat)
    //             //2A. '*' means zero occurence of x 
    //                 //dp[i][j] = dp[i][j-2] => we reduce 2 characters from the pat and skip both '*' and the 
    //                     //preceding character of '*'. dp[i][j-2] here denotes -> given the str till i, what was 
    //                     //the result if we don't consider last two characters from pat (j and j-1)?
    //             //2B. '*' means one or more occcurence of x
    //                 //dp[i][j] = if(str.charAt(i - 1) == pat.charAt(j - 2) || pat.charAt(j - 2) == '.') dp[i - 1][j]
                    
    //                 //str.charAt(i-1) == pat.charAt(j-2) means current character of str matches with character
    //                     //before '*' in pat
    //                 //pat.charAt(j-2) == '.' means if character before '*' in pat is a '.' (dot) 
    //                 //if any of the above conditions is true, then one of the str character matches and now the 
    //                     //current dp state will depend on dp[i-1][j] 

    //                 //'*' consumes/eats one str character at a time. Pattern stays at same index and str moves back 
    //                     //by one index. dp[i - 1][j] here denotes -> given the pat till j, what was the result if
    //                     //we don't consider the last element of str (i-1)?
    //             //if either of 2A or 2B give us true, we make our current dp[i][j] true
    //         //j >= 2 always holds when pat[i - 1] == '*' and pat[j - 2] cannot go out of bounds as '*' can never
    //             //be the first place. It will always follow some other character 
    //         //" '*' either removes the previous character entirely, or consumes one matching character at a time 
    //             //while staying on the same pattern index"
    //         //" '*' either deletes the previous pattern character or keeps consuming the matching str characters"
    // public boolean isMatch(String str, String pat) {
    //     //dp[i][j] represents if first i characters of str match with first j characters of pat
    //     //dp[str.length()][pat.length()] will represent if full str string matches with full pat string
    //     //Therefore, we need a 2D array of size str.length()+1 x pat.length()+1 

    //     int rows = str.length() + 1;
    //     int cols = pat.length() + 1;

    //     boolean[][] dp = new boolean[rows][cols];

    //     //base case
    //     dp[0][0] = true; //given empty pattern string and empty str string, it is a match

    //     //given empty string and non empty pattern, it is only possible to match if 2nd character is a '*'
    //     //eg: str = "" will match to pat = "a*" or pat = "a*b*"
    //     //Therefore, fill the first row according to this condition
    //     for(int j = 2; j < cols; j ++){
    //         if(pat.charAt(j - 1) == '*'){
    //             dp[0][j] = dp[0][j - 2];
    //         }
    //     }

    //     //given empty pattern and non empty string, it is not possible to match, so fill the first col with false
    //     for(int i = 1; i < rows; i ++){
    //         dp[i][0] = false;
    //     }


    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
    //             //case 1: if pat char matches str char
    //             if(str.charAt(i - 1) == pat.charAt(j - 1) || pat.charAt(j - 1) == '.'){
    //                 dp[i][j] = dp[i - 1][j - 1]; //we look for previous character result from both the strings
    //             }

    //             //case 2: if the pat char is a '*'
    //             else if(pat.charAt(j - 1) == '*'){
    //                 //first option: '*' might mean 0 occurences of pat character at "j-2" in str
    //                 //It is like looking for the result, if in case we were not given "x*" in pat, where x is
    //                     //the preceding character of '*'
    //                 boolean zeroOccurences = dp[i][j - 2]/*skipping current character of pat to be compared */;
                    
    //                 //second option: '*' might mean 1 or more occurences of pat character at "j-2" in str but
    //                     //this is only possible if str.charAt(i - 1) matches with pat.charAt(j - 2) or 
    //                     //pat.charAt(j - 2) == '.' and previous state of str.charAt(i - 1) is true given pat chars
    //                     //till j 
    //                 boolean oneOrMoreOccurences = false;

    //                 if(str.charAt(i - 1) == pat.charAt(j - 2)/*character previous to '*' character*/ ||
    //                     pat.charAt(j - 2) == '.'){
    //                     //Consume/eat one character from string and stay on the same pattern. '*' can eat 
    //                         //infinite characters from str given the above if condition is true
    //                     //If preceding character matches, consume one char from string and stay on same pattern
    //                     oneOrMoreOccurences = dp[i-1][j] /*Was the previous character of str matching given 
    //                         //the pat characters till j (current '*')*/;
    //                 }

    //                 dp[i][j] = zeroOccurences || oneOrMoreOccurences;

    //             }

    //         }
    //     }
        
    //     return dp[rows - 1][cols - 1];

    
    // }



























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
//     //Solving on 10 Dec 2025
//     //intuition 2 (brute force): 
//         //"a*" -> means possible strings that this pattern could match to are ["", "a", "aa", "aaa", .....]
//             //empty string because 'a' character could be repeated 0 times
//         //".*" -> means possible strings that this pattern could match to are ["", ".", "..", "..." (triple dot), .....]

//         //Brute force:
//             //anytime we encounter a star we are going to have 2 different decisions:
//                 //1. choose to use the star and repeat the preceding character
//                 //2. do not repeat the star and move to the next character in pattern
//             //TC: O(2^n) where n is the length of the string 
        
//         //DP (Top-down memoization):
//             //we can solve this problem by DP using a cache and bring down the TC to O(n.m) where n and m are the lens of
//                 //string and pattern


//         //DP (Bottom-up: Full DP solution):
//             //

//     public boolean isMatch(String str, String pat) {
      
//         return dfs(str, pat, 0, 0);        
//     }

//     //i is the pointer for string str
//     //j is the pointer for string pat
//     private boolean dfs(String str, String pat, int i, int j){
//         //base cases
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
//             return ((matchVar && dfs(str, pat, i + 1, j)) || //choose a star only in case of a match
//                    dfs(str, pat, i, j + 2));   //not choosing a star and skipping to next char 
//         }

//         if(matchVar){
//             return dfs(str, pat, i + 1, j + 1);
//         }

//         return false;


//     }


// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 09 Dec 2025

//     //intuition 1: This is a DP question. What is the subproblem here?  
//         //Sub-problem: Does the previous substring matches with pattern?
//         //It is a 2D DP question. 
//         //Form a 2D boolean matrix that stores true/false for the whole substring till  
//             //that cell. If any of the cells become false, break the loop and return
//             //last cell. The default value of any boolean array is false, so a false will
//             //be returned.

//             //To get our answer at dp[patSize - 1][strSize - 1] the we need to know if
//                 //dp[patSize - 2][strSize - 2] (diagonally backward) is a true.
//             //For any * fill the preceding character for the length of str (increase length of pat) or until
//                 //a different character is encountered

//         //Base case: 
            

//         //Recurrence relation:
//             //See if current character 

//     public boolean isMatch(String str, String pat) {
//         //dp[i][j] will represent if string till j index is macthing with the pattern that we have
//             //till i.
         
//         // if(str.length() != pat.length()) return false; //this is not right, as 
//             //str = "aaaa" and pat "a*" should give true and not false

//         if(pat.length() - str.length() > 1) return false; //eg: pat = "a*a", str = "a"

        

//         return true;

        
//     }
}