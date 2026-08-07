class Solution {
   
    //Solving on 06 Aug 2026

    //intuition 1: Binary search
        //Run normal binary search
        //see if nums[mid] < nums[mid+1] - move the left to mid + 1 (probable peak at mid + 1)
        //if nums[mid] > nums[mid+1] - move the right to mid (probable peak at mid)
        
        //0 1 2 3 4 5 6
        //1 2 1 6 7 8 9 -> in this test case there are two probable answers 0 idx (2) or 6 idx (9)
            //6 idx can be one of the answer as 5 < 6 and anything outside boudary of the array is also -INF
            //with the below apporach 6 idx will be our answer
    public int findPeakElement(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            int currMid = nums[mid];
            if(currMid < nums[mid + 1]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;

    }























    /////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    //intuition 1: the constraints say that the algo should run in O(log n), which means binary
    //search will be used in this problem.
    
    //brute force approach would be to traverse the array and compare each element with its 
    //neighbors and see if it is a peak element
    // public int findPeakElement(int[] nums) {
    //     if(nums.length == 2){
    //         return nums[0] > nums[1] ? 0 : 1;
    //     }
    //     for(int i = 1; i < nums.length - 1; i ++){
    //         if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
    //             return i;
    //         }
    //         if(i + 1 == nums.length - 1){
    //             if(nums[i + 1] > nums[i]){
    //                 return i + 1;
    //             }
    //         }
    //     }
    //     return 0;    
    // }
    /////////////////////////////////////////////////////////////////////////////////
    //intuition 2 (Brute force): Simply finding max element can also give the answer 
    // public int findPeakElement(int[] nums) {
    //     int maxIdx = 0;
    //     int maxNum = Integer.MIN_VALUE;


    //     for(int i = 0; i < nums.length; i ++){
    //         if(nums[i] > maxNum){
    //             maxIdx = i;
    //             maxNum = nums[i];
    //         }
    //     }

    //     return maxIdx;   
    // }

    ///////////////////////////////////////////////////////////////////////////////////
    // //intuition 3 (Binary Search): The logic is to start from left = 0 and right = nums.length - 1
    // //then apply normal binary search with moving left = mid + 1 if mid + 1 element > mid element
    // //as that means mid is for sure not our probable peak else if mid + 1 element < mid
    // //element (means the mid could be our probable peak)
    // public int findPeakElement(int[] nums) {
    //     int left = 0;
    //     int right = nums.length - 1;

    //     while(left < right){
    //         int mid = (left + right) / 2;

    //         if(nums[mid] < nums[mid + 1]){
    //             left = mid + 1;
    //         }
    //         else{
    //             right = mid;
    //         }
    //     }

    //     return left;
    // }

} 