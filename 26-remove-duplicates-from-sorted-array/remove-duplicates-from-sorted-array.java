class Solution {
    public int removeDuplicates(int[] nums) {
//    int j = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] != nums[i - 1]) {
//                 nums[j] = nums[i];
//                 j++;
//             }
//         }
//         return j;




 int i =0;
   for(int k: nums){
       if(i==0 || k > nums[i-1]){
           nums[i++] = k;
          
       }
      
   }
    return i;
    }
}