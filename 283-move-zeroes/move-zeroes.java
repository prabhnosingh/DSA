class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0;
        for(int num : nums){
            if(num != 0){
                nums[i++] = num;
            }
        }
        while(i < nums.length){
            nums[i++] = 0;
        }


//************************************************************************** */
        //    int pointer = 0;
        // for(int i = 0; i < nums.length; i++){
            
        //     if(nums[pointer] == 0 && nums[i] != 0){
            
        //         nums[pointer] = nums[i];
        //         nums[i] = 0;
        //         pointer ++;
                
    
        //     }
        //     else if(nums[pointer] != 0){
        //         pointer ++;                
        //     }
            
           
        // }
    // *************************************************************************   
        // int first =0, second= 1;
        // while(second<nums.length){
        //     if(nums[first]==0 && nums[second]!=0){
        //         nums[first]= nums[second];
        //         nums[second]= 0;
        //         first++;
        //         second++;

        //     }            
        //     else if(nums[second]==0 && nums[first]!=0){
        //         first++;
        //         second++;
        //     }
        //     else if(nums[first]==0 && nums[second]==0){
        //         second++;
        //     }
        //     else{
        //         first++;
        //         second++;
        //     }
        // }
        
    }
}