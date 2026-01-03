class Solution {
    
    //Solving on 03 Jan 2026:

    //Intuition 1 (brainstorming):
        //Looks like LCS pattern (longest common subsequence). But LCS only gives length of longest 
            //subsequence, which will be length of t but we need all possible subsequences of length 
            //t.length

        //What is the subproblem?
        
        //It is a DP on substrings pattern.

        
    //Intuition 1: (2D DP : DP on Strings)
        //For each matching s char we have two options: pick or not pick.
        //For each non-matching s char we have one option: not pick.

        //Recurrence relation:
        
            //In this we have two scenarios:
                //1. When both the currChars from s and t match. In this case we have two options:
                    //i. Select the currChar from s and contribute towards matching with t
                        //In this case the recurrence relation is => dp[i-1][j-1] (number of ways 
                        //to form first j-1 chars from t with first i-1 chars from s).
                        
                        //Rationale:
                            //As both the currChars match we look for previous dp state where none of
                                //the chars were present, i.e. dp[i-1][j-1]. Whatever the value of this
                                //state is will be the number of ways to form t string till first j chars
                                //with s string till first i chars. This is true as addition of matching
                                //chars does not change the number of ways.


                    //ii. Do not select the currChar from s
                        //In this case the recurrece relations is => dp[i-1][j] (number of ways
                        //to form first j chars from t with first i-1 chars from s)

                            //Rationale:
                                //Even if both the currChars match, we look for number of ways to form first
                                    //j chars from t in the scenario where currChar from s was not present.
                    
                    //We take summation of both of these options because we are finding number of ways to form
                        //t string from s and each of the option represent ways

                    //=> dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
                
                //2. When both the currChars from s and t do not match. In this case we only have the option 
                    //to not select the currChar from s.
                    //In this case the recurrence relation is => dp[i-1][j] (number of ways to form first j 
                    //chars from t with first i - 1 chars from s). i-1 because we choose not to select the 
                    //current character
                        //Rationale:
                            //If the currChar from s does not match with currChar from j, we cannot choose

                    //dp[i][j] = dp[i-1][j]

            
        //Base case:
            //Given empty s string and empty t string, there is 1 way for t to appear in s. 
            //Therefore, dp[0][0] = 1
            
            //Given empty s string and non-empty t string, there are 0 ways for any t char 
                //to appear in s string
            //Therefore, in first row starting from 1 index, fill all 0s

            //Given non-empty s string and empty t string, there is 1 way for t to appear in 
                //s, i.e. by choosing not to select any char from s
            //Therefore, in first col starting from 1 index, fill all 1s

    public int numDistinct(String s, String t) {
        //dp[i][j] represents number of ways in which t, till first j chars, apprears in s till first i chars
        //dp[s.length][t.length] will represenet number of ways in which full t string appreas in full s string
        //Therefore, we will need a 2D DP matrix of size s.length()+1 x t.length()+1 


        int rows = s.length() + 1;
        int cols = t.length() + 1;

        int[][] dp = new int[rows][cols];

        //base cases:
        //first cell
        dp[0][0] = 1;
        
        //first row
        for(int j = 1; j < cols; j ++){
            int i = 0;

            dp[i][j] = 0;
        }

        //filling first col
        for(int i = 1; i < rows; i ++){
            int j = 0;

            dp[i][j] = 1;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                int currSChar = s.charAt(i-1);
                int currTChar = t.charAt(j-1);

                int pick = dp[i-1][j-1];
                int notPick = dp[i-1][j];

                if(currSChar == currTChar){
                    dp[i][j] = pick + notPick;
                } 
                else{
                    dp[i][j] = notPick; 
                }
            }
        }

        return dp[rows-1][cols-1];



    }
}