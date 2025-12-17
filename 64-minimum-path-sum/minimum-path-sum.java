class Solution {

    //Solving on 17 Dec 2025:

    //intuition 1: 2D DP : Bottom up Tabulation : DP on grid pattern : Answer at 0,0
        
        //Recurrence relation:
            //We can only travel right or down, so to find minimum path sum for any cell i,j we
                //can make the decision to choose one path that is minimum from right or down neighboring
                //cells from dp grid and add that to the current cell number from original grid.
            //=> dp[i][j] = grid[i][j] + Math.min(dp[i+1][j](down), dp[i][j+1](right))
        //Base case:
            //For last row we can only travel right as down will lead us to out of bounds. So, we just 
                //add the numbers from right to left, starting from rows-1, cols-1
            //For last col we can only travel down as right will lead us to out of bounds. So, we just
                //add the numbers from bottom to top, starting from rows-1, cols-1

    public int minPathSum(int[][] grid) {
        //dp[i][j] represents the minimum path sum from i, j to bottom right while only travelling down and right
        //dp[0][0] will represent the minimum path sum from 0,0 to bottom right while only travelling down and right
        //The maximum index cell that we will reach is gridRows-1, gridCols - 1. Therefore, we need a matrix of size
            //gridRows x gridCols

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        //base cases
        dp[rows-1][cols-1] = grid[rows-1][cols-1];

        //filling last col
        for(int i = rows-2; i >= 0; i --){
            dp[i][cols-1] = grid[i][cols-1] + dp[i+1][cols-1]; 
        }       

        //filling last row
        for(int j = cols-2; j >= 0; j --){
            dp[rows-1][j] = grid[rows-1][j] + dp[rows-1][j+1];
        }

        for(int i = rows-2; i >= 0; i --){
            for(int j = cols-2; j >= 0; j --){
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }   

        return dp[0][0];
    }




























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 14 Dec 2025:

//     //intuition 1: 2D DP : Bottom up Tabulation : Answer at 0,0
//         //As we can only move down or right, there are only two ways to approach any cell, from top or from left.
        
//         //Base cases:
//             //In last row we can only move right and in last col we can only move down, so fill them by adding 
//                 //the previous sum stored in dp array.
             
//         //Recurrence relation: 
//             //dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j](down), dp[i][j + 1](right))

//     public int minPathSum(int[][] grid) {
//         //dp[i][j] represents the minimum path sum possible from i, j to bottom right m-1, n-1
//         //dp[0][0] will represent the minimum path sum possible from 0,0 to bottom right m-1, n-1
//         //Therefore, we need a 2D matrix of size m x n
        
//         int rows = grid.length;
//         int cols = grid[0].length;

//         int[][] dp = new int[rows][cols];

//         //base cases
//         dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];

//         //filling last col
//         for(int i = rows - 2; i >=0; i --){
//             dp[i][cols - 1] = dp[i + 1][cols - 1] + grid[i][cols - 1];
//         }

//         //filling last row
//         for(int j = cols - 2; j >= 0; j --){
//             dp[rows - 1][j] = dp[rows - 1][j + 1] + grid[rows - 1][j];
//         }


//         for(int i = rows - 2; i >= 0; i --){
//             for(int j = cols - 2; j >= 0; j --){
//                 dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//             }
//         }


//         return dp[0][0];

//     }




























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 10 Dec 2025:

    // //intuition 1 (DP: Bottom-Up Solution): 
    //     //Solve with 2D dynamic programming matrix
    //     //We can store the minimum sum possible for each cell in the matrix
    //     //Since we can only move in the right or down direction, we can only approach a particular cell
    //         //from left (i, j-1) or top (i-1, j).
    //     //Base case: 
    //         //Fill the first/extra row and first/extra col with positive infinity
    //     //Recurrence relation:
    //         //For any cell consider the minimum of its top and left cells.
    //         //dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
        
    //     //We need m+1 x n+1 size matrix to use 1-based indexing trick to avoid boundary checks
    //         //"dp[0][*] and dp[*][0] are sentinel rows/columns set to infinity."

    
    // //TC: O(n x m)
    // //SC: O(n x m)

    // public int minPathSum(int[][] grid) {
    //     //dp[i][j] stores the minimum path sum to reach cell i-1, j-1 index in the grid

    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     int[][] dp = new int[rows + 1][cols + 1];

    //     //filling first col with infinity
    //     for(int i = 0; i < rows + 1; i ++){
    //         dp[i][0] = Integer.MAX_VALUE;
    //     }

    //     //filling first row with infinity
    //     for(int j = 0; j < cols + 1; j ++){
    //         dp[0][j] = Integer.MAX_VALUE;
    //     }
        
    //     for(int i = 1; i < rows + 1; i ++){
    //         for(int j = 1; j < cols + 1; j ++){
    //             if(i == 1 && j == 1) { //because 1,1 is a starting cell and Math.min would have given an infinity
    //                 dp[1][1] = grid[0][0]; 
    //                 continue;
    //             }
    //             dp[i][j] = grid[i - 1][j - 1] + Math.min(dp[i-1][j], dp[i][j-1]);
    //             // System.out.println("i : " + i + ", j : " + j + " = "+ dp[i][j]);
    //         }
    //     }

    //     return dp[rows][cols];
    // }
}