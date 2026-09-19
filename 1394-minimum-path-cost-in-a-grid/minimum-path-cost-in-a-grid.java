class Solution {

    //Solving on 19 Sept 2026

    //intuition 1: Recursion 
        //we can start from all the cells in the first row and recursively find the minimum cost to 
            //reach the bottom row

        //This looks like a dp problem. Why dp?
            //1. There is an optimal sub structure required. i.e. to get minimum cost path from 
                //any cell i, j we need minimum optimal cost path of the cells in the below row
            
            //2. There is computation of repeated states that can be memoized

        //dp invariant:
            //recurse(i, j) represents minimum cost path from i, j cell till any cell of last row

            //min(recurse(0, j)) where j = [0, n - 1] will be our answer

        //reucrrence relation:
            //each state recurse(i, j) will be computed from its sub-states with below relation:
                //recurse(i, j) = grid[i][j] + Math.min(moveCost[grid[i][j]][k] +
                    //recurse(i + 1, k)) where k = [0, n - 1]


        //base cases:
            //recurse(i, j) where i == row - 1, return grid[i][j]


        //memoization:
            //each state depends on two coordiates (i, j), so we can have a 2D DP array to store the
                //value of computed states


        //TC without memoization: O(n ^ (m x n))
            //at each state we potentially make n recursive calls and we have m x n total states
            //at every cell in the grid (m x n) we traverse n additional cells from the next row
        //TC with memoization: O(m x n x n) 
            //we only traverse each state once 
        
        //SC without memoization: O((m + n) x n) for recursive stack
        //SC with memoization: O((m + n) x n) + O(m x n)

    public int minPathCost(int[][] grid, int[][] moveCost) {

        int minPathCost = Integer.MAX_VALUE;
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i ++){
            Arrays.fill(dp[i], -1);
        }


        for(int j = 0; j < cols; j ++){
            int i =  0;
            minPathCost = Math.min(minPathCost, recurse(grid, moveCost, i, j, dp));
        }

        return minPathCost;        
    }

    private int recurse(int[][] grid, int[][] moveCost, int i, int j, int[][] dp){
        if(i == grid.length - 1){
            return grid[i][j];
        }

        if(dp[i][j] != -1) return dp[i][j];

        int currMinCost = Integer.MAX_VALUE;

        for(int col = 0; col < grid[0].length; col ++){
            int row = i + 1; 
            currMinCost = Math.min(currMinCost, grid[i][j] + moveCost[grid[i][j]][col] + recurse(grid, moveCost, row, col, dp));

        }
        dp[i][j] = currMinCost;
        return dp[i][j];
    }
}