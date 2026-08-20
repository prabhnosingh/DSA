class Solution {

    //Solving on 20 Aug 2026

    //intuition 2 (without dp aray): 
        //Topic: DP
        //Pattern:
        //Sub-pattern:
        
        //At each step we have 2 options,
            //either to jump at full capacity 
            //or to jump at less capacity
        
        //start from the last index and fill a boolean dp array towards first index 
            //if a jump from index i can help us reach to last index, then any index
                //j that can reach to index i can help us reach to last index 
            //track the last true index using a variable and see if current nums[i] + i
                //is greater than equal to lastTrueIdx
            //at last see if lastTrueIdx == 0

       

        //TC: O(n)
        //SC: O(1)
    public boolean canJump(int[] nums) {
        
        int numsLen = nums.length;

        int lastTrueIdx = numsLen - 1;

        for(int i = numsLen - 2; i >= 0; i --){
            if(nums[i] > 0 && (i + nums[i]) >= lastTrueIdx){ //if nums[i] is greater than 1 and 
                //by adding nums[i] to i we can reach lastTruIdx then we can jump to last
                //index in some way
                lastTrueIdx = i;
            }
        }

        return lastTrueIdx == 0 ? true : false;


    }


///////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 20 Aug 2026

    // //intuition 1: 
    //     //Topic: DP
    //     //Pattern:
    //     //Sub-pattern:
        
    //     //At each step we have 2 options,
    //         //either to jump at full capacity 
    //         //or to jump at less capacity
        
    //     //start from the last index and fill a boolean dp array towards first index 
    //         //if a jump from index i can help us reach to last index, then any index
    //             //j that can reach to index i can help us reach to last index 
    //         //track the last true index using a variable and see if current nums[i] + i
    //             //is greater than equal to lastTrueIdx

    //     //dp invariant:
    //         //given any index i, dp[i] will store if we can reach last index from index i

    //     //TC: O(n)
    //     //SC: O(n)
    // public boolean canJump(int[] nums) {
        
    //     boolean[] dp = new boolean[nums.length];
    //     int numsLen = nums.length;
    //     dp[numsLen - 1] = true;

    //     int lastTrueIdx = numsLen - 1;
    //     for(int i = numsLen - 2; i >= 0; i --){
    //         if(nums[i] > 0 && (i + nums[i]) >= lastTrueIdx){ //if nums[i] is greater than 1 and 
    //             //by adding nums[i] to i we can reach lastTruIdx then we can jump to last
    //             //index in some way
    //             lastTrueIdx = i;
    //             dp[i] = true;
    //         }
    //         else dp[i] = false;
    //     }

    //     return dp[0];


    // }































////////////////////////////////////////////////////////////////////////////////////////////////
    // public boolean canJump(int[] nums) {
        
    //     // int len = nums.length;
    //     int goalPost = nums.length - 1;

    //     for(int i = nums.length - 2; i >= 0; i--){

    //         if(nums[i] >= goalPost - i){
    //             goalPost = i;
    //         }
    //     }

    //     if(goalPost == 0){
    //         return true;
    //     }
    //     return false;














    // //     if(nums.length == 1 ){
    // //         return true;
    // //     }
    // //     for(int i = 0; i< nums.length; i++){
            
    // //         if(i == 0){
    // //             n[i] = nums[i];

    // //         }
    // //         else{
    // //             n[i] = nums[i] + i;
    // //         }

    // //   }
    // //   for(int ans : n){
    // //       if(ans == nums.length - 1){
    // //           return true;
    // //       }

    // //   }
    // //   return false;


    // }
}