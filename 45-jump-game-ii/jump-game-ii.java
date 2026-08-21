class Solution {

    //Solving on 21 Aug 2026

    //intuition 1: 
        //Topic: DP
        //Pattern: 1D-DP
        //Sub-pattern: 

        //we can think of minimum number of jumps needed at each index
        //dp invariant:
            //dp[i] represents minimum number of jumps needed to reach n-1 index from i index

        //at each index i if nums[i] > 0, we can have upto nums[i] jump while making sure that the 
            //jump does not exceed n-1 index
        //we can run a for loop from 1 to nums[i] jumps (inclusive) at each index i and take the minimum
            //from all the jumps and store it at dp[i]


    public int jump(int[] nums) {
        
        int numsLen = nums.length;
        int[] dp = new int[numsLen];

        if(numsLen == 1) return 0;
        dp[numsLen-1] = 0;
        // if(nums[i-2] != 0) dp[n-2] = 1;

        for(int i = numsLen - 2; i >=0 ; i --){
            // if(nums[i] == 0) continue;
            int minJumps = Integer.MAX_VALUE;
            for(int j = 1; j <= nums[i]; j++){
                if(j + i > numsLen-1) break;
                if(dp[j + i] == Integer.MAX_VALUE){
                    continue;
                }
                else minJumps = Math.min(minJumps, 1 + dp[j + i]);
            }
            dp[i] = minJumps;
        }

        return dp[0];

    }



























//////////////////////////////////////////////////////////////////////////////////////////////////
    //     // int jumps = 0;
    //     // int farthest = 0;

    //     // int end = 0;
    //     // for(int i = 0; i < nums.length - 1; i ++){
    //     //     farthest = Math.max(farthest, i + nums[i]);

    //     //     if(farthest >= nums.length - 1){
    //     //         jumps ++;
    //     //         break;
    //     //     }
    //     //     if(i == end){
    //     //         jumps ++;
    //     //         end = farthest;
    //     //     }
    //     // }
    //     // return jumps;


    // //******************************************************************* */   
    //     int jumps = 0;
    //     int left = 0; 
    //     int right = 0;
            
    //         while(right < nums.length - 1 ){
    //             int farthest = 0;

    //             for(int i = left; i < right + 1; i++){
    //                 farthest = Math.max(farthest, i + nums[i]);

    //             }
                
    //             left = right + 1;
    //             right = farthest;
    //             jumps ++;
    //         }

        
    //     return jumps;
    // }
}