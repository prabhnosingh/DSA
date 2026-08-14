class Solution {

    //Solving on 13 Aug 2026

    //intuition 1: 
        //We assume each lock state as graph node 
        //We can solve this by DFS as well as BFS, but BFS will be more optimal
            //in this case, given that it is finding shortest path in a unweighted
            //graph.
        //DFS will go in deep into a branch before backtracking and then might be
            //inefficient given the constraints
        //BFS explores the graph layer by layer and hence guarantees that the first
            //target node encountered is indeed the shortest from root ('0000')

        //We can store combinations at level starting from '0000' in a queue and
            //push the resulting valid (not in deadends) combinations back into
            //the queue
        //Use a HashSet to avoid traversing deadends and the combinations that have
            //already been traversed

        
    public int openLock(String[] deadends, String target) {
        
        if(target.equals("0000")) return 0;
        
        HashSet<String> set = new HashSet<>();
        Queue<StringBuilder> queue = new ArrayDeque<>();
        queue.offer(new StringBuilder("0000"));
        set.add("0000");


        for(String deadend: deadends){
            set.add(deadend);

            if(deadend.equals("0000")) return -1;
        }

        int turns = 0;
        while(!queue.isEmpty()){
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

                    else if(!set.contains(newSb1.toString())) {
                        queue.offer(newSb1);
                        set.add(newSb1.toString());
                    }

                    StringBuilder newSb2 = new StringBuilder(currComb);
                    newSb2.setCharAt(i, (char) (minusOne + '0'));
                    
                    if(newSb2.toString().equals(target)) return turns;
                    
                    else if(!set.contains(newSb2.toString())){
                        queue.offer(newSb2);
                        set.add(newSb2.toString());
                    }
                    
                }   

            }
        }

        return -1; 



    }
}