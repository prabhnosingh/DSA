class Solution {
    //Solving on 25 Jan 2026
    //intuition 1: Graphs : BFS
        //For a graph to be bipartite, there should two sets possible such that none of the nodes could
            //be grouped together with their neighbors. i.e. Any node in the graph cannot be in the same
            //set as neighbors.

        //Assing each node to two differnt sets, like odd(-1) or even(1)
        //Have a visited array that stores whether a node is already visited or not and if the node
            //is assigned to even set (marked as 1) or assigned to odd set (marked as -1)
        //Run a BFS traversal:
            //Starting from 0, assign 0 to even set, mark visited[0] as 1
            //Put 0's neighbors in a queue and assign the neighbors to odd set, mark visited[] as -1
            //At each iteration of BFS it is expected that the neighbor nodes are either not visited
                //or assigned to different set other than currNode's set. If not, return false
    public boolean isBipartite(int[][] graph) {
        
        int numOfNodes = graph.length;
        Queue<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[numOfNodes];
        Arrays.fill(visited, 0);
        
        for(int i = 0; i < numOfNodes; i ++){
            if(visited[i] != 0) continue;
            queue.offer(i);
            visited[i] = 1; //assigning 0 to even (1) set

            while(!queue.isEmpty()){
                int currNode = queue.poll();
                int currNodeSet = visited[currNode];

                for(int neiNode : graph[currNode]){
                    int neiNodeSet = visited[neiNode];
                    if(neiNodeSet == 0){ //if neiNode is not already visited
                        visited[neiNode] = currNodeSet * -1; //assigning neiNode to opposite set other than currNodeSet
                        queue.offer(neiNode);
                    }
                    else{ //if neiNode is already visited, we just check the neiNodeSet and do not add it 
                        //to the queue for further traversals
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