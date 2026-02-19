class Solution {

    //Re-solving on 18 Feb 2026
    
    //intuition 1: DP : 1D DP
        //Implement the same solution as house robber I with additional check on first and 
            //house. => This does not work as expected. Instead have a helper function that takes
            //array as input and gives maximum robbable amount using House Robber I logic. Now
            //pass original array once from 0 to n-2 and once from 1 to n-1 and finally take the
            //maximum of the two. 
        //So basically consider two scenarios, first one when we do not have the last element and
            //the second one when we do not have the first element.
        //House robber I:
            //For each house we have two options, either to steal the current house + dp[i-2]
                //and leave the dp[i-1] loot or take the dp[i-1] loot and skip the current house.
    public int rob(int[] nums) {
        //dp[i] represents maximum money robbed till house i
        //dp[nums.length-1] will represent maximum money robbed till house nums.length-1
        //Therefore, we need a dp array of length nums.length

        if(nums.length == 1) return nums[0];

        int skippingLast = maxRobbable(Arrays.copyOfRange(nums, 0, nums.length-1));
        int skippingFirst = maxRobbable(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(skippingLast, skippingFirst);
    }


    private int maxRobbable(int[] nums){
        int houses = nums.length;

        if(houses == 1) return nums[0];

        int[] dp = new int[houses];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        if(houses == 2) return dp[1];

        for(int i = 2; i < houses; i ++){
            int rob = dp[i-2] + nums[i];
            int doNotRob = dp[i-1];

            dp[i] = Math.max(rob, doNotRob);
        }

        return dp[houses - 1];
    }
}