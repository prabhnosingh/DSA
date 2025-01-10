
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> currCombination, int[] nums){
        
        if(currCombination.size() == nums.length){
            res.add(new ArrayList<>(currCombination));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(currCombination.contains(nums[i])){
                continue;
            }
            currCombination.add(nums[i]);
            backtrack(res, currCombination, nums);
            currCombination.remove(currCombination.size() - 1);

        }

    }
}