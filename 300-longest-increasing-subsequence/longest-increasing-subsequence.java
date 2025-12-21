class Solution {

    //Solving on 21 Dec 2025:

    //intuition 2: DP on lengths (Patience sorting idea) — O(n log n)
        //Have an array named dpLIS. dpLIS[i] will be storing the smallest possbile tail of an increasing subsequence
            //of length i+1. Using lowerbound concept, for every element check if there exists a lower bound (first >=) 
            //of that element in dpLIS using binary search upto current size. If yes, replace  the lowerbound element 
            //found with the current element. If there is no lower bound of the current element, insert the current
            //element at the last of dpLIS (size + 1).

        //Why “lower bound (≥)” and not “>”, because:
            //-LIS is strictly increasing
            //-Equal elements cannot extend the subsequence
            //-So equal values must replace existing tail, instead of appending

        //Conceptual clarifications:
            //dpLIS stores optimal tails
            //its length (currSize) equals LIS length
            //The actual LIS sequence is not directly recoverable from this array
        
        //TC: O(nlogn)
        //SC: O(n)
    public int lengthOfLIS(int[] nums) {
        //dpLIS[i] represents smallest possible tail (last value) of an increasing subsequence of length i+1.
        //Maximum possible length of LIS could be of length numsLen with smallest tail at index dpLIS[numsLen-1]
        //Therefore, we need a dp 1D array of size numsLen.

        int numsLen = nums.length;
        int[] dpLIS = new int[numsLen];
        dpLIS[0] = nums[0];
        //forgot to put semicolon at above line : did not proof read your code
        int currSize = 1;  
        //currSize tracks how many elements have been inserted in the dpLIS

        for(int i = 1; i < numsLen; i ++){
            int lowerBoundIdx = findLowerBound(dpLIS, nums[i], currSize);

            if(lowerBoundIdx == -1){//i.e. no lower bound element found in dpLIS. In this case add nums[i] 
            //at currSize + 1 index in dpLIS
                dpLIS[currSize ++] = nums[i];
            }
            else{ //a lower bound element was found at lowerBoundIdx. In this case replace nums[i] with
            //element at dpLIS[lowerBoundIdx]
                dpLIS[lowerBoundIdx] = nums[i];
            }
        }

        return currSize;

    }

    //finding the index of first element that is greater than equal to num
    private int findLowerBound(int[] dpLIS, int num, int currSize){
        int start = 0;
        int end = currSize - 1;

        int lowerBoundIdx = -1;
        while(start <= end){
            int mid = (start + end) / 2;
            //int mid = end - ((end - start) / 2);
            if(dpLIS[mid] >= num){
                lowerBoundIdx = mid; //we have found a probable lowerBound index
                end = mid - 1; //we know that dpLIS is sorted array and if we have found an element at mid that is
                //greater than or equal to num, then there is a possibility that there could be some other element
                //that is greater than or equal to num on the left side of mid, so we do end = mid - 1
            }
            else{ //if(num > dpLIS[mid]), givent that dpLIS is sorted array, look towards right
                start = mid + 1;
            }
        }
        return lowerBoundIdx;
    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 21 Dec 2025:

    // //intuition 1: (1D DP : LIS pattern)
    //     //Store the LIS possible at each index in the corresponding index of dp array
    //     //For each index i, consider all previous indices j < i (till 0) and see if there is any number that is 
    //         //smaller than current num. If a smaller number is encountered at j, then take LIS possible at j
    //         //from dp[j] and take the max of all such small numbers. 
    //     //Recurrence relation: dp[i] = 1 + max(dp[j]) for all j < i where nums[j] < nums[i] 
    //     //Base case: for 1st element at 0 index, only LIS possible is of length 1 
    //     //Keep track of LIS encountered at each index since LIS can end at any position

    //     //TC: O(n^2)
    //     //SC: O(n)
    // public int lengthOfLIS(int[] nums) {
    //     //dp[i] represents the length of longest increasing subsequence including num at i index
    //     //"dp[i] represents the length of longest increasing subsequence that ends at i index (including nums[i])"
    //     //We will be travelling till n-1 index where n is the length of nums    
    //     //Therefore, we need a 1D DP array of length n

    //     int numsLen = nums.length;
    //     int[] dp = new int[numsLen];
    //     int ansLIS = 1;

    //     dp[0] = 1;
    //     for(int i = 1; i < numsLen; i ++){
    //         int prevMaxLIS = 0;
    //         for(int j = i - 1; j >= 0; j --){
    //             if(nums[j] < nums[i]){
    //                 prevMaxLIS = Math.max(prevMaxLIS, dp[j]);
    //             }
    //         }
    //         // dp[i] = Math.max(dp[i-1], 1 + prevMaxLIS);
    //         dp[i] = 1 + prevMaxLIS;
    //         ansLIS = Math.max(dp[i], ansLIS);
    //     }

    //     return ansLIS;
    // }
}