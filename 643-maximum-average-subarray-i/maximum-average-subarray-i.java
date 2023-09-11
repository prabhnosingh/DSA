class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k - 1;

        int maxSum = Integer.MIN_VALUE;
        double maxAvg = 0;
        boolean neg = false;
        while(end < nums.length){
            int sum = 0;
            for(int i = start; i <= end; i ++){
                sum += nums[i];
            }
            if(nums.length != 1){
             
                maxSum = Math.max(sum, maxSum);
            }
            else{
                maxSum = sum;
            }
    
            maxAvg = (double)maxSum / k;
            start ++;
            end ++;
        }

        return maxAvg;
    }
}