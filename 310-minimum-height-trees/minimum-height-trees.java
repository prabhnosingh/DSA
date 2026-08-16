class Solution {

    //Solving on 15 Aug 2026
    

    //intuition 2: 
        //Topic: Graph
        //Pattern: Topological sort
        //Sub-pattern: Tree Center / Leaf Trimming

        //for a root to have minimum height it needs to be in middle of all the nodes
        //now at most 2 nodes can be in the middle of the tree because he input forms
            //a tree (connected + acyclic), and every tree has either one center or 
            //two adjacent centers.

        //the problem boils down to finding these middle nodes
        //we can find these nodes by trimming the leaf nodes
            //leaf nodes will be the nodes that will have in-degree 1
        
        //build a two-way adjlist as the graph is undirected
        //store inDegree of each node in a array
        //have a queue and store all the in-degree 1 nodes to the queue
        //poll the nodes and reduce the in-degree of there adjacent nodes
        //enqueue adjacent nodes if there in-degree becomes 1 
        //perform this until the remaining nodes are greater than 2

        //at last either we will have 1 node in the queue or 2 nodes in the queue
        //return these node(s)

        //TC: O(V+E) for BFS +
            //O(E) for building adjList +
            //O(V) for enqueuing

        //SC: O(V+E) for adjList +
            //O(V) for inDegree +
            //O(V) for queue



    //intuition 1: Graph : DFS
        //the input is guaranteed to not have a cycle in the graph

        //run dfs traversal on all the nodes from 0 to n-1
        //build a two way adjList 
        //have a heights array that will indicate heights[i] as height of 
            //a tree if i was the root

        //TC: one DFS O(V + E) and we run the DFS for every node (V nodes) => O(V(V + E))
            //and since this is a tree, so E = V-1. Therefore, O(VxV) = O(V^2) 
    // public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        
    //     int[] inDegree = new int[n];
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     HashMap<Integer, List<Integer>> adjList = new HashMap<>();
    //     List<Integer> MHTList = new ArrayList<>();

    //     if(edges.length == 0) {
    //         MHTList.add(0);
    //         return MHTList;
    //     }

    //     //building adjList and inDegree
    //     for(int[] edge : edges){
    //         int u = edge[0];
    //         int v = edge[1];

    //         if(!adjList.containsKey(u)) adjList.put(u, new ArrayList<>());
    //         adjList.get(u).add(v);
    //         inDegree[v] += 1;

    //         if(!adjList.containsKey(v)) adjList.put(v, new ArrayList<>());
    //         adjList.get(v).add(u);
    //         inDegree[u] += 1;
    //     }

    //     //filling queue with inDegree 1 nodes (leaf nodes)
    //     for(int i = 0; i < n; i ++){
    //         if(inDegree[i] == 1) queue.offer(i);
    //     }

    //     while(n > 2){ //until remaining nodes are more than 2 
    //         int currQueueSize = queue.size();

    //         for(int i = 0; i < currQueueSize; i ++){
    //             int currNode = queue.poll();
    //             n -= 1;
    //             if(!adjList.containsKey(currNode)) continue;

    //             for(int connectingNode : adjList.get(currNode)){
    //                 if(inDegree[connectingNode] == 0) continue; //indicates that connecting node
    //                     //has already been processed as a leaf node


    //                 //we don't need to actually remove the edge, we can use inDegree here
    //                 //The standard leaf-trimming solution never needs to physically remove  
    //                     //adjacency-list entries.

    //                 //removing the edge using inDegree
    //                 inDegree[currNode] -= 1; 
    //                 inDegree[connectingNode] -= 1;
                    
    //                 if(inDegree[connectingNode] == 1) queue.offer(connectingNode);
    //             }
    //         }
    //         // for(int i = 0; i < currQueueSize; i ++){
    //         //     int currNode = queue.poll();
    //         //     n -= 1;
    //         //     if(!adjList.containsKey(currNode)) continue;

    //         //     //currNode only have 1 connecting node, we remove that edge 
    //         //     int connectingNode = adjList.get(currNode).get(0);

    //         //     adjList.get(connectingNode).remove(Integer.valueOf(currNode));
    //         //     inDegree[connectingNode] -= 1;

    //         //     adjList.remove(currNode); //removes the currNode from the adjList
                
    //         //     if(inDegree[connectingNode] == 1) queue.offer(connectingNode);
    //         // }

    //     }

    //     if(queue.size() == 2){
    //         MHTList.add(queue.poll());
    //         MHTList.add(queue.poll());
    //     }
    //     else{
    //         MHTList.add(queue.poll());
    //     }
    //     return MHTList;

    // }




/////////////////////////////////////////////////////////////////////////////////////////////////
    //intuition 2: 
        //Topic: Graph
        //Pattern: Topological sort
        //Sub-pattern: Tree Center / Leaf Trimming

        //for a root to have minimum height it needs to be in middle of all the nodes
        //now at most 2 nodes can be in the middle of the tree because he input forms
            //a tree (connected + acyclic), and every tree has either one center or 
            //two adjacent centers.

        //the problem boils down to finding these middle nodes
        //we can find these nodes by trimming the leaf nodes
            //leaf nodes will be the nodes that will have in-degree 1
        
        //build a two-way adjlist as the graph is undirected
        //store inDegree of each node in a array
        //have a queue and store all the in-degree 1 nodes to the queue
        //poll the nodes and reduce the in-degree of there adjacent nodes
        //enqueue adjacent nodes if there in-degree becomes 1 
        //perform this until the remaining nodes are greater than 2

        //at last either we will have 1 node in the queue or 2 nodes in the queue
        //return these node(s)

        //TC: O(V+E) for BFS +
            //O(E) for building adjList +
            //O(V) for enqueuing

        //SC: O(V+E) for adjList +
            //O(V) for inDegree +
            //O(V) for queue



    //intuition 1: Graph : DFS
        //the input is guaranteed to not have a cycle in the graph

        //run dfs traversal on all the nodes from 0 to n-1
        //build a two way adjList 
        //have a heights array that will indicate heights[i] as height of 
            //a tree if i was the root

        //TC: one DFS O(V + E) and we run the DFS for every node (V nodes) => O(V(V + E))
            //and since this is a tree, so E = V-1. Therefore, O(VxV) = O(V^2) 
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        
        int[] inDegree = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> MHTList = new ArrayList<>();

        if(edges.length == 0) {
            MHTList.add(0);
            return MHTList;
        }

        //building adjList and inDegree
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!adjList.containsKey(u)) adjList.put(u, new ArrayList<>());
            adjList.get(u).add(v);
            inDegree[v] += 1;

            if(!adjList.containsKey(v)) adjList.put(v, new ArrayList<>());
            adjList.get(v).add(u);
            inDegree[u] += 1;
        }

        //filling queue with inDegree 1 nodes (leaf nodes)
        for(int i = 0; i < n; i ++){
            if(inDegree[i] == 1) queue.offer(i);
        }

        while(n > 2){ //until remaining nodes are more than 2 
            int currQueueSize = queue.size();

            for(int i = 0; i < currQueueSize; i ++){
                int currNode = queue.poll();
                n -= 1;
                if(!adjList.containsKey(currNode)) continue;

                //currNode only have 1 connecting node, we remove that edge 
                int connectingNode = adjList.get(currNode).get(0);

                adjList.get(connectingNode).remove(Integer.valueOf(currNode));
                inDegree[connectingNode] -= 1;

                adjList.remove(currNode); //removes the currNode from the adjList
                
                if(inDegree[connectingNode] == 1) queue.offer(connectingNode);
                }
            }
            


        if(queue.size() == 2){
            MHTList.add(queue.poll());
            MHTList.add(queue.poll());
        }
        else{
            MHTList.add(queue.poll());
        }
        return MHTList;

    }
}