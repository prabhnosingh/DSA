class Solution {


    public int computeMaxRob(int[] arr){

        if(arr.length == 1){
            return arr[0];
        }
        int n = arr.length;
        int[] dp = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < n; i++){

            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }

        return dp[n-1];
    }
    public int rob(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        int one = computeMaxRob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int two = computeMaxRob(Arrays.copyOfRange(nums, 1, nums.length));
       return Math.max(one, two);
        
    }
}