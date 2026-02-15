class Solution {

    //Resolving on 15 Feb 2026

    //intuition 1: DP : 1D DP
        //Distinct ways to climb to the top will depend on previous two states.
            //Eg, to reach nth step (top) we have two options, either to jump two steps from
                //n-2th step or jump 1 step from n-1th step.
            //In first way total number will be number of ways to reach n-2th step
            //In second way total number will be number of ways to reach n-1th step
            //Therefore total number of ways to reach nth step is dp[n-2] + dp[n-1]
    public int climbStairs(int n) {
        //dp[i] will represent number of ways to reach ith level
        //Our answer will lie at dp[n], therefore we need a dp array of size n + 1

        if(n == 1) return 1; //there is only 1 way to reach 1st step, i.e. to take 1 step from
            //0th level
        
        if(n == 2) return 2; //there are two ways to reach 2nd step, i.e. to take 2 steps from 
            //0th level or take 1 step to 1st level and then from there 1 step to 2nd level 

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i < n+1; i ++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n];

    }











































/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 11 Dec 2025:

//     //intuition 1 (DP : bottom up : space optimized): To compute the number of distinct ways to climb to the n level, we can
//         //use the answers for previous 2 levels (n-1 and n-2) as at any time we can take 1 step or
//         //2 steps to reach to current level, so if we add the number of ways to reach the previous 
//         //levels, we will get the total ways to reach the current level.
        
//         //This way we will break the problem into subproblems
//     public int climbStairs(int n) {
//         //curr will represent the number of ways to reach the top level

//         int prevPrev = 1; //level 0
//         int prev = 1; //level 1

//         if(n == 1){
//             return prev;
//         }
//         int curr = 0;
//         for(int i = 2; i <=n ; i ++){
//             curr = prevPrev + prev;

//             prevPrev = prev;
//             prev = curr;
//         }

//         return curr;
//     }











































// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 05 Dec 2025:

//     //intuition 2 (dp: space optmized): 
//     //Total ways to reach top by taking i steps will be the addition of (total ways to reach i - 1 steps) + (total
//         //ways to reach i - 2 steps). Because there are two ways to reach ith step:
//             //1. Either jump 1 from step i - 1
//             //2. Or jump 2 from step i - 2 (jump form "i - 2 to i - 1 to i" is already covered in the total ways to jump from i - 1)
//     public int climbStairs(int n) {
//         if(n == 1 || n == 2) return n;


//         int prevPrevStepWays = 1;
//         int prevStepWays = 2;

//         int currStepWays = 0;
//         for(int i = 3; i < n + 1; i ++){
//             currStepWays = prevStepWays + prevPrevStepWays; 

//             prevPrevStepWays = prevStepWays;
//             prevStepWays = currStepWays;           
//         }

//         return currStepWays;    
//     }


// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 05 Dec 2025:

    // //intuition 1 (dp: array): 
    // //Total ways to reach top by taking i steps will be the addition of (total ways to reach i - 1 steps) + (total
    //     //ways to reach i - 2 steps). Because there are two ways to reach ith step:
    //         //1. Either jump 1 from step i - 1
    //         //2. Or jump 2 from step i - 2 (jumpt form "i - 2 to i - 1 to i" is already covered in the total ways to jump from i - 1)
    // public int climbStairs(int n) {
    //     //dp[i] will represent the total ways to climb to top when steps are i

    //     int[] dp = new int[n + 1]; 

    //     // dp[0] = 1;
    //     if(n == 1) return 1;
    //     dp[1] = 1;
    //     dp[2] = 2;

    //     for(int i = 3; i < n + 1; i ++){
    //         dp[i] += dp[i - 1];
    //         dp[i] += dp[i - 2];

    //     }

    //     return dp[n];

    // }

























































/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 02 Dec 2025:

    // //intuition 2(Space-optimized DP: using three pointers): At every step we have two options, 
    // //either to take 1 step or 2 step. 
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
    //     int prevPrev = 1; //n == 0
    //     int prev = 1; //n == 1
    //     if(n == 1) {
    //         return 1;
    //     }
    //     int curr = prevPrev + prev;
    //     for(int i = 3; i <= n; i ++){
    //         prevPrev = prev;
    //         prev = curr;
    //         curr = prevPrev + prev;
    //     }

    //     return curr;
        

    // }


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