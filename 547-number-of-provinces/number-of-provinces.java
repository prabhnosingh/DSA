
class DSU{

    int numOfNodes;
    int[] parent;
    int[] rank;

    //constructor
    DSU(int n){
        numOfNodes = n;
        parent = new int[n];
        rank = new int[n];

        //intializing parent of each node with itself
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
        //we want rank of each node to initialzed to 0, this is by default in Java
    }


    public int findParent(int node){
        if(node != parent[node]){
            return findParent(parent[node]);
        }
        return node;
    }

    public boolean unite(int node1, int node2){
        int parent1 = findParent(node1);
        int parent2 = findParent(node2);
        
        if(parent1 == parent2){
            return false; //nodes are already under the same parent (already united)
        }

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];    

        if(rank1 > rank2){
            parent[parent2] = parent1;
        }
        else if(rank2 > rank1){
            parent[parent1] = parent2;
        }
        else{ //if rank1 == rank2
            rank[parent1] += 1;
            parent[parent2] = parent1;
        }
        return true;
    }


}





class Solution {
    //Solving on 14 Jan 2026
    //intuition 1: Graphs : DSU
        //We are given adjacency matrix, we can use it to extract edges
        //DSU logic:
            //have two arrays parent and rank 
            //parent tracks ulimate parent of each node (city)
            //rank tracks the rank of each city which helps in deciding the parent of 
                //nodes

    public int findCircleNum(int[][] isConnected) {
        int numOfNodes = isConnected.length;
        int provinces = numOfNodes; //max possible number of provinces are numOfNodes
            //assuming the scenario when all of cities are disconnected

        DSU dsu = new DSU(numOfNodes);

        //traversing the adjacency matrix to extract edges
        for(int i = 0; i < numOfNodes; i ++){
            for(int j = 0; j < numOfNodes; j ++){
                if(isConnected[i][j] == 1){ //only if i and j are connected
                    if(dsu.unite(i, j)){
                        provinces -= 1;
                    }
                }
            }
        }
        return provinces;
    }
}