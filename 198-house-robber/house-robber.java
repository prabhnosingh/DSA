class Solution {
    //Re-solving on 06 Dec 2025:

    //intuition 1: 
    //Maintain a dp array that tracks the money stolen till now. At each step we have two choices, either to steal the 
        //house or not steal the house in order and continue with the current money we have stolen. Eg: In case of 
        //nums = [2, 1, 1, 2], after stealing nums[0] we have 2 money, now if we want to steal nums[1] we will have 1
        //money and in that case we will have to drop nums[0] money (2) to avoid alarming the police, so in this case
        //we will simply not steal the house nums[1] and keep the nums[0] money with us. So max money till now is 2.
        //Now we move to nums[2] house, which have money 1. Now as we have not stolen house nums[1], it is safe to 
        //steal from nums[2] house, so now we will have 2 + 1 = 3 money. Now we reach house nums[3], which have 2 money.
        //Now we have two choices either drop the money that we just stole from nums[2] and steal the money from nums[3]
        //to have a total of 2 + 2  = 4 money or keep the money from nums[2] (3) and do not steal the money from 
        //nums[3], in which case we will have total of 3 money. We will go with stealing the nums[3] in order to 
        //have max money stolen as 4.

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

        // return Math.max(dp[nLen - 1], dp[nLen - 2]);
        return dp[nLen - 1];


    }
}