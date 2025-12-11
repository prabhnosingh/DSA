class Solution {

    //Solving on 10 Dec 2025:

    //intuition 1 (DP: Bottom-Up Solution): 
        //Solve with 2D dynamic programming matrix
        //We can store the minimum sum possible for each cell in the matrix
        //Since we can only move in the right or down direction, we can only approach a particular cell
            //from left (i, j-1) or top (i-1, j).
        //Base case: 
            //Fill the first row and first col with positive infinity
        //Recurrence relation:
            //For any cell consider the minimum of its top and left cells.
            //dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
        

    public int minPathSum(int[][] grid) {
        //dp[i][j] represents the minimum sum possible to reach i-1, j-1
        //Therefore, to reach m-1, n-1 we need m+1 x n+1 size matrix

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows + 1][cols + 1];

        //filling first col with infinity
        for(int i = 0; i < rows + 1; i ++){
            dp[i][0] = Integer.MAX_VALUE;
        }

        //filling first row with infinity
        for(int j = 0; j < cols + 1; j ++){
            dp[0][j] = Integer.MAX_VALUE;
        }
        
        for(int i = 1; i < rows + 1; i ++){
            for(int j = 1; j < cols + 1; j ++){
                if(i == 1 && j == 1) {
                    dp[1][1] = grid[0][0];
                    continue;
                }
                dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i-1][j], dp[i][j-1]);
                // System.out.println("i : " + i + ", j : " + j + " = "+ dp[i][j]);
            }
        }

        return dp[rows][cols];
    }
}