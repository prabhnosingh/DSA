class Solution {
    //Solving on 11 Feb 2026

    //intuition 1: Graphs : Prims
        //We need to find minimum cost spanning tree. 
        //Prims algo will be used in this.
            //Have a priority queue (minheap) that stores the edge weights.
            //Initialize minheap with any node's connecting edges.
            //Also maintain a visited array to avoid visiting same node multiple times
            //Pop from minheap and if one of the node is not visited, then add the
                //edge weight to the MST weight.
        
        //Before applying prim's algo, construct an adjacency list
            //Each point will have an edge with another point.
            //Adjacency list should be like x, y, z where x and y are points and z is 
                //the distance between them
            //We can use index of each point in points array to map them together
            //Use a hashmap
    public int minCostConnectPoints(int[][] points) {
        
        if(points.length == 1) return 0;

        HashMap<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i = 0; i < points.length; i ++){
            for(int j = 0; j < points.length; j ++){
                if(i == j) continue;
                if(!adjList.containsKey(i)) adjList.put(i, new ArrayList<>());
                int x1 = points[i][0];
                int y1 = points[i][1];
                
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adjList.get(i).add(new int[] {dist, j});
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        for(int[] edge : adjList.get(0)){ //adjList contains a list of int[]
            minHeap.offer(edge);
        }

        int minCost = 0;
        boolean[] visited = new boolean[points.length];
        visited[0] = true;

        while(!minHeap.isEmpty()){
            int[] currEdge = minHeap.poll();
            int currNode = currEdge[1];
            int currWeight = currEdge[0];
            if(visited[currNode]) continue; //skipping the iteration if the currNode is
                //already visited

            visited[currNode] = true; //marking current node as visited
            minCost += currWeight;

            for(int[] edge : adjList.get(currNode)){
                minHeap.offer(edge);
            }
        }

        return minCost;
    }
} 