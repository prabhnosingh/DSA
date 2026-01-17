
class DSU{
    int numOfNodes;
    int[] rank;
    int[] parent;

    DSU(int n){
        numOfNodes = n;
        rank = new int[n];
        parent = new int[n];

        //intializing parents of nodes with nodes themselves
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        } 
    }

    public int findParent(int node){
        if(node != parent[node]){
            return findParent(parent[node]);
        }

        return node;
    }

    public boolean unite(int node1, int node2){
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);

        if(parent1 == parent2){//means that node1 and node2 are already united under a single parent
            return false; 
        }

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if(rank1 > rank2){
            parent[parent2] = parent1;
        }
        else if(rank2 > rank1){
            parent[parent1] = parent2;
        }
        else{ //when rank1 = rank2
            rank[parent1] += 1;
            parent[parent2] = parent1;
        }
        return true;
    }

    public int[] returnParent(){
        return parent;
    }
}

class Solution {
    //Solving on 14, 15 Jan 2026

    //intuition 1: Graphs : DSU
        //The problem is to find maximum number of bombs in a single cluster
        //How to fetch edges: 
            //Have to make Adjacency matrix/list based on the radius of each bomb
            //Go with adjacency list
            //For each bomb b1 check if it falls under the radius of any other bomb b2, if yes then
                //there should be a directed edge between b2 -> b1.
            
            //How to know if a point lies inside a circle:
                //find the distance of the point from the center of the circle 
                    //and if the distance is less than equal to radius of the circle
                    //then the point lies on or inside the circle
            
        //After forming an adjList, we can use DSU to find the largest cluster by finding the maximum
            //number of nodes having same ultimate parent


        
        //DSU:
            //rank
                //initialized to 0
            //finding ultimate parent
            //storing parents in parent array
                //intialized to nodes themselves

        //DFS:
            //We can also run dfs on the adjList and find maximum nodes traversed in a single 
                //dfs run by adding 1 to the count for each valid dfs call
    public int maximumDetonation(int[][] bombs) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        int numOfBombs = bombs.length;
        for(int i = 0; i < numOfBombs; i ++){
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < numOfBombs; i ++){
            for(int j = 0; j < numOfBombs; j ++){
                if(i == j) continue;

                if(checkIfConnected(bombs, i, j)){ //if bombs are connected, form an edge in adjList
                    if(adjList.get(i).contains(j)) continue; //to avoid adding duplicate neighbors. But this
                        //is not efficient, find a better solution to this
                    adjList.get(i).add(j); //i -> j directed edge
                    // adjList.get(j).add(i);
                }

            }
        }

        // DSU dsu = new DSU(numOfBombs);
        // for(int i = 0; i < numOfBombs; i ++){
        //     for(int childNode : adjList.get(i)){
        //         dsu.unite(i, childNode);
        //     }
        // }


        // int[] parent = dsu.returnParent();
        // // HashSet<Integer>
        // int prevParent = -1;
        // int maxParentCount = 1;
        // int currParentCount = 1;
        // for(int p : parent){
        //     if(p == prevParent){
        //         currParentCount += 1;
        //         maxParentCount = Math.max(maxParentCount, currParentCount);
        //     }
        //     else{
        //         prevParent = p;
        //         currParentCount = 1; 
        //     }
        // }

        // return maxParentCount;   

        // //printing adjList
        // for(int i = 0; i < numOfBombs; i ++){
        //     System.out.print(i + " -> ");
        //     for(int childBomb : adjList.get(i)){
        //         System.out.print(childBomb + " ");
        //     }
        //     System.out.println();
        // }

        int maxCluster = 1;
        for(int i = 0; i < numOfBombs; i ++){
            boolean[] visited = new boolean[numOfBombs];
            if(visited[i]) continue;
            visited[i] = true;
            maxCluster = Math.max(maxCluster, dfs(i, adjList, visited));
        }
        return maxCluster;

    }

    private boolean checkIfConnected(int[][] bombs, int b1, int b2){
        int[] bomb1 = bombs[b1];
        int[] bomb2 = bombs[b2];

        //considering long instead of int to avoid overflow conditions
        long x1 = bomb1[0];
        long y1 = bomb1[1];
        long r1 = bomb1[2];

        long x2 = bomb2[0];
        long y2 = bomb2[1];
        long r2 = bomb2[2];

        //if distBetweenBombs is less than equal to either of the bomb's radius, then they are connected
        double distBetweenBombs = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));

        // if(distBetweenBombs <= r1 || distBetweenBombs <= r2){
        if(distBetweenBombs <= r1){
            return true;
        }
        return false;
    }

    private int dfs(int bomb, HashMap<Integer, List<Integer>> adjList, boolean[] visited){
        int nodesTraversed = 0;
        for(int childBomb : adjList.get(bomb)){
            if(!visited[childBomb]){
                visited[childBomb] = true;
                nodesTraversed += dfs(childBomb, adjList, visited);
            }
        }
        return 1 + nodesTraversed;
    }
}