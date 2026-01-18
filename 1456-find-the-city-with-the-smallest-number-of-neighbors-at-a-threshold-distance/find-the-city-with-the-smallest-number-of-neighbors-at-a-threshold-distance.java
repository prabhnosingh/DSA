class Solution {

    //Solving on 17 Jan 2026

    //intuition 1: Graphs: Dijkstra
        //Find neighboring cities from each city that have distance less than threshold
            //While computing distance of other cities from src city, if the distance
                //goes above threshold, stop and do not add that city in the neighbor
                //of the src city
        //At last see which city have minimum number of neighboring cities 
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<List<Integer>>[] adjList = new ArrayList[n];
        //initializing adjList
        for(int i = 0; i < n; i ++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];

            adjList[node1].add(new ArrayList<>(Arrays.asList(weight, node2)));
            adjList[node2].add(new ArrayList<>(Arrays.asList(weight, node1)));
        }   

        int[] neiCityCount = new int[n];

        for(int city = 0; city < n; city ++){
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[city] = 0;
            minHeap.offer(new int[]{0, city});

            while(minHeap.size() != 0 ){
                int[] currElement = minHeap.poll();
                int currEdgeWeight = currElement[0];
                int currNode = currElement[1];

                //Stale entry check: this could happen when the dist for currNode is already updated
                    //to a smaller value but there is a stale dated value for curr node in the 
                    //minHeap (currEdgeWeight) which is greater than the new value and hence will never
                    //lead to a valid entry to the minheap again, so we can skip it
                if(currEdgeWeight != dist[currNode]) continue;

                for(List<Integer> neiEdge : adjList[currNode]){
                    int neiEdgeWeight = neiEdge.get(0);
                    int neiNode = neiEdge.get(1);

                    // int newNeiDist = neiEdgeWeight + currEdgeWeight

                    if(dist[neiNode] > neiEdgeWeight + currEdgeWeight){
                        dist[neiNode] = neiEdgeWeight + currEdgeWeight;
                        if(dist[neiNode] >= distanceThreshold) continue;
                        minHeap.offer(new int[]{dist[neiNode], neiNode});
                    }
                } 
            }

            for(int i = 0; i < n; i ++){
                if(dist[i] <= distanceThreshold){
                    neiCityCount[city] += 1;
                }
            }
        }

        int minNeighbors = Integer.MAX_VALUE;
        int maxCity = 0;
        for(int i = 0; i < n; i ++){
            int currNeiCount = neiCityCount[i];

            if(minNeighbors > currNeiCount){
                minNeighbors = currNeiCount;
                maxCity = i;
            }
            else if(minNeighbors == currNeiCount){
                // maxCity = Math.max(maxCity, i);
                maxCity = i;
            }
        }

        return maxCity;

    }
}