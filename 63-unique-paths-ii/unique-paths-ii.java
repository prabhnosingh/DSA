class Solution {    
   

    //Re-solving on 16 Sept 2026

    //intuition 1: Recursion + memoization (top - down)
        //From any cell (i,j), we can only move down or right, i.e., (i+1, j) and (i, j+1)
        //Therefore, the number of paths from (i,j) to the bottom right is the sum of paths obtainable
            //for both of these (bottom and right) cells
        
        //this looks like a DP problem. Why?
            //1. There are subproblems that when calculated, will help us solve the bigger problems
            //2. A single cell (state) can be reached from multiple paths, so we can store the results
                //of already computed states to use in other state's calculation
        
        //Topic: DP
        //Pattern: 2D Grid DP
        //Sub-pattern: 

        //Recursion (top-down memoization)
            //dp invariant:
                //recurse(i, j) will represent number of unique paths to reach bottom right from i, j
                    //while only travelling down and right plus avoiding any obstacles
                
                //recurse(0, 0) will represent number of unique paths to reach bottom right from 0, 0

           
            //recurrence relation:
                //each state recurse(i, j) can be computed by calculating recurse(i+1, j) and 
                    //recurse (i, j+1)

                //recurse(i, j) = recurse(i+1, j) + recurse(i, j+1)
            
            //base cases:
                //ifgrid[m-1][n-1] == 1 return 0
                //recurse(m-1, n-1) = 1 as there is only 1 way to reach bottom right from m-1, n-1, i.e. by 
                    //staying there

                //if while recursing any state i,j we encounter an obstacle (grid(i, j)) then we simply return 0 
                
                //also for any cell in m-1 row and n-1 col we need to check whether there is any obstacle from  
                    //current cell till bottom right, if yes, return 0, else return 1 as there is only 1 way to    
                    //reach bottom right from m-1 row and n-1 col

            //memoization:
                //each state is dependent on two coordinates (i, j). Therefore, we can have a 2D int matrix
                    //to store the computed values of states

            //TC without memoization: exponential (2^(m+n))
            //TC with memoization: m x n

            //SC without memoization: m + n (recursive stack)
            //SC with memoization: m x n + (m + n)

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;


        if(obstacleGrid[rows-1][cols-1] == 1) return 0;

        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                dp[i][j] = -1;
            }
        }

        dp[rows-1][cols-1] = 1;

        return recurse(obstacleGrid, 0, 0, dp);

    }

    private int recurse(int[][] obstacleGrid, int i, int j, int[][] dp){
        
        if(i == obstacleGrid.length || j == obstacleGrid[0].length) return 0;

        if(obstacleGrid[i][j] == 1) return 0;

        // if(i == obstacleGrid.length - 1) {
        //     for(int col = j; col < obstacleGrid[0].length; col ++){
        //         if(obstacleGrid[i][col] == 1) return 0;    
        //     }
        //     return 1;
        // }
        // if(j == obstacleGrid[0].length - 1) {
        //     for(int row = i; row < obstacleGrid.length; row ++){
        //         if(obstacleGrid[row][j] == 1) return 0;
        //     }
        //     return 1;
        // }
        // if(i == obstacleGrid.length || j == obstacleGrid[0].length) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        dp[i][j] = recurse(obstacleGrid, i + 1, j, dp) + recurse(obstacleGrid, i, j + 1, dp);

        return dp[i][j];
    }






















/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     // If in the problem it was allowed 4-direction movement (no revisits in the same path), it would have become a 
//         //"graph path-finding" problem with visited-state tracking, which is solved with backtracking / DFS.

//         //Re-solving on 20 Feb 2026:
        
//         //intuition 1: 2D DP: DP on grids
//             //For any cell we have two choices to take, either go down or go right
//             //Therefore, to find number of uinque paths for any cell i,j we can add the unique
//                 //paths from bottom (i+1, j) and right cell (i, j+1)
            
//             //Base case:
//                 //From last row there is only 1 way to reach bottom right, given that there is no
//                     //obstacle in the cells on the right of the cell.
//                 //From last col there is only 1 way to reach bottom right, given that there is no
//                     //obstacle in the cells on the below of the cell.

//                 //Any obstacle cell should be skipped while calculating DP and only marked as 0
            
//             //Recurrence relation:
//                 //dp[i][j] = dp[i+1][j] + dp[i][j+1], given that i, j is not an obstacle cell

        
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         //dp[i][j] represents number of unique paths to reach bottom right form i,j while
//             //only travelling right and down with no obstacles in the paths
//         //dp[0][0] will represent number of unique paths to reach bottom right from 0,0
//             //while only travelling right and down with no obstacles in the paths
//         //Therefore, we need a 2D dp matrix of size rows x cols
        
//         int rows = obstacleGrid.length;
//         int cols = obstacleGrid[0].length;

//         int[][] dp = new int[rows][cols];

//         if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;
        
//         //base cases
//         dp[rows-1][cols-1] = 1; //there is 1 way to reach bottom right from bottom right
//             //i.e. by staying where you already are
//         //filling last row
//         for(int j = cols - 2; j >= 0; j --){
//             int i = rows - 1;
//             if(obstacleGrid[i][j] == 1) break;
//             dp[i][j] = 1;
//         }

//         //filling last col
//         for(int i = rows - 2; i >= 0; i --){
//             int j = cols - 1;
//             if(obstacleGrid[i][j] == 1) break;
//             dp[i][j] = 1;
//         }

//         for(int i = rows - 2; i >= 0; i --){
//             for(int j = cols - 2; j >= 0; j --){
//                 if(obstacleGrid[i][j] == 1) continue;
//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }

//         return dp[0][0];

//     }






















// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     // If in the problem it was allowed 4-direction movement (no revisits in the same path), it would have become a 
//         //"graph path-finding" problem with visited-state tracking, which is solved with backtracking / DFS.


//     //Solving on 13 Dec 2025:

//     //intuition 1: 2D DP - Bottom up Tabulation - Answer at 0,0 
//         //Base case:
//             //For any index in last row and last col, there is only 1 way to reach bottom
//                 //right, if there is no obstacle in betweeen. Have a flag to know if there
//                 //is an obstacle in last row and col and make all the preceding cells as 0

//         //Recurrence relation:  
//             //For any index the number of unqiue paths is the sum of number of unique paths 
//                 //from right cell and bottom cell.
//             //If the current cell is an obstacle in the obstacleGrid, simply skip it
        
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         //dp[i][j] represents number of unique paths to reach bottom right from i,j 
//             //while ony going down and right and avoiding any obstacles
//         //dp[0][0] represents number of  unique paths to reach bottom right from 0,0
//             //while only going down and right and avoiding any obstacles
        
//         //The maximum cell that we want to reach is rows-1, cols-1, therefore we need
//             //a 2D matrix of size rows x cols

//         int rows = obstacleGrid.length;
//         int cols = obstacleGrid[0].length;

//         if(obstacleGrid[rows-1][cols-1] == 1) return 0;
//         if(obstacleGrid[0][0] == 1) return 0;

//         int[][] dp = new int[rows][cols];

//         //base cases

//         dp[rows-1][cols-1] = 1; //there is one way to stay on bottom right cell

//         //filling last col
//         boolean obstacleFound = false;
//         for(int i = rows - 2; i >= 0; i --){
//             if(obstacleGrid[i][cols-1] == 1) obstacleFound = true;
//             // if(obstacleFound){
//             //     dp[i][cols-1] = 0;
//             //     continue;
//             // }
//             // dp[i][cols-1] = 1;

//             dp[i][cols-1] = (obstacleGrid[i][cols-1] == 0 && !obstacleFound) ? 1 : 0;
//         }

//         //filling last row
//         obstacleFound = false;
//         for(int j = cols - 2; j >= 0; j --){
//             if(obstacleGrid[rows-1][j] == 1) obstacleFound = true;
//             // if(obstacleFound){
//             //     dp[rows-1][j] = 0;
//             //     continue;
//             // }
//             // dp[rows-1][j] = 1;

//             dp[rows-1][j] = (obstacleGrid[rows-1][j] == 0 && !obstacleFound) ? 1 : 0;
//         }

//         for(int i = rows - 2; i >= 0; i --){
//             for(int j = cols - 2; j >= 0; j --){
//                 if(obstacleGrid[i][j] == 1){
//                     dp[i][j] = 0;
//                     continue;
//                 }

//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }

//         return dp[0][0];


       

//     }






















// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 13 Dec 2025:

//     //intuition 1: 2D DP - Bottom up Tabulation - Answer at 0,0 
//         //As the robot can only move down or right, for any cell (i, j) we can get the unique paths 
//             //by adding up the unique paths from right and down neighboring cells.
        
//         //Recurrence relation: 
//             //dp[i][j] = dp[i+1][j](down) + dp[i][j+1](right)

//         //Base case:
//             //Fill last row and last col with 1, given that any of the cell is not an obstacle. 
//             //If an obstacle is at that index, fill 0 there. Before filling any cell check if its
//                 //next index contains 0, if yes fill 0. As if there is an obstacle in last row
//                 //or last col, all the preceding cells will have 0s   
        
//         //Before filling any normal cell, check if it is an obstacle, if yes, simply skip it
        
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         //start, destination and special condition 
//         //dp[i][j] represents number of unique paths from i, j to reach bottom right without encountering obstacle cells
//         //dp[0][0] will represent number of unique paths from 0,0 to reach bottom right (m-1, n-1)
//         //Therefore, we need a m x n 2D matrix 

//         int rows = obstacleGrid.length;
//         int cols = obstacleGrid[0].length;

//         if(obstacleGrid[0][0] == 1 || obstacleGrid[rows-1][cols-1] == 1) return 0;

//         int[][] dp = new int[rows][cols];

//         //base case
//         dp[rows-1][cols-1] = 1;
//         //filling last col
//         for(int i = rows - 2; i >= 0; i --){
//             if(dp[i + 1][cols - 1] == 0 || obstacleGrid[i][cols - 1] == 1){
//                 dp[i][cols - 1] = 0;
//             }
//             else{
//                 dp[i][cols-1] = 1;
//             }

//         }

//         //filling last row
//         for(int j = cols - 2; j >= 0; j --){
//             if(dp[rows - 1][j + 1] == 0 || obstacleGrid[rows - 1][j] == 1){
//                 dp[rows - 1][j] = 0;
//             }
//             else{
//                 dp[rows - 1][j] = 1;
//             }
//         }

//         for(int i = rows - 2; i  >= 0; i --){
//             for(int j = cols - 2; j >= 0; j --){
//                 if(obstacleGrid[i][j] == 1) continue;

//                 dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//             }
//         }

//         return dp[0][0];

       

//     }






















// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // // If in the problem it was allowed 4-direction movement (no revisits in the same path), it would have become a 
    //     //"graph path-finding" problem with visited-state tracking, which is solved with backtracking / DFS.


    // //Solving on 08 Dec 2025:

    // //intuition 1: To find number of unique paths possible to reach any index i, j we need to know the number of
    //     //unique paths possible to reach (i-1, j) and (i, j-1) indices and add them together, as any cell can only
    //     //be reached from left or top. 
    // //After breaking into subproblems, our recurrence relation is: dp[i][j] = dp[i-1][j] + dp[i][j-1]

    // //Have a dp array of same size of obstacleGrid. 
    // //Any cell in obstacleGrid will be filled with 0 in dp, as technically there are no ways to reach that particular cell,
    //     //hence 0. 
    // //Base case is to fill top row and first col with 1. If any of the cells is an 
    //     //obstacle (i.e. 1 in obstacleGrid), we break the loop as any further cells cannot be reached due to obstacle.

    // //While iterating over the dp array, we skip the cells that have an obstacle in obstacleGrid. So these cells will remain
    //     //as 0 s and if any other cell tries to use their values in order to compute its own number of ways possible, it
    //     //will get 0 from here.

    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
    //     //dp[i][j] represents unique paths possible to reach i, j position
    //     //Therefore to reach m-1, n-1 position we need a grid of m x n size

    //     int rows = obstacleGrid.length;
    //     int cols = obstacleGrid[0].length;
    //     if(obstacleGrid[rows - 1][cols - 1] == 1) return 0;

    //     int[][] dp = new int[rows][cols];

    //     //filling top row with 1 s
    //     for(int j = 0; j < cols; j ++){
    //         if(obstacleGrid[0][j] == 1){
    //             // dp[0][j] = 0; //we do not need this as int[][] is already initialized with 0
    //             break;
    //         }
    //         dp[0][j] = 1;
    //     }

    //     //filling first col with 1 s
    //     for(int i = 0; i < rows; i ++){
    //         if(obstacleGrid[i][0] == 1){
    //             break;
    //         }
    //         dp[i][0] = 1;
    //     }

    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
    //             if(obstacleGrid[i][j] == 1) continue;

    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }

    //     return dp[rows - 1][cols - 1];

    // }
}