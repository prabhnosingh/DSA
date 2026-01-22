
class DSU{
    int numOfNodes;
    int[] parent;
    int[] rank;
    DSU(int n){
        numOfNodes = n;
        parent = new int[n];
        rank = new int[n];
        //intializing parent with the node itself
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node){ //SC :O(log n) (because union by rank keeps tree height logarithmic)
        // if(parent[node] != node){ //TC: O(logn)
        //     return findUltimateParent(parent[node]);
        // }

        // return node;
        
        //path compression
        if(parent[node] != node){ //TC: alpha(n) => inverse Ackermann, almost constant
            parent[node] = findUltimateParent(parent[node]);
        }

        return parent[node];
    }

    public boolean unite(int node1, int node2){
        int parent1 = findUltimateParent(node1);
        int parent2 = findUltimateParent(node2);

        if(parent1 == parent2){
            return false; //the nodes are already united and have same parent
        }

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if(rank1 < rank2){
            parent[parent1] = parent2;
        }
        else if(rank1 > rank2){
            parent[parent2] = parent1;
        }
        else{ //when rank1 == rank2
            rank[parent1] += 1;
            parent[parent2] = parent1;
        }
        return true;
    }
    public int[] returnParent(){
        return parent;
    }
    public int[] returnRank(){
        return rank;
    }
}

class Solution {
    //Solving on 19 Jan 2026

    //intuition 2 (Optimization : beats %): Graphs: Graph Connected Componenets / DSU on Row-Column Connectivity
        //brute force will be to pick each stone and then remove it and see how many more 
            //stones we were able to remove
        
        //Graphs: Removing a stone means removing edges to the stones in the same row and same col
        //Build adjacency list and connect stones birectionally (undirected) from same row and same col
        //Then traverse over all stones 1 by 1 and track maximum stones removed

        //KEY IDEA: 
            //In each connected component (i.e. stones connected via row/col links), we can remove all
                //stones except 1 as our conidition of stone removal stays valid until there is atleast
                //1 stone in the component.
            //Therefore, the problem reduces to finding number of connected components. 
            //Most stones removed will be = total stones - connected components
        
        //We can use DSU (Disjoint Set Union) as the edges undirected
            //find ultimate parent function
            //parent array

        //How to build an adjancency list: 
            //How to determine the key -> take the first stone index in stones array as first stone and second
                //as second and so on
        
        //converting indices in a matrix to numbers
            //row x totalCols + col


        //Optimization:
            //Instead of running two loops and comparing all indices, have two hashMaps with keys of rows/cols
                //and values as index of stones. 
        
        //TC: O(n^2 log n) or (n^2 alpha(n)) => O(n^2) with path compression    
            //alpha = amortized
        //Sc: O(n)
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;

        //rows = stones.length
        int cols = 2;

        HashMap<Integer, Integer> rMap = new HashMap<>();
        HashMap<Integer, Integer> cMap = new HashMap<>();

        
        DSU dsu = new DSU(totalStones);
        int connectedComponents = totalStones; //max components possible (all disconnected)

        for(int i = 0; i < totalStones; i ++){
            int[] parStoneIdx = stones[i];
            int parStoneX = parStoneIdx[0];
            int parStoneY = parStoneIdx[1];

            if(rMap.containsKey(parStoneX)){
                if(dsu.unite(i, rMap.get(parStoneX)))connectedComponents -= 1;
            }
            else{
                rMap.put(parStoneX, i);
            }


            if(cMap.containsKey(parStoneY)){
                if(dsu.unite(i, cMap.get(parStoneY))) connectedComponents -= 1;
            }
            else{
                cMap.put(parStoneY, i);
            }

           
        }



        return totalStones - connectedComponents;
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////
// class Solution {
//     //Solving on 19 Jan 2026

//     //intuition 1 (beats 16.23% -> 49.49%): Graphs: Graph Connected Componenets / DSU on Row-Column Connectivity
//         //brute force will be to pick each stone and then remove it and see how many more 
//             //stones we were able to remove
        
//         //Graphs: Removing a stone means removing edges to the stones in the same row and same col
//         //Build adjacency list and connect stones birectionally (undirected) from same row and same col
//         //Then traverse over all stones 1 by 1 and track maximum stones removed

//         //KEY IDEA: 
//             //In each connected component (i.e. stones connected via row/col links), we can remove all
//                 //stones except 1 as our conidition of stone removal stays valid until there is atleast
//                 //1 stone in the component.
//             //Therefore, the problem reduces to finding number of connected components. 
//             //Most stones removed will be = total stones - connected components
        
//         //We can use DSU (Disjoint Set Union) as the edges undirected
//             //find ultimate parent function
//             //parent array

//         //How to build an adjancency list: 
//             //How to determine the key -> take the first stone index in stones array as first stone and second
//                 //as second and so on
        
//         //converting indices in a matrix to numbers
//             //row x totalCols + col
        
//         //TC: O(n^2 log n) or (n^2 alpha(n)) => O(n^2) with path compression    
//             //alpha = amortized
//         //Sc: O(n)
//     public int removeStones(int[][] stones) {
//         int totalStones = stones.length;

//         //rows = stones.length
//         int cols = 2;

//         //finding the connected components
//         //in DSU we need to pass the edges, therefore we don't need an adjList

//         //we don't need to compute the ids of each stone, just use i and j (indices
//         //in stones array)
        
//         DSU dsu = new DSU(totalStones);
//         int connectedComponents = totalStones; //max components possible (all disconnected)

//         for(int i = 0; i < totalStones; i ++){
//             int[] parStoneIdx = stones[i];
//             int parStoneX = parStoneIdx[0];
//             int parStoneY = parStoneIdx[1];

//             // int parStoneId = parStoneX * cols + parStoneY;
//             int parStoneId = i;

//             // for(int j = 0; j < totalStones; j ++){
//             for(int j = i + 1; j < totalStones; j ++){ //values less than i + 1 will anyways give dsu.unite
//                 // as false, as (if applicable) the dsu would have already proccessed them (beats 16.23% -> 49.49%)
//                 if(i == j) continue;
//                 int[] neiStoneIdx = stones[j];
//                 int neiStoneX = neiStoneIdx[0]; 
//                 int neiStoneY = neiStoneIdx[1];

//                 // int neiStoneId = neiStoneX * cols + neiStoneY;
//                 int neiStoneId = j;

//                 if(parStoneX == neiStoneX || parStoneY == neiStoneY){ //connected nodes
//                     if(dsu.unite(parStoneId, neiStoneId)){
//                         // System.out.println("node1 = " + parStoneId + " node2 = " + neiStoneId);
//                         connectedComponents -= 1;
//                     }
//                 }
//             }
//         }

//         // int[] parent = dsu.returnParent();
//         // HashSet<Integer> set = new HashSet<>();

//         // for(int i = 0; i < totalStones; i ++){
//         //     int ultParent = dsu.findUltimateParent(i);
//         //     // System.out.print(ultParent + " ") ;
//         //     // set.add(ultParent);
//         // }
//         // connectedComponents = set.size();

//         return totalStones - connectedComponents;
//     }
}