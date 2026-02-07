class Solution {
    //intuition 1: Graphs : DFS
        //Start from all the boundary cells (first row, frist col, last row, last col) and run
            //dfs on 1's encountered. 
        //During the dfs, mark all the 1's as 0's.

        //Last run a grid traversal and count the number of 1's remaining, this is our answer.

        //TC: O(m x n) : Visiting each grid cell exactly once
        //SC: O(m x n) : Depth of the recursive stack

    public int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        //first row and last row
        int fRow = 0;
        int lRow = rows - 1;
        for(int j = 0; j < cols; j ++){
            if(grid[fRow][j] == 1) dfs(fRow, j, grid, directions);
            if(grid[lRow][j] == 1) dfs(lRow, j, grid, directions);
        }

        //first col and last col
        int fCol = 0;
        int lCol = cols - 1;
        for(int i = 0; i < rows; i ++){
            if(grid[i][fCol] == 1) dfs(i, fCol, grid, directions);
            if(grid[i][lCol] == 1) dfs(i, lCol, grid, directions);
        }

        int remOnes = 0;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(grid[i][j] == 1) remOnes += 1;
            }
        }

        return remOnes;

    }

    private void dfs(int row, int col, int[][] grid, int[][] directions){

        grid[row][col] = 0;

        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length 
            && grid[newRow][newCol] == 1){
                dfs(newRow, newCol, grid, directions);
            } 
        }

    }
}