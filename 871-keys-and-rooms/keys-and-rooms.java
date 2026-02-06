class Solution {
    //Solving on 06 Feb 2026

    //intuition 1: Graphs : DFS
        //The given list rooms is like an adjacency list
        //Have a visited boolean array of size n and run dfs
        //Start traversing from 0 and mark each visited node in a visited array
        //if a room is already visited then return 
        //at last check if all the rooms are visited
         

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int numOfRooms = rooms.size();
        boolean[] visited = new boolean[numOfRooms];

        visited[0] = true;
        dfs(0, visited, rooms); 

        for(boolean room : visited){
            if(room == false) return false; 
        }
        return true;
    }

    private void dfs(int room, boolean[] visited, List<List<Integer>> rooms){
        
        for(int neiRoom : rooms.get(room)){
            if(!visited[neiRoom]){ //if neiRoom is not visited 
                visited[neiRoom] = true;
                dfs(neiRoom, visited, rooms);
            }
        }
    }
}