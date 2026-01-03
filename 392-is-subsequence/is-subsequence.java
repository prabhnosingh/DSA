class Solution {

    //Re-Solving on 03 Jan 2026:
    
    //intuition 1: (2D DP : DP on strings)
        //For any character of t, there are two options, whether to pick it and contribute 
            //towards s subsequnce or not pick it
        //For any current character of t, there are two scenarios:
            //1. If the currChar of t matches with currChar of s
                //In this case we check if the previous dp state where both of these matching
                    //chars were not present, is true or not. 
                //=> dp[i][j] = dp[i-1][j-1]

            //2. If the currChar of t does not match with currChar of s
                //In this case we check if the previous dp state where currChar of t was not
                    //present, is true or not. As it is mismatching so we just not pick it 
                    //towards our building of s subsequence
                //dp[i][j] = dp[i-1][j]

                        
            //=> dp[i][j] = matching && dp[i-1][j-1]

        //Base case:
            //Given empty s and t strings, s is indeed a subsequnce of t, therefore dp[0][0] = true

            //Given empty s and non-empty t, it is possible to form s from t by not picking any char
                //from t, therefore fill first col, starting from 1 index, with true
            
            //Given non-empty s and empty t, it is not possible to from s from t, therefore, fill
                //first row, starting from 1 index, with false

    public boolean isSubsequence(String s, String t) {
        //dp[i][j] represents whether we can form a subsequence first j chars of s from first 
            //i chars of t
        //dp[t.length()][s.length()] will represent whether we can form a subsequence of full s 
            //string from full t string
        //Therefore, we need a 2D DP matrix of size t.length()+1 x s.length()

        int rows = t.length() + 1;
        int cols = s.length() + 1;

        boolean[][] dp = new boolean[rows][cols];

        //base cases
        dp[0][0] = true;

        // filling first row 
        for(int j = 1; j < cols; j ++){
            int i = 0;
            dp[i][j] = false;
        }

        //filling first col
        for(int i = 1; i < rows; i ++){
            int j = 0;
            dp[i][j] = true;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                boolean matching = t.charAt(i-1) == s.charAt(j-1);

                if(matching){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[rows-1][cols-1];
    }
}