class Solution {
    //Solving on 05 Jan 2026

    //intuition 1: 
        //Traverse the grid and compute the connecting cell for each cell using its value
            //in an adjacency list, like:
                //6 links right (i, j+1) cell to upper (i-1, j) cell, therefore add it to
                    //adjList right and upper to each other's adjacency list
               
               //1 links (i, j-1) left to (i, j+1) right
               //2 links (i-1, j) upper to (i+1, j) lower
               //3 links (i, j-1) left to (i+1, j) lower
               //4 links (i, j+1) right to (i+1, j) lower
               //5 links (i, j-1) left to (i-1, j) upper
               //6 links (i, j+1) right to (i-1, j) upper

        //At last run dfs on adjList to see if 0,0 leads to m-1, n-1

        //To identify each cell uniquely with a single integer in a rows x cols matrix, use below formula:
            //map (x,y) -> id
                //id = x * cols  + y
            //map id -> (x,y)
                //x = id / cols 
                //y = id % cols


        //Two-way compatibility:
            //“If I can go from A to B, then from B I must be able to come back to A.”
            //currCell(i,j) can connect (form an edge) to neighbor (nx,ny) if and only if:
                //(nx,ny) is one of currCell's two endpoints, and 
                //(i,j) is one of neighbor's two endpoints 

    public boolean hasValidPath(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;  

        if(rows == 1 && cols == 1) return true;

        //based on value of each cell, below map can be applied to i,j to find two neighboring cells 
        int[][] connectionMap = {{0,-1,0,1}, {-1,0,1,0}, {0,-1,1,0}, {0,1,1,0}, {0,-1,-1,0}, {0,1,-1,0}}; 

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[(rows * cols)];

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                int cellVal = grid[i][j]; 
                int currId = i*cols + j;
                if(!adjList.containsKey(currId)) adjList.put(currId, new ArrayList<>());

                int[] currConnection = connectionMap[cellVal-1];
                int x1 = i + currConnection[0];
                int y1 = j + currConnection[1];
                
                int x2 = i + currConnection[2];
                int y2 = j + currConnection[3];

                //using id = x*cols + y for mapping each cell to a unique id

                if(x1  >= 0 && y1 >= 0 && x1 < rows && y1 < cols){
                    if(isCompatible(grid, i, j, x1, y1, connectionMap)){
                        int x1Id = x1*cols + y1;
                        //connecting currCell to x1 and currCell to x2 as we can travel to all x1, x2 and currCell with this path
                        if(!adjList.containsKey(x1Id)) adjList.put(x1Id, new ArrayList<>());
                        if(!adjList.get(x1Id).contains(currId)) adjList.get(x1Id).add(currId);
                        if(!adjList.get(currId).contains(x1Id)) adjList.get(currId).add(x1Id);
                    }
                }

                //splitting these conditions as one of them could be valid while the other might not be a valid one
                if(x2 >=0 && y2 >= 0 && x2 < rows && y2 < cols){
                    if(isCompatible(grid, i, j, x2, y2, connectionMap)){
                        int x2Id = x2*cols + y2;
                        if(!adjList.containsKey(x2Id)) adjList.put(x2Id, new ArrayList<>());
                        if(!adjList.get(x2Id).contains(currId)) adjList.get(x2Id).add(currId);
                        if(!adjList.get(currId).contains(x2Id)) adjList.get(currId).add(x2Id);
                    }
                }


            }
        }

        //running dfs to find if we can reach rows-1, cols-1 with cellId (rows-1) * cols + (cols-1)
        int dest = (rows-1) * cols + (cols-1);
        // System.out.println(dest);
        // for(int cell : adjList.keySet()){
        //     System.out.print(cell + " -> ");
        //     for(int child : adjList.get(cell)){
        //         System.out.print(child + " ");
        //     }
        //     System.out.println();
        // }
        visited[0] = true;
        return dfs(0, adjList, visited, dest);

        
    }


    //currCell connection to nei is verified as that is how nei variable was intialized in the first place  
    //Below function verifies whether nei connects back to currCell. 
    private boolean isCompatible(int[][] grid, int currCellX, int currCellY, int neiX, int neiY, int[][] connectionMap){
        int neiVal = grid[neiX][neiY];

        int[] neiConn = connectionMap[neiVal - 1];

        int x1 = neiX + neiConn[0]; //x of first neigbor of neigbor
        int y1 = neiY + neiConn[1]; //y of first neigbor of neigbor

        int x2 = neiX + neiConn[2]; //x of second neigbor of neigbor
        int y2 = neiY + neiConn[3]; //y of second neigbor of neigbor

        return ((currCellX == x1 && currCellY == y1) || (currCellX == x2 && currCellY == y2));

    }

    private boolean dfs(int cellId, HashMap<Integer, List<Integer>> adjList, boolean[] visited, int dest){

        
        // if(!adjList.containsKey(cellId)) return false;
        boolean res = false;
        for(int child : adjList.get(cellId)){
            if(!visited[child]){
                visited[child] = true;
                // System.out.println(child + " -> " + visited[child]);
                if(child == dest) return true;
                if(dfs(child, adjList, visited, dest)) return true; //if some call returned true, return true
            }
        }
        return false;
    }
} 