class Solution {
    //Solving on 04 Dec 2025: 

    //intuition 2 (bfs): 
        //Use a queue of int[] type to store the next positions possible from the current positions
            //int[] = {idx, 0(forwards)/1(backwards} => {idx, 0/1}

        //Use a 2D visited set of boolean type to keep track of forward and backward visits

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int n = forbidden.length;

        boolean[][] visited = new boolean[6000][2];
        if(x == 0) return 0;

        int jumps = 0;

        //adding indices in forbidden array to the visited set, to avoid visiting them
        for(int i = 0; i < n; i ++){
            visited[forbidden[i]][0] = true; //for avoiding travelling forwards 
            visited[forbidden[i]][1] = true; //for avoiding travelling backwards 
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        //a single position consists of idx and direction of travel (idx, 0/1)

        while(queue.size() > 0){
            int currQueueSize = queue.size();

            for(int i = 0; i < currQueueSize; i ++){
                int[] currPos = queue.poll();

                //checking if the position is already in visited
                if(visited[currPos[0]][currPos[1]]) continue;

                visited[currPos[0]][currPos[1]] = true;

                if(currPos[0] == x) return jumps;

                //6000 is the max possible value for forward moment
                if(currPos[0] + a < 6000){
                    queue.add(new int[]{currPos[0] + a, 0});
                }

                //to restrict double backward movement we add backward movement from currPos[0] as well
                if(currPos[0] - b >= 0 && currPos[1] != 1){ //do not do backward movement if the currPos is already
                //created by a backward movement, i.e. its currPos[1] is already 1
                    queue.add(new int[]{currPos[0] - b, 1});

                }

            }
            jumps += 1;
        }
        return -1;

    }




























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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