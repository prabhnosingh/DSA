class Solution {

    //Solving on 10 Aug 2026
    //intuition 1: Graphs BFS
        //We can start from all the gates and fill the empty spaces
        //Add all the gates to a queue and then as per each increasing
            //level fill any empty spaces encountered
    public void wallsAndGates(int[][] rooms) {
        
        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(rooms[i][j] == 0){ //gate encountered
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()){
            int currQueueSize = queue.size();

            for(int i = 0; i < currQueueSize; i ++){
                int[] currIdx = queue.poll();

                for(int[] direction : directions){
                    int newX = currIdx[0] + direction[0];
                    int newY = currIdx[1] + direction[1];

                    if(newX != -1 && newX != rooms.length && newY != -1 &&
                    newY != rooms[0].length && rooms[newX][newY] == Integer.MAX_VALUE){
                    //valid empty room
                        rooms[newX][newY] = rooms[currIdx[0]][currIdx[1]] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

    }


}