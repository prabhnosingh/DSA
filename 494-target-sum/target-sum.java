class Solution {
    //Solving on 16 Dec 2025:

    //intuition 1: (Backtracking DFS):

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
        // "+currNum"
        int positiveCount = dfs(nums, currIdx + 1, currSum + currNum, target);

        // "-currNum"
        int negativeCount = dfs(nums, currIdx + 1, currSum - currNum, target);

        return positiveCount + negativeCount;
    }
}