class Solution {
    public int longestOnes(int[] nums, int k) {

        // int left = 0;
        // int right = 0;
        // int maxLen = 0;
        // int n = k;
        // while(right < nums.length){
        //     int len = 0;
        //     if(nums[right] == 1){
        //         right ++;
        //     }
        //     else{

        //         if(k == 0){
        //             left = right;
        //             k = n - 1;
        //         }
        //         else{
        //             k --;
        //             right ++;
        //             len = right - left + 1;
        //             maxLen = Math.max(maxLen, len);
        //         }
                
            

        //     }
        // }
        // return maxLen;
        
































///////////////////////////////////////////////////////////////
        int left = 0;
        int right = 0;
        int f = k;
        int count = 0;
        int maxCount = 0;

        while(right < nums.length){
            if(nums[right] == 1){
                count ++;
            }
            else if(nums[right] == 0 && f > 0){
                f --;
                count ++;
            }
            else if(nums[right] == 0 && f == 0){
                left ++;
                right = left - 1;
                count = 0;
                f = k;
            }
            maxCount = Math.max(count, maxCount);
            right ++;
        }
        return maxCount;
    }
}