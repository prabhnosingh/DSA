class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set1= new HashSet<>();
        for(int i=0; i< nums.length; i++){
       
                if(set1.contains(nums[i])){
                    return true;
                
            }
            set1.add(nums[i]);
        }
        return false;
    }
}