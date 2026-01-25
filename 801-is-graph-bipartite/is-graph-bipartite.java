class Solution {
    //Solving on 25 Jan 2026
    //intuition 1: Graphs : BFS coloring
        //For a graph to be bipartite, there should two sets possible such that none of the nodes could
            //be grouped together with their neighbors. i.e. Any node in the graph cannot be in the same
            //set as neighbors.

        //Assign each node to two different sets, like odd(-1) or even(1)
        //Have a visited array that stores whether a node is already visited or not and if the node
            //is assigned to even set (marked as 1) or assigned to odd set (marked as -1)
        //Run a BFS traversal:
            //Starting from each unvisited node i, assign i to even set, mark visited[i] as 1
            //Put 0's neighbors in a queue and assign the neighbors to odd set, mark visited[] as -1
            //At each iteration of BFS it is expected that the neighbor nodes are either not visited
                //or assigned to different set other than currNode's set. If not, return false

        //"A graph is bipartite if we can 2-color it so every edge connects nodes of opposite colors.
        // Use color[]: 0 = uncolored, 1 and -1 are the two sets.
        // For each uncolored node (graph may be disconnected), BFS and assign opposite color to neighbors.
        // If we ever see an edge where both endpoints have the same color -> not bipartite."

        //TC: O(E + V) :
            //Because each edge is enqueued at most once
            //And each edge is processed at most twice (undirected) / once per adjacency entry
        //SC: O(V) : Queue + visited size
    public boolean isBipartite(int[][] graph) {
        
        int numOfNodes = graph.length;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[numOfNodes];
        // Arrays.fill(visited, 0);
        
        //running explicit for loop as it is mentioned that the graph can be disconnected graph as well
        for(int i = 0; i < numOfNodes; i ++){
            if(visited[i] != 0) continue; //if the node i is already visited
            queue.offer(i);
            visited[i] = 1; //assigning node i to even (1) set

            while(!queue.isEmpty()){
                int currNode = queue.poll();
                int currNodeSet = visited[currNode];

                for(int neiNode : graph[currNode]){
                    int neiNodeSet = visited[neiNode];
                    if(neiNodeSet == 0){ //if neiNode is not already visited
                        visited[neiNode] = currNodeSet * -1; //assigning neiNode to opposite set other than currNodeSet
                        queue.offer(neiNode);
                    }
                    else{ //if neiNode is already visited, we just compare the neiNodeSet and currNodeSet and do 
                        //not add it to the queue for further traversals
                        if(neiNodeSet == currNodeSet){ //in case both currNode and neiNode have same set
                            return false;
                        }
                    }
                    
                }
            }
        }

        return true;
    }
}