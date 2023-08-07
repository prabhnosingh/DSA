class Solution {
    public int jump(int[] nums) {
        

        if(nums.length == 1){
            
            return 0;
            // if(nums[0] == 0){
            //     return 0;
            // }
            // else{
            //     return 1;
            // }
        } 
        int jumps = 0;
        int left = 0; 
        int right = 0;
            
            while(right < nums.length - 1 ){
                int farthest = 0;

                for(int i = left; i < right + 1; i++){
                    farthest = Math.max(farthest, i + nums[i]);

                }
                
                left = right + 1;
                right = farthest;
                jumps ++;
            }

        
        return jumps;
    }
}