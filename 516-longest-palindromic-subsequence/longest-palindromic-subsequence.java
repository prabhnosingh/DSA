class Solution {

    //Solving on 15 Dec 2025:

    //intuition 1: (2D: DP: Bottom-up Tabulation solution: DP on strings / DP on prefixes of strings pattern)
        //If we reverse the string s to revS and then find the longest common subsequence, we will get the logest
            //palindromic subsequence.
        //This works because a pallindrome subsequence will remain same in a reversed string as in original string,
            //because it is a pallindrome. 
        
        //So now the problem becomes finding longest common subsequence between two strings (s and revS)
        //Recurrence relation: We have two scenarios while comparing characters of both the strings
            //1. the characters from both the strings are equal: In this case simply check for LCS between two strings
                //while excluding common character => 1 (for common char) + dp[i-1][j-1] 
            //2. the characters from both the strings are not equal: In this case we have two further scenarios:
                //i. Do not consider the character from string1, leaving us with the subproblem to find LCS on
                    //remaining length of string1 and initial length of string2 dp[i-1][j]
                //ii. Do not consider the character from string2, leaving us with the subproblem to find LCS on
                    //remaning length of string2 and intial length of string1 dp[i][j-1]
                
                //We take the max of both these scenarios    
                //This way we decide which recent addition we want to keep and which one to exclude from both the 
                    //strings that is causing a mismatch
        
        //Base case:
            //Given an empty string1 and a non-empty string2, the LCS between these will be of length 0, i.e. an 
                //empty string. 
            //Therefore, fill 0 in first row and first col

    public int longestPalindromeSubseq(String s) {
        //dp[i][j] represents the LCS between string1 till length i and string2 till length j
        //dp[string1.length()][string2.length()] will represent the LCS between string1 and string2
        //Therefore, we need a 2D matrix of length string1.length()+1 x string2.length()+1
        
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i --){
            sb.append(s.charAt(i));
        }

        String sRev = sb.toString();

        int rows = s.length()+1;
        int cols = rows;

        int[][] dp = new int[rows][cols];

        //base cases

        //filling first row
        for(int j = 0; j < cols; j ++){
            dp[0][j] = 0;
        }

        //filling first col
        for(int i = 0; i < rows; i ++){
            dp[i][0] = 0;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(s.charAt(i-1) == sRev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[rows-1][cols-1];


    }
}




