class Solution {


    //❗ Find minimum moves / minimum jumps / minimum steps
    // → That is almost always solved with BFS, not DP.
    

    //🧠 This Problem = Graph + BFS

        // Each position is like a node.
        // Each valid jump (forward/backward) is like an edge.

        // You perform a BFS shortest path search on an implicit graph.

        // That's why the final solution is BFS with a visited matrix.

        // 💡 So what do we call it formally?

        // This is a shortest-path BFS on implicit graph states.
        // NOT DP.
            
    
    
    //Solving on 06 Dec 2025: 

    //intuition 1 (bfs): 
        //Use a queue of int[] type to store the  {pos, 0/1} (0 means forward and 1 means negative)
        //Explore all the possibilities at all the positions. 
        //Start with adding {0,0} to the queue and then adding {0 + a, 0} and {0 - b, 1}
        //Run the for loop for the current size of queue, and poll one element in each iteration while adding
            //forward and backward jump (only if valid) back to the queue.
        //Each level (for loop) is considered one jump. Increment jumps after the for loop.
        //If at any time in the process currPos[0] becomes equal to x, return the jumps.

        //Keep track of visited or forbidden positions by adding them to a 2d boolean visited array

        //We choose 6000 as the upper limit due to upperlimit of the constraints:
            //1 jump forward: 1999
            //1 jump backward : -1 (out of bounds)
            //1 jump forward : 3998
            //1 jump bacward: 1998 (forbidden)
            //1 jump forward: 5997

            //This works as it gives algo to explore all possibilities to converge towards x after tackling
                //edge values of forbidden, a and b.
        
        //BFS ensures the first time we hit x, the number of steps is minimal.

        //TC: O(6000 x 2): BFS explores atmost 6000x2 states
        //SC: O(6000 x 1): Visited array size
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[6000][2];
        int jumps = 0;

        for(int forbidIdx : forbidden){
            visited[forbidIdx][0] = true; //forbidIdx reached from forward jump is already visited
            visited[forbidIdx][1] = true; //forbidIdx reaced from backward jump is already visited
        }

        queue.add(new int[]{0,0});

        while(!queue.isEmpty()){
            int currQueueSize = queue.size();

            for(int i = 0; i < currQueueSize; i ++){
                int[] currPos = queue.poll();

                if(currPos[0] == x){
                    return jumps;
                }

                if(visited[currPos[0]][currPos[1]]){
                    continue;
                }


                visited[currPos[0]][currPos[1]] = true;

                if(currPos[0] + a < 6000){
                    queue.add(new int[]{currPos[0] + a, 0});
                }

                if(currPos[0] - b >= 0 && currPos[1] != 1){ 
                    queue.add(new int[]{currPos[0] - b, 1});
                }


            }
            jumps += 1; 
        }

        return -1;


    }




























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 04 Dec 2025: 

//     //intuition 2 (bfs): 
//         //Use a queue of int[] type to store the next positions possible from the current positions
//             //int[] = {idx, 0(forwards)/1(backwards} => {idx, 0/1}

//         //Use a 2D visited set of boolean type to keep track of forward and backward visits

//     public int minimumJumps(int[] forbidden, int a, int b, int x) {
//         int n = forbidden.length;

//         boolean[][] visited = new boolean[6000][2];
//         if(x == 0) return 0;

//         int jumps = 0;

//         //adding indices in forbidden array to the visited set, to avoid visiting them
//         for(int i = 0; i < n; i ++){
//             visited[forbidden[i]][0] = true; //for avoiding travelling forwards 
//             visited[forbidden[i]][1] = true; //for avoiding travelling backwards 
//         }

//         Queue<int[]> queue = new ArrayDeque<>();
//         queue.add(new int[]{0, 0});

//         //a single position consists of idx and direction of travel (idx, 0/1)

//         while(queue.size() > 0){
//             int currQueueSize = queue.size();

//             for(int i = 0; i < currQueueSize; i ++){
//                 int[] currPos = queue.poll();

//                 //checking if the position is already in visited
//                 if(visited[currPos[0]][currPos[1]]) continue;

//                 visited[currPos[0]][currPos[1]] = true;

//                 if(currPos[0] == x) return jumps;

//                 //6000 is the max possible value for forward moment
//                 if(currPos[0] + a < 5000){
//                     queue.add(new int[]{currPos[0] + a, 0});
//                 }

//                 //to restrict double backward movement we add backward movement from currPos[0] as well
//                 if(currPos[0] - b >= 0 && currPos[1] != 1){ //do not do backward movement if the currPos is already
//                 //created by a backward movement, i.e. its currPos[1] is already 1
//                     queue.add(new int[]{currPos[0] - b, 1});

//                 }

//             }
//             jumps += 1;
//         }
//         return -1;

//     }




























// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // // Solving on 04 Dec 2025: 

    // // intuition 1: 
    // //     If while jumping forward, we encounter a forbidden position, jump backward and try jumping
    // //         forward again.
    // //     Keep jumping forward, until the currentIdx becomes more than x, in that case jump backwards
    // //         If jumping backwards lead to a forbidden position, return -1
    // //     If while jumping we encounter a negative index, return -1




    // public int minimumJumps(int[] forbidden, int a, int b, int x) {
        
    //     for(int f : forbidden){
    //         if(f % a == 0 && f < x){
    //             return -1;
    //         }
    //     }
        
    //     if(x % a == 0){
    //         return x / a;
    //     }

    //     if(x % (a-b) == 0){
    //         return (x / (a-b)) + 1;
    //     }

    //     // System.out.println("d");
    //     int currIdx = 0;
    //     int jumps = 0;
    //     while(true){
    //         if(currIdx == x){
    //             return jumps; 
    //         }
    //         currIdx += a;
    //         jumps += 1;

    //         if(currIdx > x){
    //             currIdx -= b;
    //             if(currIdx > x){ //even after jumping back the index is still greater than x
    //                 return - 1;
    //             }
    //             for(int f : forbidden){
    //                 if(f == currIdx){
    //                     return -1;
    //                 }
    //             }
    //             jumps += 1;
    //         }


    //     }

    //     // return - 1;
    // }
}