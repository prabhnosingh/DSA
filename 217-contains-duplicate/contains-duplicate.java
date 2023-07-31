class Solution {
    public boolean containsDuplicate(int[] nums) {
    
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i = 0; i < nums.length; i++){
        //     int count = map.getOrDefault(nums[i], 0)+1;
        //     map.put(nums[i], count);
        //     if(count > 1){
        //         return true;
        //     }
            
            
        // }
        // return false;
        
        
        
        
        
        
        
        
        
        
        HashSet<Integer> set1= new HashSet<>();
        for(int i=0; i< nums.length; i++){
       
                if(!set1.add(nums[i])){
                    return true;
                
            }
            
        }
        return false;
    }
}