class Solution {

    //Solving on 29 Aug 2026

    //intuition 1: 
        //Topic: DP
        //Pattern: 1D DP
        //Sub-pattern: Max/Min state tracking for contiguous subarrays

        //why DP?
            //main problem is to find optimal(largest) product of the whole array nums[0....n-1]
            //sub-problem is to find the optimal largest product of subarray nums[0...n-2]

            //Therefore, as each state depends on the previous state, we choose DP

        //dp invariant:
            
            //we would need two different states to track in order to get maximum product
                //maxProductDp array will track maximum product of a contiguous subarray ending at i 
                //minProductDp array will track minimum product of a contiguous subarray ending at i
            //minProductDp is needed as a large negative * large negative gives a large positive number
                //and we need to consider that
            
            //The final answer is the maximum value of maxProductDp[i] across all indices
            //Since maxProductDp and minProductDp can go till index n-1, we would need two arrays
                //of size n


        //base case
            //maxProductDp = nums[0]
            //minProductDp = nums[0]

        //recurrence relation
            //We have three possible ways for a contiguous subarray to end at index i:
                //1. start fresh
                //2. extend previous maximum: maxProductDp[i-1] * nums[i]
                //3. extend previous minimum: minProductDp[i-1] * nums[i]

            //For maxProductDp we take max of these three options and for minProductDp we take min of these
                //three options         

            //As we need previous state to compute next state, we will fill dp array while traversing from
                //left to right
            

            //TC: O(n)
            //SC: O(n)
            
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        if(n == 1) return nums[0];

        int maxProd = nums[0];

        int[] maxProductDp = new int[n];
        int[] minProductDp = new int[n];

        maxProductDp[0] = nums[0];
        minProductDp[0] = nums[0];
        
        for(int i = 1; i < n; i ++){
            
            //starting a new subarray
            int option1 = nums[i]; 

            //extending the previous subarray
            int option2 = maxProductDp[i-1] * nums[i];
            int option3 = minProductDp[i-1] * nums[i];

            maxProductDp[i] = Math.max(option1, Math.max(option2, option3)); //max of three options
            minProductDp[i] = Math.min(option1, Math.min(option2, option3)); //min of three options

            maxProd = Math.max(maxProd, maxProductDp[i]); 

        }

        return maxProd;


    }
}