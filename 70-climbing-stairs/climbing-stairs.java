class Solution {

    //Re-solving on 02 Dec 2025:

    //intuition 2(Space-optimized DP: using three pointers): At every step we have two options, 
    //either to take 1 step or 2 step. 
        //At each step i the number of possible steps to reach i are combinations to reach [i-1] 
            //step + combinations to reach [i-2] step
        //As from i-2 step we can go either i-1 (1 step) or i (2 steps), and from i-1 step 
            //can only go to i (1 step). Hence, in total 3 ways. If we take 2 steps from i-1
            //step, then we will reach i+1 step, which is out of bounds. 

    //Combinations to reach at a particular stair depends on previous two stair combinations, becuase
        //to reach a paricular stair, we can only come from previous two steps because we are only
        //allowed to either take 1 step or 2 steps

    // When i == 0, there are total of 1 ways to reach at top: There is only 1 way to stay at top.
        //Doing nothing is also 1 way

    public int climbStairs(int n) {
        int prevPrev = 1; //n == 0
        int prev = 1; //n == 1
        if(n == 1) {
            return 1;
        }
        int curr = prevPrev + prev;
        for(int i = 3; i <= n; i ++){
            prevPrev = prev;
            prev = curr;
            curr = prevPrev + prev;
        }

        return curr;
        

    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 02 Dec 2025:

    // //intuition 1 (Tabulation DP): At every step we have two options, either to take 1 step or 2 step. 
    //     //At each step i the number of possible steps to reach i are combinations to reach [i-1] 
    //         //step + combinations to reach [i-2] step
    //     //As from i-2 step we can go either i-1 (1 step) or i (2 steps), and from i-1 step 
    //         //can only go to i (1 step). Hence, in total 3 ways. If we take 2 steps from i-1
    //         //step, then we will reach i+1 step, which is out of bounds. 

    // //Combinations to reach at a particular stair depends on previous two stair combinations, becuase
    //     //to reach a paricular stair, we can only come from previous two steps because we are only
    //     //allowed to either take 1 step or 2 steps

    // // When i == 0, there are total of 1 ways to reach at top: There is only 1 way to stay at top.
    //     //Doing nothing is also 1 way
    // public int climbStairs(int n) {
    //     //dp[i] -> no. of ways to reach ith stairs
    //     if(n == 1) {
    //         return 1;
    //     }
    //     int[] dp = new int[n + 1];
    //     dp[1] = 1;
    //     dp[2] = 2;
    //     for(int i = 3; i <= n; i ++){
    //         dp[i] = dp[i - 1] + dp[i -2];
    //     }
    //     return dp[n];
    // }
}