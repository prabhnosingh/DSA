class Solution {
    
    //Re-solving on 04 Jan 2025


    
    //intuition 2: Graph: BFS
        //Add all rotten oranges to a queue and start polling all of the them one by one and 
            //offer back teh newly affected oranges to the queue. Each level will signify one
            //minute.
        //After each level complete, all the rotten oranges would have infected their respective
            //adjacent fresh oranges


        //TC: O(rows * cols) : We traverse each cell once
        //SC: O(rows * cols): In worst call all the cells could be in queue

    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int minTime = 0;

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        Queue<int[]> queue = new ArrayDeque<>();

        int freshOrangeCount = 0; //this avoids rescanning grid after bfs traversal to find 
            //any remaining fresh oranges

        //intializing queue with rotten oranges
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                if(grid[i][j] == 1) freshOrangeCount += 1;
            }
        }   

        if(freshOrangeCount == 0){
            return 0;
        }
        while(!queue.isEmpty()){
            int currQSize = queue.size();
            boolean freshOrangeFound = false;

            for(int i = 0; i < currQSize; i ++){
                int[] currPos = queue.poll();
                int x = currPos[0];
                int y = currPos[1];

                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 1){
                        freshOrangeFound = true;
                        freshOrangeCount -= 1;
                        grid[newX][newY] = 2;
                        queue.offer(new int[]{newX, newY});
                    }
                } 
            }
            //do not increase time if none of the rotten oranges were able to infect any fresh oranges
                //due unavailability of fresh oranges
            if(freshOrangeFound){
                freshOrangeFound = false;
                minTime += 1;
            }
        }

        // //checking for any fresh oranges
        // for(int i = 0; i < rows; i ++){
        //     for(int j = 0; j < cols; j ++){
        //         if(grid[i][j] == 1) return -1;
        //     }
        // }
        
        return freshOrangeCount > 0 ? -1 : minTime;

    }




//////////////////////////////////////////////////////////////////////////////////////////////////
    // //This does not work as it starts from top left and move towards bottom right with increasing
    //     //time but this will fail in case we have a rotten orange somewhere down the grid as this
    //     //rotten orange will start affecting other fresh oranges sooner than the rotten orange at top.
    // //intuition 1: Graph : BFS
    //     //We do BFS traversal. 
    //     //Run a nested for loop to traverse the grid. 
    //     //Have a helper function that takes the indices of a rotten orange.
    //     //Expand level by level from that rotten orange and return the levels.
    //     //The minimum time taken for all oranges to rot is the maximum time (levels)
    //         //it takes for any rotten orange to infect all connecting oranges.
    
    //     //mark the visited orages as -1

    // public int orangesRotting(int[][] grid) {
        
    //     int rows = grid.length;
    //     int cols = grid[0].length;

    //     int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    //     int minTime = 0;

    //     for(int i = 0; i < rows; i ++){
    //         for(int j = 0; j < cols; j ++){
    //             if(grid[i][j] == 2){ //rotten orange found
    //                 // grid[i][j] = -1; //marking an orange visited
    //                 int currTime = bfsTraversal(grid, i, j, directions);
    //                 // System.out.println(currTime);
    //                 minTime = Math.max(currTime, minTime);
    //             }
    //         }
    //     }

    //     for(int i = 0; i < rows; i ++){
    //         for(int j = 0; j < cols; j ++){
    //             if(grid[i][j] == 1){
    //                 return -1;
    //             }
    //         }
    //     }
    //     return minTime;

    // }

    // private int bfsTraversal(int[][] grid, int row, int col, int[][] directions){
    //     Queue<int[]> queue = new ArrayDeque<>();
    //     int time = 0;
    //     queue.offer(new int[]{row, col});
    //     boolean freshOrangeFound = false;
    //     while(!queue.isEmpty()){
    //         int currQSize = queue.size();

    //         for(int i = 0; i < currQSize; i ++){
    //             int[] currPos = queue.poll();
    //             int x = currPos[0];
    //             int y = currPos[1];

    //             for(int[] dir : directions){
    //                 int newX = x + dir[0];
    //                 int newY = y + dir[1];

    //                 if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length 
    //                 && grid[newX][newY] == 1){
    //                     freshOrangeFound = true;
    //                     grid[newX][newY] = 2; 
    //                     queue.offer(new int[]{newX, newY});
    //                 }
                    
    //             }
    //         }
    //         // time += 1;

    //         if(freshOrangeFound){ //in the current level was there any fresh orange  that was turned into
    //             //rotten?
    //             // System.out.println("x: " + x + "y: " + y);
    //             freshOrangeFound = false;
    //             time += 1;
    //         }
    //     }
    //     return time;
    // }






























/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1(bfs): start by initializing a queue with all rotten oranges locations
    // //then poll each rotten orange and add its neighbor fresh oranges to the queue (now rotten)
    // //each level of queue represents 1 second passed

    // //TC: O(m.n): Visiting each cell ones 
    // //SC: O(m.n): queue used
    // Queue<int[]> queue;
    // int freshOranges;
    
    // public void addOranges(int[][] grid, int row, int col){
    //     if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != 1){
    //         return;
    //     }

    //     freshOranges -= 1; //updating the count of freshOranges
    //     grid[row][col] = 2; //marking a fresh orange as rotten
    //     queue.add(new int[] {row, col});

    // }

    // public int orangesRotting(int[][] grid) {
    //     queue = new ArrayDeque<>();
    //     freshOranges = 0;


    //     int timeElapsed = 0; 
    //     for(int row = 0; row < grid.length; row ++){
    //         for(int col = 0; col < grid[0].length; col ++){
    //             if(grid[row][col] == 2){ //adding rotten oranges to the queue
    //                 queue.add(new int[]{row, col});
    //             }
    //             else if(grid[row][col] == 1){
    //                 freshOranges += 1;
    //             }
    //         }
    //     }

    //     while(!queue.isEmpty()){
    //         int qSize = queue.size();
    //         for(int i = 0; i < qSize; i ++){
    //             int[] tempIdx = queue.remove();
    //             addOranges(grid, tempIdx[0] + 1, tempIdx[1]);
    //             addOranges(grid, tempIdx[0] - 1, tempIdx[1]);
    //             addOranges(grid, tempIdx[0], tempIdx[1] + 1);
    //             addOranges(grid, tempIdx[0], tempIdx[1] - 1);
    //         }
    //         if(queue.size() != 0){ //only increment timeElapsed if queue'size is more than 0 
    //         //no addition to queue (queue.size == 0) means that no fresh oranges are left
    //             timeElapsed += 1;
    //         }
    //     }

    //     return freshOranges == 0 ? timeElapsed : -1; //if fresh oranges are not 0, this means that some orange
    //     //was unaffected by the rotten oranges, so it is impossible to make all oranges rotten
    // }
}