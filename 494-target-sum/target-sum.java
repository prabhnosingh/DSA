class Solution {
    //Solving on 16 Dec 2025:

    //intuition 2 (improved version of intuition 1): Backtracking DFS: decision tree on nums
        //At each index currIdx, we decide how nums[currIdx] contributes to the final sum.
        //For every number, we have exactly two choices:
            //1. Add the number to the current sum
            //2. Subtract the number from the current sum
        
        //1️⃣ What does one level of recursion represent?
            //Each level represents fixing the sign (+ or -) for nums[currIdx].
            //Moving to dfs(currIdx + 1) means we have already decided the sign for all numbers
                //before currIdx and are now deciding for the next number.

        //2️⃣ What are my choices at that level?   
            //At each level, there are exactly two recursive branches:
                //i. Take nums[currIdx] as +nums[currIdx]
                //ii. Take nums[currIdx] as -nums[currIdx]

        //3️⃣ When do I stop?
            //When currIdx == nums.length, all numbers have been assigned a sign.
            //At this point, if currSum == target, we have found one valid way.
            //Return 1 for a valid way, otherwise return 0.

        //The final answer is the sum of valid ways from all branches of the recursion tree.



    //intuition 1 (self-thought): (Backtracking DFS):

    //1️⃣ What does one level of recursion represent?
        //Each digit from nums being processed 
        //dfs(currIdx + 1) -> currIdx + 1 represents going one level deep in recursion

    //2️⃣ What are my choices at that level?    
        //At each level we have two choices, either to choose the current digit as a positive number
            //or as a negative number
        //At each level there will be two recursive calls, one for positive currNum and one for negative
            //currNum

    //3️⃣ When do I stop?
        //When currIdx becomes equalt to nums.length. At this point, check if currSum is equal to target, 
            //if yes, increment your variable

    //TC: O(2^n): where n is the length of nums
    //SC: O(n): Length of recursive stack
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int currIdx, int currSum, int target){
        if(currIdx == nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }

        int currNum = nums[currIdx];
        // // "+currNum"
        // int positiveCount = dfs(nums, currIdx + 1, currSum + currNum, target);
        
        // // "-currNum"
        // int negativeCount = dfs(nums, currIdx + 1, currSum - currNum, target);
        
        
        currSum = currSum + currNum;
        int positiveCount = dfs(nums, currIdx + 1, currSum, target);
        currSum = currSum - currNum;


        currSum = currSum - currNum;
        int negativeCount = dfs(nums, currIdx + 1, currSum, target);
        currSum = currSum + currNum;

        return positiveCount + negativeCount;
    }
}