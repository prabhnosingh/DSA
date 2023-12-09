class Solution {
    public void moveZeroes(int[] nums) {



        int pointer = 0;
        int countZeros = 0;
        int i = 0;
        for(i = 0; i < nums.length; i ++){
            if(nums[i] != 0){
                nums[pointer ++] = nums[i];
            }
            else{
                countZeros ++;
            }
        }
        i --;

        while(countZeros > 0){
            nums[i --] = 0;
            countZeros --;
        }

//************************************************************
        // int[] nums2 = new int[nums.length];

        // int start = 0;
        // int end = nums.length - 1;

        // for(int num : nums){
        //     if(num == 0){
        //         nums2[end --] = num;
        //     }
        //     else{
        //         nums2[start ++] = num;
        //     }

        // }
        // int idx = 0;
        // for(int num : nums){
        //     nums[idx] = nums2[idx]; 
        //     idx ++;
        // }























        // int i = 0;
        // for(int num : nums){
        //     if(num != 0){
        //         nums[i++] = num;
        //     }
        // }
        // while(i < nums.length){
        //     nums[i++] = 0;
        // }


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