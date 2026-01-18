class Solution {

    //Solving on 17 Jan 2026

    //intuition 2: Graphs : Floyd warshall
        //Floyd warshall algo helps in finding the shortest distances between all the nodes in
            //a weighted graph
        
        //Fill adj list with the available edges
        //Have a dist matrix of size n x n that stores minimum distance of each node to each of
            //the other node. 
        //Then traverse dist matrix and for each city see how many cities are within the distanceThreshold


    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] adjMatrix = new int[n][n];
           
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(i != j) {
                    adjMatrix[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                adjMatrix[i][j] = 0;
            }
        }

        //filling adjList
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            int weight = edge[2];

           adjMatrix[node1][node2] = weight;
           adjMatrix[node2][node1] = weight;
        }

 

        for(int k = 0; k < n; k ++){
            for(int i = 0; i < n; i ++){
                for(int j = 0; j < n; j ++){
                    if(adjMatrix[i][k] == Integer.MAX_VALUE || adjMatrix[k][j] == Integer.MAX_VALUE) continue;
                    adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                }
            }
        }

        //finding city with minimum neighbor cities within distanceThreshold 
        int maxCity = 0;
        int minNeiCities = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++){
            int currNeiCities = 0;
            for(int j = 0; j < n; j ++){
                if(i != j && adjMatrix[i][j] <= distanceThreshold){
                    currNeiCities += 1;
                }
            }
            if(currNeiCities <= minNeiCities){
                minNeiCities = currNeiCities;
                maxCity = i;
            }
        }

        return maxCity;

        
    }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 17 Jan 2026

    // //intuition 1 (beats 15.07%): Graphs: Dijkstra
    //     //Find neighboring cities from each city that have distance less than threshold
    //         //While computing distance of other cities from src city, if the distance
    //             //goes above threshold, stop and do not add that city in the neighbor
    //             //of the src city
    //     //At last see which city have minimum number of neighboring cities 

    //  //TC: O(n * ((n+E) log n)) : Where n is number of nodes and E is number of edges
    //     //O((n+E) log n) is the TC of djikstra algo
    //  //SC: O(n + E)

    // public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
    //     List<List<Integer>>[] adjList = new ArrayList[n];
    //     //initializing adjList
    //     for(int i = 0; i < n; i ++){
    //         adjList[i] = new ArrayList<>();
    //     }
        
    //     for(int[] edge : edges){
    //         int node1 = edge[0];
    //         int node2 = edge[1];
    //         int weight = edge[2];

    //         adjList[node1].add(new ArrayList<>(Arrays.asList(weight, node2)));
    //         adjList[node2].add(new ArrayList<>(Arrays.asList(weight, node1)));
    //     }   

    //     int[] neiCityCount = new int[n];

    //     for(int city = 0; city < n; city ++){
    //         PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
    //         int[] dist = new int[n];
    //         Arrays.fill(dist, Integer.MAX_VALUE);
    //         dist[city] = 0;
    //         minHeap.offer(new int[]{0, city});

    //         while(minHeap.size() != 0 ){
    //             int[] currElement = minHeap.poll();
    //             int currEdgeWeight = currElement[0];
    //             int currNode = currElement[1];

    //             //Stale entry check: this could happen when the dist for currNode is already updated
    //                 //to a smaller value but there is a stale dated value for curr node in the 
    //                 //minHeap (currEdgeWeight) which is greater than the new value and hence will never
    //                 //lead to a valid entry to the minheap again, so we can skip it
    //             if(currEdgeWeight != dist[currNode]) continue;


    //             for(List<Integer> neiEdge : adjList[currNode]){
    //                 int neiEdgeWeight = neiEdge.get(0);
    //                 int neiNode = neiEdge.get(1);

    //                 int newNeiDist = neiEdgeWeight + currEdgeWeight;
                    
    //                 //do not explore once the threshold is reached
    //                 if(dist[neiNode] > newNeiDist && newNeiDist <= distanceThreshold){
    //                     dist[neiNode] = newNeiDist;
    //                     minHeap.offer(new int[]{dist[neiNode], neiNode});
    //                 }
    //             } 
    //         }

    //         for(int i = 0; i < n; i ++){
    //             if(i != city && dist[i] <= distanceThreshold){
    //                 neiCityCount[city] += 1;
    //             }
    //         }
    //     }

    //     int minNeighbors = Integer.MAX_VALUE;
    //     int maxCity = 0;
    //     for(int i = 0; i < n; i ++){
    //         int currNeiCount = neiCityCount[i];

    //         if(minNeighbors > currNeiCount){
    //             minNeighbors = currNeiCount;
    //             maxCity = i;
    //         }
    //         else if(minNeighbors == currNeiCount){
    //             // maxCity = Math.max(maxCity, i);
    //             maxCity = i;
    //         }
    //     }

    //     return maxCity;

    // }
}