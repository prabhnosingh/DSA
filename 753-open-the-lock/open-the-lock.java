class Solution {

    // //Re-solving on 13 Aug 2026

    // //intuition 2: Graphs - Optimization - did not improve TC - (Shortest Path 
    //     //in Unweighted Graph / BFS) 
    //     //Model every lock combination as a graph node.
    //     //Each valid one-wheel turn creates an edge to another state.
    //     //We can solve this by DFS as well as BFS, but BFS will be more optimal
    //         //in this case, given that it is finding shortest path in a unweighted
    //         //graph.
    //     //DFS will go in deep into a branch before backtracking and then might be
    //         //inefficient given the constraints
    //     //BFS explores the graph layer by layer and hence guarantees that the first
    //         //target node encountered is indeed the shortest from root ('0000')
    //     //Since every edge has equal cost (1 turn), BFS is appropriate
    //         //for finding the shortest path from "0000" to target.
    //     //At every BFS level, generate the 8 possible neighboring states:
    //         //4 wheels × 2 directions.
    //     //We can store states at level starting from '0000' in a queue and
    //         //push the resulting valid (not in deadends) combinations back into
    //         //the queue
        
    //     //Have two char maps nextChar and prevChar for finding next and prev number of
    //         //any lock state
    //     //The first time target is reached through BFS gives the minimum turns.

    //     //TC: O(10^4 * 8) = O(10^4) : there are only 10 x 10 x 10 x 10 = 10,000 possible 
    //         //lock states and each state has at most (4 wheels x 2 directions = 8 neighbors)
    //         //Initializing has
    //     //SC: (10^4) : Total: O(10^4)
    //         //HashSet: O(10^4)
    //         //Queue: O(10^4) worst case
        
    // public int openLock(String[] deadends, String target) {
        
    //     HashMap<Character, Character> nextChar = new HashMap<>();
    //     HashMap<Character, Character> prevChar = new HashMap<>();

    //     for(int i = 0; i < 10; i ++){
    //         if(i == 0){
    //             prevChar.put('0', '9');
    //             nextChar.put('0', '1');
    //         }
    //         else if(i == 9){
    //             nextChar.put('9', '0');
    //             prevChar.put('9', '8');
    //         }
    //         else{
    //             prevChar.put((char) (i + '0'), (char)((i - 1) + '0'));
    //             nextChar.put((char)(i + '0'), (char)((i + 1) + '0'));
    //         }
    //     }

    //     if(target.equals("0000")) return 0;
        
    //     HashSet<String> set = new HashSet<>();
    //     Queue<StringBuilder> queue = new ArrayDeque<>();
    //     queue.offer(new StringBuilder("0000"));
    //     set.add("0000");


    //     for(String deadend: deadends){
    //         set.add(deadend);

    //         if(deadend.equals("0000")) return -1;
    //     }

    //     int turns = 0;
    //     while(!queue.isEmpty()){
    //         int currQueueSize = queue.size();

    //         turns += 1;
    //         for(int j = 0; j < currQueueSize; j ++){
    //             String currComb = new String(queue.poll());

    //             for(int i = 0; i < 4; i ++){ //turning each lock by 1 and putting back in queue
    //                 //-1 / +1

    //                 char currChar = currComb.charAt(i);
                    
    //                 StringBuilder newSb1 = new StringBuilder(currComb);
    //                 newSb1.setCharAt(i, nextChar.get(currChar));
                    
    //                 if(newSb1.toString().equals(target)) return turns;

    //                 else if(!set.contains(newSb1.toString())) {
    //                     queue.offer(newSb1);
    //                     set.add(newSb1.toString());
    //                 }

    //                 StringBuilder newSb2 = new StringBuilder(currComb);
    //                 newSb2.setCharAt(i, prevChar.get(currChar));
                    
    //                 if(newSb2.toString().equals(target)) return turns;
                    
    //                 else if(!set.contains(newSb2.toString())){
    //                     queue.offer(newSb2);
    //                     set.add(newSb2.toString());
    //                 }
                    
    //             }   

    //         }
    //     }

    //     return -1; 

/////////////////////////////////////////////////////////////////////////////////////////


    
    //Solving on 13 Aug 2026

    //intuition 1: Graphs (Shortest Path in Unweighted Graph / BFS)
        //Model every lock combination as a graph node.
        //Each valid one-wheel turn creates an edge to another state.
        //We can solve this by DFS as well as BFS, but BFS will be more optimal
            //in this case, given that it is finding shortest path in a unweighted
            //graph.
        //DFS will go in deep into a branch before backtracking and then might be
            //inefficient given the constraints
        //BFS explores the graph layer by layer and hence guarantees that the first
            //target node encountered is indeed the shortest from root ('0000')
        //Since every edge has equal cost (1 turn), BFS is appropriate
            //for finding the shortest path from "0000" to target.
        //At every BFS level, generate the 8 possible neighboring states:
            //4 wheels × 2 directions.
        //We can store states at level starting from '0000' in a queue and
            //push the resulting valid (not in deadends) combinations back into
            //the queue
        //Use a HashSet to avoid both deadend states and already visited states.
        //The first time target is reached through BFS gives the minimum turns.

        //TC: O(10^4 * 8) = O(10^4) : there are only 10 x 10 x 10 x 10 = 10,000 possible 
            //lock states and each state has at most (4 wheels x 2 directions = 8 neighbors)

            //O(deadends.length * w + n^w x (2 x w))
            //O(4 x deadends.length + n^4 x (8))
            //O(deadends.length + n^4)
            //O(deadends.length + 10^4)
        //SC: (10^4 + 10^4) : Total: O(10^4)
            //HashSet: O(10^4)
            //Queue: O(10^4) worst case
        
    public int openLock(String[] deadends, String target) {
        
        if(target.equals("0000")) return 0;
        
        // HashSet<String> set = new HashSet<>();
        boolean[] visited = new boolean[10000];
        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder("0000"));
        // set.add("0000");
        visited[0] = true;


        for(String deadend: deadends){ //TC: O(deadends.length * 4) SC: O(deadends.length * 4)
            // set.add(deadend);
            visited[Integer.parseInt(deadend)] = true;
 
            if(deadend.equals("0000")) return -1;
        }

        int turns = 0;
        while(!queue.isEmpty()){ //TC: O(10^4 x (2x4)) : in worst case we might iterate on all
            //n^w (n = 10 - number of slots and w = 4 (number of wheels)) unique combinations
            //and for each uique combinations we perform 2*w turns (one next and one prev)
            
            int currQueueSize = queue.size();

            turns += 1;
            for(int j = 0; j < currQueueSize; j ++){
                String currComb = new String(queue.poll());

                for(int i = 0; i < 4; i ++){ //turning each lock by 1 and putting back in queue
                    //-1 / +1
                    int currCombCharInt = currComb.charAt(i) - '0'; //converting a char to int
                    int plusOne = currCombCharInt + 1;
                    int minusOne = currCombCharInt - 1; 
                    if(minusOne == -1){
                        minusOne = 9;
                    }
                    else if(plusOne == 10){
                        plusOne = 0;
                    }
                    StringBuilder newSb1 = new StringBuilder(currComb);
                    newSb1.setCharAt(i, (char) (plusOne + '0'));
                    
                    if(newSb1.toString().equals(target)) return turns;

                    // else if(!set.contains(newSb1.toString())) {
                    else if(!visited[Integer.parseInt(newSb1.toString())]){
                        queue.offer(newSb1);
                        // set.add(newSb1.toString());
                        visited[Integer.parseInt(newSb1.toString())] = true;
                    }

                    StringBuilder newSb2 = new StringBuilder(currComb);
                    newSb2.setCharAt(i, (char) (minusOne + '0'));
                    
                    if(newSb2.toString().equals(target)) return turns;
                    
                    // else if(!set.contains(newSb2.toString())){
                    else if(!visited[Integer.parseInt(newSb2.toString())]){
                        queue.offer(newSb2);
                        // set.add(newSb2.toString());
                        visited[Integer.parseInt(newSb2.toString())] = true;;
                    }
                    
                }   

            }
        }

        return -1; 



    }
}