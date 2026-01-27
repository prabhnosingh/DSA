class Solution {

    //Re-solving on 27 Jan 2026:
    
    //intuiton 1: Graphs : BFS (max/min)
        //Have bfs helper function
        //Traverse whole grid 
        //For each 1 encountered, add it to the queue and run BFS on adjacent 1s
            //While bfs traversing keep count of 1's encountered and update each 1 to 0 to mark
                //it as visited
        
    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        
        int maxArea = 0;
        int[][] directions = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                    grid[i][j] = 0;
                    maxArea = Math.max(maxArea, bfs(grid, queue, directions));
                }
            }
        }
        return maxArea;
    
    }
    private int bfs(int[][] grid, Queue<int[]> queue, int[][] directions){
        int area = 1;


        while(!queue.isEmpty()){
            int[] currIdx = queue.poll();
            
            int currX = currIdx[0];
            int currY = currIdx[1];

            for(int[] direction : directions){
                int newX = currX + direction[0];
                int newY = currY + direction[1];

                if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] == 1){
                    grid[newX][newY] = 0;
                    area += 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return area;
    }




































///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //intuition 2 (bfs): Find the islands using bfs. Iterate over the entire grid and add indices of the first 1 encountered to the queue
//     //Then run bfs and add all the neighboring 1s to the queue until it is empty. Update each polled index with 2. Also add to currIslandArea will each poll.  
//     //An empty queue will signify that one whole island have been traversed. 
    
//     //TC: O(m.n)
//     //SC: O(m.n)

//     Queue<int[]> queue = new LinkedList<>();
//     public int maxAreaOfIsland(int[][] grid) {
//         int ans = 0;
//         for(int row = 0; row < grid.length; row ++){
//             for(int col = 0; col < grid[0].length; col ++){
//                 if(grid[row][col] == 1){
//                     queue.add(new int[]{row, col}); //adding intial 1 to the queue
//                     grid[row][col] = 2;
//                     ans = Math.max(ans, bfs(grid));
//                 }
//             }
//         }
//         return ans;

//     }

//     public void addIsland(int[][] grid, int row, int col){
//         if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 1){
//             return;
//         }
//         queue.add(new int[]{row, col});
//         grid[row][col] = 2; //marking an island as visited

//     }

//     public int bfs(int[][] grid){
//         int currIslandSize = 0;
//         while(!queue.isEmpty()){
//             int qSize = queue.size();
//             currIslandSize += qSize;
//             for(int i = 0; i < qSize; i ++){
//                 int[] tempIsland = queue.remove();
//                 addIsland(grid, tempIsland[0] + 1, tempIsland[1]);
//                 addIsland(grid, tempIsland[0] - 1, tempIsland[1]);
//                 addIsland(grid, tempIsland[0], tempIsland[1] + 1);
//                 addIsland(grid, tempIsland[0], tempIsland[1] - 1);
//             }
//         }

//         return currIslandSize;

//     }

// }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //intuition 1: Find the islands using dfs. Change each visited island to 2. Keep track of max area encountered  

    //TC: O(4.m.n) = O(m.n) => each cell is processed at most once, and each visit does O(1) work over 4 neighbor
    //SC: O(m.n) => the DFS call stack can grow to the size of the largest island—in the worst case that’s O(mn).
    // int maxArea;
    // int[][] directions;
    // public int maxAreaOfIsland(int[][] grid) {
    //     maxArea = 0;
    //     directions = new int[][]{
    //         {1,0}, //right
    //         {-1,0}, //left
    //         {0,1}, //up
    //         {0,-1} //down
    //     };

    //     int rows = grid.length;
    //     int cols = grid[0].length;
 
    //     for(int row = 0; row < rows; row ++){
    //         for(int col = 0; col < cols; col ++){
    //             if(grid[row][col] == 1){
    //                 maxArea = Math.max(maxArea, dfs(grid, row, col));  //dfs returns area for a full island
    //             }
    //         }
    //     }
    //      return maxArea;

    // }

    // public int dfs(int[][] grid, int row, int col){

    //     if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 1){
    //         return 0;
    //     }

    //     grid[row][col] = 2;
    //     int currArea = 1;

    //     for(int[] direction : directions){
    //         int dr = direction[0]; //direction row
    //         int dc = direction[1]; //direction col

    //         currArea += dfs(grid, row + dr, col + dc);
    //     }

    //     return currArea; 

    // }
}









