class Solution {

    //Re-solving 21 Feb 2026:

    //intuition 1: 
        //We can have a 2D DP array to store the minimum path sum from 
            //each cell to bottom level
        //Recurrence relation:
            //For each cell i,j we have two previous states to choose from,
                //dp[i+1][j] or dp[i+1][j+1].
            //We will take minimum of the two and add it to the current cell's
                //value to finally get current dp state's value
            //dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])

        //Base case:
            //last row of dp array will be as it is as triangle's last row

    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i][j] represents minimum path sum to reach bottom level 
            //from i, j cell
        //dpp[0][0] will represent minimum path sum to reach bottom level
            //from top
        //The most extreme cell that can exist is triangle.length-1, 
            //triangle[triangle.lenth-1].length-1
        //Therefore we need a 2D DP matrix of size triangle.length x
            //triangle[triangle.length-1].length

        
        int rows = triangle.size();
        int cols = triangle.get(rows-1).size(); //cols will be length of longest array in triangle

        int[][] dp = new int[rows][cols];

        //base case
        //filling last row  
        for(int j = 0; j < cols; j ++){
            int i = rows - 1;
            dp[i][j] = triangle.get(i).get(j);
        }

        for(int i = rows - 2; i >= 0; i --){
            for(int j = i; j >= 0; j --){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];        

    }




























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 27 Dec 2025:

//     //intuition 1 (brainstorming):
//         //At each number we have two choices:
//             //Either to move to ith index of next row
//             //Or, to move to i+1th index of next row

//         //Input 1: Starting from top we have problem to find min path sum from 2 to bottom level (triangle.length).
//         //Currently we have two choices:
//             //move to 3: now the sub-problem reduces to finding min path sum from 3 to bottom level
//             //move to 4: now the sub-problem reduces to finding the path sum from 4 to bottom level
//         //We traverse each branch till bottom level and then compare them along the way to choose the least cost path
        
//         //We compare and choose the minimum pathSum returned from two branches. 


//     //intuition 3 (2D DP: Tabulation): Dp on grids pattern: Bottom up approach
//         //We have a problem to find minimum path sum from top to bottom. For choosing this minimum path sum
//             //we depend on two states. If we had already computed these two states, we could have found the
//             //minimum path for the current state.
//         //Therefore, problem reduces to finding next two states to find the previous state.
        
//         //We will traverse from bottom level up towards 0 level and our answer will be at 0,0
//         //Base case:
//             //For bottom row of dp matrix we can fill same as last row of triangle as we need at least
//                 //that much cost to reach bottom level from that cell.
            
//         //Recurrence relation:
//             //For any cell dp[i][j] we need to choose minimum of dp[i+1][j] or dp[i+1][j+1]

//             //=> dp[i][j] = triangle.get(i).get(j) + min(dp[i+1][j], dp[i+1][j+1])
//             //run for loop for indices based on levels (if level is 2, then run index for loop 2 times)

//             //“Each cell’s best path to the bottom depends only on the best paths from the two cells directly below it, 
//                 //so compute from the last row upward and store dp[i][j] = val + min(below, below-right).”

//         //traverse(level, idx) represents minimum sum from this cell to the bottom

//     //TC: O(rows^2)
//     //SC: O(rows^2) -> can be optimized to O(n) using 1D dp
//     public int minimumTotal(List<List<Integer>> triangle) {
//         //dp[i][j] represents minimum path sum to reach bottom level from ith level and jth index
//         //At max we have triangle.size() elements at triangle.size() level, therefore, we need a 
//             //2D dp matrix of size triangle.size() x triangle.size()

//         int rows = triangle.size();
//         int cols = rows;

//         int[][] dp = new int[rows][cols];

//         //base case

//         //filling last row
//         for(int j = cols - 1; j >= 0; j --){
//             int i = rows - 1;
//             dp[i][j] = triangle.get(i).get(j);
//         }

//         for(int i = rows - 2; i >= 0; i --){
//             for(int j = i; j >= 0; j --){ //because row i has i+1 elements
//                 dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
//             }
//         }

//         return dp[0][0];

//     }























// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 27 Dec 2025:

//     //intuition 1 (brainstorming):
//         //At each number we have two choices:
//             //Either to move to ith index of next row
//             //Or, to move to i+1th index of next row

//         //Input 1: Starting from top we have problem to find min path sum from 2 to bottom level (triangle.length).
//         //Currently we have two choices:
//             //move to 3: now the sub-problem reduces to finding min path sum from 3 to bottom level
//             //move to 4: now the sub-problem reduces to finding the path sum from 4 to bottom level
//         //We traverse each branch till bottom level and then compare them along the way to choose the least cost path
        
//         //We compare and choose the minimum pathSum returned from two branches. 


//     //intuition 3 (recursion: State DP: beats 10.9%): Top down approach + memoization
//         //To avoid TLE, we need to store the minPathSum computed for states in order to avoid re-calculations.
//         //Each state can be uniquely identified as level of triangle and index in the level.
//         //We can use a hashMap that uniquely identifies a state and stores the minSum from that state to the bottom.
//         //State can defined by a string like level + "," + idx

//         //traverse(level, idx) represents minimum sum from this cell to the bottom
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int minPathSum = Integer.MAX_VALUE;

//         int m = triangle.size();
//         // HashMap<String, Integer> dpMap = new HashMap<>(); //beats 10.9%
//         Integer[][] dpMap = new Integer[m][m]; //beats 21.11%

//         minPathSum = Math.min(minPathSum, traverse(triangle, 0, 0, dpMap));
        
//         return minPathSum;

//     }

//     private int traverse(List<List<Integer>> triangle, int currLevel, int currIdx, Integer[][] dpMap){
//         String key = currLevel + "," + currIdx; 
//         if(dpMap[currLevel][currIdx] != null){
//             return dpMap[currLevel][currIdx];
//         }
//         // if(dpMap.containsKey(key)){
//         //     return dpMap.get(key);
//         // }

//         if(currLevel == triangle.size() - 1){   
//             return triangle.get(currLevel).get(currIdx);
//         }

//         int currNodeCost = triangle.get(currLevel).get(currIdx);

//         //hypothesis
//         //currIdx remains same (0)
//         int iPathSum = traverse(triangle, currLevel + 1, currIdx, dpMap);
        
//         //currIdx changes to currIdx + 1 (1)
//         int iPlusOnePathSum = traverse(triangle, currLevel + 1, currIdx + 1, dpMap);

//         //induction (deciding results and sending upwards)
//         int minPathSum = currNodeCost + Math.min(iPathSum, iPlusOnePathSum);
//         dpMap[currLevel][currIdx] = minPathSum;
//         // dpMap.put(key, minPathSum);

//         return minPathSum;
//     }   























// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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