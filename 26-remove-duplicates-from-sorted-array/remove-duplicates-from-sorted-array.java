class Solution {
    public int removeDuplicates(int[] nums) {





 int i =0;
   for(int k: nums){
       if(i==0 || k > nums[i-1]){
           nums[i++] = k;
          
       }
      
   }
    return i;
    }
}