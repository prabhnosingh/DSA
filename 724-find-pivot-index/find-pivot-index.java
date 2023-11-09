class Solution {
    public int pivotIndex(int[] nums) {
       
       int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        
        int sumL = 0;

        for(int i = 0; i < nums.length; i ++){
            if(sumL * 2 == totalSum - nums[i]){
                return i;
            }
            sumL += nums[i];
        }
        return -1;









       // beats 9.23 %
        // int pi = -1;
        // for(int idx = 0; idx < nums.length; idx ++){
        //     int varL = idx - 1;
        //     int varR = idx + 1;
        //     int totalLeft = 0;
        //     int totalRight = 0;
        //     while(varL >= 0){
        //         totalLeft += nums[varL];
        //         varL --;
        //     }
        //     while(varR < nums.length){
        //         totalRight += nums[varR];
        //         varR ++;
        //     }
        //     if(totalRight == totalLeft){
        //         return idx;
        //     }
        // }
        // return pi;
    }
}