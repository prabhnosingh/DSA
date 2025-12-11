class Solution {

    //Solving on 11 Dec 2025:

    //intuition 1 (DP : 2D: Bottom-Up Solution):
        //We can have a 2D matrix to store longest subsequence's length till now in each cell
        
        //Base case: 
            //Set the extra row/col to -INF 
        //Recurrence relation:
            //if text1[i-1] == text2[j-1] => add 1 to the previous diagnol cell in dp (dp[i-1][j-1]) 
                //doing this in order to avoid any duplicate summations. As adding to diagonal ensures that
                    //there was some character, other than current one, that was matched.           
            //else dp[i][j] = max(top + left)
                //top and left are being considered because we need to make sure if any of the previous
                    //addition to the length have resulted in an increase of longest subsequence's length,
                    //and consider the max.


    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j] represents the longest common subsequence between two strings till i length of text1 
            //and j length of text2
        //Assuming length of text1 is tLen1 and length of text2 is tLen2, to find longest common subsequence 
            //between both these strings, we need a dp matrix of tLen1+1 x tLen2+1 size

        int rows = text1.length();
        int cols = text2.length();

        int[][] dp = new int[rows + 1][cols + 1];

        for(int j = 0; j < cols + 1; j ++){
            dp[0][j] = 0;
        }

        for(int i = 0; i < rows + 1; i ++){
            dp[i][0] = 0;
        }

        for(int i = 1; i < rows + 1; i ++){
            for(int j = 1; j < cols + 1; j ++){
                int match = text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0;
                // if(i == 1 && j == 1){
                //     dp[1][1] = match;
                //     continue;
                // }
                if(match == 1){
                    dp[i][j] = match + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }

        return dp[rows][cols];
    
    }
}