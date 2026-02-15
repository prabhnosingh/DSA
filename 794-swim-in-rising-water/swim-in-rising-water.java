class Solution {

    //Solving on 14 Feb 2026
    
    //intuition 2: Graphs : Djikstra (priority queue)
        //We have to find the path where maximum elevation is "minimized"
        //We store each node in an int array of (elevation, x, y) in priorityQueue (minHeap)
        //And we maintain the maximum elevation throughout the path, i.e. each time while
            //offering neighboring node to the queue we offer the maximum of currNode, neighbor node
        
        //Start from top left value
        //We stop and return the polled node's elevation when bottom right cell is acheived

        //mark the cells visited by marking them as -1 after being offered to the minHeap

    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

        
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int minTime = 0;
 
        while(!minHeap.isEmpty()){
            int[] currCell = minHeap.poll();

            int currCellElevation = currCell[0];
            int currCellX = currCell[1];
            int currCellY = currCell[2];

            if(currCellX == grid.length - 1 && currCellY == grid[0].length - 1){
                minTime = currCellElevation;
                break;
            }

            for(int[] direction : directions){
                int newX = currCellX + direction[0];
                int newY = currCellY + direction[1];

                if(newX >=0 && newY >= 0 && newX < grid.length  && newY < grid[0].length
                && grid[newX][newY] != -1){
                    int newElevation = Math.max(grid[newX][newY], currCellElevation);
                    minHeap.offer(new int[]{newElevation, newX, newY});
                    grid[newX][newY] = -1;
                }
            }

        }

        return minTime;

        
    }


///////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 14 Feb 2026
    
    // //intuition 1: Graphs : BFS
    //     //We have to find minimum time, so we will be using BFS
    //     //Start from top left value (add it to minTime)
    //     //Then check if any neighboring values of this node are less than equal to currNode's value, 
    //         //if yes, then add that in the queue, if not, add the minimum value from the neighbors 
    //         //in the queue and update the minTime to this node's value.
    //         //
    // public int swimInWater(int[][] grid) {
        
    //     Queue<int[]> queue = new ArrayDeque<>();

    //     int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    //     int topLeft = grid[0][0];

    //     int minTime = 0 ;

    //     queue.offer(new int[]{0,0});
    //     grid[0][0] = -1;

    //     while(!queue.isEmpty()){
    //         int[] currNode = queue.poll();
    //         int currNodeX = currNode[0];
    //         int currNodeY = currNode[1];
    //         if(currNodeX == grid.length - 1 && currNodeY == grid[0].length - 1) break;
    //         int currNodeVal = grid[currNodeX][currNodeY];

    //         // if(currNodeVal <= minTime) continue;
    //         int minNeighborVal = Integer.MAX_VALUE;
    //         int[] minCoordinates = new int[2];
    //         for(int[] direction : directions){
    //             int newX = currNodeX + direction[0];
    //             int newY = currNodeY + direction[1];

    //             if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && grid[newX][newY] != -1){
    //                 if(minNeighborVal > grid[newX][newY]){
    //                     minCoordinates[0] = newX;
    //                     minCoordinates[1] = newY;

    //                     minNeighborVal = grid[newX][newY];
    //                 }
    //             }
    //         }
    //         if(minNeighborVal > minTime) minTime = minNeighborVal; //updating the minTime
    //         grid[minCoordinates[0]][minCoordinates[1]] = -1; //marking as visited
    //         queue.offer(minCoordinates);

    //     }

    //     return minTime;
    // }
}