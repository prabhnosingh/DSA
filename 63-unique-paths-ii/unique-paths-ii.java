class Solution {    
    // If in the problem it was allowed 4-direction movement (no revisits in the same path), it would have become a 
        //"graph path-finding" problem with visited-state tracking, which is solved with backtracking / DFS.


    //Solving on 13 Dec 2025:

    //intuition 1: 2D DP - Bottom up Tabulation - Answer at 0,0 
        //Base case:
            //For any index in last row and last col, there is only 1 way to reach bottom
                //right, if there is no obstacle in betweeen. Have a flag to know if there
                //is an obstacle in last row and col and make all the preceding cells as 0

        //Recurrence relation:  
            //For any index the number of unqiue paths is the sum of number of unique paths 
                //from right cell and bottom cell.
            //If the current cell is an obstacle in the obstacleGrid, simply skip it
        
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j] represents number of unique paths to reach bottom right from i,j 
            //while ony going down and right and avoiding any obstacles
        //dp[0][0] represents number of  unique paths to reach bottom right from 0,0
            //while only going down and right and avoiding any obstacles
        
        //The maximum cell that we want to reach is rows-1, cols-1, therefore we need
            //a 2D matrix of size rows x cols

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        //base cases
        if(obstacleGrid[rows-1][cols-1] == 1) return 0;
        if(obstacleGrid[0][0] == 1) return 0;

        dp[rows-1][cols-1] = 1; //there is one way to stay on bottom right cell

        //filling last col
        boolean obstacleFound = false;
        for(int i = rows - 2; i >= 0; i --){
            if(obstacleGrid[i][cols-1] == 1) obstacleFound = true;
            if(obstacleFound){
                dp[i][cols-1] = 0;
                continue;
            }
            dp[i][cols-1] = 1;

        }

        //filling last row
        obstacleFound = false;
        for(int j = cols - 2; j >= 0; j --){
            if(obstacleGrid[rows-1][j] == 1) obstacleFound = true;
            if(obstacleFound){
                dp[rows-1][j] = 0;
                continue;
            }
            dp[rows-1][j] = 1;
        }

        for(int i = rows - 2; i >= 0; i --){
            for(int j = cols - 2; j >= 0; j --){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];


       

    }






















/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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