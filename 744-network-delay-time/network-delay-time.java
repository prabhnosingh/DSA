class Solution {
    //Solving on 17 Jan 2026

    //intuition 1: Graphs:
        //The question is about finding the max distance from source node to any other node.
        //As the node with the max distance will be the last one to receive the signal and 
            //by then all of the other nodes would have received the signals  

        //Apply djikstra algo and fill the dist array with smallest distances from source to
            //all other nodes. The max distance is our answer.
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<Integer>>[] adjList = new ArrayList[n + 1];

        //intializing adjList 
        for(int i = 0; i < n + 1; i ++){
            adjList[i] = new ArrayList<>();
        }

        //filling adjList
        for(int[] edge : times){
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];

            adjList[node1].add(new ArrayList<>(Arrays.asList(weight, node2)));
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        minHeap.offer(new int[]{0, k});
        dist[k] = 0;

        boolean[] nodesReached = new boolean[n + 1];
        nodesReached[k] = true;
        while(minHeap.size() != 0){
            int[] currElement = minHeap.poll();

            int currNodeWeight = currElement[0];
            int currNode = currElement[1];

            //avoiding traversing stale currNode weight
            if(dist[currNode] != currNodeWeight) continue;

            for(List<Integer> neiEdge : adjList[currNode]){
                int neiEdgeWeight = neiEdge.get(0);
                int neiNode = neiEdge.get(1);

                nodesReached[neiNode] = true;

                int newNeiEdgeWeight = currNodeWeight + neiEdgeWeight;
                if(dist[neiNode] > newNeiEdgeWeight){
                    dist[neiNode] = newNeiEdgeWeight;
                    minHeap.offer(new int[]{newNeiEdgeWeight, neiNode});
                }
            }
        }

        int maxDist = 0;
        // System.out.println(nodesReached[4]);
        boolean allNodesReached = true;
        for(int i = 1; i < n + 1; i ++){
            // allNodesReached = allNodesReached && nodesReached[i];
            if(dist[i] == Integer.MAX_VALUE) return -1;
            maxDist = Math.max(maxDist, dist[i]);

        }

        // System.out.println(allNodesReached);
        // return allNodesReached ? maxDist : -1;
        return maxDist;

    }   
}