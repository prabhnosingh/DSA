class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double maxSum = 0.0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while(end < nums.length){

            if(end >= k){
                sum -= nums[start];
                sum += nums[end];
                start ++;
                maxSum = Math.max(maxSum, sum);
                
            }
            else{
                sum += nums[end];
                maxSum = sum;
            }


            end ++;
        }
        
        return maxSum / k;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
///////////////////////////////////////////////////////////////////////////////////////////        
        // // beats 62.64 % (optimal)
        // int sum = 0;

        // for(int i = 0; i < k; i ++){
        //     sum += nums[i];
        // }
        // double maxSum = sum;
        // for(int i = k; i < nums.length; i ++){
        //     sum += nums[i] - nums[i - k];
        //     maxSum = Math.max(maxSum, sum);
        // }

        // return maxSum / k;
        


//************************************************************************* */
         // beats 43.46%
        // int[] sum = new int[nums.length];

        // sum[0] = nums[0];
        // for(int i = 1; i < nums.length; i ++){
        //     sum[i] = sum[i - 1] + nums[i];
        // }

        // double maxAvg = (sum[k - 1] * 1.0) / k;
 
        // for(int i = k; i < nums.length; i ++){
        //     maxAvg = Math.max((sum[i] - sum[i - k]) * 1.0 / k, maxAvg);
        // }

        // return maxAvg;

//************************************************************************** */
       // beats 5 %
        // int start = 0;
        // int end = k - 1;

        // int maxSum = Integer.MIN_VALUE;
        // double maxAvg = 0;
      
        // while(end < nums.length){
        //     int sum = 0;
        //     for(int i = start; i <= end; i ++){
        //         sum += nums[i];
        //     }
                  
        //         maxSum = Math.max(sum, maxSum);
       
           
    
        //     maxAvg = (double)maxSum / k;
        //     start ++;
        //     end ++;
        // }

        // return maxAvg;
    }
}