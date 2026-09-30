class Solution {

    //Re-solving on 30 Sept 2026:
    
    //intuition 2: 
        //a square have both length and width equal
        //a single 1 cell is a square of area 1   
        //for any cell with 1 value we need to check if right, down and right-down diagnoal are also 1.
            //if yes, then we can say that we have a square of area 4.
        //now the main thing is that all these 3 neighbors should be 1 for a square to be extended.

        //We can recursively start from any 1 cell and see if it satifies the condition of all 3 neighbors 
            //returning same value. Then we check the same condition for these 3 neighbors and so on. 
            //With each level we increase the length by 1 which makes the area as length * length
        //And any time we find that any neighbor is not 1, we stop traversing that path and return 
        
        //Also as we can see that each cell can be approached by multiple paths, there is redundancy when 
            //it comes to computing the states. 
        //This looks like a DP problem. Why DP?
            //1. Optimal Substructure: We need to find the maximum area and a big problem of finding maximum
                //square area in the whole matrix can be broken down to finding maximum square area in a
                //smaller sub-matrix
            //2. There is state re-computations involved, resulting in duplicated work and hence
                //memoization can be applied 

        //intuition 2: Tabulation (bottom up)
            //dp invariant:
                //each cell is represented by i, j and a maximum square can start from any i, j cell
                //dp[i][j] will represent maximum length of square such that the square's left
                    //corner is at i, j

            //recurrence relation:
                //each state dp[i][j] depends on right, bottom and bottom right cell
                //now each of these 3 sub-states can different values returning, means each of them 
                    //can have different lengths of squares starting from them. We need to choose
                    //the minimum of all these 3 states in order to proceed with the calculation of
                    //maximum length for the current state as we need all the sides to increase uniformly
                    //and by choosing min of these three sub-states we make sure that this is happening.
                //the relation between these states will be:
                    //dp[i][j]= 1 + Math.min((i, j + 1), (i + 1, j) and (i + 1, j + 1)) 

                //if any of the sub-state is 0, then we will have max length of the square from i, j as 1,
                    //which makes sense

            //base cases:
                //for last row and col, all the 1 cells would have 1 value as it is not possible to have
                    //larger squares from these cells



            
            //algorigthm:
                //since each state needs three further states to compute its value, we will traverse 
                    //dp array from m-2, n-2 towards 0, 0
                //also we would track the maximum length found throughtout the execution 


            //TC: O(m x n)
            //SC: O(m x n)

    public int maximalSquare(char[][] matrix) {

        int maxLen = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        
        //base cases
        //last col
        for(int i = 0; i < rows; i ++){
            if(matrix[i][cols - 1] == '1') {
                dp[i][cols - 1] = 1;
                maxLen = 1;
            }
        }

        //last row
        for(int j = 0; j < cols; j ++){
            if(matrix[rows - 1][j] == '1') {
                dp[rows - 1][j] = 1;
                maxLen = 1;
            }
        }




        for(int i = rows - 2; i >= 0; i --){
            for(int j = cols - 2; j >= 0; j --){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;

    }

////////////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 30 Sept 2026:
    
    // //intuition 1: 
    //     //a square have both length and width equal
    //     //a single 1 cell is a square of area 1   
    //     //for any cell with 1 value we need to check if right, down and right-down diagnoal are also 1.
    //         //if yes, then we can say that we have a square of area 4.
    //     //now the main thing is that all these 3 neighbors should be 1 for a square to be extended.

    //     //We can recursively start from any 1 cell and see if it satifies the condition of all 3 neighbors 
    //         //returning same value. Then we check the same condition for these 3 neighbors and so on. 
    //         //With each level we increase the length by 1 which makes the area as length * length
    //     //And any time we find that any neighbor is not 1, we stop traversing that path and return 
        
    //     //Also as we can see that each cell can be approached by multiple paths, there is redundancy when 
    //         //it comes to computing the states. 
    //     //This looks like a DP problem. Why DP?
    //         //1. Optimal Substructure: We need to find the maximum area and a big problem of finding maximum
    //             //square area in the whole matrix can be broken down to finding maximum square area in a
    //             //smaller sub-matrix
    //         //2. There is state re-computations involved, resulting in duplicated work and hence
    //             //memoization can be applied 

    //     //intuition 1: Recursion (top down + memoization)
    //         //dp invariant:
    //             //each cell is represented by i, j and a maximum square can start from any i, j cell
    //             //recurse(i, j) will represent maximum lenght of square such that the square's left
    //                 //corner is at i, j

    //         //recurrence relation:
    //             //each state recurse(i, j) depends on right, bottom and bottom right cell
    //             //now each of these 3 sub-states can different values returning, means each of them 
    //                 //can have different lengths of squares starting from them. We need to choose
    //                 //the minimum of all these 3 states in order to proceed with the calculation of
    //                 //maximum length for the current state as we need all the sides to increase uniformly
    //                 //and by choosing min of these three sub-states we make sure that this is happening.
    //             //the relation between these states will be:
    //                 //recurse(i, j) = 1 + Math.min((i, j + 1), (i + 1, j) and (i + 1, j + 1)) 

    //             //if any of the sub-state is 0, then we will have max length of the square from i, j as 1,
    //                 //which makes sense

    //         //base cases:
    //             //if matrix[i][j] == 0, return 0
    //             //if i, j are going out of matrix boudaries, return 0


    //         //memoization: 
    //             //since each recursive state depends on two parameters (i, j) we can store then in a
    //                 //2D integer array of size m x n

            
    //         //algorigthm:
    //             //since maximum square can be totally isolated in the whole matrix, we need to traverse 
    //                 //the whole matrix and pass each 1 cell to the recure function and choose the maximum
    //                 //of all such cells

    //         //TC without memoization:
    //             //exponential due to 3 recursive branches per state
    //             //at worst, we explore 3 states from a state and all its substates
    //             //O(m x n (3 ^ (m + n)))
    //                 //branching factor <= 3
    //                 //maximum recursion depth = O(m+n)
    //                 //TC: O(branchingFactor ^ maximumRecursionDepth)
    //         //TC with memoization: 
    //             //each state is computed at most once
    //             //O(m x n)

    //         //SC without memoization:
    //             //O(m + n) for recursive stack
    //         //SC with memoization:
    //             //O(m + n) for recursive stack + O(m x n) for DP array 

    // public int maximalSquare(char[][] matrix) {

    //     int maxLen = 0;
    //     int rows = matrix.length;
    //     int cols = matrix[0].length;

    //     int[][] dp = new int[rows][cols];
    //     for(int i = 0; i < rows; i ++){
    //         Arrays.fill(dp[i], -1);
    //     }



    //     for(int i = 0; i < rows; i ++){
    //         for(int j = 0; j < cols; j ++){
    //             if(matrix[i][j] == '1'){
    //                 maxLen = Math.max(maxLen, recurse(matrix, i, j, dp));
    //             }
    //         }
    //     }

    //     return maxLen * maxLen;
    // }

    // public int recurse(char[][] matrix, int i, int j, int[][] dp){
    //     if(i == matrix.length || j == matrix[0].length) return 0;
    //     if(matrix[i][j] == '0') return 0;

    //     if(dp[i][j] != -1) return dp[i][j];


    //     dp[i][j] = 1 + Math.min(recurse(matrix, i + 1, j, dp), 
    //         Math.min(recurse(matrix, i, j + 1, dp), recurse(matrix, i + 1, j + 1, dp)));

    //     return dp[i][j];
    // }





























// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 23 Dec 2025:

//     //intuition 1: (2D DP: DP On Grids: Bottom - up - is this really bottom up as we are traversing matrix from 
//         //top left to bottom right? -> Yes — it is bottom-up, even though you traverse top-left -> bottom-right,
//         //becuase you compute each state using already-computed smaller subproblems)
//         //"Bottom-up != reverse traversal
//         //Bottom-up = “dependencies already solved”"
        
//         //Base cases: for top row and top col, fill dp matrix with same values as in matrix
//             //“In the first row or first column, the largest square ending at any cell can only be of size 1 
//                 //if the cell is '1', otherwise 0.”
//         //Recurrence relation: 
//             //For any cell that is 0, simply put 0(or skip) in dp matrix
//             //For a square to expand, all three previous neighbors(left, top-left, top) should be atleast k-1
//             //If all three previous negibors are not equal, then take the minimum of the three and add 1 for current
//                 //cell in dp array  
//             //"A square of side k can only end at i,j if all three neighbors (left, top-left, top) support atleast
//                 //a square of side k-1. Therefore, the side of square is limited by the smallest of the three neighbors"

//     public int maximalSquare(char[][] matrix) {
//         //dp[i][j] represents the maximum side length of square containing all 1's ending at i,j
//         //Update the maximum side encountered at each dp state to get final answer
//         //At max we can have our max side of square containing all 1's ending at matrix.length-1, matrix[0].length-1
//         //Therefore, we need a 2D array of size matrix.length x matrix[0].length

//         int rows = matrix.length;
//         int cols = matrix[0].length;
//         int maxSide = 0;
//         int[][] dp = new int[rows][cols];

//         //base cases
//         //filling first col
//         for(int i = 0; i < rows; i ++){
//             int j = 0;
//             dp[i][j] = matrix[i][j] - '0';
//             maxSide = Math.max(maxSide, dp[i][j]);
//         }

//         //filling first row
//         for(int j = 0; j < cols; j ++){
//             int i = 0;
//             dp[i][j] = matrix[i][j] - '0';
//             maxSide = Math.max(maxSide, dp[i][j]);
//         }

//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(matrix[i][j] == '0') continue;                
//                 dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]);

//                 maxSide = Math.max(maxSide, dp[i][j]);
//             }
//         }

//         return maxSide * maxSide;

//     }





























// // ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 20 Dec 2025:

//     //intuition 2: (2D: DP: DP on grid pattern: Solution tracked while filling DP array):
//         //Base case: 
//             //for first row and first col, fill matrix[i][j] in dp matrix
//             //Rationale:
//                 //if the cell contains 1, then it is only possible to form a square containing all 1's
//                     //of length 1 that ends at current cell.
//                 //if the cell contains 0, then it is not possible to form a square contaning all 1's that 
//                     //end at current cell


//         //Recurrence relation: 
//             //For any cell (i,j), given that it is 1, take minimum of top, left and top-left dp cell and add 1 to it
//                 //to determine the side of square that ends at i,j. 
//             //Rationale:
//                 //Only when all the three neighbors are equal, is when the max side of square will increase by 1.
//                 //=> dp[i][j] = min(top, left, top-left) + 1
                
//                 //"A square of size k can end at i,j only if all three neighboring cells can support a square
//                     //of size at least k-1. Therefore the smallest of the three neighbors limits the growth"
//                 //In case of all three neighbors not equal, "growth is limited by the smallest neighbor"
//                 //“The square size at (i, j) is limited by the smallest square ending at top, left, or top-left.”

//         //For any cell that have 0 in matrix, fill 0 in dp as no square containing all 1's can end here.
//         //Have a variable tracking the max side of square encountered till now    

//     public int maximalSquare(char[][] matrix) {
//         //dp[i][j] represents maximum side of square possible containing all 1's ending at i,j
//         //"dp[i][j] represents the maximum side length of a square containing all 1's that ends at cell i,j"
//         //We will be traverse the whole matrix and filling the dp matix along the way till bottom right cell.
//         //Therefore, we need a 2D matrix of size matrix.length x matrix[0].length

//         int rows = matrix.length;
//         int cols = matrix[0].length;

//         int[][] dp = new int[rows][cols];
//         int maxSide = 0;

//         //base cases
//         //filling first row
//         for(int j = 0; j < cols; j ++){
//             dp[0][j] = matrix[0][j] - '0';
//             maxSide = Math.max(maxSide, dp[0][j]);
//         }

//         //filling first col
//         for(int i = 0; i < rows; i ++){
//             dp[i][0] = matrix[i][0] - '0';
//             maxSide = Math.max(maxSide, dp[i][0]);
//         }

//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(matrix[i][j] == '0') continue;

//                 int top = dp[i-1][j];
//                 int left = dp[i][j-1];
//                 int topLeft = dp[i-1][j-1];    
                
//                 dp[i][j] = 1 + Math.min(Math.min(top, left), topLeft); 
                
//                 maxSide = Math.max(maxSide, dp[i][j]);
//             }
//         }

//         return maxSide * maxSide;

//     }
























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 20 Dec 2025:

    // //intuition 1 (didn't work): (2D: DP: DP on grids pattern: Solution at 0,0)  
    //     //minimum is when we find a single 1 => area = 1
    //     //for any i,j that is 1 we can verify if it is the starting of a square with all 1s by checking 
    //         //down, right and digonal

    //     //Base case:   
    //         //Last row and last col:
    //             //Starting from rows-1, cols-1, fill dp[rows-1][cols-1] with matrix[rows-1][cols-1]
    //             //for all the indices of last col and last row, fill the dp[i][j] with dp[i+1][j]/dp[i][j+1] 
    //                 //to carry forward any previous '1' square to the current index while moving from right to left

    //     //Recurrence relation:
    //         //For any cell with index i,j, look for right, down and down-diagnol dp cells.
    //         //For a square with all 1's to start from i,j there needs to be non-zero values in all these three
    //             //cells. Then take the minimum of all these three cells and add 1 to it to get side of square with
    //             //all 1's starting from i, j.
    //         //Eg: If we get 2 in all three neighboring cells, then that means by adding i,j (given that i,j is a '1'),
    //             //a 3x3 matrix will be formed.

    // public int maximalSquare(char[][] matrix) {
    //     //dp[i][j] represents maximum side of the square starting from i,j that contains only 1's
    //     //dp[0][0] represents maximum side of the square starting from 0,0 that contains only 1's
    //     //Therefore, we need a 2D matrix of size matrix.length x matrix[0].length
    //     //Our answer will be dp[0][0] * dp[0][0]

    //     int rows = matrix.length;
    //     int cols = matrix[0].length;

    //     int[][] dp = new int[rows][cols];

    //     //base cases
    //     //filling bottom right
    //     dp[rows-1][cols-1] = matrix[rows-1][cols-1] - '0';

    //     //filling last row
    //     for(int j = cols - 2; j >= 0; j --){
    //         dp[rows-1][j] = matrix[rows-1][j] - '0' == 0 ? dp[rows-1][j+1] : matrix[rows-1][j] - '0';
    //     }

    //     //filling last col
    //     for(int i = rows - 2; i >= 0; i --){
    //         dp[i][cols-1] = matrix[i][cols-1] - '0' == 0 ? dp[i+1][cols-1] : matrix[i][cols-1] - '0';
    //     }

    //     for(int i = rows - 2; i >= 0; i --){
    //         for(int j = cols - 2; j >= 0; j --){
    //             // if(matrix[i][j] == 0) continue; //in this case dp[i][j] will be left at 0 (default value in java)

    //             int right = matrix[i][j+1] - '0';
    //             int down = matrix[i+1][j] - '0';
    //             int diagnolDown = matrix[i+1][j+1] - '0';

    //             int rightDp = dp[i][j+1];
    //             int downDp = dp[i+1][j];
    //             int diagnolDownDp = dp[i+1][j+1];

                
    //             if((right != 0 && down != 0 && diagnolDown != 0) && matrix[i][j] - '0' != 0){
    //                 dp[i][j] = 1 + Math.min(Math.min(rightDp, downDp), diagnolDownDp);
    //             }
    //             else if((right == 0 && down == 0 && diagnolDown == 0) && matrix[i][j] - '0' != 0){
    //                 dp[i][j] = 1;
    //             } 
    //             else{
    //                 dp[i][j] = Math.max(Math.max(rightDp, downDp), diagnolDownDp);
    //             }
    //         }
    //     }

    //     for(int i = 0; i < rows; i ++){
    //         for(int j = 0; j < cols; j ++){
    //             System.out.print(dp[i][j] + ", ");
    //         }
    //         System.out.println();
    //     }

    //     return dp[0][0] * dp[0][0];
    //     // return dp[0][0];

    // }
}