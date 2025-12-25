class Solution {

    //Re-solving on 25 Dec 2025:

    //intuition 1: (1D: DP: LIS pattern)
        //We maintain a DP array that will store the longest increasing subsequence found till now 
            //while traversing the nums array. For each number currNum in nums, we find if a lower
            //bound (first element greater than equal to) of currNum exists in the dp array. If we 
            //find a lower bound of currNum in dp array, we replace it with currNum. This is done in
            //order to add more increasing numbers in the future.
        //We find the lower bound idx with binary search (logn)
        //base case: if nums is of length 1, LIS is of length 1. Have dp[0] = nums[0]

    public int lengthOfLIS(int[] nums) {
        //dpLIS[i] represent smallest tail possible of increasing subsequence of length i + 1
        //Length of dpLIS at the end of the algo will give us longest increasing subsequence for nums array
        //Longest possible subsequence can be of length nums.length.
        //Therefore, we need a 1D dp array of length nums.length

        int numsLen = nums.length;
        int[] dpLIS = new int[numsLen];

        //base case
        dpLIS[0] = nums[0];
        int currLISLength = 1;
        for(int i = 1; i < numsLen; i ++){
            int currNum = nums[i];
            int lowerBoundIdxInDpLIS = findLowerBoundIdxInDpLIS(dpLIS, currNum, currLISLength);

            if(lowerBoundIdxInDpLIS == -1){ //no lower bound found in dpLIS. Add currNum at last of dpLIS,
                //increasing its size by 1
                dpLIS[currLISLength ++] = currNum;
            }
            else{
                dpLIS[lowerBoundIdxInDpLIS] = currNum;
            }
        
        }

        return currLISLength;
    }

 
    private int findLowerBoundIdxInDpLIS(int[] dpLIS, int currNum, int currLISLength){
        int start = 0;
        int end = currLISLength - 1;
        int lowerBoundIdx = -1;
        while(start <= end){
            int mid = end - ((end - start) / 2);

            if(dpLIS[mid] >= currNum){ //probable lower bound found
                lowerBoundIdx = mid;
                end = mid - 1; //we want the first largest number's idx and since dpLIS is sorted in ascending order
                    //we move towards left to find the first largest number
            }
            else{
                start = mid + 1;
            }
        }

        return lowerBoundIdx;

    }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 22 Dec 2025:

    // //intuition 1: (1D DP: Longest Increasing Subsequence (LIS) pattern : Patience sort O(nlogn))
    //     //Maintain an LIS array while traversing nums array from left to right:
    //         //if lower bound of currNum (i.e. first element E to satisfy E >= currNum) is present 
    //             //in LIS array, then replace E with currNum.
    //             //“Replacing keeps subsequence length the same but makes its tail smaller, increasing
    //                 //the chance of extending it later.”
    //         //else, if no lower bound of currNum is present in the current LIS, add the currNum to the 
    //             //last of current LIS, increasing the size of LIS
    //         //Apply binary search in finding the lower bound of currNum

    //         //“dpLIS does not store the actual LIS.
    //         //It only stores the smallest possible tail for each subsequence length, which is sufficient
    //             //to compute the length of LIS.”

    // public int lengthOfLIS(int[] nums) {
    //     //dpLIS[i] represent tail element of longest subsequence of length i + 1
    //     //dpLIS[numsLen - 1] will represent tail element of longest subsequence of length numsLen (longest possible)
    //     //Therefore, we need 1D dp array of length nums.length  

    //     int numsLen = nums.length;
    //     int[] dpLIS = new int[numsLen];

    //     dpLIS[0] = nums[0];
    //     int currDPLISSize = 1;

    //     for(int i = 1; i < numsLen; i ++){
    //         int lowerBoundIdxInDPLIS = findLowerBoundIdx(nums[i], dpLIS, currDPLISSize);

    //         if(lowerBoundIdxInDPLIS == -1){ //no lower bound of nums[i] found in dpLIS
    //             dpLIS[currDPLISSize ++] = nums[i]; //increase size of dpLIS
    //         }
    //         else{ //replace the element in dpLIS at lower bound idx found with nums[i] 
    //             if(lowerBoundIdxInDPLIS < currDPLISSize - 1){
    //                 continue; //do not replace the dpLIS[lowerBoudIdxDPLIS] number if lower bound idx is less
    //                     //than currsize to maintain a valid LIS in dpLIS
    //             }
    //             dpLIS[lowerBoundIdxInDPLIS] = nums[i];
    //         }
    //     }
    //     return currDPLISSize;

    // }

    // private int findLowerBoundIdx(int currNum, int[] dpLIS, int currSize){
    //     int start = 0;
    //     int end = currSize - 1;

    //     int currLowerBoundIdx = -1;

    //     while(start <= end){
    //         int mid = (start + end) / 2;
    //         if(dpLIS[mid] >= currNum){
    //             currLowerBoundIdx = mid; 
    //             end = mid - 1; //find more smaller lowerbound of currNum 
    //         }
    //         else{
    //             start = mid + 1;
    //         }

    //     }
    //     return currLowerBoundIdx;
    // }
































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 21 Dec 2025:

//     //intuition 2: DP on lengths (Patience sorting idea) — O(n log n)
//         //Have an array named dpLIS. dpLIS[i] will be storing the smallest possbile tail of an increasing subsequence
//             //of length i+1. Using lowerbound concept, for every element check if there exists a lower bound (first >=) 
//             //of that element in dpLIS using binary search upto current size. If yes, replace  the lowerbound element 
//             //found with the current element. If there is no lower bound of the current element, insert the current
//             //element at the last of dpLIS (size + 1).

//         //Why “lower bound (≥)” and not “>”, because:
//             //-LIS is strictly increasing
//             //-Equal elements cannot extend the subsequence
//             //-So equal values must replace existing tail, instead of appending

//         //Conceptual clarifications:
//             //dpLIS stores optimal tails
//             //its length (currSize) equals LIS length
//             //The actual LIS sequence is not directly recoverable from this array
        
//         //TC: O(nlogn)
//         //SC: O(n)
//     public int lengthOfLIS(int[] nums) {
//         //dpLIS[i] represents smallest possible tail (last value) of an increasing subsequence of length i+1.
//         //Maximum possible length of LIS could be of length numsLen with smallest tail at index dpLIS[numsLen-1]
//         //Therefore, we need a dp 1D array of size numsLen.

//         int numsLen = nums.length;
//         int[] dpLIS = new int[numsLen];
//         dpLIS[0] = nums[0];
//         //forgot to put semicolon at above line : did not proof read your code
//         int currSize = 1;  
//         //currSize tracks how many elements have been inserted in the dpLIS

//         for(int i = 1; i < numsLen; i ++){
//             int lowerBoundIdx = findLowerBound(dpLIS, nums[i], currSize);

//             if(lowerBoundIdx == -1){//i.e. no lower bound element found in dpLIS. In this case add nums[i] 
//             //at currSize + 1 index in dpLIS
//                 dpLIS[currSize ++] = nums[i];
//             }
//             else{ //a lower bound element was found at lowerBoundIdx. In this case replace nums[i] with
//             //element at dpLIS[lowerBoundIdx]
//                 dpLIS[lowerBoundIdx] = nums[i];
//             }
//         }

//         return currSize;

//     }

//     //finding the index of first element that is greater than equal to num
//     private int findLowerBound(int[] dpLIS, int num, int currSize){
//         int start = 0;
//         int end = currSize - 1;

//         int lowerBoundIdx = -1;
//         while(start <= end){
//             int mid = (start + end) / 2;
//             //int mid = end - ((end - start) / 2);
//             if(dpLIS[mid] >= num){
//                 lowerBoundIdx = mid; //we have found a probable lowerBound index
//                 end = mid - 1; //we know that dpLIS is sorted array and if we have found an element at mid that is
//                 //greater than or equal to num, then there is a possibility that there could be some other element
//                 //that is greater than or equal to num on the left side of mid, so we do end = mid - 1
//             }
//             else{ //if(num > dpLIS[mid]), given that dpLIS is sorted array, look towards right
//                 start = mid + 1;
//             }
//         }
//         return lowerBoundIdx;
//     }




// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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