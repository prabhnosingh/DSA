class Solution {
    

    //Resolving on 25 Dec 2025:
        //intuition 1(Kadane's algo):
            //Intialize maxSum and currSum variables to 0. 
            //maxSum will track the ans and currSum will track the current sum. Now add every number we get while
                //traversing the array to currSum. If at any point currSum goes negative, reinitialize it to 0.
            //This works because we don't want to add any number to a negative currSum:
                //if next num is positive: currSum will be increased by num and decreased by currSum's previous 
                    //negative value
                //if next num is negative: currSum will be decreased by num further
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int num : nums){
            currSum += num;

            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0) currSum = 0;     
        } 
        
        return maxSum;
    }





























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Resolving on 21 Dec 2025:
    //     //intuition 1 (DP: Kadane's algo):
    //         //Have a maxSum variable initialized to -INF and a currSum variable initialized to 0.
    //         //Iterate over the numbers in nums and add the current num to currSum and update maxSum if smaller
    //             //than currSum.
    //         //We re-initialize currSum to 0 if it is negative because we don't want negatives to accumulate.
    //         //-1 + (-3) = -4 and -4 is smaller than -1, so we don't want it
    // public int maxSubArray(int[] nums) {
    //     int maxSum = Integer.MIN_VALUE;
    //     int currSum = 0;

    //     for(int num : nums){
    //         currSum += num;

    //         maxSum = Math.max(maxSum, currSum);

    //         currSum = currSum < 0 ? 0 : currSum;
    //     }
    //     return maxSum;
    // }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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