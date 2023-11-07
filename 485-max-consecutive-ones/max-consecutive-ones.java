class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int len = 0;
       for(int i = 0; i < nums.length; i ++){
           if(nums[i] == 1){
               len ++;
           }
           else if(nums[i] == 0){
               maxLen = Math.max(maxLen, len);
               len = 0;
           }
           if(i == nums.length - 1){
                maxLen = Math.max(maxLen, len);
                
           }
       }
       return maxLen;
    }
}