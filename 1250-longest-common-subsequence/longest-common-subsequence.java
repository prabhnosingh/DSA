class Solution {

    //Re-solving on 30 Sept 2026
    //intuition 2: 
        //the longest subsequence can be the shortest string of text1 and text2 if subsequence condition 
            //matches, in which case the short_string.length will be our answer

        //We can traverse both the strings simultaneously and compare the characters using two pointers
        //Now we can have two scenarios:
            //scenario 1: both the characters match
                //in this case we can use this matching character as part of optimal LCS
                    //we increase the subsequence length by 1 and move both the pointers by 1
               
            
            //scenario 2: both the characters do not match. In this case the we have two choices, either
                //to consider including char at i in the subsequence and excluding char at j or to 
                //consider including char at j in the subsequence and excluding char at i
                //in this case we have two choices:
                    //we move either of the pointer by 1 and keep the other as it is
                    //i+1, j
                    //i, j +1

            
        //We can solve this by recursion
            //dp[i][j] will represent length of LCS staring form ith index of text1 till end and jth index of
                //text2 till end 
        //We can also solve this by dp. Why dp?
            //1. Optimal substructure: we need to find longest common subsequence and getting optimal state
                //depends on choosing optimal sub states
            //2. Recomputation of states can occur leading to duplicate work

        //intuition 2: Tabulation (bottom up)

        //dp invariant:
            //dp[i][j] will represent length of LCS starting from ith index of text1 till m-1 and jth index of
                //text2 till n-1
            //dp[0][0] will represent the answer

            //we need to have 1 extra row and 1 extra col at the last of the dp array to accomodate base case
                //of LCS between empty and any other string

            //therefore, we will have dp array of size m+1 x n+1

        //recurrence relation: 
            //if both the chars are equal:
                //dp[i][j] = 1 + dp[i + 1][j + 1]

            //else:
                //dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]) 

        
        //base cases:   
            //fill last col and last row with 0s



        //algorithm:
            //since we need forward states and answer is at dp[0][0] we fill dp array in reverse starting 
                //m-1, n-1



        //memoization:
            //since each state depends on two parameters i, j, we can have an int[][] of size
                //text1.length() x text2.length()

        //TC:
            //each unique state gets computed only once
            //O(m x n)
        
        //SC:
            //O(m x n)


    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int rows = text1.length() + 1;
        int cols = text2.length() + 1;
        int[][] dp = new int[rows][cols];

        //base case 
        //filling last col
        for(int i = 0; i < rows; i ++){
            dp[i][cols-1] = 0;
        }

        //filling last row
        for(int j = 0; j < cols; j ++){
            dp[rows - 1][j] = 0;
        }

        for(int i = rows - 2; i >= 0; i --){
            for(int j = cols - 2; j >= 0; j --){
                int ch1 = text1.charAt(i);
                int ch2 = text2.charAt(j);

                if(ch1 == ch2){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];

        
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 30 Sept 2026
    // //intuition 1: 
    //     //the longest subsequence can be the shortest string of text1 and text2 if subsequence condition 
    //         //matches, in which case the short_string.length will be our answer

    //     //We can traverse both the strings simultaneously and compare the characters using two pointers
    //     //Now we can have two scenarios:
    //         //scenario 1: both the characters match
    //             //in this case we can use this matching character as part of optimal LCS
    //                 //we increase the subsequence length by 1 and move both the pointers by 1
               
            
    //         //scenario 2: both the characters do not match. In this case the we have two choices, either
    //             //to consider including char at i in the subsequence and excluding char at j or to 
    //             //consider including char at j in the subsequence and excluding char at i
    //             //in this case we have two choices:
    //                 //we move either of the pointer by 1 and keep the other as it is
    //                 //i+1, j
    //                 //i, j +1

            
    //     //We can solve this by recursion
    //         //recurse (i, j) will represent length of LCS staring form ith index of text1 till end and jth index of
    //             //text2 till end 
    //     //We can also solve this by dp. Why dp?
    //         //1. Optimal substructure: we need to find longest common subsequence and getting optimal state
    //             //depends on choosing optimal sub states
    //         //2. Recomputation of states can occur leading to duplicate work

    //     //intuition 1: Recursion (top down + memoization)

    //     //dp invariant:
    //         //recurse(i,j) will represent length of LCS starting from ith index of text1 till end and jth index of
    //             //text2 till end
    //         //recurse(0, 0) will represent the answer

    //     //recurrence relation: 
    //         //if both the chars are equal:
    //             //recurse(i, j) = 1 + recurse(i + 1, j + 1)

    //         //else:
    //             //recurse(i, j) = Math.max(recurse(i, j + 1), recurse(i + 1, j)) 

        
    //     //base cases:   
    //         //when i or j reaches end of the strings, return 0 as empty string cannot have 
    //             //any LCS with any other string



    //     //memoization:
    //         //since each state depends on two parameters i, j, we can have an int[][] of size
    //             //text1.length() x text2.length()


        
    //     //TC without memoization:
    //         //exponential
    //         //branching factor <= 2
    //         //max depth = m + n
    //         //O(2 ^ (m + n))


    //     //TC with memoizattion:
    //         //each unique state gets computed only once
    //         //O(m x n)

    //     //SC without memoization:   
    //         //O(m + n) : recursive stack

        
    //     //SC with memoization:
    //         //O(m x n) + O(m + n)


    
    // public int longestCommonSubsequence(String text1, String text2) {
        
    //     int rows = text1.length();
    //     int cols = text2.length();
    //     int[][] dp = new int[rows][cols];

    //     for(int i = 0; i < rows; i ++){
    //         Arrays.fill(dp[i], -1);
    //     }

    //     return recurse(text1, text2, 0, 0, dp);
        
    // }

    // private int recurse(String text1, String text2, int i, int j, int[][] dp){
    //     if(i == text1.length() || j == text2.length()) return 0;

    //     if(dp[i][j] != -1) return dp[i][j];

    //     if(text1.charAt(i) == text2.charAt(j)){
    //         dp[i][j] = 1 + recurse(text1, text2, i + 1, j + 1, dp);
    //         return dp[i][j];
    //     }

    //     dp[i][j] = Math.max(recurse(text1, text2, i + 1, j, dp), recurse(text1, text2, i, j + 1, dp));
    //     return dp[i][j];
    // }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 03 Mar 2026:

//     //intuition 3: Tabulation 
//         //bigger problem: length of common subsequence given text1 string till
//             //idx text1.length-1 and text2 string till idx text2.length-1. 
//         //The parameters of the recursive function will be idx1, idx2 and return type
//             //should be int.
//         //Smaller sub-problem will be the find length of common subsequence while
//             //reducing the idx of each string till 0

//         //Recurrence relation:
//             //expression: 
//                 //f(idx1, idx2)

//             //exploring all possibilities:
//                 //if characers from each string match 
//                     //i.e. text1.charAt(idx1) == text2.charAt(idx2)
//                 //f(idx1-1, idx2-1) then reduce both idx1 and idx2 by 1 and return 1

//                 //if characters from each string do not match
//                 //then explore all possibilities:
//                     //f(idx1-1, idx2) reducing idx1 and keeping idx2 same
//                     //f(idx1, idx2-1) keeping idx1 same and reducing idx2
//                     //f(idx1-1, idx2-1) recucing both idx1 and idx2
                
//             //return
//                 //pick the max of all the possibilities and return

//         //base cases:
//             //if any idx goes below 0 (-1) return 0
//             //if both chars match , return 1


//         //TC: O(mxn)
//         //SC: O(m+n) (recursive stack) + O(mxn) (dp table) 
//             //(There are two changing indices, therefore DP state space is O(mxn)) 

//         //memoization:
//             //variable parameters are idx1 and idx2
//             //therefore we can have a 2D dp matrix of size text1.length x text2.length
//             //here dp[i][j] will represent, longest common subsequence given text1 till 
//                 //index i and text2 till index j
            
//         //tabulation:
//             //base case:
//                 //given 0 characters for text1 and non-zero characters of text2 we can only
//                     //form common subsequence of length 0, hence fill first row with 0's
//                 //given 0 characters for text2 and non-zero characters of text1 we can only
//                     //form common subsequence of length 0, hence fill first col with 0's

                
//             //recurrence relation:
//                 //if the curr char from both the strings matches:
//                     //then current state dp[i][j] depends on the state when both of these chars
//                         //were not present
//                     //dp[i][j] = 1 + dp[i-1][j-1]
//                 //if the current char from both the strings do not match:
//                     //then we have two choices:
//                         //skip curr char from text1, in which case our current dp state will depend
//                             //on the state when the curr char from text1 was not there, i.e. dp[i-1][j]
                    
//                         //skip curr char from text2, in which case our current dp state will depend 
//                             //on the state when the curr char from text2 was not there, i.e. dp[i][j-1]
                    
//                     //we take the max out of these states for our current dp state
//                     //dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])

//     public int longestCommonSubsequence(String text1, String text2) {
//         //dp[i][j] represent length of longest common subsequence given first i charcters of text1
//             //and first j characters of text2
//         //dp[text1.length][text2.length] will represent length of longest common subsequence given the
//             //full text1 and text2 strings
//         //Therefore, we will required a 2D DP matrix of size text1.length + 1 x text2.length + 1

//         int rows = text1.length() + 1;
//         int cols = text2.length() + 1;
        
//         int[][] dp = new int[rows][cols];

//         //base cases
//         dp[0][0] = 0;

//         //filling first col
//         for(int i = 0; i < rows; i ++){
//             int j = 0;
//             dp[i][j] = 0;
//         }

//         //filling first row
//         for(int j = 0; j < cols; j ++){
//             int i = 0;
//             dp[i][j] = 0;
//         }


//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 int t1char = text1.charAt(i-1);
//                 int t2char = text2.charAt(j-1);

//                 if(t1char == t2char){
//                     dp[i][j] = 1 + dp[i-1][j-1];
//                 }

//                 else{
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             }   
//         }

//         return dp[rows-1][cols-1];
   
        
//     }

// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 03 Mar 2025:

    // //intuition 2: Recursion + memoization 
    //     //bigger problem: length of common subsequence given text1 string till
    //         //idx text1.length-1 and text2 string till idx text2.length-1. 
    //     //The parameters of the recursive function will be idx1, idx2 and return type
    //         //should be int.
    //     //Smaller sub-problem will be the find length of common subsequence while
    //         //reducing the idx of each string till 0

    //     //Recurrence relation:
    //         //expression: 
    //             //f(idx1, idx2)

    //         //exploring all possibilities:
    //             //if characers from each string match 
    //                 //i.e. text1.charAt(idx1) == text2.charAt(idx2)
    //             //f(idx1-1, idx2-1) then reduce both idx1 and idx2 by 1 and return 1

    //             //if characters from each string do not match
    //             //then explore all possibilities:
    //                 //f(idx1-1, idx2) reducing idx1 and keeping idx2 same
    //                 //f(idx1, idx2-1) keeping idx1 same and reducing idx2
    //                 //f(idx1-1, idx2-1) recucing both idx1 and idx2
                
    //         //return
    //             //pick the max of all the possibilities and return

    //     //base cases:
    //         //if any idx goes below 0 (-1) return 0
    //         //if both chars match , return 1


    //     //TC: O(mxn)
    //     //SC: O(m+n) (recursive stack) + O(mxn) (dp table) 
    //         //(There are two changing indices, therefore DP state space is O(mxn)) 

    //     //memoization:
    //         //variable parameters are idx1 and idx2
    //         //therefore we can have a 2D dp matrix of size text1.length x text2.length
    //         //here dp[i][j] will represent, longest common subsequence given text1 till 
    //             //index i and text2 till index j
            
   

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int[][] dp = new int[text1.length()][text2.length()];

    //     for(int i = 0; i < text1.length(); i ++){
    //         Arrays.fill(dp[i], -1);
    //     }
    //     return recurse(text1.length()-1, text2.length()-1, text1, text2, dp);

    // }

    // private int recurse(int idx1, int idx2, String text1, String text2, int[][] dp){
    //     if(idx1 == -1 || idx2 == -1) return 0;
    //     if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    //     if(text1.charAt(idx1) == text2.charAt(idx2)){
    //         return 1 + recurse(idx1-1, idx2-1, text1, text2, dp);
    //     } 

    //     int pos1 = recurse(idx1 - 1, idx2, text1, text2, dp);
    //     int pos2 = recurse(idx1, idx2 - 1, text1, text2, dp);
    //     // int pos3 = recurse(idx1-1, idx2-1, text1, text2); //not necessary 
    //         //as already covered under pos1 and pos2

    //     dp[idx1][idx2] = Math.max(pos1, pos2);
    //     // return Math.max(Math.max(pos1, pos2), pos3);
    //     return Math.max(pos1, pos2);
        
    // }


///////////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 03 Mar 2025:

    // //intuition 1: recursion
    //     //bigger problem: length of common subsequence given text1 string till
    //         //idx text1.length-1 and text2 string till idx text2.length-1. 
    //     //The parameters of the recursive function will be idx1, idx2 and return type
    //         //should be int.
    //     //Smaller sub-problem will be the find length of common subsequence while
    //         //reducing the idx of each string till 0

    //     //Recurrence relation:
    //         //expression: 
    //             //f(idx1, idx2)

    //         //exploring all possibilities:
    //             //if characers from each string match 
    //                 //i.e. text1.charAt(idx1) == text2.charAt(idx2)
    //             //f(idx1-1, idx2-1) then reduce both idx1 and idx2 by 1 and return 1

    //             //if characters from each string do not match then explore all possibilities:
    //                 //f(idx1-1, idx2) reducing idx1 and keeping idx2 same
    //                 //f(idx1, idx2-1) keeping idx1 same and reducing idx2
    //                 //f(idx1-1, idx2-1) recucing both idx1 and idx2
                
    //         //return
    //             //pick the max of all the possibilities and return

    //     //base cases:
    //         //if any idx goes below 0 (-1) return 0
    //         //if both chars match , return 1
    //     
    //     //TC: O(2^(m+n))
    //          //“In the worst case when characters don’t match, each state branches into 
    //              //two recursive calls (i-1,j) and (i,j-1), i.e. skip character from text1 or 
    //              //skip character from text2. The recursion depth is at most m+n, so the recursion
    //              //tree can have up to 2^(m+n) nodes, giving time complexity O(2^(m+n)).” 
    //     //SC: O(m+n) where m and n are size of text1 and text2

    // public int longestCommonSubsequence(String text1, String text2) {
       
    //     return recurse(text1.length()-1, text2.length()-1, text1, text2);

    // }

    // private int recurse(int idx1, int idx2, String text1, String text2){
    //     if(idx1 == -1 || idx2 == -1) return 0;
    //     if(text1.charAt(idx1) == text2.charAt(idx2)){
    //         return 1 + recurse(idx1-1, idx2-1, text1, text2);
    //     } 

    //     int pos1 = recurse(idx1 - 1, idx2, text1, text2);
    //     int pos2 = recurse(idx1, idx2 - 1, text1, text2);
    //     // int pos3 = recurse(idx1-1, idx2-1, text1, text2); //not necessary 
    //         //as already covered under pos1 and pos2

    //     // return Math.max(Math.max(pos1, pos2), pos3);
    //     return Math.max(pos1, pos2);
        
    // }






























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 14 Dec 2025:

//     //intuition 1 (DP : 2D : Bottom-up Tabulation Solution : DP on strings pattern / DP on prefixes of strings)
//         //Recurrence relation: 
//             //We have two scenarios:
//                 //1. When current char from text1 == current char from text2. In this case we increase our LCS
//                     //count by 1 and add it to dp state where both of the current chars were not added (dp[i-1][j-1])
//                     //This gives dp[i][j] = 1 + dp[i-1][j-1]
//                     //Suproblem reduces to finding the LCS on strings where both of the matching chars were not added
//                 //2. When the current char from text1 != current char from text2. In this case we take max of two cases:
//                     //i. What if current char from text1 was not added, resulting in i-1 length of text1? What will be the 
//                         //dp state in that case? => dp[i-1][j] => We can do this as in a subsequence skipping charcters 
//                         //is allowed.
//                         //Subproblem reduces to finding the LCS on strings where text1's latest char was not added
//                     //ii. What if current char from text2 was not added, resulting in j-1 length of text2? What will be
//                         //the dp state in that case? => dp[i][j-1] => We can do this as in a subsequence skipping characters
//                         //is allowed.
//                         //Subproblem reduces to finding the LCS on strings where text2's latest char was not added
//                     //This gives dp[i][j] = Math.max(dp[i-1][j] + dp[i][j-1])

//         //Base cases:
//             //Given empty text1, the LCS is 0, therefore, fill the first row with 0
//             //Given empty text2, the LCS is 0, therefore, fill the first col with 0
   

//     public int longestCommonSubsequence(String text1, String text2) {
//         //dp[i][j] represents LCS between text1 till i length and text2 till j length
//         //dp[tex1.length()][text2.length()] will represent LCS between text1 and text2
//         //Therefore, we need a 2D matrix of size text1.length()+1 x text2.length()+1

//         int rows = text1.length() + 1;
//         int cols = text2.length() + 1;

//         int[][] dp = new int[rows][cols];

//         //filling base cases
        
//         dp[0][0] = 0;

//         //filling first row
//         for(int j = 1; j < cols; j ++){
//             dp[0][j] = 0;
//         }

//         //filling first col
//         for(int i = 1; i < rows; i ++){
//             dp[i][0] = 0;
//         }

//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i-1][j-1];
//                 else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

//             }
//         }

//         return dp[rows-1][cols-1];


//     }






























// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 14 Dec 2025:

//     //intuition 1 (DP : 2D: Bottom-Up Tabulation Solution: DP on strings pattern / DP on prefixes of strings)
//         //Base cases:
//             //Fill first row with 0: This is true as given 0 length of text1, the 
//                 //only possible LCS is an empty string and hence, 0
//             //Fill the first col with 0: This is true as given 0 length of text2, the
//                 //only possible LCS is an empty string and hence, 0
//         //Recurrence relation:
//             //If current character from both the strings matches, then the subproblem reduces
//                 //to finding LCS from both of the remaining strings after not considering
//                 //the matching character. => dp[i][j] = 1 + dp[i-1][j-1]
//             //If current character from both the strings does not match, then we have two scenarios:
//                 //1. Skip the current character from text1 and look for LCS in remaining text1 (reduced by 1) with original text2
//                 //2. Skip the current character from text2 and look for LCS in remaining text2 (reduced by 1) with original text1
//                 //And then take the max out of these two as we need LCS
//             //=> dp[i][j] = Math.max(dp[i-1][j](reducing text1 length), dp[i][j-1](reducing text2 length))

//     public int longestCommonSubsequence(String text1, String text2) {
//         //dp[i][j] represents longest common subsequence till i length of text1
//             //and j length of text2
//         //dp[text1.length()][text2.length()] will represent LCS for both the strings
//         //Therefore, we need a 2D matrix of size text1.length()+1 x text2.length()+1

//         int rows = text1.length() + 1;
//         int cols = text2.length() + 1;

//         int[][] dp = new int[rows][cols];


//         //base cases
//         //filling first row
//         for(int j = 0; j < cols; j ++){
//             dp[0][j] = 0;
//         }

//         //filling first col
//         for(int i = 0; i < rows; i ++){
//             dp[i][0] = 0;
//         }


//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(text1.charAt(i - 1) == text2.charAt(j - 1)){
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 }
//                 else{
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }

//         return dp[rows - 1][cols - 1];


    
//     }






























// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 11 Dec 2025:

    // //intuition 1 (DP : 2D: Bottom-Up Tabulation Solution):
    //     //We can have a 2D matrix to store longest subsequence's length till now in each cell
        
    //     //Base case: 
    //         //Set the extra row/col to 0
    //     //Recurrence relation:
    //         //if text1[i-1] == text2[j-1] => add 1 to the previous diagnol cell in dp (dp[i-1][j-1]) 
    //             //doing this in order to avoid any duplicate summations. As adding to diagonal ensures that
    //                 //there was some character, other than current one, that was matched. 
    //             //Reson: If one character gets matched, then we are left with i-1 length of text1 and j-1 length 
    //                 //of text2 to compare
    //         //else dp[i][j] = max(top + left)
    //             //top and left are being considered because we need to make sure if any of the previous
    //                 //addition to the length have resulted in an increase of longest subsequence's length,
    //                 //and consider the max.


    // public int longestCommonSubsequence(String text1, String text2) {
    //     //dp[i][j] represents the longest common subsequence between two strings till i length of text1 
    //         //and j length of text2
    //     //Assuming length of text1 is tLen1 and length of text2 is tLen2, to find longest common subsequence 
    //         //between both these strings, we need a dp matrix of tLen1+1 x tLen2+1 size

    //     int rows = text1.length();
    //     int cols = text2.length();

    //     int[][] dp = new int[rows + 1][cols + 1];

    //     for(int j = 0; j < cols + 1; j ++){
    //         dp[0][j] = 0;
    //     }

    //     for(int i = 0; i < rows + 1; i ++){
    //         dp[i][0] = 0;
    //     }

    //     for(int i = 1; i < rows + 1; i ++){
    //         for(int j = 1; j < cols + 1; j ++){
    //             int match = text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0;
    //             // if(i == 1 && j == 1){
    //             //     dp[1][1] = match;
    //             //     continue;
    //             // }
    //             if(match == 1){
    //                 dp[i][j] = match + dp[i - 1][j - 1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
    //             }
    //         }
    //     }

    //     return dp[rows][cols];
    
    // }
}