class Solution {

    //Re-solving on 02 Dec 2025:

    //intuition 1: At every step we have two options, either to take 1 step or 2 step. 
        //If we can take 1 step, add 1 to the total ways
        //If we can take 2 steps add 1 to the total ways
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i ++){
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }
}