class Solution {

    //Re-solving on 01 Sept 2026

    //intuition 1: 
        //topic: DP
        //pattern: 1D DP
        //sub-pattern: pick not pick

        //at each state we have two choices, either we rob a house or we do not rob a house
        //the maximum amount of money robbed depends on the previous two states

        //we have two options to start with -
            //rob the first house 
            //or leave the first house 

            //this is crucial to track as based on that we can figure out if we can rob last house or not
        
        //So we can have two scenarios to begin with and then compute max money in each of them
            //in first scenario, when we do rob the first house, we can make the last house money as 0
            //in second scenario, when we do not rob the first house, we can make the first house money
                //as 0 


        //why DP?
            //DP makes sense here as we need optimized previous states in order to get the new optimal state
        
        //dp invariant
            //dp[i] will represent maximum money robbed from [0 .... i] house

            //therefore we would need a dp array of size n
        
        //base cases
            //dp[0] will be nums[0]
            //dp[1] will be max(nums[0], nums[1])
            //if n == 2 return 0 
        
        //recurrence relation
            //for each state we need previous two states

            //dp[i] = math.max(dp[i-2] + nums[i], dp[i-1])



    public int rob(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        //first scenario (first house robbed)
        int[] dp1 = new int[n];
        // nums[n-1] = 0; //last house made to have 0 money

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i ++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]); 
        }

        int max1 = dp1[n-2];

        //second scenario (last house robbed)
        int[] dp2 = new int[n];

        dp2[1] = nums[1]; //starting from nums[1]
        dp2[2] = Math.max(nums[1], nums[2]); 

        for(int i = 3; i < n; i ++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }

        int max2 = dp2[n-1];

        return Math.max(max1, max2);




    }























/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 18 Feb 2026
    
    // //intuition 1: DP : 1D DP
    //     //Implement the same solution as house robber I with additional check on first and 
    //         //house. => This does not work as expected. Instead have a helper function that takes
    //         //array as input and gives maximum robbable amount using House Robber I logic. Now
    //         //pass original array once from 0 to n-2 and once from 1 to n-1 and finally take the
    //         //maximum of the two. 
    //     //So basically consider two scenarios, first one when we do not have the last element and
    //         //the second one when we do not have the first element.
    //     //House robber I:
    //         //For each house we have two options, either to steal the current house + dp[i-2]
    //             //and leave the dp[i-1] loot or take the dp[i-1] loot and skip the current house.
    // public int rob(int[] nums) {
    //     //dp[i] represents maximum money robbed till house i
    //     //dp[nums.length-1] will represent maximum money robbed till house nums.length-1
    //     //Therefore, we need a dp array of length nums.length

    //     if(nums.length == 1) return nums[0];

    //     int skippingLast = maxRobbable(Arrays.copyOfRange(nums, 0, nums.length-1));
    //     int skippingFirst = maxRobbable(Arrays.copyOfRange(nums, 1, nums.length));

    //     return Math.max(skippingLast, skippingFirst);
    // }


    // private int maxRobbable(int[] nums){
    //     int houses = nums.length;

    //     if(houses == 1) return nums[0];

    //     int[] dp = new int[houses];

    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[0], nums[1]);

    //     if(houses == 2) return dp[1];

    //     for(int i = 2; i < houses; i ++){
    //         int rob = dp[i-2] + nums[i];
    //         int doNotRob = dp[i-1];

    //         dp[i] = Math.max(rob, doNotRob);
    //     }

    //     return dp[houses - 1];
    // }
}