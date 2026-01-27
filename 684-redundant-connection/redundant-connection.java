class DSU{
    int[] parent;
    int[] rank;

    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
    }   

    protected int findUltimateParent(int node){
        if(parent[node] != node){
            parent[node] = findUltimateParent(parent[node]);
        }
        return parent[node];
    }

    protected boolean unite(int node1, int node2){
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
        else{
            rank[parent1] += 1;
            parent[parent2] = parent1;
        }
        return true;
    }


}


class Solution {
    //Re-solving on 27 Jan 2026

    //intuition 1: DSU
        //Unite all the nodes as per normal dsu
        //When dsu.unite returns false (i.e the edge is already united), a cycle is detected
        //Store the edge that returned false in an Arraylist and return the last element 
    public int[] findRedundantConnection(int[][] edges) {
        
        List<int[]> redundantEdges = new ArrayList<>();

        int numOfNodes = edges.length + 1;
        DSU dsu = new DSU(numOfNodes);

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            if(!dsu.unite(node1, node2)){
                return edge;
                // redundantEdges.add(edge);
            }
        }

        return redundantEdges.get(redundantEdges.size() - 1);


    }































///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//     //intuition 1: We do not need to worry about the disconnected graph here. Focus on the edge that results in cycle. 
//     //traverse over the graph using DFS and when a cycle is detected, store that redundant edge.
//     //for "multiple answers return the answer that occurs last", store all redundant edges in a hashSet and then traverse edges from 
//     //last to see if any edge is present in the hashSet, check both sorted and unsorted edges.
    
//     // boolean[] visited;
//     // List<Integer>[] adjList;
//     // // List<List<Integer>> redList;
//     // HashSet<List<Integer>> redSet;
//     // public int[] findRedundantConnection(int[][] edges) {
//     //     int nodes = edges.length;
//     //     visited = new boolean[nodes + 1];
//     //     adjList = new ArrayList[nodes + 1];
//     //     // redList = new ArrayList<>();
//     //     redSet = new HashSet<>();

//     //     for(int i = 1; i <= nodes; i ++){ //initializing the adjacency list
//     //         adjList[i] = new ArrayList<>();
//     //     }

//     //     for(int[] edge : edges){
//     //         int node1 = edge[0];
//     //         int node2 = edge[1];

//     //         adjList[node1].add(node2);
//     //         adjList[node2].add(node1); //for undirected edges
//     //     }

//     //     for(int node = 1; node < nodes; node ++){ //running dfs through all nodes to find all redundant nodes

//     //         dfs(node, -1); //passing -1 as prevNode
//     //         visited = new boolean[nodes + 1];
//     //     }

//     //     // if(redList.size() > 1){}
//     //     // System.out.println(redList.get(0));
//     //     // return redList.get(0).stream()
//     //     //            .mapToInt(Integer::intValue)
//     //     //            .toArray(); //converting list to array of int[]

//     //     // System.out.println(redSet);
//     //     if(redSet.size() == 1){
//     //         for(List<Integer> list : redSet){
//     //             return new int[]{list.get(0), list.get(1)};
//     //         }
//     //     }
//     //     for(int i = nodes - 1; i >= 0; i --){
//     //         // System.out.println(edges[i]);
//     //         if(redSet.contains(Arrays.asList(edges[i][0], edges[i][1]))){
//     //             return edges[i];
//     //         }
//     //         Arrays.sort(edges[i]);
//     //         if(redSet.contains(Arrays.asList(edges[i][0], edges[i][1]))){
//     //             return edges[i];
//     //         }
//     //     }
//     //     return new int[2];
//     // }

//     // public void dfs(int node, int prevNode){
        
//     //     if(visited[node]){ //cycle detected
//     //         // redList.add(new ArrayList<>(Arrays.asList(node, prevNode))); //redundant edge here is "node <-> prevNode"
//     //         redSet.add(new ArrayList<>(Arrays.asList(node, prevNode))); //redundant edge here is "node <-> prevNode"
//     //         return;
//     //     }

//     //     visited[node] = true;
//     //     for(int neighborNode : adjList[node]){
//     //         if(neighborNode == prevNode) continue; //when the immediate child tries to traverse its immediate parent
//     //         dfs(neighborNode, node);
//     //     }

//     //     return;
//     // }

//     // intuition 2: use Union to improve time compelxity
//     public int[] findRedundantConnection(int[][] edges) {

// }
}


