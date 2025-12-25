class Solution {
    //Solving on 23 Dec 2025:

    //intuition 1: (2D DP: Bottom up: DP on grids pattern)

        //For area of a rectangle we need length and breadth
        //A single '1' cell is of area 1
        //A square is also a rectangle
        //What should be stored in dp[i][j] as a subproblem? Area? -> area does not seem to work
        //Can we store int[] array of size two (length and breadth) inside dp arary -> too many states

        //We can take each row and for each index i that is 1 in that row check if previous rows had a 1 
            //at index i as well. If yes, add 1 for each row to get a total of consecutive 1's in all the
            //previous rows and store it at index i for current index. To get continous 1's from all the
            //previous rows, have a 2D dp array computed for each row that stores the number of consecutive
            //1's for each index in each row.
        //Then for each row calculate largest rectangle possible (using monotonic stack). Have a helper 
            //function for this.

        //Base cases for dp matrix:
            //first row will be same as matrix[0] as it is the starting of consecutive 1's
        //Recurrence relation for dp matrix:
            //add 1 to the dp state of same col and previous row.
            //dp[i][j] = 1 + dp[i-1][j]
        
    public int maximalRectangle(char[][] matrix) {
        //dp[i][j] represents number of consecutive 1's from starting row till i row in j column
        //We will be traversing till the last row of matrix.
        //Therefore, we need a 2D dp matrix of size matrix.length x matrix[0].length

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int maxArea = 0;

        //base case
        //filling first row
        for(int j = 0; j < cols; j ++){
            int i = 0;
            dp[i][j] = matrix[i][j] - '0';
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = 1 + dp[i-1][j];
                }
            }
        }


        for(int i = 0; i < rows; i ++){
            maxArea = Math.max(maxArea, findLargestRectInRow(dp[i]));
        }

        return maxArea;

    }

    private int findLargestRectInRow(int[] heights){
        
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        int hLen = heights.length;
 
        for(int i = 0; i <= hLen; i ++){
            int currHeight = i == hLen ? 0 : heights[i];

            while(!stack.isEmpty() && currHeight <= heights[stack.peek()]){
                int height = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;

    }


}