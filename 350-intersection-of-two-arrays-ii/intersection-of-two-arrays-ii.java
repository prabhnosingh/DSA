class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int[] exist1 = new int[1001];
        int[] exist2 = new int[1001];
        
        for(int i = 0; i < nums1.length; i++) exist1[nums1[i]]++;
        for(int i = 0; i < nums2.length; i++) exist2[nums2[i]]++;
        
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        
        int idx = 0;
        
        for(int i = 0; i < nums2.length; i++){
            if(exist1[nums2[i]] > 0 && exist2[nums2[i]] > 0) {
               
                result[idx++] = nums2[i]; 
                exist1[nums2[i]] --;
                exist2[nums2[i]] --;
                
            }
        }
        
        return Arrays.copyOfRange(result, 0, idx);
        

        
    }
}