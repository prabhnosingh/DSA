class Solution {
    
    //Resolving on 21 Dec 2025:
        //intuition 1 (DP: Kadane's algo):

            //We re-initialize currSum to 0 if it is negative because we don't want negatives to accumulate.
            //-1 + (-3) = -4 and -4 is smaller than -1, so we don't want it
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int num : nums){
            currSum += num;

            maxSum = Math.max(maxSum, currSum);

            currSum = currSum < 0 ? 0 : currSum;
        }
        return maxSum;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    
    // public int maxSubArray(int[] nums) {

    //     int[] dp = new int[nums.length];
    //     int maxSum = nums[0];
    //     dp[0] = nums[0];
    //     for(int i = 1; i < nums.length; i ++){
    //         dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

    //         if(dp[i] > maxSum){
    //             maxSum = dp[i];
    //         }
    //     }
    //     return maxSum;



//*******************************************************************/
       //beats 100 % Kadane Algo(best)
        // int maxSum = Integer.MIN_VALUE;
        // int sum = 0;
        // for(int i = 0; i < nums.length; i ++){
        //     sum += nums[i];

        //     maxSum= Math.max(sum, maxSum);

        //     if(sum < 0){
        //         sum = 0;
        //     }
        // }

        // return maxSum;
    // }

}