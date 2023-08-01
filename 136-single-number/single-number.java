class Solution {
    public int singleNumber(int[] nums) {
        
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int singleNum = nums[0];
        for(int i = 0; i < nums.length; i++){
           map.put(nums[i], map.getOrDefault(nums[i], 0)+1); 
        }
        
        for(int k: map.keySet()){
            if(map.get(k) == 1){
                singleNum = k;
            }
        }
        
 
        return singleNum;
    }
}