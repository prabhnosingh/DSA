class Solution {
    //Solving on 28 Jan 2026

    //intuition 2 : Graphs: DFS + memoization (3-color DFS)
        //"leads to a terminal node (or another safe node)" -> recursion
        //this is directed graph so no DSU

     
        //from every node run dfs on its children, if all of the children lead to temrinal nodes
            //add the node to safeNodes list -> it should already by sorted as we will traverse from
            //0 to n-1
        //We only check for the cycles as if cycle is not detected than the node will for sure lead
            //to a terminal node

        //Have a state int array that can have three different values for each node:
            //0 : unvisited
            //1 : currently being recursed
            //2 : marked as safe
    public List<Integer> eventualSafeNodes(int[][] graph) {    
        int numOfNodes = graph.length;

        int[] states = new int[numOfNodes];

        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0; i < numOfNodes; i ++){
            if(dfsHelper(graph, i, states)){
                safeNodes.add(i);
            }
        }

        return safeNodes;


    }

    private boolean dfsHelper(int[][] graph, int currNode, int[] states){
        if(states[currNode] == 2){
            return true;
        }

        boolean isSafe = true;

        for(int neiNode : graph[currNode]){
            if(states[neiNode] == 2) continue;
            if(states[neiNode] == 1) return false; //neiNode is already in recursive call and 
                //is encountered again without finishing its recursiva call
            states[neiNode] = 1;
            isSafe = isSafe && dfsHelper(graph, neiNode, states);
            if(!isSafe){
                return false;
            }
        }
        
        states[currNode] = 2;

        return isSafe;
    }
























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// class Solution {
//     //Solving on 28 Jan 2026

//     //intuition 1 (TLE) : Graphs: dfs
//         //"leads to a terminal node (or another safe node)" -> recursion
//         //this is directed graph so no DSU

//         //first mark the nodes that do not have any children as termninal nodes
//             //have a boolean array 'isTerminalNode'
//         //from every node run dfs on its children, if all of the children lead to temrinal nodes
//             //add the node to safeNodes list -> it should already by sorted as we will traverse from
//             //0 to n-1
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int numOfNodes = graph.length;
//         boolean[] isTerminalNode = new boolean[numOfNodes];
//         List<Integer> safeNodes = new ArrayList<>();

//         for(int i = 0; i < numOfNodes; i ++){
//             int[] neiNodes = graph[i];
//             if(neiNodes.length == 0) isTerminalNode[i] = true;
//         } 

//          for(int i = 0; i < numOfNodes; i ++){//optimize this - traverse only non-safe nodes and 
//             //mark safe nodes separately as well
            
//             boolean[] visited = new boolean[numOfNodes];
            
//             visited[i] = true;
//             if(isSafeDfs(graph, i, isTerminalNode, visited)) safeNodes.add(i);
            
//         }

//         return safeNodes;


//     }

//     //what is the false condition for isSafeDfs
//         //any node that is part of a cycle is not a safe node
//     private boolean isSafeDfs(int[][] graphs, int currNode, boolean[] isTerminalNode, 
//     boolean[] visited){
        
//         boolean isSafe = true;

//         if(isTerminalNode[currNode]){
//             return true;
//         }

//         for(int neiNode : graphs[currNode]){
//             if(visited[neiNode]){
//                 // System.out.println("currNode is " + currNode + " neiNode that was already visited : " + neiNode);
//                 return false; //cycle detected
//             }
//             visited[neiNode] = true; //marking the neiNode as visited
//             isSafe = isSafe && isSafeDfs(graphs, neiNode, isTerminalNode, visited);
//             if(!isSafe){
//                 // System.out.println("neiNode that gave false was : " + neiNode);
//                 break;
//             }
//             visited[neiNode] = false; //to avoid triggering false cycle detections. If there is a cycle, then it will be 
//                 //detected before reaching this statement because of the depth first search. This statement helps in 
//                 //resetting visited nodes to false as this is a directed graph and same could be reached by multiple nodes
//                 //without necessarily creating a cycle (eg: In case where the node is having all inward edges and no 
//                 //outward edges)
//         }
        
//         return isSafe;
//     }
} 