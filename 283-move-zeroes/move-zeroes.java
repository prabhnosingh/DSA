class Solution {
    public void moveZeroes(int[] nums) {
        int first =0, second= 1;
        while(second<nums.length){
            if(nums[first]==0 && nums[second]!=0){
                nums[first]= nums[second];
                nums[second]= 0;
                first++;
                second++;

            }            
            else if(nums[second]==0 && nums[first]!=0){
                first++;
                second++;
            }
            else if(nums[first]==0 && nums[second]==0){
                second++;
            }
            else{
                first++;
                second++;
            }
        }
        
    }
}