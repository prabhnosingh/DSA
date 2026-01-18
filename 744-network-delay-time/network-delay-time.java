class Solution {
    //Solving on 17 Jan 2026

    //intuition 1: Graphs:
        //The question is about finding the max distance from source node to any other node.
        //As the node with the max distance will be the last one to receive the signal and 
            //by then all of the other nodes would have received the signals  

        //Apply djikstra algo and fill the dist array with smallest distances from source to
            //all other nodes. The max distance is our answer.
    
        //TC: O((V+E)logV)
        //SC: O(V+E) : adjList O(V) + minHeap O(E)
        //in worst case E can be equal to V^2
        
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // List<List<Integer>>[] adjList = new ArrayList[n + 1];
        List<int[]>[] adjList = new ArrayList[n + 1];

        //intializing adjList 
        for(int i = 0; i < n + 1; i ++){
            adjList[i] = new ArrayList<>();
        }

        //filling adjList
        for(int[] edge : times){
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];

            adjList[node1].add(new int[]{weight, node2});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        minHeap.offer(new int[]{0, k});
        dist[k] = 0;    

        //this does not make any differece in time complexity
        // boolean[] finalized = new boolean[n+1];
        // int finalizedCount = 0;

        while(minHeap.size() != 0){
            int[] currElement = minHeap.poll();

            int currNodeWeight = currElement[0];
            int currNode = currElement[1];

            //avoiding traversing stale currNode weight
            if(dist[currNode] != currNodeWeight) continue;

            //In djikstra a node is finalized with its distance only when it is polled from minHeap
                //with its shortest distance (i.e. dist[node] == polledDistance) 
            // if(finalized[currNode]) continue;
            // finalized[currNode] = true;
            // finalizedCount += 1;

            // if(finalizedCount == n) break;

            for(int[] neiEdge : adjList[currNode]){
                int neiEdgeWeight = neiEdge[0];
                int neiNode = neiEdge[1];


                int newNeiEdgeWeight = currNodeWeight + neiEdgeWeight;
                if(dist[neiNode] > newNeiEdgeWeight){
                    dist[neiNode] = newNeiEdgeWeight;
                    minHeap.offer(new int[]{newNeiEdgeWeight, neiNode});
                }
            }
        }

        int maxDist = 0;
        for(int i = 1; i < n + 1; i ++){
            if(dist[i] == Integer.MAX_VALUE) return -1; //if any node has an infinity distance, that means
                //this node can not be reached by the source node and hence the signal can also not 
                //reach this node.
            maxDist = Math.max(maxDist, dist[i]);

        }


        return maxDist;

    }   
}