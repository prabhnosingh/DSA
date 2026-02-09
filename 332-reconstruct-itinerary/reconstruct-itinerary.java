class Solution {
    //Solving on 08 Feb 2026

    //intuition 2 : Graphs : (Hierholzer / Eulerian path) DFS and backtracking 
        //Eulerian path is a path in a finite grapht that visits every edge exactly once,
            //allowing for the potential reuse of vertices.

        //We must use every ticket exactly once. Therefore, this makes this porblem an
            //edge-usage problem, not a "find any path" problem.
        
        //City = node
        //Ticket = directed edge (must be used once)

        //An itinerary that uses all tickets exactly once is an eulerian path

        //"Because we must use every ticket once, it's an Euler path problem; we keep
            //walking via smallest edges and only commit a city to the answer when it 
            //has no outgoing edges left"
        

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adjList = new HashMap<>();

        for(List<String> ticket : tickets){  
            String src = ticket.get(0);
            String dest = ticket.get(1);

            if(!adjList.containsKey(src)) adjList.put(src, new PriorityQueue<>());
            adjList.get(src).offer(dest);

        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", adjList, route);

        return route;
    }

    private void dfs(String currCity, HashMap<String, PriorityQueue<String>> adjList, 
    LinkedList<String> route){
        PriorityQueue<String> neiCities = adjList.get(currCity);

        while(neiCities != null && !neiCities.isEmpty()){
            String nextCity = neiCities.poll();
            dfs(nextCity, adjList, route);
        }

        route.addFirst(currCity);
    }

//////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 08 Feb 2026

    // //intuition 1 (TLE): Graphs : DFS and backtracking
    //     //We can construct an adjacency list from tickets. 
    //     //After that, we just need to run dfs starting from JFK
    //         //Make the dfs to return a boolean 
    //         //Base case is when itinerary.size() == tickets.size() + 1, return true
    //         //And if currCity does not exist as key in the adjList, return false
    //         //Make a templist while iterating over the neicities of currCity
    //         //remove the nextCity from the original list and add it to itinerary
    //         //if dfs returns false, that means that there is no solution along the previous
    //             //path traversed, so backtrack
    //         //while backtracking, remove the last added city from itinerary and add back the 
    //             //nextCity at the same index (to keep sorted) that was previously 
    //             //removed (before dfs) 
    //     //The main point is that we have to return the itinerary in lexical order
    //         //Sort the cities in adjacency list 
        

    // public List<String> findItinerary(List<List<String>> tickets) {
    //     HashMap<String, List<String>> adjList = new HashMap<>();
    //     HashSet<String> visited = new HashSet<>();
    //     List<String> itinerary = new ArrayList<>();

    //     for(List<String> ticket : tickets){
    //         String src = ticket.get(0);
    //         String dest = ticket.get(1);

    //         if(!adjList.containsKey(src)) adjList.put(src, new ArrayList<>());
    //         adjList.get(src).add(dest);
    //     }
    //     for(String src : adjList.keySet()){
    //         Collections.sort(adjList.get(src)); //sorting the values of all the keys
    //     }
        
    //     itinerary.add("JFK");
    //     dfs("JFK", adjList, itinerary, tickets);
    //     return itinerary;
    // }

    // private boolean dfs(String currCity, HashMap<String, List<String>> adjList, 
    // List<String> itinerary, List<List<String>> tickets){
        
    //     if(itinerary.size() == tickets.size() + 1){ //solution reached
    //         return true; 
    //     }
    //     if(!adjList.containsKey(currCity)) {
    //         return false;
    //     }
        
    //     List<String> list = adjList.get(currCity);
    //     List<String> tempList = new ArrayList<>(list); 
    //     for(int idx = 0; idx < tempList.size(); idx ++){
    //         String nextCity = tempList.get(idx);
    //         list.remove(nextCity); //removing the next city from the adjList to 
    //             //avoid duplicate traversals of the same edge in future
    //         itinerary.add(new String(nextCity));
                
    //         if(dfs(nextCity, adjList, itinerary, tickets)) return true;

    //         //backtrack
    //         list.add(idx, nextCity);
    //         itinerary.remove(itinerary.size() - 1);                
    //     }
    //     return false;
    //         // else{
    //             // System.out.println(currCity);
    //         // }
    // }
}