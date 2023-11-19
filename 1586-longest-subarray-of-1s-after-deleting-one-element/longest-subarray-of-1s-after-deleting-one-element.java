class Solution {
    public int longestSubarray(int[] nums) {

        int prevCount = 0;
        int currCount = 0;
        int maxCount = 0;

        for(int i = 0; i < nums.length; i ++){
            
            if(nums[i] == 1){
                currCount ++;
            }

            else{
                maxCount = Math.max(maxCount, prevCount + currCount);
                prevCount = currCount;
                currCount = 0;
                
            }

        }
        maxCount = Math.max(maxCount, prevCount + currCount);

        return maxCount == nums.length ? maxCount - 1 : maxCount;
        // return maxCount;





















//////////////////////////////////////////////////////////////////
   //beats 94%     
        // int left = 0;
        
        // int zeros = 0;

        // int ans = 0;
        // for(int right = 0; right < nums.length; right ++){

        //     if(nums[right] == 0){
        //         zeros ++;
        //     }

        //     while(zeros > 1){
        //         if(nums[left] == 0){
        //             zeros --;
        //         }
        //         left ++;
        //     }

        //     ans = Math.max(ans, right - left + 1 - 1);
        // }

        // return ans == nums.length ? ans - 1 : ans;
    }
}