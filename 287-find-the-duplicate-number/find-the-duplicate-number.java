class Solution {
    public int findDuplicate(int[] nums) {
       
       HashSet<Integer> set = new HashSet<>();
       int doubleNum = 0;

        for(int num : nums){
            if(set.contains(num)) {
            doubleNum = num;
            break;  
            }
            set.add(num);
        }
        return doubleNum;

        }
}