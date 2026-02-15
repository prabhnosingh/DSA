class Solution {

    //Re-solving on 15 Feb 2026

    //intuition 1: DP : 1D
        //Work backwards, start from top and see what options you have to reach there
        //We can have a dp array to store the min cost to reach each stair

        //then at each step we analayze and choose the minimum cost including current cost
            //and minimum of minimum cost to reach previous two steps
        //dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2])
    public int minCostClimbingStairs(int[] cost) {
        //dp[i] will represent minimum cost needed to reach top given i steps
        //dp[totalStairs-1] will represent min cost needed to reach top  
        //therefore, we need dp array of length totalStairs

        int totalStairs = cost.length;
        int[] dp = new int[totalStairs];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < totalStairs; i ++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[totalStairs - 1], dp[totalStairs - 2]); //this is becase we can jump 1
        //or 2 steps from last or second last step to reach top, and we should take the minimum of the
        //both
    }
}