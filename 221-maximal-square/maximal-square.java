class Solution {

    //Solving on 20 Dec 2025:

    //intuition 2: (2D: DP: Ad-hoc pattern):
        //Base case: 
            //for first row and first col, fill matrix[i][j] in dp matrix
            //Rationale:
                //if the cell contains 1, then it is only possible to form a square containing all 1's
                    //of length 1 that ends at current cell.
                //if the cell contains 0, then it is not possible to form a square contaning all 1's that 
                    //end at current cell


        //Recurrence relation: 
            //For any cell (i,j), given that it is 1, take minimum of top, left and top-left dp cell and add 1 to it
                //to determine the side of square that ends at i,j. 
            //Rationale:
                //Only when all the three neighbors are equal, is when the max side of square will increase by 1.
                    //=> dp[i][j] = min(top, left, top-left) + 1

        //For any cell that have 0 in matrix, fill 0 in dp as no square containing all 1's can end here.
        //Have a variable tracking the max side of square encountered till now    

    public int maximalSquare(char[][] matrix) {
        //dp[i][j] represents maximum side of square possible containing all 1's ending at i,j
        //We will traverse the whole matrix and filling the dp matix along the way till bottom right cell.
        //Therefore, we need a 2D matrix of size matrix.length x matrix[0].length

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int maxSide = 0;

        //base cases
        //filling first row
        for(int j = 0; j < cols; j ++){
            dp[0][j] = matrix[0][j] - '0';
            maxSide = Math.max(maxSide, dp[0][j]);
        }

        //filling first col
        for(int i = 0; i < rows; i ++){
            dp[i][0] = matrix[i][0] - '0';
            maxSide = Math.max(maxSide, dp[i][0]);
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(matrix[i][j] == '0') continue;

                int top = dp[i-1][j];
                int left = dp[i][j-1];
                int topLeft = dp[i-1][j-1];    
                
                dp[i][j] = 1 + Math.min(Math.min(top, left), topLeft); 
                
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;

    }
























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