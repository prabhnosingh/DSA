class Solution {

    //Solving on 11 Aug 2026

    //intuition 1: Graph (multi-source BFS)
        //to maximize the height in the matrix and also satisfy the condition of diff
            //in heights between any two cells is at most 1, we can start from all water
            //cells and run BFS traverse towards its neigbors 1 step at a time while
            //assigning height to each land cell as 1 + currCell height. This way 
            //any neighbor cell cannot have more height diff than 1 from the 
            //current cell.
    public int[][] highestPeak(int[][] isWater) {
        
        int rows = isWater.length;
        int cols = isWater[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        //pushing all water cells to queue
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(isWater[i][j] == 1){
                    isWater[i][j] = 0; //marking height of water cell as 0
                    queue.offer(new int[]{i, j});
                }
                else{ //if cell is 0, i.e. a land
                    //we need to differentiate this cell from water
                    //we can mark it as -1 so that we can safely update it to
                        //a positive number(height) while traversing in future
                    isWater[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] currElm = queue.poll();
            
            for(int[] direction : directions){
                int newX = currElm[0] + direction[0];
                int newY = currElm[1] + direction[1];

                if(newX != -1 && newX != rows && newY != -1 && newY != cols &&
                isWater[newX][newY] == -1){ //-1 denotes unvisited cell
                    isWater[newX][newY] = isWater[currElm[0]][currElm[1]] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return isWater;
        

    }
}