class Solution {

    
    //Re-solving on 13 Sept 2026

    //intuition 2: Tabulation
        //to reach bottom right from m-1, n-2 cell we would only have 1 way
        //to reach bottom right from m-2, n-1 cell we would only have 1 way

        //for any cell i, j we can only reach it from i-1, j or i, j-1 as we can only move
            //right or down
        
        //so we depend on previous 2 states

        //this looks like a dp problem because:
            //1. The problem can be divided into smaller subproblems
            //2. The same states would be repeatedly reached, giving overlapping sub-problems 
        
        //topic: DP
        //pattern: 2D DP
        //sub-pattern: Counting paths

        //dp invariant:
            //d[i][j] reperesents number of unique paths to reach bottom right from i, j while
                //only moving right and down

            //therefore, dp[0][0] will prepresent number of unique paths to reach bottom right from
                //0,0 while only moving right and down

            //the max coordintates that we might need in dp array is m-1, n-1. Therefore, we need a 2D
                //dp array of size m x n 
        
        //recurrence relation:
            //each state i, j depends on next two states dp[i+1][j] and dp[i][j+1]

            //current state dp[i][j] would be equal to the sum of dp[i+1][j] and dp[i][j+1]

            //dp[0][0] will give us our answer


        //base case:
            //there is only 1 way to reach bottom right from all the cells in bottom row (m-1)
                //fill dp[m-1][x] row with 1
            //there is only 1 way to reach bottom right from all the cells in last column (n-1)
                //fill dp[x][n-1] col with 1
            //there is only 1 way to reach bottom right from m-1, n-1, i.e. by staying there only  
                //dp[m-1][n-1] = 0

        //algorithm:
            //to compute any state dp[i][j] we need two forward states, therefore we would run two
                //for loops in backward direction
    
        

        //TC: O(2^m+n) without memoization
        //TC: O(m . n) with memoization

        //SC: O(m+n) without memoization (recursive stack) 
            //as one recursive path can contain approx. m-1 downs and n-1 rights before terminating 
        //SC: O(m . n) with memoization

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        //base cases:
        for(int row = 0; row < m; row ++){
            int col = n - 1;

            dp[row][col] = 1;
        }

        for(int col = 0; col < n; col ++){
            int row = m - 1;
            dp[row][col] = 1;
        }

        for(int row = m - 2; row >= 0; row --){
            for(int col = n - 2; col >= 0; col --){
                dp[row][col] = dp[row + 1][col] + dp[row][col + 1];
            }
        }

        return dp[0][0];


    }





///////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 13 Sept 2026

    // //intuition 1: Brute force recursion (top down) + memoization 
    //     //to reach bottom right from m-1, n-2 cell we would only have 1 way
    //     //to reach bottom right from m-2, n-1 cell we would only have 1 way

    //     //for any cell i, j we can only reach it from i-1, j or i, j-1 as we can only move
    //         //right or down
        
    //     //so we depend on previous 2 states

    //     //this looks like a dp problem because:
    //         //1. The problem can be divided into smaller subproblems
    //         //2. The same states would be repeatedly reached, giving overlapping sub-problems 
        
    //     //topic: DP
    //     //pattern: 2D DP
    //     //sub-pattern: Counting paths

    //     //dp invariant:
    //         //recurse(i, j) reperesents number of unique paths to reach bottom right from i, j while
    //             //only moving right and down
        
    //     //recurrence relation:
    //         //each state i, j depends on next two states recurse(i+1, j) and recurse(i, j+1)

    //         //current state recurse(i, j) would be equal to the sum of recurse(i+1, j) and recurse(i, j+1)

    //         //recurse(0,0) will give us our answer


    //     //base case:
    //         //there is only 1 way to reach bottom right from all the cells in bottom row (m-1)
    //         //there is only 1 way to reach bottom right from all the cells in last column (n-1)

    //         //there is only 1 way to reach bottomr right from m-1, n-1, i.e. by staying there only

    //     //memoization:
    //         //we can store the results of states in a 2D dp array 

        

    //     //TC: O(2^m+n) without memoization
    //     //TC: O(m . n) with memoization

    //     //SC: O(m+n) without memoization (recursive stack) 
    //         //as one recursive path can contain approx. m-1 downs and n-1 rights before terminating 
    //     //SC: O(m . n) with memoization

    // public int uniquePaths(int m, int n) {

    //     int[][] dp = new int[m][n];
    //     return recurse(m, n, 0, 0, dp);
        
    // }

    // public int recurse(int m, int n, int i, int j, int[][] dp){
    //     if(i == m || j == n) return 0;

    //     if(i == m-1 || j == n-1) return 1;

    //     if(dp[i][j] != 0) return dp[i][j];

    //     dp[i][j] = recurse(m, n, i + 1, j, dp) + recurse(m, n, i, j + 1, dp); 
    //     return dp[i][j];

    // }



















 







///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 20 Feb 2026:   
    
//     //intuition 1: 2D Dp : DP on grids
//         //To reach bottom right we have two immediate paths (up and left)
        
//         //Base case:
//             //To reach bottom right from any cell in last row, there is only 1 path
//                 //Therefore dp[m-1] will be all 1's
//             //To reach bottom right from any cell in last col, there is only path
//                 //Therefore dp[n-1] will be all 1's
        
//         //Recurrence relation:
//             //for any cell at non-boundary i,j we have two choices, either to move
//                 //down or to move right
//             //Therefore, for i,j we can get total unique paths to reach bottom right
//                 //by adding down (dp[i+1][j]) and right dp[i][j+1]
            

//     public int uniquePaths(int m, int n) {
//         //dp[i][j] represents number of unique paths possible to reach bottom right
//             //from i,j while only travelling down and right
//         //dp[0][0] will represent number of unique paths possible to reach bottom right
//             //from 0,0 while only travelling down and right
//         //Therefore, we need a 2D DP matrix of size m x n 


//         int[][] dp = new int[m][n];
//         //base cases
//         //filling last row
//         for(int j = 0; j < n; j ++){
//             int i = m-1;

//             dp[i][j] = 1;
//         }

//         //filling last col
//         for(int i = 0; i < m; i ++){
//             int j = n-1;
            
//             dp[i][j] = 1;
//         }


//         for(int i = m-2; i >= 0; i --){
//             for(int j = n-2; j >= 0; j --){
//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }

//         return dp[0][0];

//     }



























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Dec 2025:

//     //intuition 2: DP on Grid problem - 2D Dp - Bottom up Tabulation solution (solution at 0,0)
//         //As the robot can only move down and right, we can use already computed unique paths 
//             //of bottom and right neighboring cells and add them so that we get unique path count
//             //for our current cell.
        
//         //Base case: 
//             //In the last column robot can only travel in down direction and not right (out of bounds)
//             //Therefore, the unique paths for all the cells in last col are 1
//             //In the last row robot can only travel in the right direction and not down (out of bounds)
//             //Therefore, the unique paths for all the cells in the last row are 1.

//         //Recurrence relation: 
//             //For any cell the number of unique pahts are : dp[i][j] = dp[i+1][j](down) + dp[i][j+1](right)    
    
//     public int uniquePaths(int m, int n) {
//         //dp[i][j] represents the number of unique paths from i,j to reach the bottom right (m-1, n-1) by
//             //travelling only down and right
//         //dp[0][0] will represent the number of unique paths from 0,0 to reach the bottom right by travelling
//             //only down and right
//         //Therefore, we need a dp matrix of size m x n.

//         int[][] dp = new int[m][n];

//         //base cases

//         dp[m-1][n-1] = 1; //as there are 1 total ways to stay at m-1, n-1

//         //filling last row
//         for(int j = n-2; j >= 0; j --){
//             dp[m-1][j] = 1;
//         }

//         //filling last col
//         for(int i = m-2; i >= 0; i --){
//             dp[i][n-1] = 1;
//         }

//         for(int i = m-2; i >= 0; i --){
//             for(int j = n-2; j >= 0; j --){
//                 dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
//             }
//         }

//         return dp[0][0];

//     }



























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Dec 2025:

//     //intuition 2: DP on Grid problem - 2D Dp - Bottom up Tabulation solution (solution at 0,0)
//         //Approach where answer comes at 0,0 works for all DP on grid problems but approach where
//             //answer comes at bottom right, do not work for some problems
        
//         //To get the solution at 0,0 we start from bottom right (m-1, n-1). 
//         //Base case:
//             //dp[m-1][n-1] = 1 as there is one way to reach bottom right from m-1,n-1, i.e. by doing nothing
//                 //and staying there
//             //for any cell in last col, we only have 1 way to reach bottom right, therefore, fill last
//                 //col with 1 s
//             //for any cell in last row, we only have 1 way to reach bottom rigth, therefore, fill last 
//                 //row with 1 s
        
//         //Recurrence relation:
//             //for any cell we have two options, either to move right or move down, therefore number of 
//                 //ways to reach bottom right from i, j will be "number of ways to reach bottom right from 
//                 //i,j 's right neighboring cell" + "number of ways to reach bottom right from i,j 's below
//                 //neighboring cell"
//             //dp[i][j] = dp[i+1][j](below) + dp[i][j+1](right)
    
    
//     public int uniquePaths(int m, int n) {
//        //dp[i][j] represents the number of unique paths to reach m-1, n-1 location from i, j
//        //dp[0][0] will represent the number of unique paths to reach m-1, n-1 location
//        //Therefore, we need a 2D matrix of size m x n
        
//         int[][] dp = new int[m][n];


//         //filling last col with 1 s
//         for(int i = m-1; i >= 0; i --){
//             dp[i][n-1] = 1;
//         }

//         //filling last row with 1 s
//         for(int j = n-1; j >= 0; j --){
//             dp[m-1][j] = 1;
//         }

//         for(int i = m-2; i >= 0; i --){
//             for(int j = n-2; j >= 0; j --){
//                 dp[i][j] = dp[i+1][j] + dp[i][j+1];
//             }
//         }

//         return dp[0][0];


//     }



























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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