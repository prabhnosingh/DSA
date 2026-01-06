class Solution {
    //Sovling on 05 Jan 2026

    //intuition 2: Graph : Mutli-source BFS pattern
        //Add all the 0's to a queue and run BFS on all of them together.
        //Anytime a 1 is encountered, replace it with current BFS level + 1 and add th pos to a 
            //boolean visited array
        //This way we visit each cell exactly once

    //TC: O(rows*cols) (each cell enqueued once)
    //SC: O(rows*cols) (queue worst case + visited)

    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[rows][cols];

        //initializing queue with positions of 0s
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int currBFSLevel = 0;
        while(!queue.isEmpty()){
            int currQSize = queue.size();

            for(int i = 0; i < currQSize; i ++){
                int[] currPos = queue.poll();
                int x = currPos[0];
                int y = currPos[1];

                for(int[] dir : directions){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >= 0 && newY >= 0 && newX < rows && newY < cols && mat[newX][newY] == 1
                    && !visited[newX][newY]){
                        visited[newX][newY] = true;
                        mat[newX][newY] = currBFSLevel + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            currBFSLevel += 1;
        }
        
        return mat;
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Sovling on 05 Jan 2026

    // //intuition 1 (TLE: Coded in 16 mins): Graph : BFS
    //     //Run a bfs on each of the cell and find the distance to nearest 0
    //     //Traverse the matrix using nested for loop:
    //         //Mark 0 for any 0 encountered
    //         //Run bfsTraversal over any 1 encountered with newly initialized boolean visited 2D array
        
    //     //TC: O((rows * cols) ^ 2) : Every cell can be travesed rows*cols times
    //     //SC: O(rows * cols + rows * cols) = O(rows * cols) : Visited array + max queue size

    //     //TLE retrospection: Something is being repeated and needs to be optimized. Maybe we can reuse 
    //         //already computed shortest distances 
    // public int[][] updateMatrix(int[][] mat) {

    //     int rows = mat.length;
    //     int cols = mat[0].length;    

    //     int[][] dist = new int[rows][cols];

    //     int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    //     for(int i = 0; i < rows; i ++){
    //         for(int j = 0; j < cols; j ++){
    //             if(mat[i][j] == 0) dist[i][j] = 0;
    //             else{
    //                 boolean[][] visited = new boolean[rows][cols];
    //                 dist[i][j] = bfsTraversal(mat, i, j, visited, directions);
    //             }
    //         }
    //     }
    //     return dist;

    // }

    // private int bfsTraversal(int[][] mat, int row, int col, boolean[][] visited, int[][] directions){

    //     Queue<int[]> queue = new ArrayDeque<>();

    //     queue.offer(new int[]{row, col});
    //     visited[row][col] = true;
    //     int currDist = 0;

    //     while(!queue.isEmpty()){
    //         int currQSize = queue.size();

    //         for(int i = 0; i < currQSize; i ++){
    //             int[] currPos = queue.poll();
    //             int x = currPos[0];
    //             int y = currPos[1];

    //             for(int[] dir : directions){
    //                 int newX = x + dir[0];
    //                 int newY = y + dir[1];

    //                 if(newX >= 0 && newY >= 0 && newX < mat.length && newY < mat[0].length && !visited[newX][newY]){
    //                     if(mat[newX][newY] == 0){
    //                         return currDist + 1;
    //                     }
    //                     visited[newX][newY] = true;
    //                     queue.offer(new int[]{newX, newY});
    //                 }
    //             }
    //         }
    //         currDist += 1; //distance increases after each level finishes 
    //     }
    //     return 0;
    // }
}