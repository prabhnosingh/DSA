class Solution {

    //Solving on 21 Dec 2025:

    //intuition 1: (1D DP : LIS pattern)
        //Store the LIS possible at each index in the corresponding index of dp array
        //At each index travel back (till 0) and see if there is any number that is smaller than current
            //num. If a smaller number is encountered at i-x, then take LIS possible at i-x from dp[i-x] 
            //and take the max of all such small numbers. 
        //Recurrence relation: dp[i] = 1; dp[i] += dp[i-x]
        //Base case: for 1st element at 0 index, only LIS possible is of length 1 

    public int lengthOfLIS(int[] nums) {
        //dp[i] represents the length of longest increasing subsequence including num at i index
        //We will be travelling till n-1 index where n is the length of nums    
        //Therefore, we need a 1D DP array of length n

        int numsLen = nums.length;
        int[] dp = new int[numsLen];
        int ansLIS = 1;

        dp[0] = 1;
        for(int i = 1; i < numsLen; i ++){
            int prevMaxLIS = 0;
            for(int j = i - 1; j >= 0; j --){
                if(nums[j] < nums[i]){
                    prevMaxLIS = Math.max(prevMaxLIS, dp[j]);
                }
            }
            // dp[i] = Math.max(dp[i-1], 1 + prevMaxLIS);
            dp[i] = 1 + prevMaxLIS;
            ansLIS = Math.max(dp[i], ansLIS);
        }

        return ansLIS;
    }
}