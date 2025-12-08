class Solution {

    //Solving on 08 Dec 2025:

    //intuition 1: To find number of unique paths possible to reach any index i, j we need to know the number of
        //unique paths possible to reach (i-1, j) and (i, j-1) indices and add them together, as any cell can only
        //be reached from left or top. 
    //After breaking into subproblems, our recurrence relation is: dp[i][j] = dp[i-1][j] + dp[i][j-1], given that
        //either of the subproblem position is not an obstacle, in which case do not consider that in our addition.

    //Have a dp array of same size of obstacleGrid and fill any obstacles with 0 as that particular cell cannot be reached
        //due to obstacle. Base case is to fill top row and first col with 1. If any of the cells is an 
        //obstacle (i.e. 1 in obstacleGrid), we break the loop as any further cells cannot be reached due to obstacle.
 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        //dp[i][j] represents unique paths possible to reach i, j position
        //Therefore to reach m-1, n-1 position we need a grid of m x n size

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(obstacleGrid[rows - 1][cols - 1] == 1) return 0;

        int[][] dp = new int[rows][cols];

        //filling top row with 1 s
        for(int j = 0; j < cols; j ++){
            if(obstacleGrid[0][j] == 1){
                // dp[0][j] = 0; //we do not need this as int[][] is already initialized with 0
                break;
            }
            dp[0][j] = 1;
        }

        //filling first col with 1 s
        for(int i = 0; i < rows; i ++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(obstacleGrid[i][j] == 1) continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rows - 1][cols - 1];

    }
}