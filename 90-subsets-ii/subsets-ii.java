class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> currSubset, int[] nums, int start){
        if(start == nums.length){
            if(!res.contains(currSubset)){ // this works as we have sorted the array in the first place
                res.add(new ArrayList<>(currSubset));
            }
            return;
        }

        currSubset.add(nums[start]);
        dfs(res, currSubset, nums, start + 1);

        while(start + 1 < nums.length && nums[start] == nums[start + 1]){
            start ++;
        }
        currSubset.remove(currSubset.size() - 1);
        dfs(res, currSubset, nums, start + 1);
    }
}