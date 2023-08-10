class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int len = cost.length;
        int first = cost[len-1];
        int second = Math.min(cost[len - 2], first + cost[len - 2]); 
        int i = len - 3;

        while(i >=0){
            int temp = second;
            second = Math.min(cost[i] + first, cost[i] + second);
            first = temp;
            i --;

        }

        return Math.min(first, second);




















        
//***************************************************************************************** */        
        // int len = cost.length;
        // int[] dp = new int[len];

        // dp[len - 1] = cost[len - 1];
        // dp[len - 2] = Math.min(cost[len - 2], cost[len - 2] + cost[len - 1]);
        
        // for(int i = len - 3; i >= 0; i--){
        //     dp[i] = Math.min(cost[i] + dp[i+1], cost[i] + dp[i + 2]);
        // }

        // int ans = dp[0];
        // if(dp[1] < dp[0]) ans = dp[1];
        
        // return ans;
    }
}