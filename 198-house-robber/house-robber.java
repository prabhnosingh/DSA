class Solution {
    //Re-solving on 06 Dec 2025:

    //intuition 1: 
    //Maintain a dp array that tracks the money stolen till now. At each step we have two choices, either to steal the 
        //house or not steal the house. 
    //dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]) => dp[i-1] is when we do not want to rob the current house at i
    // At last return max (dp[n-1], dp[n-2])
    public int rob(int[] nums) {
        //dp[i] will represent the max money stolen till now
        int nLen = nums.length;
        if(nLen == 1) return nums[0];
        int[] dp = new int[nLen];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for(int i = 2; i < nLen; i ++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return Math.max(dp[nLen - 1], dp[nLen - 2]);


    }
}