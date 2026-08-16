class Solution {

    //Solving on 16 Aug 2026

    //intuition 2 (no need to find the root of the tree):
        //Topic: Graph
        //Pattern: Tree Prunning
        //Sub-Pattern: BFS + Leaf trimming
        

        //To optimize the path for collecting all the coins we don't need to traverse
            //the leafs that do not have any coins. So we can prune them
        
        //After prunning all unnecessary nodes, we will only have leaf nodes that have 
            //coins

        //Now as we can fetch coins from a distance of 2 without moving any distance,
            //we can remove extra two layer of coins
        
        //Now we will be only left with edges that must be traversed in order to
            //collect all the coins. 2 x no. of remaining edges will be our answer

        
        //prunning the leaf nodes with no coins
            //calculate inDegree of all the nodes and add all the nodes with inDegree
                //as 1 and no coins into a queue
            //run BFS to remove all the leaf nodes with no coins
        
        //prunning the next two layers of nodes
            //add all the remaining leaf nodes (inDegree == 1) to queue and remove
                //2 layers

        //calculate how many edges are remaining using inDegree and return 2 x remaining edges
       

        //What if there are no coins in the coins array (i.e. all are 0) -> return 0

        //TC: O(V+E) for BFS+
            //O()

        //SC: O(V) for queue +
            //O(V+E) for adjList +
            //O(V) for inDegree
    public int collectTheCoins(int[] coins, int[][] edges) {
        
        int totalNodes = coins.length;
        if(totalNodes <= 2) return 0;
        
        int[] inDegree = new int[totalNodes];

        

        Queue<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> adjList = new ArrayList<>();
        
        int totalCoins = 0;
        //initializing adjList
        for(int i = 0; i < totalNodes; i ++){
            adjList.add(new ArrayList<>());
            if(coins[i] == 1) totalCoins += 1;
        }
        if(totalCoins == 0) return 0;

        //filling adjList and inDegree
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            adjList.get(node1).add(node2);
            inDegree[node2] += 1;

            adjList.get(node2).add(node1);
            inDegree[node1] += 1;
        }

        //adding leaf nodes with no coins to queue
        for(int i = 0; i < totalNodes; i ++){
            if(inDegree[i] == 1 && coins[i] == 0){
                queue.offer(i);
            }
        }

        //prunning leaf nodes with no coins from the tree
        while(!queue.isEmpty()){
            int currQueueSize = queue.size();

            for(int i = 0; i < currQueueSize; i ++){
                int currNode = queue.poll();
                inDegree[currNode] -= 1;

                for(int connectingNode : adjList.get(currNode)){
                    if(inDegree[connectingNode] == 0) continue;
                    inDegree[connectingNode] -= 1;
                    if(inDegree[connectingNode] == 1 && coins[connectingNode] == 0) 
                        queue.offer(connectingNode);
                }

            }
        }

        //prunning two more leaf node layers
        for(int i = 0; i < totalNodes; i ++){
            if(inDegree[i] == 1) queue.offer(i);
        }

        int iteration = 0;
        while(!queue.isEmpty() && iteration < 2){
            int currQueueSize = queue.size();
            iteration += 1;

            for(int i = 0; i < currQueueSize; i ++){
                int currNode = queue.poll();
                inDegree[currNode] -= 1;

                for(int connectedNode : adjList.get(currNode)){
                    if(inDegree[connectedNode] == 0) continue;
                    inDegree[connectedNode] -= 1;
                    if(inDegree[connectedNode] == 1) queue.offer(connectedNode);
                }
            }
        }

        //all the prunned nodes must be having 0 inDegree and any nodes still part
            //of the tree will have greater than 0 inDegree
        int remNodes = 0;
        for(int i = 0; i < totalNodes; i ++){
            if(inDegree[i] > 0) remNodes += 1;
        }

        //returning 2 x edges and edges = nodes - 1
        return 2*(remNodes - 1) < 0 ? 0 : 2*(remNodes - 1);
               
    }


///////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 16 Aug 2026

    // //intuition 1:
    //     //Topic: Graph
    //     //Pattern: Tree center
    //     //Sub-Pattern: BFS + Leaf trimming + DFS

    //     //For the edeges to be minimum to collect all the coins we have to choose
    //         //a root such that the height of the tree is minimized. 
    //     //As if height is minimum then we can fetch far coins while traversing minimal
    //         //edges
    //     //For deciding root that will give minimum height tree, we can apply 
    //         //BFS + leaf trimming algo:
    //             //keep trimming leaf nodes until only 1 or 2 nodes remain
    //             //if there are 2 nodes remaining as the center of the tree, then
    //                 //proceed with any one of them
        
    //     //After settling down with a root node, now we need to find minimum edges needed
    //         //to collect all the coins
    //         //DFS: 
    //             //for this we can bubble up the coins by 2 edges 
    //                 //from the nodes that have the coins and then run dfs to calculate the number
    //                 //of edges from root node to the nodes that have all the coins

    //         //BFS:
    //             //we can start from root and put 2 level down nodes to queue, look if the
    //                 //nodes contain coins, if yes, subtract them from totalCoins, enque next
    //                 //level of tree and repeat until totalCoins are zero
            
    //         //Not sure about whether it should be DFS/BFS but bubbling up seems the correct
    //             //intuition

        

    //     //What if there are no coins in the coins array (i.e. all are 0) -> return 0
    // public int collectTheCoins(int[] coins, int[][] edges) {

    //     //finding the root with minimum height
    //     int totalNodes = coins.length;
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     int[] inDegree = new int[totalNodes];
    //     List<List<Integer>> adjList = new ArrayList<>();

    //     if(totalNodes == 1) return 0; //only 1 node exists in the tree

    //     //initializing adjList
    //     for(int i = 0; i < totalNodes; i ++){
    //         adjList.add(new ArrayList<>());
    //     }

    //     //filling adjList and inDegree
    //     for(int[] edge : edges){
    //         int node1 = edge[0];
    //         int node2 = edge[1];

    //         adjList.get(node1).add(node2);
    //         inDegree[node2] += 1;

    //         adjList.get(node2).add(node1);
    //         inDegree[node1] += 1;
    //     }

    //     //filling queue with in-degree == 1 (leaf nodes)
    //     for(int i = 0; i < totalNodes; i ++){
    //         if(inDegree[i] == 1) queue.offer(i);
    //     }

    //     while(totalNodes > 2){
    //         int currQueueSize = queue.size();

    //         for(int i = 0; i < currQueueSize; i ++){
    //             int currNode = queue.poll();
    //             inDegree[currNode] -= 1;
    //             totalNodes -= 1;

    //             for(int connectingNode : adjList.get(currNode)){
    //                 inDegree[connectingNode] -= 1;                    

    //                 if(inDegree[connectingNode] == 1) queue.offer(connectingNode);    
    //             }
    //         }
    //     }

    //     int rootNode = queue.poll();


        
    // }
}