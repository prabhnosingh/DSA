class Solution {
    public boolean canJump(int[] nums) {
        
        // int len = nums.length;
        int goalPost = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){

            if(nums[i] >= goalPost - i){
                goalPost = i;
            }
        }

        if(goalPost == 0){
            return true;
        }
        return false;














    //     if(nums.length == 1 ){
    //         return true;
    //     }
    //     for(int i = 0; i< nums.length; i++){
            
    //         if(i == 0){
    //             n[i] = nums[i];

    //         }
    //         else{
    //             n[i] = nums[i] + i;
    //         }

    //   }
    //   for(int ans : n){
    //       if(ans == nums.length - 1){
    //           return true;
    //       }

    //   }
    //   return false;


    }
}