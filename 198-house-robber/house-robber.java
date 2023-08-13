class Solution {
    public int rob(int[] nums) {

   if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int now = 0;
        int last = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = last;
            last = now;
            now = Math.max(now, nums[i] + temp);
        }
        return now;
    }
    
//****************************************************************** */
    //      if(nums.length==0) return 0;
    //      if(nums.length==1) return nums[0];
        
    //     int[] ans = new int[nums.length];

    //     ans[0] = nums[0];
    //     ans[1] = Math.max(nums[0], nums[1]);

    //     for(int i = 2; i < nums.length; i++){

    //         ans[i] = Math.max(nums[i] + ans[i-2], ans[i-1]);            
    //     }

    //     return ans[nums.length-1];
    // }

}