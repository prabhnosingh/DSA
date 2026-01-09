class Solution {

    // Re-Solving on 08 Jan 2026:
    
    //intuition 1: DFS : Graph pattern?
        //traverse the cells from first row, first col, last row and last col and for O's encountered 
            //and dfs traverse on them marking them as 'A'. The traverse the board and mark all remaining
            //O's as X's as these O's are the ones that are surrounded
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;

        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        //first row
        for(int j = 0; j < cols; j ++){
            int i = 0;
            if(board[i][j] == 'O') dfs(board, directions, i, j);
        }
        
        //first col
        for(int i = 0; i < rows; i ++){
            int j = 0;
            if(board[i][j] == 'O') dfs(board, directions, i, j);
        }

        //last row
        for(int j = 0; j < cols; j ++){
            int i = rows - 1;
            if(board[i][j] == 'O') dfs(board, directions, i , j);
        }

        //last col
        for(int i = 0; i < rows; i ++){
            int j = cols - 1;
            if(board[i][j] == 'O') dfs(board, directions, i, j);
        }


        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }

        
    }
    private void dfs(char[][] board, int[][] directions, int row, int col){
        
        board[row][col] = 'A'; //marking as visited

        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newCol >= 0 && newRow < board.length && newCol < board[0].length && board[newRow][newCol] == 'O'){
                dfs(board, directions, newRow, newCol);
            }
        }

        
    }






























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // //intuition 2(dfs): recursively run dfs function on all the O's along the edges and its neigbors
    // // and transform each 'O' to 'T' to mark it as invalid region. After marking all invalid regions, iterate 
    // //through entire board and mark all remaining 'O's as 'X's and 'T's as 'O's.
    
    // int[][] directions;
    // int rows;
    // int cols;
    // public void solve(char[][] board) {
    //     directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //     rows = board.length;
    //     cols = board[0].length;

    //     for(int row = 0; row < rows; row ++){
    //         dfs(board, row, 0); //leftmost column
    //         dfs(board, row, cols - 1); //rightmost column
    //     }
    //     for(int col = 0; col < cols; col ++){
    //         dfs(board, 0, col); // topmost row
    //         dfs(board, rows - 1, col); //bottommost row
    //     }

    //     for(int row = 0; row < rows; row ++){
    //         for(int col = 0; col < cols; col ++){
    //             if(board[row][col] == 'O'){
    //                 board[row][col] = 'X'; //updating any valid region's 'O' with 'X'
    //             }
    //             if(board[row][col] == 'T'){
    //                 board[row][col] = 'O'; //reverting back any invalid region's 'T' to 'O'
    //             }
    //         }
    //     }

    // }

    // public void dfs(char[][] board, int row, int col){
        
    //     if(board[row][col] == 'O'){
    //         board[row][col] = 'T';
    //     }
    //     else{
    //         return;
    //     }

    //     for(int[] direction : directions){
    //         int newRow = row + direction[0];
    //         int newCol = col + direction[1];

    //         if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
    //         && board[newRow][newCol] == 'O'){     
    //             //try with newRow < rows - 1 and newCol < cols - 1
    //             dfs(board, newRow, newCol);
    //         }
    //     }
    //     return;
    // }



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //intuition 1 (bfs): start with intializing a queue with all 'O' cells on edges of the board. Have a validRegion boolean matrix to track
    //regions originating from the edge. At last convert all 'O' cells to 'X' that are false in the validRegion. 
    // public void solve(char[][] board) {
    //     Queue<int[]> queue = new ArrayDeque<>();
    //     int rows = board.length;
    //     int cols = board[0].length;

    //     // boolean[][] validRegion = new boolean[rows][cols];

    //     int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    //     //intializing queue with all 'O' cells on the edge of the board
    //     for(int col = 0; col < cols; col ++){
    //         if(board[0][col] == 'O'){
    //             queue.offer(new int[]{0, col});
    //         }

    //         if(board[rows - 1][col] == 'O'){
    //             queue.offer(new int[]{rows - 1, col});
    //         }
    //     }
    //     for(int row = 1; row < rows - 1; row ++){
    //         if(board[row][0] == 'O'){
    //             queue.offer(new int[]{row, 0});
    //         }

    //         if(board[row][cols - 1] == 'O'){
    //             queue.offer(new int[]{row, cols - 1});
    //         }
    //     }

    //     while(!queue.isEmpty()){
            
    //         int[] temp = queue.remove();
    //         int r = temp[0];
    //         int c = temp[1];
    //         // validRegion[r][c] = true;
    //         board[r][c] = 'T';

    //         for(int[] direction : directions){
    //             int newRow = r + direction[0];
    //             int newCol = c + direction[1];

    //             if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
    //             // && !validRegion[newRow][newCol]
    //             && board[newRow][newCol] == 'O'){
    //                 queue.offer(new int[]{newRow, newCol});
    //             }
    //         }

    //     }


    //     for(int row = 0; row < rows; row ++){
    //         for(int col = 0; col < cols; col ++){
    //             // if(!validRegion[row][col]){
    //             //     board[row][col] = 'X';
    //             // }
    //             if(board[row][col] == 'O'){
    //                 board[row][col] = 'X';
    //             }
    //             if(board[row][col] == 'T'){
    //                 board[row][col] = 'O';
    //             }
    //         }   
    //     }


    // }

    ////////////////////////////////////////////////////////////////////////////////////////

}