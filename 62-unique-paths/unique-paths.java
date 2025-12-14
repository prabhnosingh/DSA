class Solution {

    //Re-solving on 13 Dec 2025:

    //intuition 1: 2D Dp - Bottom up Tabulation solution 
        //To reach any cell the robot can come from two directions (top and left) as it is only allowed to move
            //bottom and right. Therefore, if we find the number of unique paths to reach each cell's top and left 
            //neighboring cells add them up together, we can get our unique paths for that cell.
        
        //Base case: 
            //To reach 0,0 there is only 1 path for the robot, i.e. to stay there
            //To reach any cell in the first row, there is only 1 path for robot. Therefore, fill first row with 1 s
            //To reach any cell int the first col, there is only 1 path for robot. Therefore, fill the first col with 1 s

        //Recurrence relation:
            //dp[i][j] = dp[i-1][j] (top) + dp[i][j-1] (left)
    
    public int uniquePaths(int m, int n) {
       //dp[i][j] represents the number of unique paths to reach i, j location.
       //dp[m-1][n-1] will represent the number of unique paths to reach m-1, n-1 location
       //Therefore, we need a 2D matrix of size m x n
        
        int[][] dp = new int[m][n];
        
        //filling first row and col with 1s
        for(int j = 0; j < n; j ++){
            dp[0][j] = 1;
        }
        for(int i = 0; i < m; i ++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 08 Dec 2025:

    // //intuition 1: 
    // //Looks like Backtracking question. But since you know that this was in DP section how can we solve it using DP?
    
    // //After forming and exloring a matrix on paper: To reach [m - 1][n - 1] we should know unique paths possible 
    //     //to reach [m - 2][n - 1] (top) and [m - 1][n - 2] (left) and then add them together, because to reach 
    //     //(m-1, n-1), you can only come from (m-2, n-1) and (m-1)(n-2). Therefore, the recurrence relation would
    //     //be dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    // //Now these form our subproblems.
    // //Base cases will be to fill top row and leftmost column with 1s, as there is only 1 way to reach at any of these
    //     //cells from start. 
    //     //First row -> can come only from the left
    //     //First col -> can come only from above
    // //Then start nested loop from 1,1
    // public int uniquePaths(int m, int n) {
    //     //dp[i][j] represents unique paths possible to reach i, j position.
    //     //Therefore, we need m x n matrix in order to get our answer at dp[m - 1][n - 1]


    //     int[][] dp = new int[m][n];
    //     //filling top row with 1 s
    //     for(int j = 0; j < n; j ++){
    //         dp[0][j] = 1;
    //     } 

    //     //filling left most col with 1 s
    //     for(int i = 0; i < m; i ++){
    //         dp[i][0] = 1;
    //     }


    //     for(int i = 1; i < m; i ++){
    //         for(int j = 1; j < n; j ++){
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }

    //     return dp[m - 1][n - 1];
    // }
}