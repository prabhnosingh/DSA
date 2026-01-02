class Solution {
    //Solving on 02 Jan 2026

    //intuiton 2 (optimizing intuition 1): Graph : BFS
        //Have a queue of type int[] array. Make each entry size of 3. For each polled entry
            //offer all 8 neighboring valid (0 and in-bounds of grid) cells back to queue. The
            //0 and 1 index of each entry will specify the x and y coordinates and 2 index will
            //specify current path length.
        //When we enter any entry in queue, we mark its value to 2, to avoid the same cell being
            //entering again in the queue.
        //When bottom right of the grid is reached, we return the path length.
        //By this way, at each level our path length will increase by 1 unit.
        //By following BFS, it is guaranteed that we will reach bottom right with shortest path 
            //length and do not need to traverse other options available, hence we return the 
            //path length as soon as we reach bottom right

        //Getting TLE: Do we need to traverse all the paths from the queue?
            //Learning: "A node must be marked visited at the moment it is enqueued, not when it is dequeued."
        
        //Optimization: We do not need to track an extra integer (currPathSum) in int[] array as each level of 
            //BFS itself signifies the shortest path. So when the bottom right is reached, we simply return the
            //curr BFS level 
    public int shortestPathBinaryMatrix(int[][] grid) { 
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        //if top left cell is 1 or bottom right cell is 1, just return -1
        if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1) return -1; 
        
        int currLevel = 0;
        queue.offer(new int[]{0, 0});
        grid[0][0] = 2;

        while(!queue.isEmpty()){
            int currQSize = queue.size();
            currLevel += 1;
            for(int i = 0; i < currQSize; i ++){
                int[] currCell = queue.poll();
                int x = currCell[0];
                int y = currCell[1];
                if(x == rows - 1 && y == cols - 1) return currLevel; //bottom right reached
                
                //The below code is causing TLE as we are marking a cell as visited too late with this block
                //Instead we should mark any cell visited as soon as we offer it to the queue.
                //The below code allows same cell to be offered in the queue multiple times by its neighbors 
                    //in the below "directions" for loop
                // //marking x, y as visited 
                // grid[x][y] = 2;

                int[][] directions = {
                {1,0}, //down 
                {-1,0}, //up
                {0,1}, //right
                {0,-1}, //left
                {-1,-1}, //top-left
                {-1,1}, //top-right
                {1,1}, //down-right
                {1,-1} //down-left
                }; 

                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    // if(newX == rows - 1 && newY == cols - 1) return currLevel + 1; //bottom right reached
                    if(newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 0){
                        //marking newX, newY as visited
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                    } 
                }
            }

        }
        return -1;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 02 Jan 2026

    // //intuiton 1: Graph : BFS
    //     //Have a queue of type int[] array. Make each entry size of 3. For each polled entry
    //         //offer all 8 neighboring valid (0 and in-bounds of grid) cells back to queue. The
    //         //0 and 1 index of each entry will specify the x and y coordinates and 2 index will
    //         //specify current path length.
    //     //When we enter any entry in queue, we mark its value to 2, to avoid the same cell being
    //         //entering again in the queue.
    //     //When bottom right of the grid is reached, we return the path length.
    //     //By this way, at each level our path length will increase by 1 unit.
    //     //By following BFS, it is guaranteed that we will reach bottom right with shortest path 
    //         //length and do not need to traverse other options available, hence we return the 
    //         //path length as soon as we reach bottom right

    //     //Getting TLE: Do we need to traverse all the paths from the queue?
    //         //Learning: "A node must be marked visited at the moment it is enqueued, not when it is dequeued."
    // public int shortestPathBinaryMatrix(int[][] grid) { 
        
    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     Queue<int[]> queue = new ArrayDeque<>();

    //     //if top left cell is 1 or bottom right cell is 1, just return -1
    //     if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1) return -1; 

    //     queue.offer(new int[]{0, 0, 1});
    //     grid[0][0] = 2;

    //     while(!queue.isEmpty()){
    //         int currQSize = queue.size();
    //         for(int i = 0; i < currQSize; i ++){
    //             int[] currCell = queue.poll();
    //             int x = currCell[0];
    //             int y = currCell[1];
    //             int currPathLen = currCell[2];
    //             if(x == rows - 1 && y == cols - 1) return currPathLen; //bottom right reached
                
    //             //The below code is causing TLE as we are marking a cell as visited too late with this block
    //             //Instead we should mark any cell visited as soon as we offer it to the queue.
    //             //The below code allows same cell to be offered in the queue multiple times by its neighbors 
    //                 //in the below "directions" for loop
    //             // //marking x, y as visited 
    //             // grid[x][y] = 2;

    //             int[][] directions = {
    //             {1,0}, //down 
    //             {-1,0}, //up
    //             {0,1}, //right
    //             {0,-1}, //left
    //             {-1,-1}, //top-left
    //             {-1,1}, //top-right
    //             {1,1}, //down-right
    //             {1,-1} //down-left
    //             }; 

    //             for(int[] dir : directions){
    //                 int newX = x + dir[0];
    //                 int newY = y + dir[1];
    //                 if(newX == rows - 1 && newY == cols - 1) return currPathLen + 1; //bottom right reached
    //                 if(newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 0){
    //                     //marking newX, newY as visited
    //                     grid[newX][newY] = 2;
    //                     queue.offer(new int[]{newX, newY, currPathLen + 1});
    //                 } 
    //             }
    //         }

    //     }
    //     return -1;
    // }
}