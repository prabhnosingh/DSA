class DSU{
    int numOfNodes;
    int[] parent;
    int[] rank;

    DSU(int n){
        numOfNodes = n;
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node){
        if(node != parent[node]){
            parent[node] = findUltimateParent(parent[node]);
        }

        return parent[node];
    }

    public boolean unite(int node1, int node2){
        int parent1 = findUltimateParent(node1);
        int parent2 = findUltimateParent(node2);

        if(parent1 == parent2){
            return false;
        }

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if(rank1 > rank2){
            parent[parent2] = parent1;
        }
        else if(rank2 > rank1){
            parent[parent1] = parent2;
        }
        else{ //when rank1 == rank2
            rank[parent1] += 1;
            parent[parent2] = parent1;
        }
        return true;
    }
}


class Solution {
    //Solving on 22 Jan 2026: 

    //intuition 1: Graphs : DSU
        //The problem seems to be finding number of cycles.
        //The number of edges needs to be alteat n-1 for all computers to be connected
            //if total edges < n-1 return -1

        //minimum operations needed is the number of connected components - 1

        //DSU
    public int makeConnected(int n, int[][] connections) {
        int totalConnections = connections.length;
        
        if(totalConnections < n-1) return -1;

        int connectedComponents = n;

        DSU dsu = new DSU(n);

        for(int i = 0; i < totalConnections; i ++){
            int[] connection = connections[i];
            int c1 = connection[0];
            int c2 = connection[1];

            if(dsu.unite(c1, c2)){
                // System.out.println(c1 + " " + c2);
                connectedComponents -= 1;
            }
        }

        return connectedComponents - 1;
    }
}