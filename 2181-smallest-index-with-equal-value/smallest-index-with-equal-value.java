class Solution {
    //Solving on 04 July 2026

    //intuition 1 (brute force): Run a for loop and check the logic for all the numbers and
        //return the first encountered index 
    public int smallestEqual(int[] nums) {
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == (i % 10)){
                return i;
            }
        }

        return -1;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1 (brute force): Run a for loop and check the logic for all the numbers and
    //     //return the first encountered index 
    // public int smallestEqual(int[] nums) {
    //     for(int i = 0; i < nums.length; i ++){
    //         if(nums[i] == (i % 10)){
    //             return i;
    //         }
    //     }

    //     return -1;
    // }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   ///////////////////////////////////////////////////////////////////////////////////////////// 
    
    
    
    
    // //intuition 1: Start from index 0, the first index to match the condition is the answer
    // public int smallestEqual(int[] nums) {
    //     int minIdx = Integer.MAX_VALUE;
    //     for(int i = 0; i < nums.length; i ++){
    //         if(i % 10 == nums[i]){
    //             // minIdx = Math.min(minIdx, i);
    //             return i;
    //         }
    //     }
    // // return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    // return -1;
    // }
}