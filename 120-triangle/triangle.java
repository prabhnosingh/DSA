class Solution {

    //Solving on 27 Dec 2025:

    //intuition 1 (brainstorming):
        //At each number we have two choices:
            //Either to move to ith index of next row
            //Or, to move to i+1th index of next row

        //Input 1: Starting from top we have problem to find min path sum from 2 to bottom level (triangle.length).
        //Currently we have two choices:
            //move to 3: now the sub-problem reduces to finding min path sum from 3 to bottom level
            //move to 4: now the sub-problem reduces to finding the path sum from 4 to bottom level
        //We traverse each branch till bottom level and then compare them all to come up with the least sum
        
        //We compare and choose the minimum pathSum returned from two branches. 


    //intuition 3 (recursion: State DP): Top down approach + memoization
        //To avoid TLE, we need to store the minPathSum computed for states in order to avoid re-calculations.
        //Each state can be uniquely identified as level of triangle and index in the level.
        //We can use a hashMap that uniquely identifies a state and stores the minSum from that state to the bottom.
        //State can defined by a string like level + "," + idx

        //traverse(level, idx) represents minimum sum from this cell to the bottom
    public int minimumTotal(List<List<Integer>> triangle) {
        int minPathSum = Integer.MAX_VALUE;

        HashMap<String, Integer> dpMap = new HashMap<>(); 

        minPathSum = Math.min(minPathSum, traverse(triangle, 0, 0, dpMap));
        
        return minPathSum;

    }

    private int traverse(List<List<Integer>> triangle, int currLevel, int currIdx, HashMap<String, Integer> dpMap){
        String key = currLevel + "," + currIdx; 
        if(dpMap.containsKey(key)){
            // System.out.println(key);
            return dpMap.get(key);
        }

        if(currLevel == triangle.size() - 1){   
            return triangle.get(currLevel).get(currIdx);
        }

        int currNodeCost = triangle.get(currLevel).get(currIdx);

        //hypothesis
        //currIdx remains same (0)
        int iPathSum = traverse(triangle, currLevel + 1, currIdx, dpMap);
        
        //currIdx changes to currIdx + 1 (1)
        int iPlusOnePathSum = traverse(triangle, currLevel + 1, currIdx + 1, dpMap);

        //induction (deciding results and sending upwards)
        int minPathSum = currNodeCost + Math.min(iPathSum, iPlusOnePathSum);
        dpMap.put(key, minPathSum);

        return minPathSum;
    }   

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 27 Dec 2025:

    // //intuition 1 (brainstorming):
    //     //At each number we have two choices:
    //         //Either to move to ith index of next row
    //         //Or, to move to i+1th index of next row

    //     //Input 1: Starting from top we have problem to find min path sum from 2 to bottom level (triangle.length).
    //     //Currently we have two choices:
    //         //move to 3: now the sub-problem reduces to finding min path sum from 3 to bottom level
    //         //move to 4: now the sub-problem reduces to finding the path sum from 4 to bottom level
    //     //We traverse each branch till bottom level and then compare them all to come up with the least sum
        
    //     //We compare and choose the minimum pathSum returned from two branches. 


    // //intuition 2 (recursion: prefixSum (path DP): TLE): Top down approach + memoization 

    //  //"You intended to memoize “min path sum from (level, idx) to bottom”, but you implemented “min path sum of a 
    //      //full path so far” by passing currPathSum.""
    //  //"What it means: traverse(level, idx, currPathSum) -> minimum TOTAL path sum from the top to bottom"
    //  //Mental rule for memoization DP solutions: "If a value is carried downward, it must appear in the 
        //memo key, otherwise it must be removed from recursion."


    //     //To avoid TLE, we need to store the minPathSum computed for states in order to avoid re-calculations.
    //     //Each state can be uniquely identified as level of triangle and index in the level.
    //     //We can use a hashMap that uniquely identifies a state and stores the minSum from that state to the bottom.
    //     //State can defined by a string like level + "," + idx

    
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int minPathSum = Integer.MAX_VALUE;

    //     HashMap<String, Integer> dpMap = new HashMap<>(); 

    //     minPathSum = Math.min(minPathSum, traverse(triangle, 0, 0, triangle.get(0).get(0), dpMap));
        
    //     return minPathSum;

    // }

    // private int traverse(List<List<Integer>> triangle, int currLevel, int currIdx, int currPathSum, HashMap<String, Integer> dpMap){
    //     String key = currLevel + "," + currIdx + "," + currPathSum; //need to have currPathSum in the key to differentiate
    //         //between same cell (level, idx) being reached by different prefix sums
    //     if(dpMap.containsKey(key)){
    //         // System.out.println(key);
    //         return dpMap.get(key);
    //     }

    //     if(currLevel == triangle.size() - 1){   
    //         return currPathSum;
    //     }

    //     //hypothesis
    //     //currIdx remains same (0)
    //     int iPathSum = traverse(triangle, currLevel + 1, currIdx, currPathSum + triangle.get(currLevel+1).get(currIdx), dpMap);
        
    //     //currIdx changes to currIdx + 1 (1)
    //     int iPlusOnePathSum = traverse(triangle, currLevel + 1, currIdx + 1, currPathSum + triangle.get(currLevel+1).get(currIdx+1), dpMap);

    //     //induction (deciding results and sending upwards)
    //     int minPathSum = Math.min(iPathSum, iPlusOnePathSum);
    //     dpMap.put(key, minPathSum);

    //     return minPathSum;
    // }   


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 27 Dec 2025:

    // //intuition 1 (brainstorming):
    //     //At each number we have two choices:
    //         //Either to move to ith index of next row
    //         //Or, to move to i+1th index of next row

    //     //Input 1: Starting from top we have problem to find min path sum from 2 to bottom level (triangle.length).
    //     //Currently we have two choices:
    //         //move to 3: now the sub-problem reduces to finding min path sum from 3 to bottom level
    //         //move to 4: now the sub-problem reduces to finding the path sum from 4 to bottom level
    //     //We traverse each branch till bottom level and then compare them all to come up with the least sum
        
    //     //We compare and choose the minimum pathSum returned from two branches. 


    // //intuition 1 (recursion : TLE): Top down approach  

    // //TC: O(2^m): at each level we have two choices to make, forming a binary recursion tree of heigth m
    //  // where n is the size of largest level of triangle (i.e. triangle.get(m))
    // //SC: O(m) : recursive stack depth: where m is the size of triangle   
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     int minPathSum = Integer.MAX_VALUE;

    //     minPathSum = Math.min(minPathSum, traverse(triangle, 0, 0, triangle.get(0).get(0)));
        
    //     return minPathSum;

    // }

    // private int traverse(List<List<Integer>> triangle, int currLevel, int currIdx, int currPathSum){
    //     if(currLevel == triangle.size() - 1){   
    //         return currPathSum;
    //     }

    //     //hypothesis
    //     //currIdx remains same (0)
    //     int iPathSum = traverse(triangle, currLevel + 1, currIdx, currPathSum + triangle.get(currLevel+1).get(currIdx));
        
    //     //currIdx changes to currIdx + 1 (1)
    //     int iPlusOnePathSum = traverse(triangle, currLevel + 1, currIdx + 1, currPathSum + triangle.get(currLevel+1).get(currIdx+1));

    //     //induction (deciding results and sending upwards)
    //     return Math.min(iPathSum, iPlusOnePathSum);
    // }   
}