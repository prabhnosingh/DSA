class Solution {
    public boolean containsDuplicate(int[] nums) {
    
        // HashSet<Integer> set = new HashSet<>();
        // for(int i = 0; i < nums.length; i++){
        //     if(set.contains(nums[i])){
        //       return true;
        //     }
        //     else{
        //         set.add(nums[i]);
        //     }
        // }
        // return false;
        
        
        
        
        
        
        
        
        
        
        HashSet<Integer> set1= new HashSet<>();
        for(int i=0; i< nums.length; i++){
        int num = nums[i];
                if(set1.contains(num)){
                    return true;
                
            }
            set1.add(num);
        }
        return false;
    }
}