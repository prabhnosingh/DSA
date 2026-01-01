class Solution {
    //Solving on 01 Jan 2026

    //intuition 1: Graph : DFS
        //Traverse the whole grid with DFS. At each cell travel in all 4 directions. To make sure
            //we do not travel on the same node again, we mark each visited cell as 2. 
        //Base case will be when we encounter 0 or go out of bound
        //We run a for loop over the whole grid and call dfs on every 1 encountered.
            //For each 1 encountered, increase the island count by 1. DFS will make sure to update
                //all adjacent 1's of this 1 to 2 (all of which form one island)
            //After the for loop we return number of islands  

    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int numIslands = 0;
        
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(grid[i][j] == '1'){
                    numIslands += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }
    
    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] != '1') return;

        grid[row][col] = '2';


        dfs(grid, row + 1, col); //down
        dfs(grid, row - 1, col); //top
        dfs(grid, row, col + 1); //right
        dfs(grid, row, col - 1); //left
    }











































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////
//intuition 1: Use hashset to store already visited (row, col) pairs and use queue to perform BFS
// class Solution {
//     public int numIslands(char[][] grid) {
//         if(grid == null){
//             return 0;
//         }

//         int rows = grid.length;
//         int cols = grid[0].length;
//         HashSet<List<Integer>> visited = new HashSet<>();
//         int islands = 0;

//         for(int row = 0; row < rows; row ++){ //traversing the whole grid
//             for(int col = 0; col < cols; col ++){
//                 if(grid[row][col] == '1' && !visited.contains(new ArrayList<>(Arrays.asList(row, col)))){ 
//                     //run bfs on (row, col) if it reprsents a '1' and is not in visited set
//                     bfs(row, col, grid, visited);
//                     islands += 1;
//                 }
//             }
//         }
//         return islands;
//     }

//     public void bfs(int row, int col, char[][] grid, HashSet<List<Integer>> visited){ //this function will basically traverse 
//     //all the neighouring '1's of particular '1' (land)
//         Queue<List<Integer>> queue = new ArrayDeque<>();
//         visited.add(new ArrayList<>(Arrays.asList(row, col)));
//         queue.offer(new ArrayList<>(Arrays.asList(row, col)));

//         while(!queue.isEmpty()){
//             List<Integer> tempList = queue.poll();
//             int tempRow = tempList.get(0);
//             int tempCol = tempList.get(1);

//             List<List<Integer>> directions = new ArrayList<>();
//             directions.add(Arrays.asList(1, 0)); //right
//             directions.add(Arrays.asList(-1, 0)); //left
//             directions.add(Arrays.asList(0, 1)); //up
//             directions.add(Arrays.asList(0, -1)); //down
            
//             for(List<Integer> direction : directions){
//                 int dr = direction.get(0);
//                 int dc = direction.get(1);
//                 int newRow = tempRow + dr;
//                 int newCol = tempCol + dc;

//                 //verifying that the newRow and newCol are a valid pair
//                 if(newRow >=0 && newRow < grid.length 
//                 && newCol >= 0 && newCol < grid[0].length 
//                 && grid[newRow][newCol] == '1'
//                 && !visited.contains(new ArrayList<>(Arrays.asList(newRow, newCol)))){
//                     queue.offer(new ArrayList<>(Arrays.asList(newRow, newCol)));
//                     visited.add(new ArrayList<>(Arrays.asList(newRow, newCol)));

//                 }


//             }
//         }


//     }


// }


///////////////////////////////////////////////////////////////////////////////////////

//intuition 2 (without hashset and queue): Updating the character in the grid to '2' to mark it as visited and use dfs to avoid
//using queue
// class Solution {
//     int[][] directions;
//     public int numIslands(char[][] grid){
//         directions = new int[][]{
//             {1, 0},
//             {-1, 0},
//             {0, 1},
//             {0, -1}
//         };

//         int islands = 0;

//         for(int row = 0; row < grid.length; row ++){
//             for(int col = 0; col < grid[0].length; col ++){
//                 if(grid[row][col] == '1'){
//                     islands += 1;
//                     dfs(grid, row, col);
//                 }
                
//             }
//         }        
//         // for(int row = 0; row < grid.length; row ++){
//         //     System.out.println(grid[row]);
//         // }

//         return islands;
//     }

//     public void dfs(char[][] grid, int row, int col){
//         if(row < 0 || row == grid.length || col < 0 || col == grid[0].length || grid[row][col] != '1'){
//             return;
//         }

//         grid[row][col] = '2'; //updating the character at (row, col) to '2' to mark it as visited
//         for(int[] direction : directions){ //traverse in each direction to find all neighbouring '1's (lands)
//             int newRow = row + direction[0];
//             int newCol = col + direction[1];

//             dfs(grid, newRow, newCol);
//         }
//         return;
//     }
}



















