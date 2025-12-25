class Solution {
    

    //Resolving on 25 Dec 2025:
        //intuition 1(Divide and conquer):
            //For any array there are three ways a maximum sum can exist:
                //1. Maximum sum is on left subarray
                //2. Maximum sum is on right subarray
                //3. Maximum sum exists in the middle (i.e. left + right => whole array): Max subarray crossing the midpoint
                    //“Maximum subarray may cross the midpoint, meaning it includes elements from both left 
                        //and right halves and must touch the midpoint.”
                    //"Crossing subarrays are built outward from the midpoint, not inward from the edges."
                    //"Why the loop direction matter?"
                        //“Because the crossing subarray must touch the midpoint. Iterating from mid outward guarantees
                            //every candidate includes mid, while iterating from start does not.”

                    //"A crossing subarray must:
                        //-end exactly at mid on the left side
                        //-start exactly at mid + 1 on the right side"
            
            //We will use a recursive helper function to find these three sums and return the max
            //At any point of time, we choose max of the three sums and return it


            //TC: O(nlogn)
    public int maxSubArray(int[] nums) {
    
        return helper(0, nums.length - 1, nums);

    }


    private int helper(int start, int end, int[] nums){
        if(start == end){
            return nums[start];
        }

        int mid = (start + end) / 2;

        int sum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        //computing the left maxSum 
        //"This finds the maximum suffix sum that ends at mid."
        for(int i = mid; i >= start; i --){
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }

        //computing the right maxSum
        int rightMaxSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid + 1; i <= end; i ++){
            sum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, sum);
        }

        int leftRightMaxSum = Math.max(helper(start, mid, nums), 
                                    helper(mid + 1, end, nums)); //gives the max of left and right subarray sums

        return Math.max(leftRightMaxSum, leftMaxSum + rightMaxSum);
    }



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Resolving on 25 Dec 2025:
    //     //intuition 1(Kadane's algo):
    //         //Intialize maxSum and currSum variables to 0. 
    //         //maxSum will track the ans and currSum will track the current sum. Now add every number we get while
    //             //traversing the array to currSum. If at any point currSum goes negative, reinitialize it to 0.
    //         //This works because we don't want to add any number to a negative currSum:
    //             //if next num is positive: currSum will be increased by num and decreased by currSum's previous 
    //                 //negative value
    //             //if next num is negative: currSum will be decreased by num further
            
    //         //TC: O(n)
    // public int maxSubArray(int[] nums) {
    //     int maxSum = Integer.MIN_VALUE;
    //     int currSum = 0;

    //     for(int num : nums){
    //         currSum += num;

    //         maxSum = Math.max(maxSum, currSum);
    //         if(currSum < 0) currSum = 0;     
    //     } 
        
    //     return maxSum;
    // }





























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