class Solution {
    public void moveZeroes(int[] nums) {
        
//         int[] nums2 = new int[nums.length];
        
//         int idx = 0;
//         for(int num : nums){
//             if(num != 0){
//                 nums2[idx ++] = num;
//             }
//         }
        
//         nums = Arrays.copyOfRange(nums2, 0, nums.length);
        
        
        
        
        
        
        int pointer = 0;
        for(int i = 0; i < nums.length; i++){
            
            if(nums[pointer] == 0 && nums[i] != 0){
            
                nums[pointer] = nums[i];
                nums[i] = 0;
                pointer ++;
                 
    
            }
            else if(nums[pointer] != 0){
                pointer ++;                
            }
            
           
        }
    }
}