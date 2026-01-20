
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

    private int findUltimateParent(int node){
        if(parent[node] != node){
            return findUltimateParent(parent[node]);
        }

        return node;
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
}

class Solution {
    //Solving on 19 Jan 2026

    //intuition 1: Graphs: Graph Connected Componenets / DSU on Row-Column Connectivity
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
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;

        //rows = stones.length
        int cols = 2;

        //finding the connected components
        //in DSU we need to pass the edges, therefore we don't need an adjList

        //we don't need to compute the ids of each stone, just use i and j (indices
        //in stones array)
        
        DSU dsu = new DSU(totalStones);
        int connectedComponents = totalStones; //max components possible (all disconnected)

        for(int i = 0; i < totalStones; i ++){
            int[] parStoneIdx = stones[i];
            int parStoneX = parStoneIdx[0];
            int parStoneY = parStoneIdx[1];

            // int parStoneId = parStoneX * cols + parStoneY;
            int parStoneId = i;

            for(int j = 0; j < totalStones; j ++){
                if(i == j) continue;
                int[] neiStoneIdx = stones[j];
                int neiStoneX = neiStoneIdx[0]; 
                int neiStoneY = neiStoneIdx[1];

                // int neiStoneId = neiStoneX * cols + neiStoneY;
                int neiStoneId = j;

                if(parStoneX == neiStoneX || parStoneY == neiStoneY){ //connected nodes
                    if(dsu.unite(parStoneId, neiStoneId)){
                        connectedComponents -= 1;
                    }
                }
            }
        }

        int[] parent = dsu.returnParent();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < totalStones; i ++){
            System.out.print(parent[i] + " ") ;
            set.add(parent[i]);
        }
        // connectedComponents = set.size();
        System.out.println("totalStones = " + totalStones);
        System.out.println("connectedComponents = " + connectedComponents);

        return totalStones - connectedComponents;
    }
}