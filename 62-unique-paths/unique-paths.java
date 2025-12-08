class Solution {

    //Solving on 08 Dec 2025:

    //intuition 1: 
    //Looks like Backtracking question. But since you know that this was in DP section how can we solve it using DP?
    
    //After forming and exloring a matrix on paper: To reach [m - 1][n - 1] we should know unique paths possible 
        //to reach [m - 2][n - 1] (top) and [m - 1][n - 2] (left) and then add them together. Therefore, the recurrence
        //relation would be dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    //Now these form our subproblems.
    //Base cases will be to fill top row and leftmost column with 1s, as there is only 1 way to reach at any of these
        //cells from start.
    //Then start nested loop from 1,1
    public int uniquePaths(int m, int n) {
        //dp[i - 1][j - 1] represents unique paths possible to reach i, j position.
        //Therefore, we need m x n matrix in order to get our answer at dp[m - 1][n - 1]


        int[][] dp = new int[m][n];
        //filling top row with 1 s
        for(int j = 0; j < n; j ++){
            dp[0][j] = 1;
        } 

        //filling left most col with 1 s
        for(int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }


        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}