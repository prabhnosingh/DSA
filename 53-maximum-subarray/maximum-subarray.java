class Solution {
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);

            if(dp[i] > maxSum){
                maxSum = dp[i];
            }
        }
        return maxSum;



//********************************************************** */
       //beats 100 % 
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
    }
}