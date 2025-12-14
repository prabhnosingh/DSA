class Solution {

    //Re-solving on 13 Dec 2025:

    //intuition 2: DP on Grid problem - 2D Dp - Bottom up Tabulation solution (solution at 0,0)
        //Approach where answer comes at 0,0 works for all DP on grid problems but approach where
            //answer comes at bottom right, do not work for some problems
        
        //To get the solution at 0,0 we start from bottom right (m-1, n-1). 
        //Base case:
            //dp[m-1][n-1] = 1 as there is one way to reach bottom right from m-1,n-1, i.e. by doing nothing
                //ans staying there
            //for any cell in last col, we only have 1 way to reach bottom right, therefore, fill last
                //col with 1 s
            //for any cell in last row, we only have 1 way to reach bottom rigth, therefore, fill last 
                //row with 1 s
        
        //Recurrence relation:
            //for any cell we have two options, either to move right or move down, therefore number of 
                //ways to reach bottom right from i, j will be "number of ways to reach bottom right from 
                //i,j 's right neighboring cell" + "number of ways to reach bottom right from i,j 's below
                //neighboring cell"
            //dp[i][j] = dp[i+1][j](below) + dp[i][j+1](right)
    
    
    public int uniquePaths(int m, int n) {
       //dp[i][j] represents the number of unique paths to reach m-1, n-1 location from i, j
       //dp[0][0] will represent the number of unique paths to reach m-1, n-1 location
       //Therefore, we need a 2D matrix of size m x n
        
        int[][] dp = new int[m][n];


        //filling last col with 1 s
        for(int i = m-1; i >= 0; i --){
            dp[i][n-1] = 1;
        }

        //filling last row with 1 s
        for(int j = n-1; j >= 0; j --){
            dp[m-1][j] = 1;
        }

        for(int i = m-2; i >= 0; i --){
            for(int j = n-2; j >= 0; j --){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];


    }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Dec 2025:

//     //intuition 1: 2D Dp - Bottom up Tabulation solution 
//         //To reach any cell the robot can come from two directions (top and left) as it is only allowed to move
//             //bottom and right. Therefore, if we find the number of unique paths to reach each cell's top and left 
//             //neighboring cells add them up together, we can get our unique paths for that cell.
        
//         //Base case: 
//             //To reach 0,0 there is only 1 path for the robot, i.e. to stay there
//             //To reach any cell in the first row, there is only 1 path for robot. Therefore, fill first row with 1 s
//             //To reach any cell int the first col, there is only 1 path for robot. Therefore, fill the first col with 1 s

//         //Recurrence relation:
//             //dp[i][j] = dp[i-1][j] (top) + dp[i][j-1] (left)
    
//     public int uniquePaths(int m, int n) {
//        //dp[i][j] represents the number of unique paths to reach i, j location.
//        //dp[m-1][n-1] will represent the number of unique paths to reach m-1, n-1 location
//        //Therefore, we need a 2D matrix of size m x n
        
//         int[][] dp = new int[m][n];
        
//         //filling first row and col with 1s
//         for(int j = 0; j < n; j ++){
//             dp[0][j] = 1;
//         }
//         for(int i = 0; i < m; i ++){
//             dp[i][0] = 1;
//         }

//         for(int i = 1; i < m; i ++){
//             for(int j = 1; j < n; j ++){
//                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
//             }
//         }

//         return dp[m-1][n-1];

//     }



























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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