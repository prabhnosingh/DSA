class Solution {

    //Solving on 19 Sept 2026

    //intuition 2: Tabulation (bottom up)

        //This looks like a dp problem. Why dp?
            //1. There is an optimal sub structure required. i.e. to get minimum cost path from 
                //any cell i, j we need minimum optimal cost path of the cells in the below row
            
            //2. There is computation of repeated states that can be memoized
                //The same cell (i, j) can be reached from multiple cells in the previous row

        //dp invariant:
            //dp[i][j] represents minimum cost path from i, j cell till any cell of last row, including
                //grid[i][j]

            //min(dp[0][j]) where j = [0, n - 1] will be our answer
                //i.e. minimum value from first row of dp array will be our answer

        //reucrrence relation:
            //each state dp[i][j] will be computed from its sub-states with below relation:
                //dp[i][j] = grid[i][j] + Math.min(moveCost[grid[i][j]][k] +
                    //dp[i + 1][k]) where k = [0, n - 1]


        //base cases:
            //dp[i][j] where i == row - 1
                //dp[i][j] = grid[i][j]

        //algorithm:
            //as we need to get minimum values in the first row and for computing these values in the 
                //first row, we need to find the values of following rows, we can start from second last
                //row and move towards up


      

        //TC:
        //SC:

    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        //base case: filling last row
        for(int j = 0; j < cols; j ++){
            int i = rows - 1;
            dp[i][j] = grid[i][j];
        }


        for(int i = rows - 2; i >= 0; i --){
            for(int j = 0; j < cols; j ++){
                int currMinPathCost = Integer.MAX_VALUE;
                for(int k = 0; k < cols; k ++){
                    currMinPathCost = Math.min(currMinPathCost,  grid[i][j] + moveCost[grid[i][j]][k] +
                    dp[i + 1][k]);
                }
                dp[i][j] = currMinPathCost;
            }
        }

        int minPathCost = Integer.MAX_VALUE;
        for(int j = 0; j < cols; j ++){
            int i = 0;
            minPathCost = Math.min(minPathCost, dp[i][j]);
        }

        return minPathCost;

    }

     
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 19 Sept 2026

//     //intuition 1: Recursion (top - down + memoization)
//         //we can start from all the cells in the first row and recursively find the minimum cost to 
//             //reach the bottom row

//         //This looks like a dp problem. Why dp?
//             //1. There is an optimal sub structure required. i.e. to get minimum cost path from 
//                 //any cell i, j we need minimum optimal cost path of the cells in the below row
            
//             //2. There is computation of repeated states that can be memoized
//                 //The same cell (i, j) can be reached from multiple cells in the previous row

//         //dp invariant:
//             //recurse(i, j) represents minimum cost path from i, j cell till any cell of last row, including
//                 //grid[i][j]

//             //min(recurse(0, j)) where j = [0, n - 1] will be our answer

//         //reucrrence relation:
//             //each state recurse(i, j) will be computed from its sub-states with below relation:
//                 //recurse(i, j) = grid[i][j] + Math.min(moveCost[grid[i][j]][k] +
//                     //recurse(i + 1, k)) where k = [0, n - 1]


//         //base cases:
//             //recurse(i, j) where i == row - 1, return grid[i][j]


//         //memoization:
//             //each state depends on two coordiates (i, j), so we can have a 2D DP array to store the
//                 //value of computed states


//         //TC without memoization: O(n ^ m)
//             //at each row, we have n possible next columns and there are m rows
//             //therefore, the number of complete paths is n^m
//             //recursion depth is determined by number of rows
//             //"n possible choices at any time over m rows"
//             //"n choices across m rows"

//         //TC with memoization: O(m x n x n) 
//             //n number of choices at each cell and there are m x n cells
//             //we only traverse each state once 
        
//         //SC without memoization: O(m) 
//             //one call per row and there are m rows.
//             //the branching factor n affects time, but not recursion depth
//         //SC with memoization: O(m) + O(m x n)

//     public int minPathCost(int[][] grid, int[][] moveCost) {

//         int minPathCost = Integer.MAX_VALUE;
//         int rows = grid.length;
//         int cols = grid[0].length;

//         int[][] dp = new int[rows][cols];
//         for(int i = 0; i < rows; i ++){
//             Arrays.fill(dp[i], -1);
//         }


//         for(int j = 0; j < cols; j ++){
//             int i =  0;
//             minPathCost = Math.min(minPathCost, recurse(grid, moveCost, i, j, dp));
//         }

//         return minPathCost;        
//     }

//     private int recurse(int[][] grid, int[][] moveCost, int i, int j, int[][] dp){
//         if(i == grid.length - 1){
//             return grid[i][j];
//         }

//         if(dp[i][j] != -1) return dp[i][j];

//         int currMinCost = Integer.MAX_VALUE;

//         for(int col = 0; col < grid[0].length; col ++){
//             int row = i + 1; 
//             currMinCost = grid[i][j] + Math.min(currMinCost, moveCost[grid[i][j]][col] + 
//             recurse(grid, moveCost, row, col, dp));

//         }
//         dp[i][j] = currMinCost;
//         return dp[i][j];
//     }
// }