class Solution {
    //Solving on 06 Feb 2026

    //intuition 1: Graphs : DFS
        //The given list rooms is like an adjacency list
        //Have a visited boolean array of size n and run dfs
        //Start traversing from 0 and mark each visited node in a visited array
        //if a room is already visited then return 
        //at last check if all the rooms are visited
         
        //“Each key is a directed edge from current room to that room.” 

        //TC: O(n + k) : where n is no. of rooms and k is total number of keys. 
            //We visit each room and key once at max
        //SC: O(n) : max depth of recrusive stack (in case where there is a chain-like
            //reachability) + visited array
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