class Solution {
    public boolean increasingTriplet(int[] nums) {
        
       int firstMin = Integer.MAX_VALUE;
       int secondMin = Integer.MAX_VALUE;

        for(int num : nums){
            if(num <= firstMin){
                firstMin = num;
            }
            else if(num <= secondMin){
                secondMin = num;
            }
            else{
                return true;
            }
        }
        return false;
//////////////////////////////////////////////////////////////////////        
     //time limit exceeded
         // boolean flag = false;
        // int count = 0;

        //     for(int i = 0; i < nums.length; i ++){
        //         int first = nums[i];
        //         for(int j = i; j < nums.length; j ++){
        //             int second = nums[j];
        //             for(int k = j; k < nums.length; k ++){
        //                 int third = nums[k];

        //                 if(first < second && second < third){
        //                     return true;
        //                 }
        //             }
        //         }
        //     }
        //     return false;
        }
    }
