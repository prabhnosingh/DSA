class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int[] exist = new int[1001];
       
        
        
        
        
        for(int num : nums1){
            exist[num] ++;
        }
        
       
        
        int idx = 0;
        int[] res = new int[Math.max(nums1.length, nums2.length)];
        for(int num : nums2){
          
              if(exist[num] > 0){
                  res[idx++] = num;
                  exist[num] --;
              }
         
           }
        
        
        return Arrays.copyOfRange(res, 0, idx);
        
        
    }
}