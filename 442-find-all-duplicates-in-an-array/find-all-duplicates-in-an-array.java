class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            
            int idx = Math.abs(nums[i]);
            
            if(nums[idx - 1] < 0){
                ans.add(Math.abs(idx));
            }
            nums[idx - 1] = -1 * nums[idx - 1];
            
        }
        return ans;
        




































/////////////////////////////////////////////////////////////////////////////////////
// not correct, uses non-constant space and beats 5.84 %

        // HashMap<Integer, Integer> map = new HashMap<>();
        // List<Integer> ans = new ArrayList<>();
        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        //     if(map.get(num) == 2){
        //         ans.add(num);
        //     }
        // }
        // return ans;


        
    }
}