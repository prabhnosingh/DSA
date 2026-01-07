class Solution {
    //Solve both with DFS and BFS
    
    //Re-Solving on 07 Jan 2026
    

    //intuition 2: DFS: Graph : Pattern - Grid graph traversal with edge-compatibility (Constrained BFS/DFS)
        //Start from 0,0 and see in which direction is a valid one to travel:
            //A direction is valid to travel if the current cell have a path to a neighbor and that
                //neighbor also has backward compatible path.
            //First check the val of currCell:
                //1=> left to right => (i,j-1) to (i,j+1) => (0,-1,0,1)
                //2=> upper to lower => (i-1,j) to (i+1,j) => (-1,0,1,0)
                //3=> left to lower => (i,j-1) to (i+1,j) => (0,-1,1,0)
                //4=> right to lower => (i,j+1) to (i+1,j) => (0,1,1,0)
                //5=> left to upper => (i,j-1) to (i-1,j) => (0,-1,-1,0)
                //6=> right to upper => (i,j+1) to (i-1,j) => (0,1,-1,0)
            //Then compute the neighbor values:
                //For all valid values traverse recursively until an end or rows-1,cols-1 cell is reached
            
        //For finding a valid cell, have a helper function


    public boolean hasValidPath(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        //map to compute neighbors of a given i,j cell
        boolean[][] visited = new boolean[rows][cols];
        int[][] neiMap = {{0,-1,0,1}, {-1,0,1,0}, {0,-1,1,0}, {0,1,1,0}, {0,-1,-1,0}, {0,1,-1,0}};

        // visited[0][0] = true;
        return dfsTraverse(grid, neiMap, 0, 0, visited);

    }

    private boolean dfsTraverse(int[][] grid, int[][] neiMap, int row, int col, 
    boolean[][] visited){
        if(visited[row][col]) return false;

        if(row == grid.length - 1 && col == grid[0].length - 1) return true;

        visited[row][col] = true;
        
        int currCellVal = grid[row][col];
        int[] neiMapVal = neiMap[currCellVal - 1];

        //neighbor 1
        int nei1Row = neiMapVal[0] + row;
        int nei1Col = neiMapVal[1] + col;

        if(isValidPath(grid, neiMap, nei1Row, nei1Col, row, col)){
            if(dfsTraverse(grid, neiMap, nei1Row, nei1Col, visited)) return true;
        }
        
        //neighbor 2
        int nei2Row = neiMapVal[2] + row;
        int nei2Col = neiMapVal[3] + col;

        if(isValidPath(grid, neiMap, nei2Row, nei2Col, row, col)){
            if(dfsTraverse(grid, neiMap, nei2Row, nei2Col, visited)) return true;
        }

        return false;


    }

    private boolean isValidPath(int[][] grid, int[][] neiMap, int neiRow, int neiCol, 
    int currRow, int currCol){
        if(neiRow < 0 || neiCol < 0 || neiRow >= grid.length || neiCol >= grid[0].length){
            return false;
        }

        int neiVal = grid[neiRow][neiCol];
        //neighbor's neighbor map val
        int[] neiNeiMapVal = neiMap[neiVal - 1];

        int neiNei1Row = neiRow + neiNeiMapVal[0];
        int neiNei1Col = neiCol + neiNeiMapVal[1];

        int neiNei2Row = neiRow + neiNeiMapVal[2];
        int neiNei2Col = neiCol + neiNeiMapVal[3];

        //if currCell is the neighbor of one of the neighbors return true
        if((neiNei1Row == currRow && neiNei1Col == currCol)
        || (neiNei2Row == currRow && neiNei2Col == currCol)){
            return true;
        }
        return false;
    }

























//////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 2: Solve with both DFS and BFS


    // //intuition 1: 
    //     //Traverse the grid and compute the connecting cell for each cell using its value
    //         //in an adjacency list, like:
    //             //6 links right (i, j+1) cell to upper (i-1, j) cell, therefore add it to
    //                 //adjList right and upper to each other's adjacency list
               
    //            //1 links (i, j-1) left to (i, j+1) right
    //            //2 links (i-1, j) upper to (i+1, j) lower
    //            //3 links (i, j-1) left to (i+1, j) lower
    //            //4 links (i, j+1) right to (i+1, j) lower
    //            //5 links (i, j-1) left to (i-1, j) upper
    //            //6 links (i, j+1) right to (i-1, j) upper

    //     //At last run dfs on adjList to see if 0,0 leads to m-1, n-1

    //     //To identify each cell uniquely with a single integer in a rows x cols matrix, use below formula:
    //         //map (x,y) -> id
    //             //id = x * cols  + y
    //         //map id -> (x,y)
    //             //x = id / cols 
    //             //y = id % cols


    //     //Two-way compatibility:
    //         //“If I can go from A to B, then from B I must be able to come back to A.”
    //         //currCell(i,j) can connect (form an edge) to neighbor (nx,ny) if and only if:
    //             //(nx,ny) is one of currCell's two endpoints, and 
    //             //(i,j) is one of neighbor's two endpoints 

    // public boolean hasValidPath(int[][] grid) {
        
    //     int rows = grid.length;
    //     int cols = grid[0].length;  

    //     if(rows == 1 && cols == 1) return true;

    //     //based on value of each cell, below map can be applied to i,j to find two neighboring cells 
    //     int[][] connectionMap = {{0,-1,0,1}, {-1,0,1,0}, {0,-1,1,0}, {0,1,1,0}, {0,-1,-1,0}, {0,1,-1,0}}; 

    //     HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    //     boolean[] visited = new boolean[(rows * cols)];

    //     for(int i = 0; i < rows; i ++){
    //         for(int j = 0; j < cols; j ++){
    //             int cellVal = grid[i][j]; 
    //             int currId = i*cols + j;
    //             if(!adjList.containsKey(currId)) adjList.put(currId, new ArrayList<>());

    //             int[] currConnection = connectionMap[cellVal-1];
    //             int x1 = i + currConnection[0];
    //             int y1 = j + currConnection[1];
                
    //             int x2 = i + currConnection[2];
    //             int y2 = j + currConnection[3];

    //             //using id = x*cols + y for mapping each cell to a unique id

    //             if(x1 >= 0 && y1 >= 0 && x1 < rows && y1 < cols){
    //                 if(isCompatible(grid, i, j, x1, y1, connectionMap)){
    //                     int x1Id = x1*cols + y1;
    //                     if(!adjList.containsKey(x1Id)) adjList.put(x1Id, new ArrayList<>());
    //                     if(!adjList.get(x1Id).contains(currId)) adjList.get(x1Id).add(currId);
    //                     if(!adjList.get(currId).contains(x1Id)) adjList.get(currId).add(x1Id);
    //                 }
    //             }

    //             //splitting these conditions as one of them could be valid while the other might not be a valid one
    //             if(x2 >=0 && y2 >= 0 && x2 < rows && y2 < cols){
    //                 if(isCompatible(grid, i, j, x2, y2, connectionMap)){
    //                     int x2Id = x2*cols + y2;
    //                     if(!adjList.containsKey(x2Id)) adjList.put(x2Id, new ArrayList<>());
    //                     if(!adjList.get(x2Id).contains(currId)) adjList.get(x2Id).add(currId);
    //                     if(!adjList.get(currId).contains(x2Id)) adjList.get(currId).add(x2Id);
    //                 }
    //             }


    //         }
    //     }

    //     //running dfs to find if we can reach rows-1, cols-1 with cellId (rows-1) * cols + (cols-1)
    //     int dest = (rows-1) * cols + (cols-1);
    //     // System.out.println(dest);
    //     // for(int cell : adjList.keySet()){
    //     //     System.out.print(cell + " -> ");
    //     //     for(int child : adjList.get(cell)){
    //     //         System.out.print(child + " ");
    //     //     }
    //     //     System.out.println();
    //     // }
    //     visited[0] = true;
    //     return dfs(0, adjList, visited, dest);

        
    // }


    // //currCell connection to nei is verified as that is how nei variable was intialized in the first place  
    // //Below function verifies whether nei connects back to currCell. 
    // private boolean isCompatible(int[][] grid, int currCellX, int currCellY, int neiX, int neiY, int[][] connectionMap){
    //     int neiVal = grid[neiX][neiY];

    //     int[] neiConn = connectionMap[neiVal - 1];

    //     int x1 = neiX + neiConn[0]; //x of first neigbor of neigbor
    //     int y1 = neiY + neiConn[1]; //y of first neigbor of neigbor

    //     int x2 = neiX + neiConn[2]; //x of second neigbor of neigbor
    //     int y2 = neiY + neiConn[3]; //y of second neigbor of neigbor

    //     return ((currCellX == x1 && currCellY == y1) || (currCellX == x2 && currCellY == y2));

    // }

    // private boolean dfs(int cellId, HashMap<Integer, List<Integer>> adjList, boolean[] visited, int dest){

        
    //     // if(!adjList.containsKey(cellId)) return false;
    //     boolean res = false;
    //     for(int child : adjList.get(cellId)){
    //         if(!visited[child]){
    //             visited[child] = true;
    //             // System.out.println(child + " -> " + visited[child]);
    //             if(child == dest) return true;
    //             if(dfs(child, adjList, visited, dest)) return true; //if some call returned true, return true
    //         }
    //     }
    //     return false;
    // }
} 