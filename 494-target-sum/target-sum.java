class Solution {
    //Re-solving on 15 Mar 2026:

    //This problem can be solved with DP/memoization because:
        //It is finding total number of expressions and not the actual expressions
        //Any particular state depends on already computed state




    //intuition 3: 2D DP
        //Assuming P is the sum of numbers marked as + and N is the sum of numbers
            //marked as -, we have P-N = target and P+N = totalSum
        //This boils downt to 2P = totalSum + target => P = (totalSum + target)/2

        //So the problem now becomes finding number of subsets that form a total sum
            //of (totalSum + target) / 2

        //Recurrence relation:
            //There are two options, either to pick the current number or not pick it
            //Pick it: We cannot pick the number if it is greater than current j
                //if we choose the current number then our target reduces by j - currNum
                    //and the number of available numbers also reduce by 1.
                //Therefore, current dp state depends on previous dp state 
                    //dp[i][j] = dp[i-1][j-currNum]
            //Not pick it:
                //if we do not choose the current number, then our target remains the same
                    //and the number of available numbers reduce by 1.
                //Therefore, current dp state depends on previous dp state 
                    //dp[i][j] = dp[i-1][j]
            
            //we add result from both the options to get answer for our state

            //dp[i][j] = dp[i-1][j-currNum] + dp[i-1][j]

        //Base case:
            //dp[0][0] = 1
            //given 0 numbers and non-zero target, there are 0 ways to form the target
                //fill the first row with 0s starting from column 1
            //given 0 target and non-zero numbers, there is 1 way to form the target
                //fill the first col with 1s starting from row 1


    public int findTargetSumWays(int[] nums, int target) {
        //dp[i][j] will represent number of ways to form total sum j with first
            //i numbers from nums
        //dp[nums.length][(totalSum+target)/2] will represent number of ways to 
            //form total sum (totalSum+target)/2 given all nums
        
        //Therefore we need a 2D matrix of size nums.length+1 x (totalSum+target)/2+1
       
        int totalSum = 0;
        for(int num : nums) totalSum += num;

        if(Math.abs(target) > totalSum) return 0; //not possible to form this target
        if((totalSum + target) % 2 != 0) return 0; //because (totalSum + target)/2 
            //must be an integer

        int rows = nums.length + 1;
        int cols = ((totalSum + target) / 2) + 1;

        int[][] dp = new int[rows][cols];

        //base cases
        dp[0][0] = 1;

        //filling first row
        for(int j = 1; j < cols; j ++){
            int i = 0;
            dp[i][j] = 0;
        }

        // //filling first col -> not valid in case a number is a 0
        // for(int i = 1; i < rows; i ++){
        //     int j = 0;
        //     dp[i][j] = 1;
        // }


        for(int i = 1; i < rows; i ++){
            // for(int j = 1; j < cols; j ++){
            for(int j = 0; j < cols; j ++){ //to account for currNum = 0
                int currNum = nums[i-1];
                int pick = 0;
                int notPick = 0;

                if(currNum <= j){
                    pick = dp[i-1][j-currNum];
                }
                
                notPick = dp[i-1][j];

                dp[i][j] = pick + notPick;

            }
        }

        return dp[rows-1][cols-1];



    }

///////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 07 Mar 2026:

//     //This problem can be solved with DP/memoization because:
//         //It is finding total number of expressions and not the actual expressions
//         //Any particular state depends on already computed state

//     //intuition 2: dfs : backtracking : memoization  
//         //each number in nums have an option to be prefixed with either '+' or '-'
//         //we can explore all the possibilities to find which of these compute to target
//         //"for each nubmer, recursively choose either +nums[i] or -nums[i] and update 
//             //currSum accordingly" 
//         //base case:
//             //when currIdx becomes equal to length of nums:
//                 //and currSum equal to target, then return 1 
//                 //else return 0

//         //what if target is 0? -> only check if the currIdx becomes equal to nums length

        
//         //memoization: the variables are currSum and currIdx
//             //max currSum can be total sum of nums
//             //max currIdx can be nums.length-1

//             //therefore we can have a 2d memo array of size totalSum + 1 x nums.length

//         //TC: O(2^n) : for recursion
//         //for each number we have two choices, either to choose it as positive
//             //or to choose it as negative
//             //"each of the n numbers creates 2 branches"
//             //"total leaf expressions = 2^n"

//         //TC: O(n * rangeOfPossibleSums) 
//             //since the sum can vary from -totalSum to +totalSum, states are:
//                 //O(n * (2 * totalSum + 1))
//         //Sc: O(n) : size of recursive stack + memo. Height of the tree



//     public int findTargetSumWays(int[] nums, int target) {
        
//         int totalSum = 0;

//         HashMap<String, Integer> memo = new HashMap<>();

  
//         return dfs(nums, target, 0, 0, memo);

//     }

//     private int dfs(int[] nums, int target, int currSum, int currIdx, 
//         HashMap<String, Integer> memo){
//         // if(currSum == target) return 1;
//         String key = currSum + "_" + currIdx;
//         if(memo.containsKey(key)) return memo.get(key);

//         if(currIdx == nums.length){ //we should only check whether the target is met
//             //or not when the whole expression is traversed
//             if(currSum == target) return 1;
//             else return 0;

//         } 

//         int currNum = nums[currIdx];
        
//         //negative currNum
//         int option1 = dfs(nums, target, currSum + (currNum * -1), currIdx + 1, memo);

//         //positive currNum
//         int option2 = dfs(nums, target, currSum + currNum, currIdx + 1, memo);
        
//         memo.put(key, option1 + option2);

//         return option1 + option2;
//     }

// ///////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 07 Mar 2026:

    // //intuition 1: dfs : backtracking   
    //     //each number in nums have an option to be prefixed with either '+' or '-'
    //     //we can explore all the possibilities to find which of these compute to target
    //     //"for each nubmer, recursively choose either +nums[i] or -nums[i] and update 
    //         //currSum accordingly" 
    //     //base case:
    //         //when currIdx becomes equal to length of nums:
    //             //and currSum equal to target, then return 1 
    //             //else return 0

    //     //what if target is 0?

    //     //TC: O(2^n) : for each number we have two choices, either to choose it as positive
    //         //or to choose it as negative
    //         //"each of the n numbers creates 2 branches"
    //         //"total leaf expressions = 2^n"
    //     //Sc: O(n) : size of recursive stack. Height of the tree
    // public int findTargetSumWays(int[] nums, int target) {
        
    //     return dfs(nums, target, 0, 0);

    // }

    // private int dfs(int[] nums, int target, int currSum, int currIdx){
    //     // if(currSum == target) return 1;

    //     if(currIdx == nums.length){ //we should only check whether the target is met
    //         //or not when the whole expression is traversed
    //         if(currSum == target) return 1;
    //         else return 0;

    //     } 

    //     int currNum = nums[currIdx];
        
    //     //negative currNum
    //     int option1 = dfs(nums, target, currSum + (currNum * -1), currIdx + 1);

    //     //positive currNum
    //     int option2 = dfs(nums, target, currSum + currNum, currIdx + 1);
        

    //     return option1 + option2;
    // }
























////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 16 Dec 2025:

    // //intuition 2 (improved version of intuition 1): Backtracking DFS: decision tree on nums
    //     //At each index currIdx, we decide how nums[currIdx] contributes to the final sum.
    //     //For every number, we have exactly two choices:
    //         //1. Add the number to the current sum
    //         //2. Subtract the number from the current sum
        
    //     //1️⃣ What does one level of recursion represent?
    //         //Each level represents fixing the sign (+ or -) for nums[currIdx].
    //         //Moving to dfs(currIdx + 1) means we have already decided the sign for all numbers
    //             //before currIdx and are now deciding for the next number.

    //     //2️⃣ What are my choices at that level?   
    //         //At each level, there are exactly two recursive branches:
    //             //i. Take nums[currIdx] as +nums[currIdx]
    //             //ii. Take nums[currIdx] as -nums[currIdx]

    //     //3️⃣ When do I stop?
    //         //When currIdx == nums.length, all numbers have been assigned a sign.
    //         //At this point, if currSum == target, we have found one valid way.
    //         //Return 1 for a valid way, otherwise return 0.

    //     //The final answer is the sum of valid ways from all branches of the recursion tree.



    // //intuition 1 (self-thought): (Backtracking DFS):

    // //1️⃣ What does one level of recursion represent?
    //     //Each digit from nums being processed 
    //     //dfs(currIdx + 1) -> currIdx + 1 represents going one level deep in recursion

    // //2️⃣ What are my choices at that level?    
    //     //At each level we have two choices, either to choose the current digit as a positive number
    //         //or as a negative number
    //     //At each level there will be two recursive calls, one for positive currNum and one for negative
    //         //currNum

    // //3️⃣ When do I stop?
    //     //When currIdx becomes equalt to nums.length. At this point, check if currSum is equal to target, 
    //         //if yes, increment your variable

    // //TC: O(2^n): where n is the length of nums
    // //SC: O(n): Length of recursive stack
    // public int findTargetSumWays(int[] nums, int target) {
    //     return dfs(nums, 0, 0, target);
    // }

    // private int dfs(int[] nums, int currIdx, int currSum, int target){
    //     if(currIdx == nums.length){
    //         if(currSum == target){
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     int currNum = nums[currIdx];
    //     // // "+currNum"
    //     // int positiveCount = dfs(nums, currIdx + 1, currSum + currNum, target);
        
    //     // // "-currNum"
    //     // int negativeCount = dfs(nums, currIdx + 1, currSum - currNum, target);
        
        
    //     currSum = currSum + currNum;
    //     int positiveCount = dfs(nums, currIdx + 1, currSum, target);
    //     currSum = currSum - currNum;


    //     currSum = currSum - currNum;
    //     int negativeCount = dfs(nums, currIdx + 1, currSum, target);
    //     currSum = currSum + currNum;

    //     return positiveCount + negativeCount;
    // }
}