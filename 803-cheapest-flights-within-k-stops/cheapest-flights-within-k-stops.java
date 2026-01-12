class Solution {
    //Solving on 11 Jan 2026
    
    //intuition 1: Graph : Dijkstra with state pattern
        //Run Dijkstra algorithm from src to all other nodes. 
        //Every time a dst node is encountered, save its cost along with the 
            //number of stops(nodes in between) in a hashmap

        //Use a 2D cost array to track the cost to reach a city + stops 
            //cost[i][j] represents cost to reach city i from src with j stops


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        int[][] costArr = new int[n][k + 1];

        HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
        //filling adjacency list with flights 
        for(int[] flight : flights){
            int city1 = flight[0];
            int city2 = flight[1];
            int cost = flight[2];
            if(!adjList.containsKey(city1)) adjList.put(city1, new ArrayList<>());
            adjList.get(city1).add(new ArrayList<>(Arrays.asList(cost, city2)));
        }

        //tracks the cheapest price within k stops
        int cheapestPrice = Integer.MAX_VALUE;

        //currStops tracks number of stops
        int currStops = 0;


        //filling cost array with max value
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < k + 1; j ++){
                costArr[i][j] =  Integer.MAX_VALUE;

            }
        }

        costArr[src][0] = 0; //cost of src from src is 0

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        minHeap.offer(new int[]{0, src, currStops});

        while(!minHeap.isEmpty()){
            int[] currElement = minHeap.poll();
            int currCityCost = currElement[0];
            int currCity = currElement[1];
            int currCityStops = currElement[2];

            if(currCityStops > k) continue;

            if(!adjList.containsKey(currCity)) continue;
            for(List<Integer> neiCon : adjList.get(currCity)){
                int neiCost = neiCon.get(0);
                int neiCity = neiCon.get(1);

                if(costArr[neiCity][currCityStops] > neiCost + currCityCost){
                    costArr[neiCity][currCityStops] = neiCost + currCityCost;
                    // System.out.println("city- " + neiCity + " stops- " + currCityStops + " = " + 
                    // costArr[neiCity][currCityStops]);
                    minHeap.offer(new int[]{neiCost + currCityCost, neiCity, currCityStops + 1});
                }
            }
        }

        for(int i = 0; i < k + 1; i ++){
            cheapestPrice = Math.min(cheapestPrice, costArr[dst][i]);
        }

        return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
       




















    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 11 Jan 2026
    
    //DID NOT WORK FOR ALL TEST CASES

    // //intuition 1: Graph : Dijkstra algorithm
    //     //Run Dijkstra algorithm from src to all other nodes. 
    //     //Every time a dst node is encountered, save its cost along with the 
    //         //number of stops(nodes in between) in a hashmap
    //     //finally run for loop over the values of hashMap and choose the minimum cost
    //         //with atmost k stops


    // public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


    //     int[] costArr = new int[n];

    //     HashMap<Integer, List<List<Integer>>> adjList = new HashMap<>();
    //     //filling adjacency list with flights 
    //     for(int[] flight : flights){
    //         int city1 = flight[0];
    //         int city2 = flight[1];
    //         int cost = flight[2];
    //         if(!adjList.containsKey(city1)) adjList.put(city1, new ArrayList<>());
    //         adjList.get(city1).add(new ArrayList<>(Arrays.asList(cost, city2)));
    //     }

    //     //tracks the cheapest price within k stops
    //     int cheapestPrice = Integer.MAX_VALUE;

    //     //currLevel tracks number of stops
    //     int currLevel = 0;


    //     //filling cost array with max value
    //     for(int i = 0; i < n; i ++){
    //         costArr[i] =  Integer.MAX_VALUE;
    //     }

    //     costArr[src] = 0; //cost of src from src is 0

    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
    //     minHeap.offer(new int[]{0, src, currLevel});

    //     while(!minHeap.isEmpty()){
    //         int[] currElement = minHeap.poll();
            
    //         int currCityCost = currElement[0];
    //         int currCity = currElement[1];
    //         int currCityLevel = currElement[2];
    //         if(currCityLevel > k) continue; //continue if currCityLevel (i.e. stops) is greater than k

    //         // if(costArr[currCity] < currCityCost) continue; //outdated currCost of currCity, i.e. a 
    //             //smaller cost is available from source to currCity in the cost array 
    //         //The above statement needs to be excluded, as there
            

    //         // if(adjList.get(currCity) == null) continue; //skipp when currCity does not exist in adjList
    //         if(!adjList.containsKey(currCity)) continue; //skip when currCity does not exist in adjList
    //         for(List<Integer> neiCon : adjList.get(currCity)){
    //             int neiCost = neiCon.get(0);
    //             int neiCity = neiCon.get(1);
                
    //             if(costArr[neiCity] > neiCost + currCityCost){
    //                 if(currCityLevel == k && neiCity != dst) continue;

    //                 costArr[neiCity] = neiCost + currCityCost;
    //                 if(neiCity == dst){
    //                     cheapestPrice = Math.min(cheapestPrice, costArr[neiCity]);
    //                 }
    //                 minHeap.offer(new int[]{costArr[neiCity], neiCity, currCityLevel + 1});
    //             }
    //         }

    //     }

    //     return cheapestPrice == Integer.MAX_VALUE ? -1 : cheapestPrice;
    // }
}